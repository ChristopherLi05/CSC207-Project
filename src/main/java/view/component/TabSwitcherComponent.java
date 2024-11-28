package view.component;

import interface_adapter.ViewManager;
import interface_adapter.ViewState;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

/**
 * Basic tab switcher component
 */
public class TabSwitcherComponent extends JPanel implements PropertyChangeListener {
    private final ViewManager viewManager;

    private JButton calculator;
    private JButton puzzleRush;
    private JButton leaderboard;
    private JButton logOut;

    public TabSwitcherComponent(ViewManager viewManager) {
        this.viewManager = viewManager;
        viewManager.addPropertyChangeListener(this);
        remakeButtons();
    }

    public void remakeButtons() {
        this.removeAll();

        calculator = new JButton("Calculator");
        puzzleRush = new JButton("Puzzle Rush");
        leaderboard = new JButton("Leaderboard");
        logOut = new JButton("Log Out");

        this.add(calculator);
        this.add(puzzleRush);
        this.add(leaderboard);
        this.add(logOut);

        calculator.addActionListener(e -> viewManager.setView("CalculatorView"));
        puzzleRush.addActionListener(e -> viewManager.setView("PuzzleRushView"));
        leaderboard.addActionListener(e -> viewManager.setView("LeaderboardView"));
        logOut.addActionListener(e -> {
            viewManager.setView("SignupView");
        });

        this.validate();
        this.revalidate();
        this.repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("stateAdded")) {
            remakeButtons();
        }
    }
}
