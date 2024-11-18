package view;

import interface_adapter.ViewState;

import javax.swing.*;

public abstract class AbstractPanel<T> extends JPanel {
    private final ViewState<T> viewState;

    public AbstractPanel(ViewState<T> viewState) {
        this.viewState = viewState;
    }

    public String getViewName() {
        return viewState.getViewName();
    }

    public ViewState<T> getViewState() {
        return viewState;
    }
}
