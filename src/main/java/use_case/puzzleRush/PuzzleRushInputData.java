package use_case.puzzleRush;

import entity.calculator.HandState;

/**
 * Represents the input data for the Puzzle Rush use case.
 * This class encapsulates the data required to evaluate or process a Puzzle Rush attempt,
 * including the proposed score and the state of the hand involved in the calculation.
 */
public class PuzzleRushInputData {
    private final int proposedScore;
    private final HandState handState;

    /**
     * Constructs a new {@code PuzzleRushInputData} object.
     *
     * @param proposedScore The score proposed for the current puzzle attempt.
     * @param handState     The state of the hand used to evaluate the puzzle. This object
     *                      contains detailed information about the hand's tiles and related state.
     */
    public PuzzleRushInputData(int proposedScore, HandState handState) {
        this.proposedScore = proposedScore;
        this.handState = handState;
    }

    /**
     * Returns the state of the hand for this Puzzle Rush attempt.
     *
     * @return A {@link HandState} object containing the current hand's details.
     */
    public HandState getHandState() {
        return handState;
    }

    /**
     * Returns the proposed score for this Puzzle Rush attempt.
     *
     * @return The proposed score as an integer.
     */
    public int getProposedScore() {
        return proposedScore;
    }
}
