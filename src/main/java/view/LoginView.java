package view;

import app.IApp;

import java.beans.PropertyChangeEvent;

public class LoginView extends AbstractPanel {
    public LoginView(IApp master) {
        super(master);
    }

    @Override
    public String getViewName() {
        return "LoginView";
    }
}
