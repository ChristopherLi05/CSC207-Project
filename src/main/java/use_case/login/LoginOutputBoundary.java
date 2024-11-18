package use_case.login;

public interface LoginOutputBoundary {
    void prepareSignupView(LoginOutputData loginOutputData);
    void prepareCalculatorView(LoginOutputData loginOutputData);
    void prepareFailView(String error);
}
