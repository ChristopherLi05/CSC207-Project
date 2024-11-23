package use_case.login;

import app.IApp;

public class LoginInteractor implements LoginInputBoundary {
    private final IApp app;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(IApp app, LoginOutputBoundary loginPresenter) {
        this.loginPresenter = loginPresenter;
        this.app = app;
    }

    public void guestLogin() {
        LoginOutputData loginOutputData = new LoginOutputData(app.getUserManager().getUserFactory().createGuest(), false);
        loginPresenter.prepareCalculatorView(loginOutputData);
    }

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

    public void signup() {
        loginPresenter.prepareSignupView();
    }
}
