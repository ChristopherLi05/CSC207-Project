package view;

import app.IApp;

import java.beans.PropertyChangeEvent;

public class LeaderboardView extends AbstractPanel {
    public LeaderboardView(IApp master) {
        super(master);
    }

    @Override
    public String getViewName() {
        return "LeaderboardView";
    }
}
