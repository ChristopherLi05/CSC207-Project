package use_case.calculator;

/**
 * Data transfer object (DTO) for holding the output of the calculator.
 * This class contains the calculated score which is presented to the user.
 */
public class CalculatorOutputData {

    /** The calculated score. */
    private final int score;

    /**
     * Constructs a new {@code CalculatorOutputData} object with the specified score.
     *
     * @param score The calculated score to be stored.
     */
    public CalculatorOutputData(int score) {
        this.score = score;
    }

    /**
     * Returns the calculated score.
     *
     * @return The calculated score.
     */
    public int getScore() {
        return score;
    }
}