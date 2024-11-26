package interface_adapter.login;

import interface_adapter.ViewState;

public class LoginViewState extends ViewState<LoginState> {
    public LoginViewState(String viewName, LoginState state) {
        super(viewName, state, false);
    }
}
