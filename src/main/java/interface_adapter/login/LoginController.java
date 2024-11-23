package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

public class LoginController {
    private final LoginInputBoundary loginUseCaseInteractor;

    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    public void guestLogin() {
        loginUseCaseInteractor.guestLogin();
    }

    public void logIn(String username, String password) {
        final LoginInputData loginInputData = new LoginInputData(username, password);
        loginUseCaseInteractor.login(loginInputData);
    }

    public void signup() {
        loginUseCaseInteractor.signup();
    }
}
