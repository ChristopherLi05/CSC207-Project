package view;


import interface_adapter.ViewManager;
import interface_adapter.leaderboard.LeaderboardController;
import interface_adapter.leaderboard.LeaderboardState;
import interface_adapter.leaderboard.LeaderboardViewState;
import view.component.LeaderboardComponent;
import view.component.TabSwitcherComponent;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Leaderboard View
 */
public class LeaderboardView extends AbstractPanel<LeaderboardState> implements PropertyChangeListener {
    private LeaderboardController leaderboardController = null;

    public LeaderboardView(LeaderboardViewState viewState, ViewManager viewManager) {
        super(viewState);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Leader Board");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        this.add(new TabSwitcherComponent(viewManager));

        LeaderboardComponent leaderboard = new LeaderboardComponent(viewState);
        getViewState().addPropertyChangeListener(leaderboard);
        this.add(leaderboard);

        viewManager.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (getViewName().equals(evt.getNewValue())) {
            if (leaderboardController != null) {
                leaderboardController.execute();
            }
        }
    }

    public void setLeaderboardController(LeaderboardController leaderboardController) {
        this.leaderboardController = leaderboardController;
    }
}
