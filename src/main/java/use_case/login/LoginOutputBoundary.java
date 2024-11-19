package use_case.login;

public interface LoginOutputBoundary {
    void prepareSignupView();
    void prepareCalculatorView(LoginOutputData loginOutputData);
    void prepareFailView(String error);
}
