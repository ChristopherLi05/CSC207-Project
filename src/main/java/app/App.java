package app;

import data_access.IDataAccessor;
import data_access.InMemoryDataAccessor;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.user.IUserManager;
import entity.user.UserManager;
import interface_adapter.ViewManager;
import view.AbstractPanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class App extends JFrame implements IApp {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel = new JPanel(cardLayout);

    private IUserManager userManager;
    private IDataAccessor dataAccessor;
    private IHandStateFactory handStateFactory;
    private ViewManager viewManager;

    // Default Implementation
    public App(String title) {
        this(title, new UserManager(), new InMemoryDataAccessor(), new HandStateFactory(), new ViewManager());
    }

    public App(String title, IUserManager userManager, IDataAccessor dataAccessor, IHandStateFactory handStateFactory, ViewManager viewManager) {
        super(title);
        this.userManager = userManager;
        this.dataAccessor = dataAccessor;
        this.handStateFactory = handStateFactory;
        this.viewManager = viewManager;
        addViewManagerListener();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(cardPanel);
    }

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void addPanel(AbstractPanel<?> panel) {
        cardPanel.add(panel, panel.getViewName());
    }

    @Override
    public IUserManager getUserManager() {
        return userManager;
    }

    public void setDataAccessor(IDataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    @Override
    public IDataAccessor getDataAccessor() {
        return dataAccessor;
    }

    public void setHandStateFactory(IHandStateFactory handStateFactory) {
        this.handStateFactory = handStateFactory;
    }

    @Override
    public IHandStateFactory getHandStateFactory() {
        return handStateFactory;
    }

    @Override
    public ViewManager getViewManager() {
        return viewManager;
    }

    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
        addViewManagerListener();
    }

    private void addViewManagerListener() {
        this.viewManager.addPropertyChangeListener(evt -> {
            if ("state".equals(evt.getPropertyName())) {
                displayCard((String) evt.getNewValue());
            } else {
                throw new RuntimeException("Non state call to view manager");
            }
        });
    }

    private void displayCard(String viewName) {
        cardLayout.show(cardPanel, viewName);
    }
}
