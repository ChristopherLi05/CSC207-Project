package use_case.signup;

import data_access.IDataAccessor;
import entity.leaderboard.LeaderboardEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class SignupUseCaseTest {
    @Test
    void testExecute_withGuestUser() {
        TestSignupOutputBoundary presenter = new TestSignupOutputBoundary();
        TestDataAccessor dataAccessor = new TestDataAccessor();
        SignupInteractor interactor = new SignupInteractor(presenter, dataAccessor);

        SignupInputData inputData = new SignupInputData();

        interactor.execute(inputData);

        assertEquals("Guest view prepared", presenter.lastMessage);
    }

    @Test
    void testExecute_withMismatchedPasswords() {
        TestSignupOutputBoundary presenter = new TestSignupOutputBoundary();
        TestDataAccessor dataAccessor = new TestDataAccessor();
        SignupInteractor interactor = new SignupInteractor(presenter, dataAccessor);

        SignupInputData inputData = new SignupInputData("a","password123","password321");

        interactor.execute(inputData);

        assertEquals("Password does not match", presenter.lastMessage);
    }

    @Test
    void testExecute_withSignupSuccess() {
        TestSignupOutputBoundary presenter = new TestSignupOutputBoundary();
        TestDataAccessor dataAccessor = new TestDataAccessor();
        dataAccessor.setSignupSuccess(true); // Simulate successful signup
        SignupInteractor interactor = new SignupInteractor(presenter, dataAccessor);

        SignupInputData inputData = new SignupInputData("a","password123","password123");

        interactor.execute(inputData);

        assertEquals("Success: a", presenter.lastMessage);
    }

    @Test
    void testExecute_withSignupFailure() {
        TestSignupOutputBoundary presenter = new TestSignupOutputBoundary();
        TestDataAccessor dataAccessor = new TestDataAccessor();
        dataAccessor.setSignupSuccess(false); // Simulate failed signup
        SignupInteractor interactor = new SignupInteractor(presenter, dataAccessor);

        SignupInputData inputData = new SignupInputData("a","password123","password123");

        interactor.execute(inputData);

        assertEquals("Error", presenter.lastMessage);
    }

    @Test
    void testSwitchToLoginView() {
        TestSignupOutputBoundary presenter = new TestSignupOutputBoundary();
        TestDataAccessor dataAccessor = new TestDataAccessor();
        SignupInteractor interactor = new SignupInteractor(presenter, dataAccessor);

        interactor.switchToLoginView();

        assertEquals("Switched to login view", presenter.lastMessage);
    }

    static class TestSignupOutputBoundary implements SignupOutputBoundary {
        String lastMessage;

        @Override
        public void prepareGuestView() {
            lastMessage = "Guest view prepared";
        }

        @Override
        public void prepareFailView(String errorMessage) {
            lastMessage = errorMessage;
        }

        @Override
        public void prepareSuccessView(SignupOutputData outputData) {
            lastMessage = "Success: " + outputData.getUsername();
        }

        @Override
        public void switchToLoginView() {
            lastMessage = "Switched to login view";
        }
    }

    static class TestDataAccessor implements IDataAccessor {
        private boolean signupSuccess;

        void setSignupSuccess(boolean signupSuccess) {
            this.signupSuccess = signupSuccess;
        }

        @Override
        public boolean signUp(String username, String password) {
            return signupSuccess;
        }

        @Override
        public String logIn(String username, String password) {
            return "";
        }

        @Override
        public List<LeaderboardEntry> getTopTenLeaderboard() {
            return List.of();
        }

        @Override
        public void updateScore(String sessionId, int score) {

        }

        @Override
        public int getBestScore(String sessionId) {
            return 0;
        }
    }

}
