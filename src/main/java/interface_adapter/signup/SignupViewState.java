package interface_adapter.signup;

import interface_adapter.ViewState;

/**
 * The ViewModel for the Signup View.
 */
public class SignupViewState extends ViewState<SignupState> {
    public String TITLE_LABEL;
    public String USERNAME_LABEL;
    public String PASSWORD_LABEL;
    public String REPEAT_PASSWORD_LABEL;

    public String SIGNUP_BUTTON_LABEL;
    public String GUEST_BUTTON_LABEL;

    public String TO_LOGIN_BUTTON_LABEL;

    public SignupViewState(String viewName, SignupState signupState) {
        this(viewName, signupState, "Sign Up View", "Choose username",
                "Choose password", "Enter password again", "Sign up",
                "Guest", "Go to Login");
    }

    public SignupViewState(String viewName, SignupState state, String TITLE_LABEL, String USERNAME_LABEL, String PASSWORD_LABEL, String REPEAT_PASSWORD_LABEL, String SIGNUP_BUTTON_LABEL, String GUEST_BUTTON_LABEL, String TO_LOGIN_BUTTON_LABEL) {
        super(viewName, state, false);

        this.TITLE_LABEL = TITLE_LABEL;
        this.USERNAME_LABEL = USERNAME_LABEL;
        this.PASSWORD_LABEL = PASSWORD_LABEL;
        this.REPEAT_PASSWORD_LABEL = REPEAT_PASSWORD_LABEL;

        this.SIGNUP_BUTTON_LABEL = SIGNUP_BUTTON_LABEL;
        this.GUEST_BUTTON_LABEL = GUEST_BUTTON_LABEL;

        this.TO_LOGIN_BUTTON_LABEL = TO_LOGIN_BUTTON_LABEL;
    }
}
