package app;

import data_access.IDataAccessor;
import entity.calculator.IHandStateFactory;
import entity.user.IUserManager;
import view.AbstractPanel;

public interface IApp {
    void addPanel(AbstractPanel panel);

    void displayCard(String viewName);

    IUserManager getUserManager();

    IDataAccessor getDataAccessor();

    IHandStateFactory getHandStateFactory();
}
