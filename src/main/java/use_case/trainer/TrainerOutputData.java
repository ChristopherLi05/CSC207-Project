package use_case.trainer;

/**
 * Output Data for the Change Password Use Case.
 */
public class TrainerOutputData {

    private final long correctAnswer;

    private final boolean useCaseFailed;

    public TrainerOutputData(long correctAnswer, boolean useCaseFailed) {
        this.correctAnswer = correctAnswer;
        this.useCaseFailed = useCaseFailed;
    }

    public long getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}