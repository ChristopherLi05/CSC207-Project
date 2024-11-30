package use_case.login;

import app.App;

/**
 * The Login Interactor.
 */
public class LoginInteractor implements LoginInputBoundary {
    private final App app;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(App app, LoginOutputBoundary loginPresenter) {
        this.loginPresenter = loginPresenter;
        this.app = app;
    }

    /**
     * Executes the login use case, but as guest.
     */
    public void guestLogin() {
        LoginOutputData loginOutputData = new LoginOutputData(app.getUserManager().getUserFactory().createGuest(), false);
        loginPresenter.prepareCalculatorView(loginOutputData);
    }

    /**
     * Executes the login use case.
     * @param loginInputData the input data
     */
    public void login(LoginInputData loginInputData) {
        final String username = loginInputData.getUsername();
        final String password = loginInputData.getPassword();
        final String result = app.getDataAccessor().logIn(username, password);

        if (result == null) {
            loginPresenter.prepareFailView("Incorrect username or password");
        } else {
            int bestScore = app.getDataAccessor().getBestScore(result);
            final LoginOutputData loginOutputData = new LoginOutputData(app.getUserManager().getUserFactory().create(result, username, bestScore), false);
            loginPresenter.prepareCalculatorView(loginOutputData);
        }
    }

    /**
     * Takes user back to Signup View
     */
    public void signup() {
        loginPresenter.prepareSignupView();
    }
}
