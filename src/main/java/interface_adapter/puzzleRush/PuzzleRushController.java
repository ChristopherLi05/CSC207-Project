package interface_adapter.puzzleRush;

import entity.calculator.HandState;
import use_case.puzzleRush.PuzzleRushInputBoundary;
import use_case.puzzleRush.PuzzleRushInputData;

/**
 * The {@code PuzzleRushController} class is responsible for handling the interaction between
 * the input data and the use case logic for the Puzzle Rush game. It acts as the controller
 * in the MVC pattern, orchestrating the flow of information from the user input to the use case.
 */
public class PuzzleRushController {
    private final PuzzleRushInputBoundary inputBoundary;

    /**
     * Constructs a new {@code PuzzleRushController} with the given input boundary.
     *
     * @param inputBoundary the input boundary for the Puzzle Rush use case, which handles the business logic
     */
    public PuzzleRushController(PuzzleRushInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Executes the Puzzle Rush use case by passing the proposed score and the current hand state.
     * This method prepares the input data and delegates the execution to the input boundary.
     *
     * @param proposedScore the score that the user proposes for the current hand
     * @param handState the current state of the hand (represented by {@code HandState})
     */
    public void execute(int proposedScore, HandState handState) {

        inputBoundary.execute(new PuzzleRushInputData(proposedScore, handState));
    }
}
