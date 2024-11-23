package use_case.login;

public interface LoginInputBoundary {
    void guestLogin();

    void login(LoginInputData loginInputData);

    void signup();
}
