package view;

import interface_adapter.ViewState;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Login View
 */
public class LoginView extends AbstractPanel<LoginState> {
    private final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    private final JButton logIn;
    private final JButton guest;
    private final JButton signup;
    private LoginController loginController;

    public LoginView(ViewState<LoginState> viewState) {
        super(viewState);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel("Login Screen");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel usernameInfo = new JPanel();
        JLabel usernameInfoLabel = new JLabel("Username: ");
        usernameInfoLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        usernameInfo.add(usernameInfoLabel);
        usernameInfo.setFont(new Font("Arial", Font.PLAIN, 30));
        usernameInfo.add(usernameInputField);

        usernameInputField.setFont(new Font("Arial", Font.PLAIN, 30));

        final JPanel passwordInfo = new JPanel();
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        passwordInfo.add(passwordLabel);
        passwordInfo.setFont(new Font("Arial", Font.PLAIN, 30));
        passwordInfo.add(passwordInputField);

        passwordInputField.setFont(new Font("Arial", Font.PLAIN, 30));

        final JPanel buttons = new JPanel();
        logIn = new JButton("Log In");
        logIn.setFont(new Font("Arial", Font.PLAIN, 30));
        signup = new JButton("Go to Sign Up");
        signup.setFont(new Font("Arial", Font.PLAIN, 30));
        guest = new JButton("Guest");
        guest.setFont(new Font("Arial", Font.PLAIN, 30));
        buttons.add(logIn);
        buttons.add(signup);
        buttons.add(guest);

        logIn.addActionListener(
                evt -> {
                    char[] password = passwordInputField.getPassword();

                    loginController.logIn(
                            usernameInputField.getText(),
                            String.valueOf(password)
                    );

                    usernameInputField.setText("");
                    passwordInputField.setText("");

                    Arrays.fill(password, (char) 0);
                }

        );

        guest.addActionListener(evt -> loginController.guestLogin());
        signup.addActionListener(evt -> loginController.signup());

        this.add(title);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(buttons);
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}

