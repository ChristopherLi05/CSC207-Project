package view;

import interface_adapter.ViewManager;
import interface_adapter.ViewState;
import interface_adapter.puzzleRush.PuzzleRushState;
import util.GUIHelper;
import view.component.DisplayHandComponent;
import view.component.TabSwitcherComponent;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

public class PuzzleRushView extends AbstractPanel<PuzzleRushState> implements PropertyChangeListener {
    private final CardLayout startRunningLayout = new CardLayout();
    private final JPanel startRunningPanel = new JPanel(startRunningLayout);

    private GamePanel gamePanel;
    private StartPanel startPanel;


    public PuzzleRushView(ViewState<PuzzleRushState> viewState, ViewManager viewManager) {
        super(viewState);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        viewManager.addPropertyChangeListener(this);

        this.add(new TabSwitcherComponent(viewManager));

        gamePanel = new GamePanel(viewState);
        startPanel = new StartPanel();

        startRunningPanel.add(startPanel, "start");
        startRunningPanel.add(gamePanel, "running");

        this.add(startRunningPanel);

        startRunningLayout.show(startRunningPanel, "running");


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            if (evt.getNewValue().equals(getViewName())) {

            } else {

            }
        }
    }

    private static class StartPanel extends JPanel {
        public StartPanel() {
            JButton startButton = new JButton("Start");
            startButton.addActionListener(e -> {
                System.out.println("here");
            });
            this.add(startButton);
        }
    }

    private static class GamePanel extends JPanel {
        private final DisplayHandComponent displayHandComponent;
        private JLabel timerLabel;
        private JLabel scoreLabel;
        private JLabel inputLabel;
        private JFormattedTextField pointEntry;
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

            NumberFormatter formatter = new NumberFormatter(format);

            formatter.setValueClass(Integer.class);
            formatter.setAllowsInvalid(false);
            formatter.setMinimum(0);
            formatter.setMaximum(128000);

            pointEntry = new JFormattedTextField(formatter);
            pointEntry.setColumns(20);
            add(GUIHelper.wrapJpanel(inputLabel, pointEntry));

            errorField = new JLabel();
            add(GUIHelper.wrapJpanel(errorField));

            inputButton = new JButton("Submit");
            add(GUIHelper.wrapJpanel(inputButton));
        }
    }
}
