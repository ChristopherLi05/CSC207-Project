package interface_adapter.login;

public class LoginState {
    private String username = "";
    private String loginError;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLoginError(String message) {
        this.loginError = message;
    }
}
