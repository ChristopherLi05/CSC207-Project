package view;

import app.IApp;
import interface_adapter.leaderboard.LeaderboardState;
import interface_adapter.leaderboard.LeaderboardViewState;
import view.component.LeaderboardComponent;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LeaderboardView extends AbstractPanel<LeaderboardState> {
    public LeaderboardView(IApp master, LeaderboardViewState viewState) {
        super(master, viewState);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        LeaderboardComponent leaderboard = new LeaderboardComponent(viewState);
        getViewState().addPropertyChangeListener(leaderboard);
        this.add(leaderboard);
    }
}
