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

    /**
     * Constructor for the SignupViewState with default label values.
     *
     * @param viewName the name of the view.
     * @param signupState the state of the signup form.
     */
    public SignupViewState(String viewName, SignupState signupState) {
        this(viewName, signupState, "Sign Up View", "Choose username",
                "Choose password", "Enter password again", "Sign up",
                "Guest", "Go to Login");
    }

    /**
     * Constructor for the SignupViewState with custom label values.
     *
     * @param viewName the name of the view.
     * @param state the state of the signup form.
     * @param TITLE_LABEL label for the title of the signup view.
     * @param USERNAME_LABEL label for the username input field.
     * @param PASSWORD_LABEL label for the password input field.
     * @param REPEAT_PASSWORD_LABEL label for the repeat password input field.
     * @param SIGNUP_BUTTON_LABEL label for the signup button.
     * @param GUEST_BUTTON_LABEL label for the guest button.
     * @param TO_LOGIN_BUTTON_LABEL label for the button to navigate to the login view.
     */
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
