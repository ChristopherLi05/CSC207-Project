package use_case.login;

public class LoginOutputData {
    private final String sessionId;
    private final boolean useCaseFailed;

    public LoginOutputData(String sessionId, boolean useCaseFailed) {
        this.sessionId = sessionId;
        this.useCaseFailed = useCaseFailed;
    }

    public String getSessionId() {
        return sessionId;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
