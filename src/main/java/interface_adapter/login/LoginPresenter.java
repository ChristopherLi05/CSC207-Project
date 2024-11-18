package interface_adapter.login;

import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewState loginViewState;
    private final SignupViewState signupViewState;
    private final CalculatorViewState calculatorViewState;

    public LoginPresenter(LoginViewState loginViewState,
                          SignupViewState signupViewState,
                          CalculatorViewState calculatorViewState) {
        this.loginViewState = loginViewState;
        this.signupViewState = signupViewState;
        this.calculatorViewState = calculatorViewState;
    }

    @Override
    public void prepareSignupView(LoginOutputData loginOutputData) {

    }

    @Override
    public void prepareCalculatorView(LoginOutputData loginOutputData) {

    }

    @Override
    public void prepareFailView(String message) {

    }
}
