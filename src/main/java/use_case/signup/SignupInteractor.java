package use_case.signup;

import data_access.IDataAccessor;
import entity.user.IUserFactory;
import entity.user.IUserManager;
import entity.user.UserCreationDataAccessor;
import entity.user.user_type.IUser;

/**
 * The Signup Interactor.
 */
public class SignupInteractor implements SignupInputBoundary {
    private final IDataAccessor userDataAccessObject;
    private final SignupOutputBoundary userPresenter;

    public SignupInteractor(
            SignupOutputBoundary signupOutputBoundary,
            IDataAccessor signupDataAccessInterface
    ) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        if (signupInputData.isGuest()) {
            userPresenter.prepareGuestView();
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Password does not match");
        } else {
            boolean success = userDataAccessObject.signUp(signupInputData.getUsername(), signupInputData.getPassword());
            if (success) {
                userPresenter.prepareSuccessView(new SignupOutputData(signupInputData.getUsername(), false));
            } else {
                userPresenter.prepareFailView("Error");
            }
        }
    }

    @Override
    public void switchToLoginView() {
        userPresenter.switchToLoginView();
    }
}