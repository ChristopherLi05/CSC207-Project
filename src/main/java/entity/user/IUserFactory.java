package entity.user;

public interface IUserFactory {
    IUser create(String name, int bestScore);

    IUser createGuest();
}
