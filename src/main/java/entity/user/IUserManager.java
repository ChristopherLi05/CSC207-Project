package entity.user;

public interface IUserManager {
    IUser getCurrentUser();

    void setUserLoggedIn(String name, int bestScore);

    void setUserGuest();

    void injectFactory(IUserFactory factory);
}
