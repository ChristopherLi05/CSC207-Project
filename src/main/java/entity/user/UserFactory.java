package entity.user;

public class UserFactory implements IUserFactory {
    @Override
    public IUser create(String name, int bestScore) {
        return new User(name, bestScore);
    }

    @Override
    public IUser createGuest() {
        return new User();
    }
}
