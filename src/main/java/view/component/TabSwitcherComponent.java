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

//        for (Map.Entry<String, ViewState<?>> pair : viewManager.getViewStates().entrySet()) {
//            if (pair.getValue().isTabswitcher()) {
//                this.add(createJButton(pair.getKey()));
//            }
//        }

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
        // TODO: create logout use case
//        logOut.addActionListener(e -> viewManager.setView("LogOutView"));

        this.validate();
        this.revalidate();
        this.repaint();
    }

//    /**
//     * Creates a JButton based on a view name and tells viewmanager to switch to that view
//     * @param viewName .
//     * @return created JButton
//     */
//    public JButton createJButton(String viewName) {
//        JButton button = new JButton(viewName);
//        button.addActionListener(e -> viewManager.setView(viewName));
//        return button;
//    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("stateAdded")) {
            remakeButtons();
        }
    }
}
