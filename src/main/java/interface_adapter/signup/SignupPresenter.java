
package interface_adapter.signup;

import interface_adapter.ViewManager;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class SignupPresenter implements SignupOutputBoundary {

    private final SignupViewState signupViewState;
    private final LoginViewModel loginViewModel;
    private final ViewManager viewManager;

    public SignupPresenter(ViewManager viewManager,
                           SignupViewState signupViewState,
                           LoginViewModel loginViewModel) {
        this.viewManager = viewManager;
        this.signupViewState = signupViewState;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(SignupOutputData response) {
        // On success, switch to the login view.
        final LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewState.firePropertyChanged();

        this.switchToLoginView();
    }

    @Override
    public void prepareFailView(String error) {
        final SignupState signupState = signupViewState.getState();
        signupState.setUsernameError(error);
        signupViewState.firePropertyChanged();
    }

    @Override
    public void switchToLoginView() {
        viewManager.setState(loginViewModel.getViewName());
        viewManager.firePropertyChanged();
    }
}
