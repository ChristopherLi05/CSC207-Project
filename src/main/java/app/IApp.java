package app;

import data_access.IDataAccessor;
import entity.calculator.IHandStateFactory;
import entity.user.IUserManager;

public interface IApp {
    IUserManager getUserManager();

    IDataAccessor getDataAccessor();

    IHandStateFactory getHandStateFactory();
}
