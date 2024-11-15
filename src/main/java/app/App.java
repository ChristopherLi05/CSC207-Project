package app;

import data_access.DummyDataAccessor;
import data_access.IDataAccessor;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.user.IUserManager;
import entity.user.UserManager;

import javax.swing.*;

public class App extends JFrame implements IApp {
    private IUserManager userManager;
    private IDataAccessor dataAccessor;
    private IHandStateFactory handStateFactory;

    // Default Implementation
    public App(String title) {
        super(title);

        userManager = new UserManager();
        dataAccessor = new DummyDataAccessor();
        handStateFactory = new HandStateFactory();
    }

    public void setUserManager(IUserManager userManager) {
        this.userManager = userManager;
    }

    public IUserManager getUserManager() {
        return userManager;
    }

    public void setDataAccessor(IDataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public IDataAccessor getDataAccessor() {
        return dataAccessor;
    }

    public void setHandStateFactory(IHandStateFactory handStateFactory) {
        this.handStateFactory = handStateFactory;
    }

    public IHandStateFactory getHandStateFactory() {
        return handStateFactory;
    }
}
