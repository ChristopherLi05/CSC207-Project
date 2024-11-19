package use_case.login;

import data_access.IDataAccessor;

public class LoginInteractor implements LoginInputBoundary {
    private final IDataAccessor dataAccessor;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(IDataAccessor dataAccessor,
                           LoginOutputBoundary loginPresenter) {
        this.dataAccessor = dataAccessor;
        this.loginPresenter = loginPresenter;
    }

    public void guestLogin() {
        final LoginOutputData loginOutputData = new LoginOutputData("Guest", false);
        loginPresenter.prepareCalculatorView(loginOutputData);
    }

    public void login(LoginInputData loginInputData) {
        final String username = loginInputData.getUsername();
        final String password = loginInputData.getPassword();
        final String result = dataAccessor.logIn(username, password);

        if (!result.equals(username)) {
            loginPresenter.prepareFailView("Incorrect username or password");
        } else {
            final LoginOutputData loginOutputData = new LoginOutputData(result, false);
            loginPresenter.prepareCalculatorView(loginOutputData);
        }
    }

    public void signup() {
        loginPresenter.prepareSignupView();
    }
}
