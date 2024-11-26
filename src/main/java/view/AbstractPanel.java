package view;

import interface_adapter.ViewState;

import javax.swing.*;

/**
 * Generic Panel that all views should inherit from. Contains getViewState so we don't actually need to store viewState
 * if we need it anywhere
 * @param <T>
 */
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
