
package interface_adapter.signup;

//import interface_adapter.login.LoginState;
//import interface_adapter.login.LoginViewModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class SignupPresenter implements SignupOutputBoundary {
    @Override
    public void prepareSuccessView(SignupOutputData outputData) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }

    @Override
    public void switchToLoginView() {

    }
//
//    private final SignupViewState signupViewState;
//    private final LoginViewModel loginViewModel;
//    private final ViewManagerModel viewManagerModel;
//
//    public SignupPresenter(ViewManagerModel viewManagerModel,
//                           SignupViewState signupViewState,
//                           LoginViewModel loginViewModel) {
//        this.viewManagerModel = viewManagerModel;
//        this.signupViewState = signupViewState;
//        this.loginViewModel = loginViewModel;
//    }
//
//    @Override
//    public void prepareSuccessView(SignupOutputData response) {
//        // On success, switch to the login view.
//        final LoginState loginState = loginViewModel.getState();
//        loginState.setUsername(response.getUsername());
//        this.loginViewModel.setState(loginState);
//        loginViewModel.firePropertyChanged();
//
//        viewManagerModel.setState(loginViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//    }
//
//    @Override
//    public void prepareFailView(String error) {
//        final SignupState signupState = signupViewState.getState();
//        signupState.setUsernameError(error);
//        signupViewState.firePropertyChanged();
//    }
//
//    @Override
//    public void switchToLoginView() {
//        viewManagerModel.setState(loginViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//    }
}
