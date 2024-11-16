package view;

import app.IApp;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;

public class LoginView extends AbstractPanel {

    private final String viewName = "log in";
    private final LoginViewModel loginViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    private final JButton logIn;
    private final JButton guest;
    private LoginController loginController;

    public LoginView(IApp master) {
        super(master);

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

        logIn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(logIn)) {
                            final LoginState currentState = loginViewModel.getState();

                            loginController.execute();
                        }
                    }
                }
        );

        guest.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );


        this.add(title);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(buttons);
    }
}