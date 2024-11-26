package view;

import app.IApp;
import data_access.IDataAccessor;
import interface_adapter.ViewManager;
import interface_adapter.ViewState;
import interface_adapter.puzzleRush.PuzzleRushController;
import interface_adapter.puzzleRushHand.PuzzleRushHandController;
import interface_adapter.puzzleRush.PuzzleRushState;
import util.GUIHelper;
import view.component.DisplayHandComponent;
import view.component.TabSwitcherComponent;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Puzzle Rush View
 */
public class PuzzleRushView extends AbstractPanel<PuzzleRushState> {
    private final CardLayout startRunningLayout = new CardLayout();
    private final JPanel startRunningPanel = new JPanel(startRunningLayout);


    private GamePanel gamePanel;
    private StartPanel startPanel;
    private ResultPanel resultPanel;

    // IApp is temporary
    public PuzzleRushView(ViewState<PuzzleRushState> viewState, ViewManager viewManager, IApp app) {
        super(viewState);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        viewManager.addPropertyChangeListener((evt) -> {
            if (evt.getPropertyName().equals("state")) {
                if (evt.getNewValue().equals(getViewName())) {
                    startRunningLayout.show(startRunningPanel, "start");
                } else {
                    gamePanel.stop();
                }
            }
        });

        this.add(new TabSwitcherComponent(viewManager));

        gamePanel = new GamePanel(viewState);

        startPanel = new StartPanel(e -> {
            gamePanel.start();
            startRunningLayout.show(startRunningPanel, "running");
        });

        resultPanel = new ResultPanel(app);
        viewState.addPropertyChangeListener(resultPanel);
        viewState.addPropertyChangeListener(e -> {
            if (e.getPropertyName().equals("timerEnd")) {
                startRunningLayout.show(startRunningPanel, "result");
            }
        });

        startRunningPanel.add(startPanel, "start");
        startRunningPanel.add(gamePanel, "running");
        startRunningPanel.add(resultPanel, "result");

        this.add(startRunningPanel);
    }

    public void setPuzzleRushHandController(PuzzleRushHandController puzzleRushHandController) {
        gamePanel.setPuzzleRushHandController(puzzleRushHandController);
    }

    public void setPuzzleRushController(PuzzleRushController puzzleRushController) {
        gamePanel.setPuzzleRushController(puzzleRushController);
    }

    /**
     * Start Panel ; see this before the game has started
     */
    private static class StartPanel extends JPanel {
        public StartPanel(ActionListener startListener) {
            JButton startButton = new JButton("Start");
            startButton.addActionListener(startListener);
            this.add(startButton);
        }
    }

    /**
     * Game Panel ; see this while game is running
     */
    private static class GamePanel extends JPanel implements PropertyChangeListener {
        private final DisplayHandComponent displayHandComponent;
        private JLabel timerLabel;
        private JLabel scoreLabel;
        private JLabel inputLabel;
        private JTextField pointEntry;
        private JLabel errorField;
        private JButton inputButton;

        private final ViewState<PuzzleRushState> viewState;

        private java.util.Timer timer;
        private TimerTask timerTask;

        private PuzzleRushController puzzleRushController = null;
        private PuzzleRushHandController puzzleRushHandController = null;

        public GamePanel(ViewState<PuzzleRushState> viewState) {
            this.viewState = viewState;

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            viewState.addPropertyChangeListener(this);

            displayHandComponent = new DisplayHandComponent(false);
            viewState.addPropertyChangeListener(displayHandComponent);

            add(GUIHelper.wrapJpanel(displayHandComponent));

            timerLabel = new JLabel("Time Left: 0");
            add(GUIHelper.wrapJpanel(timerLabel));

            scoreLabel = new JLabel("Score: 0");
            add(GUIHelper.wrapJpanel(scoreLabel));

            inputLabel = new JLabel("Points:");

            NumberFormat format = NumberFormat.getInstance();
            format.setGroupingUsed(false);

            pointEntry = new JTextField(20);
            ((AbstractDocument) pointEntry.getDocument()).setDocumentFilter(new DocumentFilter() {
                @Override
                public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                    if (string != null && string.matches("\\d*")) {
                        super.insertString(fb, offset, string, attr);
                    }
                }

                @Override
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if (text != null && text.matches("\\d*")) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            });

            add(GUIHelper.wrapJpanel(inputLabel, pointEntry));

            errorField = new JLabel();
            add(GUIHelper.wrapJpanel(errorField));

            inputButton = new JButton("Submit");
            inputButton.addActionListener(e -> {
                if (pointEntry.getText() == null || pointEntry.getText().isEmpty()) return;

                puzzleRushController.execute(Integer.parseInt(pointEntry.getText()), viewState.getState().getHandState());
                pointEntry.setText("");
            });
            add(GUIHelper.wrapJpanel(inputButton));

            timer = new Timer();
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (!(evt.getNewValue() instanceof PuzzleRushState)) return;
            PuzzleRushState state = (PuzzleRushState) evt.getNewValue();

            timerLabel.setText("Time Left: " + state.getTimeLeft() / 1000);
            scoreLabel.setText("Score: " + state.getCurrScore());

            if (evt.getPropertyName().equals("successChangeHand")) {
                puzzleRushHandController.execute(state.getTimeLeft(), state.getCurrScore() + 1);
            } else if (evt.getPropertyName().equals("failChangeHand")) {
                puzzleRushHandController.execute(state.getTimeLeft() - 5000, state.getCurrScore());
            }
        }

        public void setPuzzleRushController(PuzzleRushController puzzleRushController) {
            this.puzzleRushController = puzzleRushController;
        }

        /**
         * Starts the game
         */
        public void start() {
            if (timerTask != null) {
                timerTask.cancel();
            }

            // 1 minute
            puzzleRushHandController.execute(60200, 0);

            timerTask = new TimerTask() {
                @Override
                public void run() {
                    int timeLeft = viewState.getState().getTimeLeft() - 200;
                    viewState.getState().setTimeLeft(timeLeft);
                    viewState.firePropertyChanged();

                    if (timeLeft < 0) {
                        this.cancel();
                        viewState.firePropertyChanged("timerEnd");
                    }
                }
            };

            timer.scheduleAtFixedRate(timerTask, 0, 200);
        }

        /**
         * Stops the game
         */
        public void stop() {
            if (timerTask != null) {
                timerTask.cancel();
                timerTask = null;
            }
        }

        public void setPuzzleRushHandController(PuzzleRushHandController puzzleRushHandController) {
            this.puzzleRushHandController = puzzleRushHandController;
        }
    }

    /**
     * Shows the final results of the game
     */
    private static class ResultPanel extends JPanel implements PropertyChangeListener {
        private JLabel finalScore;
        private IApp app;

        // app temp
        public ResultPanel(IApp app) {
            this.app = app;

            finalScore = new JLabel("Final Score: ");
            this.add(finalScore);
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("timerEnd") && evt.getNewValue() instanceof PuzzleRushState) {
                finalScore.setText("Final Score: " + ((PuzzleRushState) evt.getNewValue()).getCurrScore());
                if (app.getUserManager().getCurrentUser().isLoggedIn()) {
                    app.getDataAccessor().updateScore(app.getUserManager().getCurrentUser().getSessionId(), ((PuzzleRushState) evt.getNewValue()).getCurrScore());
                }
            }
        }
    }
}
