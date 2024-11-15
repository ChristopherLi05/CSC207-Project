package entity.user;

import entity.user.user_type.IUser;

public class UserManager implements IUserManager {
    // Defaults to guest login
    private IUser currentUser;
    private IUserFactory userFactory;

    public UserManager() {
        this(new LocalUserFactory());
    }

    public UserManager(LocalUserFactory userFactory) {
        this.userFactory = userFactory;
        this.currentUser = userFactory.createGuest();
    }

    @Override
    public IUser getCurrentUser() {
        return currentUser;
    }

    @Override
    public void setUserLoggedIn(String sessionId, String name, int bestScore) {
        this.currentUser = userFactory.create(sessionId, name, bestScore);
    }

    @Override
    public void setUserGuest() {
        this.currentUser = userFactory.createGuest();
    }

    @Override
    public void injectFactory(IUserFactory factory) {
        this.userFactory = factory;
    }
}
