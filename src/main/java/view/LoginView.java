package view;

import interface_adapter.ViewState;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel usernameInfo = new JPanel();
        usernameInfo.add(new JLabel("Username"));
        usernameInfo.add(usernameInputField);

        final JPanel passwordInfo = new JPanel();
        passwordInfo.add(new JLabel("Password"));
        passwordInfo.add(passwordInputField);

        final JPanel buttons = new JPanel();
        logIn = new JButton("log in");
        buttons.add(logIn);
        guest = new JButton("guest");
        buttons.add(guest);
        signup = new JButton("sign up");
        buttons.add(signup);

        logIn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)) {
                            final LoginState currentState = viewState.getState();

                            loginController.logIn(
                                    currentState.getUsername(),
                                    currentState.getPassword()
                            );
                        }
            }
        }
        );

        guest.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(guest)) {
                            loginController.guestLogin();
                        }
                    }
                }
        );

        signup.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signup)) {
                            loginController.signup();
                        }
                    }
                }
        );

        // TODO: add document listener for username and password to update LoginState

        this.add(title);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(buttons);
    }
}
