package view;

import interface_adapter.ViewManager;
import interface_adapter.ViewState;
import interface_adapter.puzzleRush.PuzzleRushController;
import interface_adapter.puzzleRush.PuzzleRushState;
import util.GUIHelper;
import view.component.DisplayHandComponent;
import view.component.TabSwitcherComponent;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class PuzzleRushView extends AbstractPanel<PuzzleRushState> {
    private final CardLayout startRunningLayout = new CardLayout();
    private final JPanel startRunningPanel = new JPanel(startRunningLayout);

    private PuzzleRushController puzzleRushController;

    private GamePanel gamePanel;
    private StartPanel startPanel;


    public PuzzleRushView(ViewState<PuzzleRushState> viewState, ViewManager viewManager) {
        super(viewState);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        viewManager.addPropertyChangeListener((evt) -> {
            if (evt.getPropertyName().equals("state")) {
                if (evt.getNewValue().equals(getViewName())) {
                    startRunningLayout.show(startRunningPanel, "start");
                } else {

                }
            }
        });

        this.add(new TabSwitcherComponent(viewManager));

        gamePanel = new GamePanel(viewState);
        startPanel = new StartPanel(e -> {
            System.out.println("here");

            puzzleRushController.execute();
            startRunningLayout.show(startRunningPanel, "running");
        });

        startRunningPanel.add(startPanel, "start");
        startRunningPanel.add(gamePanel, "running");

        this.add(startRunningPanel);
    }

    public void setPuzzleRushController(PuzzleRushController puzzleRushController) {
        this.puzzleRushController = puzzleRushController;
    }

    private static class StartPanel extends JPanel {
        public StartPanel(ActionListener startListener) {
            JButton startButton = new JButton("Start");
            startButton.addActionListener(startListener);
            this.add(startButton);
        }
    }

    private static class GamePanel extends JPanel {
        private final DisplayHandComponent displayHandComponent;
        private JLabel timerLabel;
        private JLabel scoreLabel;
        private JLabel inputLabel;
        private JTextField pointEntry;
        private JLabel errorField;
        private JButton inputButton;

        public GamePanel(ViewState<PuzzleRushState> viewState) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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
            add(GUIHelper.wrapJpanel(inputButton));
        }
    }
}
