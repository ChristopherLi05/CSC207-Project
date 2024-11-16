package app;

import data_access.IDataAccessor;
import data_access.InMemoryDataAccessor;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.user.IUserManager;
import entity.user.UserManager;
import view.AbstractPanel;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame implements IApp {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel = new JPanel(cardLayout);

    private IUserManager userManager;
    private IDataAccessor dataAccessor;
    private IHandStateFactory handStateFactory;

    // Default Implementation
    public App(String title) {
        this(title, new UserManager(), new InMemoryDataAccessor(), new HandStateFactory());
    }

    public App(String title, IUserManager userManager, IDataAccessor dataAccessor, IHandStateFactory handStateFactory) {
        super(title);
        this.userManager = userManager;
        this.dataAccessor = dataAccessor;
        this.handStateFactory = handStateFactory;

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(cardPanel);
    }

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void addPanel(AbstractPanel panel) {
        cardPanel.add(panel, panel.getViewName());
    }

    @Override
    public void displayCard(String viewName) {
        cardLayout.show(cardPanel, viewName);
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
}
