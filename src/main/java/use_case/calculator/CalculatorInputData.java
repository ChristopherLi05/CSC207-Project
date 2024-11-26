package use_case.calculator;

import entity.calculator.HandState;

/**
 * Data transfer object (DTO) for Calculator input data.
 * Encapsulates the hand state needed for the calculation process.
 */
public class CalculatorInputData {

    /** The {@link HandState} representing the current hand for calculation. */
    public final HandState hand;

    /**
     * Constructs a new {@code CalculatorInputData} object with the specified hand state.
     *
     * @param hand The {@link HandState} to be used for calculation.
     */
    public CalculatorInputData(HandState hand) {
        this.hand = hand;
    }

    /**
     * Returns the {@link HandState} object representing the hand.
     *
     * @return The current hand as a {@link HandState}.
     */
    public HandState getHand() {
        return hand;
    }
}