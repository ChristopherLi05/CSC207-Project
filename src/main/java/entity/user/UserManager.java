package entity.user;

public class UserManager implements IUserManager {
    // Defaults to guest login
    private IUser currentUser;
    private IUserFactory userFactory;

    public UserManager() {
        userFactory = new UserFactory();
        currentUser = userFactory.createGuest();
    }

    public UserManager(UserFactory userFactory) {
        this.userFactory = userFactory;
        this.currentUser = userFactory.createGuest();
    }

    @Override
    public IUser getCurrentUser() {
        return currentUser;
    }

    @Override
    public void setUserLoggedIn(String name, int bestScore) {
        this.currentUser = userFactory.create(name, bestScore);
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
