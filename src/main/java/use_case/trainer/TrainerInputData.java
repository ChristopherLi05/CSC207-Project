package use_case.trainer;

public class TrainerInputData {

    private final long attempt;

    public TrainerInputData(long attempt) {
        this.attempt = attempt;
    }

    long getAttempt() {
            return attempt;
        }
}
