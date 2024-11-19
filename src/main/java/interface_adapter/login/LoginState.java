package interface_adapter.login;

public class LoginState {
    private String username = "";
    private String loginError;
    private String password = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginError(String message) {
        this.loginError = message;
    }
}
