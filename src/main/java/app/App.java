package app;

import data_access.DummyDataAccessor;
import data_access.IDataAccessor;
import entity.user.IUserManager;
import entity.user.UserManager;

import javax.swing.*;

public class App extends JFrame implements IApp {
    private IUserManager userManager;
    private IDataAccessor dataAccessor;

    // Default Implementation
    public App(String title) {
        super(title);

        userManager = new UserManager();
        dataAccessor = new DummyDataAccessor();
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
}
