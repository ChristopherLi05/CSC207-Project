package entity.user;

import entity.user.user_type.GuestUser;
import entity.user.user_type.IUser;
import entity.user.user_type.LocalUser;
import entity.user.user_type.RemoteUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void testLocalUser() {
        LocalUser user = new LocalUser("test", 1);

        Assertions.assertEquals(user.getUsername(), "test");
        Assertions.assertEquals(user.getSessionId(), "test");
        Assertions.assertEquals(user.getBestScore(), 1);

        Assertions.assertTrue(user.isLoggedIn());

        user.setBestScore(2);
        Assertions.assertEquals(user.getBestScore(), 2);
    }

    @Test
    void testGuestUser() {
        GuestUser user = new GuestUser();

        Assertions.assertEquals(user.getUsername(), "Guest");
        Assertions.assertEquals(user.getSessionId(), "Guest");
        Assertions.assertEquals(user.getBestScore(), 0);

        Assertions.assertFalse(user.isLoggedIn());

        user.setBestScore(2);
        Assertions.assertEquals(user.getBestScore(), 2);
    }

    @Test
    void testRemoteUser() {
        RemoteUser user = new RemoteUser("test", "test1", 1);

        Assertions.assertEquals(user.getUsername(), "test1");
        Assertions.assertEquals(user.getSessionId(), "test");
        Assertions.assertEquals(user.getBestScore(), 1);

        Assertions.assertTrue(user.isLoggedIn());

        user.setBestScore(2);
        Assertions.assertEquals(user.getBestScore(), 2);
    }

    @Test
    void testLocalUserFactory() {
        LocalUserFactory factory = new LocalUserFactory();

        Assertions.assertInstanceOf(GuestUser.class, factory.createGuest());

        IUser user = factory.create("", "test", 1);
        Assertions.assertInstanceOf(LocalUser.class, user);
        Assertions.assertEquals(user.getUsername(), "test");
        Assertions.assertEquals(user.getSessionId(), "test");
        Assertions.assertEquals(user.getBestScore(), 1);

    }

    @Test
    void testRemoteUserFactory() {
        RemoteUserFactory factory = new RemoteUserFactory();

        Assertions.assertInstanceOf(GuestUser.class, factory.createGuest());

        IUser user = factory.create("test", "test1", 1);
        Assertions.assertInstanceOf(RemoteUser.class, user);
        Assertions.assertEquals(user.getUsername(), "test1");
        Assertions.assertEquals(user.getSessionId(), "test");
        Assertions.assertEquals(user.getBestScore(), 1);
    }

    @Test
    void testUserManager() {
        DefaultUserManager manager = new DefaultUserManager();
        Assertions.assertNotNull(manager.getCurrentUser());

        manager.setUserLoggedIn("test1", "test1", 1);
        Assertions.assertInstanceOf(LocalUser.class, manager.getCurrentUser());
        Assertions.assertEquals(manager.getCurrentUser().getSessionId(), "test1");
        Assertions.assertEquals(manager.getCurrentUser().getUsername(), "test1");
        Assertions.assertEquals(manager.getCurrentUser().getBestScore(), 1);

        manager.setUserGuest();
        Assertions.assertInstanceOf(GuestUser.class, manager.getCurrentUser());
        Assertions.assertEquals(manager.getCurrentUser().getSessionId(), "Guest");
        Assertions.assertEquals(manager.getCurrentUser().getUsername(), "Guest");
        Assertions.assertEquals(manager.getCurrentUser().getBestScore(), 0);

        manager.setUserFactory(new RemoteUserFactory());
        manager.setUserLoggedIn("test", "test1", 1);
        Assertions.assertInstanceOf(RemoteUser.class, manager.getCurrentUser());
        Assertions.assertEquals(manager.getCurrentUser().getSessionId(), "test");
        Assertions.assertEquals(manager.getCurrentUser().getUsername(), "test1");
        Assertions.assertEquals(manager.getCurrentUser().getBestScore(), 1);

        Assertions.assertInstanceOf(RemoteUserFactory.class, manager.getUserFactory());
    }
}
