package view;

import app.IApp;
import interface_adapter.ViewState;

import javax.swing.*;
import java.beans.PropertyChangeListener;

public abstract class AbstractPanel<T> extends JPanel {
    private final IApp master;
    private final ViewState<T> viewState;

    public AbstractPanel(IApp master, ViewState<T> viewState) {
        this.master = master;
        this.viewState = viewState;
    }

    public IApp getMaster() {
        return master;
    }

    public String getViewName() {
        return viewState.getViewName();
    }

    public ViewState<T> getViewState() {
        return viewState;
    }
}
