package use_case.signup;

import data_access.DataAccessor;

/**
 * The Signup Interactor.
 */
public class SignupInteractor implements SignupInputBoundary {
    private final DataAccessor userDataAccessObject;
    private final SignupOutputBoundary userPresenter;

    /**
     * Constructs a new SignupInteractor with the specified output boundary and data access interface.
     *
     * @param signupOutputBoundary the output boundary for presenting views to the user.
     * @param signupDataAccessInterface the data access interface for handling user data storage.
     */
    public SignupInteractor(
            SignupOutputBoundary signupOutputBoundary,
            DataAccessor signupDataAccessInterface
    ) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
    }

    /**
     * Executes the signup process by validating the user input. If the user is signing up as a guest,
     * it presents the guest view. If the user enters mismatched passwords, it presents an error view.
     * Otherwise, it attempts to sign up the user by interacting with the data access layer, and then
     * presents the appropriate success or failure view.
     *
     * @param signupInputData the input data containing the user's signup information.
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToLoginView() {
        userPresenter.switchToLoginView();
    }
}