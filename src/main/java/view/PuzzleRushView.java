package view;

import app.IApp;

import java.beans.PropertyChangeEvent;

public class PuzzleRushView extends AbstractPanel {
    public PuzzleRushView(IApp master) {
        super(master);
    }

    @Override
    public String getViewName() {
        return "PuzzleRushView";
    }
}
