package view;

import java.awt.*;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import interface_adapter.ViewManager;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewState;
import view.component.LabelTextPanel;

/**
 * Signup View
 */
public class SignupView extends AbstractPanel<SignupState> {
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private SignupController signupController;

    private final JButton signUp;
    private final JButton guest;
    private final JButton toLogin;

    /**
     * Constructs the SignupView with the provided view state and view manager.
     *
     * The constructor initializes the components for the signup form, including
     * labels, input fields, and buttons. Action listeners are added to the buttons
     * to handle user interactions.
     *
     * @param viewState the current state of the signup view, used for labels and text.
     * @param viewManager the manager that controls the switching of views.
     */
    public SignupView(SignupViewState viewState, ViewManager viewManager) {
        super(viewState);

        final JLabel title = new JLabel("Sign Up Screen");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(viewState.USERNAME_LABEL), usernameInputField);
        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(viewState.PASSWORD_LABEL), passwordInputField);
        final LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(viewState.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);

        final JPanel buttons = new JPanel();
        toLogin = new JButton(viewState.TO_LOGIN_BUTTON_LABEL);
        toLogin.setFont(new Font("Arial", Font.PLAIN, 30));
        buttons.add(toLogin);
        signUp = new JButton(viewState.SIGNUP_BUTTON_LABEL);
        signUp.setFont(new Font("Arial", Font.PLAIN, 30));
        buttons.add(signUp);
        guest = new JButton(viewState.GUEST_BUTTON_LABEL);
        guest.setFont(new Font("Arial", Font.PLAIN, 30));
        buttons.add(guest);

        toLogin.addActionListener(e -> signupController.switchToLoginView());
        signUp.addActionListener(e -> {
            char[] pwd = passwordInputField.getPassword();
            char[] rpwd = repeatPasswordInputField.getPassword();

            signupController.signUp(usernameInputField.getText(), String.valueOf(pwd), String.valueOf(rpwd));

            passwordInputField.setText("");
            repeatPasswordInputField.setText("");

            Arrays.fill(pwd, (char) 0);
            Arrays.fill(rpwd, (char) 0);
        });
        guest.addActionListener(e -> signupController.guest());

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);
    }

    /**
     * Sets the SignupController for this view to execute user actions.
     *
     * @param controller the controller responsible for the signup process.
     */
    public void setSignupController(SignupController controller) {
        this.signupController = controller;
    }
}