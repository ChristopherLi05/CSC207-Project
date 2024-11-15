package view;

import app.IApp;

import java.beans.PropertyChangeEvent;

public class SignupView extends AbstractPanel {
    public SignupView(IApp master) {
        super(master);
    }

    @Override
    public String getViewName() {
        return "SignupView";
    }
}
