package view;

import interface_adapter.ViewState;
import interface_adapter.login.LoginState;

public class LoginView extends AbstractPanel<LoginState> {
    public LoginView(ViewState<LoginState> viewState) {
        super(viewState);
    }
}
