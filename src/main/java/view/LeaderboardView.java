package view;

import app.IApp;
import interface_adapter.leaderboard.LeaderboardState;
import interface_adapter.leaderboard.LeaderboardViewState;

import java.beans.PropertyChangeEvent;

public class LeaderboardView extends AbstractPanel<LeaderboardState> {
    public LeaderboardView(IApp master, LeaderboardViewState viewState) {
        super(master, viewState);
    }
}
