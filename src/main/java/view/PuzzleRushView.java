package view;

import app.IApp;
import interface_adapter.ViewState;

import java.beans.PropertyChangeEvent;

public class PuzzleRushView extends AbstractPanel<Object> {
    public PuzzleRushView(ViewState<Object> viewState) {
        super(viewState);
    }
}
