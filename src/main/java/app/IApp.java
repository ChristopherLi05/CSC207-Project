package app;

import data_access.IDataAccessor;
import entity.calculator.IHandStateFactory;
import entity.user.IUserManager;
import interface_adapter.ViewManager;
import view.AbstractPanel;

public interface IApp {
    void addPanel(AbstractPanel<?> panel);

    IUserManager getUserManager();

    IDataAccessor getDataAccessor();

    IHandStateFactory getHandStateFactory();

    ViewManager getViewManager();
}
