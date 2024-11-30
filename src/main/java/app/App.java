package app;

import data_access.DataAccessor;
import data_access.InMemoryDataAccessor;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.user.IUserManager;
import entity.user.UserManager;
import interface_adapter.ViewManager;
import view.AbstractPanel;

import javax.swing.*;
import java.awt.*;

/**
 * The App class represents the main application window. It manages
 * the user interface, user data, state transitions, and interactions between
 * various components of the application.
 */
public class App extends JFrame implements IApp {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel = new JPanel(cardLayout);

    private IUserManager userManager;
    private DataAccessor dataAccessor;
    private IHandStateFactory handStateFactory;
    private ViewManager viewManager;

    /**
     * Constructs an {@code App} instance with default implementations for dependencies.
     *
     * @param title the title of the application window
     */
    public App(String title) {
        this(title, new UserManager(), new InMemoryDataAccessor(), new HandStateFactory(), new ViewManager());
    }

    /**
     * Constructs an {@code App} instance with specified dependencies.
     *
     * @param title            the title of the application window
     * @param userManager      the {@link IUserManager} instance for user management
     * @param dataAccessor     the {@link DataAccessor} instance for data access
     * @param handStateFactory the {@link IHandStateFactory} instance for creating hand states
     * @param viewManager      the {@link ViewManager} instance for managing views
     */
    public App(String title, IUserManager userManager, DataAccessor dataAccessor, IHandStateFactory handStateFactory, ViewManager viewManager) {
        super(title);
        this.userManager = userManager;
        this.dataAccessor = dataAccessor;
        this.handStateFactory = handStateFactory;
        this.viewManager = viewManager;
        addViewManagerListener();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(cardPanel);

        this.setPreferredSize(new Dimension(1300, 850));
        this.setResizable(false);
    }

    /**
     * Sets the IUserManager instance used for managing users.
     *
     * @param userManager the IUserManager instance
     */
    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * Adds the AbstractPanel instance used for gui.
     *
     * @param panel the AbstractPanel instance
     */
    @Override
    public void addPanel(AbstractPanel<?> panel) {
        cardPanel.add(panel, panel.getViewName());
        viewManager.addPane(panel.getViewName(), panel.getViewState());
    }

    /**
     * Gets the IUserManager instance used for managing users.
     */
    @Override
    public IUserManager getUserManager() {
        return userManager;
    }

    /**
     * Sets the IDataAccessor instance.
     *
     * @param dataAccessor the IDataAccessor instance
     */
    public void setDataAccessor(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    /**
     * Gets the IDataAccessor instance used for data access.
     */
    @Override
    public DataAccessor getDataAccessor() {
        return dataAccessor;
    }

    /**
     * Sets the IHandStateFactory instance.
     *
     * @param handStateFactory the IHandStateFactory instance
     */
    public void setHandStateFactory(IHandStateFactory handStateFactory) {
        this.handStateFactory = handStateFactory;
    }

    /**
     * Gets the IHandStateFactory instance used for hand states.
     */
    @Override
    public IHandStateFactory getHandStateFactory() {
        return handStateFactory;
    }

    /**
     * Gets the ViewManager instance used for view managing.
     */
    @Override
    public ViewManager getViewManager() {
        return viewManager;
    }

    /**
     * Sets the ViewManager instance.
     *
     * @param viewManager the ViewManager instance
     */
    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
        addViewManagerListener();
    }

    /**
     * Adds a property change listener to the ViewManager.
     * This listener updates the currently displayed panel based on the view state.
     */
    private void addViewManagerListener() {
        this.viewManager.addPropertyChangeListener(evt -> {
            if ("state".equals(evt.getPropertyName())) {
                displayCard((String) evt.getNewValue());
            }
        });
    }

    /**
     * Displays a panel based on the specified view name.
     *
     * @param viewName the name of the view to display
     */
    private void displayCard(String viewName) {
        cardLayout.show(cardPanel, viewName);
    }
}
