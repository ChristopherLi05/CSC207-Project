package use_case.login;

import app.App;
import app.IApp;
import entity.user.user_type.IUser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class LoginInteractorTest {

    @Test
    void guestLoginTest() {
        IApp app = new App("Test");

        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSignupView() {fail("Signup view is unexpected.");}

            @Override
            public void prepareCalculatorView(LoginOutputData loginOutputData) {
                assertEquals("Guest", app.getUserManager().getCurrentUser().getUsername());
            }

            @Override
            public void prepareFailView(String error) {fail("Use case failure is unexpected.");}
        };

        LoginInputBoundary interactor = new LoginInteractor(app, presenter);
        interactor.guestLogin();
    }

    @Test
    void sucessLoginTest() {
        LoginInputData inputData = new LoginInputData("Max", "abc");
        IApp app = new App("Test");

        String username = inputData.getUsername();
        String password = inputData.getPassword();

        app.getDataAccessor().signUp(username, password);

        String sessionId = app.getDataAccessor().logIn(username, password);
        int bestScore = app.getDataAccessor().getBestScore(sessionId);

        IUser user = app.getUserManager().getUserFactory().create(sessionId, username, bestScore);
        app.getUserManager().setUserLoggedIn(user.getSessionId(), user.getUsername(), user.getBestScore());

        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSignupView() {fail("Signup view is unexpected.");}

            @Override
            public void prepareCalculatorView(LoginOutputData loginOutputData) {
                assertEquals("Max", user.getUsername());
            }

            @Override
            public void prepareFailView(String error) {fail("Use case failure is unexpected.");}
        };

        LoginInputBoundary interactor = new LoginInteractor(app, presenter);
        interactor.login(inputData);
    }

    @Test
    void sucessLoggedinTest() {
        LoginInputData inputData = new LoginInputData("Max", "abc");
        IApp app = new App("Test");

        String username = inputData.getUsername();
        String password = inputData.getPassword();

        app.getDataAccessor().signUp(username, password);

        String sessionId = app.getDataAccessor().logIn(username, password);
        int bestScore = app.getDataAccessor().getBestScore(sessionId);

        app.getUserManager().setUserLoggedIn(sessionId, username, bestScore);

        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSignupView() {fail("Signup view is unexpected.");}

            @Override
            public void prepareCalculatorView(LoginOutputData loginOutputData) {
                assertEquals("Max", app.getUserManager().getCurrentUser().getUsername());
            }

            @Override
            public void prepareFailView(String error) {fail("Use case failure is unexpected.");}
        };

        LoginInputBoundary interactor = new LoginInteractor(app, presenter);
        interactor.login(inputData);
    }

    @Test
    void failureWrongPasswordTest() {
        LoginInputData inputData = new LoginInputData("Max", "123");
        IApp app = new App("Test");

        String username = "Max";
        String password = "abc";

        app.getDataAccessor().signUp(username, password);

        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSignupView() {fail("Signup view is unexpected.");}

            @Override
            public void prepareCalculatorView(LoginOutputData loginOutputData) {fail("Calculator view is unexpected");}

            @Override
            public void prepareFailView(String error) {
                assertEquals("Incorrect username or password", error);}
        };

        LoginInputBoundary interactor = new LoginInteractor(app, presenter);
        interactor.login(inputData);
    }

    @Test
    void failureUserDoesNotExistTest() {
        LoginInputData inputData = new LoginInputData("Max", "123");
        IApp app = new App("Test");

        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSignupView() {fail("Signup view is unexpected.");}

            @Override
            public void prepareCalculatorView(LoginOutputData loginOutputData) {fail("Calculator view is unexpected");}

            @Override
            public void prepareFailView(String error) {
                assertEquals("Incorrect username or password", error);}
        };

        LoginInputBoundary interactor = new LoginInteractor(app, presenter);
        interactor.login(inputData);
    }


    @Test
    void signUpTest() {
        IApp app = new App("Test");

        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSignupView() {
                assertEquals("Guest", app.getUserManager().getCurrentUser().getUsername());
            }

            @Override
            public void prepareCalculatorView(LoginOutputData loginOutputData) {fail("Calculator view is unexpected");}

            @Override
            public void prepareFailView(String error) {fail("Use case failure is unexpected.");}
        };

        LoginInputBoundary interactor = new LoginInteractor(app, presenter);
        interactor.signup();
    }
}
