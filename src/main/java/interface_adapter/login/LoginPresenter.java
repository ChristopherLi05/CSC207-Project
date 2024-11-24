package interface_adapter.login;

import app.IApp;
import interface_adapter.signup.SignupViewState;
import interface_adapter.signup.SignupState;
import interface_adapter.calculator.CalculatorState;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final LoginViewState loginViewState;
    private final IApp app;
    private final SignupViewState signupViewState;
    private final interface_adapter.calculator.CalculatorViewState calculatorViewState;

    public LoginPresenter(IApp app,
                          LoginViewState loginViewState,
                          SignupViewState signupViewState,
                          interface_adapter.calculator.CalculatorViewState calculatorViewState) {
        this.loginViewState = loginViewState;
        this.signupViewState = signupViewState;
        this.calculatorViewState = calculatorViewState;
        this.app = app;
    }

    @Override
    public void prepareSignupView() {
        this.signupViewState.setState(new SignupState());
        this.signupViewState.firePropertyChanged();

        this.app.getViewManager().setView(signupViewState.getViewName());
    }

    @Override
    public void prepareCalculatorView(LoginOutputData loginOutputData) {
        this.calculatorViewState.setState(new CalculatorState());
        this.calculatorViewState.firePropertyChanged();

        this.app.getViewManager().setView(calculatorViewState.getViewName());
    }

    @Override
    public void prepareFailView(String message) {
        final LoginState loginState = loginViewState.getState();
        loginState.setLoginError(message);
        loginViewState.firePropertyChanged();
    }
}
