package app;

import data_access.IDataAccessor;
import entity.calculator.IHandStateFactory;
import entity.user.IUserManager;
import interface_adapter.ViewManager;
import view.AbstractPanel;

public interface IApp {
    /**
     * Adds the AbstractPanel instance used for gui.
     *
     * @param panel the AbstractPanel instance
     */
    void addPanel(AbstractPanel<?> panel);

    /**
     * Gets the IUserManager instance used for managing users.
     */
    IUserManager getUserManager();

    /**
     * Gets the IDataAccessor instance used for data access.
     */
    IDataAccessor getDataAccessor();

    /**
     * Gets the IHandStateFactory instance used for hand states.
     */
    IHandStateFactory getHandStateFactory();

    /**
     * Gets the ViewManager instance used for view managing.
     */
    ViewManager getViewManager();
}
