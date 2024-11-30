package entity.user;

import entity.user.user_type.IUser;

/**
 * Implementation of User Manager
 */
public class DefaultUserManager implements UserManager {
    // Defaults to guest login
    private IUser currentUser;
    private UserFactory userFactory;

    public DefaultUserManager() {
        this(new LocalUserFactory());
    }

    public DefaultUserManager(UserFactory userFactory) {
        this.userFactory = userFactory;
        this.currentUser = userFactory.createGuest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUser getCurrentUser() {
        return currentUser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserLoggedIn(String sessionId, String name, int bestScore) {
        this.currentUser = userFactory.create(sessionId, name, bestScore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserGuest() {
        this.currentUser = userFactory.createGuest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserFactory(UserFactory factory) {
        this.userFactory = factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserFactory getUserFactory() {
        return userFactory;
    }
}
