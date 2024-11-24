package view;

import app.IApp;
import interface_adapter.ViewManager;
import interface_adapter.ViewState;
import interface_adapter.puzzleRush.PuzzleRushState;
import view.component.DisplayHandComponent;
import view.component.TabSwitcherComponent;

import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class PuzzleRushView extends AbstractPanel<PuzzleRushState> {
    private final DisplayHandComponent displayHandComponent;

    public PuzzleRushView(ViewState<PuzzleRushState> viewState, ViewManager viewManager) {
        super(viewState);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(new TabSwitcherComponent(viewManager));

        displayHandComponent = new DisplayHandComponent(false);
        add(displayHandComponent);
        viewState.addPropertyChangeListener(displayHandComponent);
    }
}
