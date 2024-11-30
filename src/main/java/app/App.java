package app;

import data_access.DataAccessor;
import entity.calculator.IHandStateFactory;
import entity.user.UserManager;
import interface_adapter.ViewManager;
import view.AbstractPanel;

/**
 * Interface for what an app should have (to set defaults)
 */
public interface App {
    /**
     * Adds the AbstractPanel instance used for gui.
     *
     * @param panel the AbstractPanel instance
     */
    void addPanel(AbstractPanel<?> panel);

    /**
     * Gets the IUserManager instance used for managing users.
     */
    UserManager getUserManager();

    /**
     * Gets the IDataAccessor instance used for data access.
     */
    DataAccessor getDataAccessor();

    /**
     * Gets the IHandStateFactory instance used for hand states.
     */
    IHandStateFactory getHandStateFactory();

    /**
     * Gets the ViewManager instance used for view managing.
     */
    ViewManager getViewManager();
}
