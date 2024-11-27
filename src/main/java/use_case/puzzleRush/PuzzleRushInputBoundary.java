package use_case.puzzleRush;

/**
 * Represents the input boundary for the Puzzle Rush use case, adhering to the
 * Clean Architecture principle of separating the application's core use case logic
 * from its external layers (e.g., user interface or database).
 *
 * This interface defines a contract for executing Puzzle Rush logic using input data.
 */
public interface PuzzleRushInputBoundary {

    /**
     * Executes the Puzzle Rush use case logic using the provided input data.
     *
     * Implementations of this method will process the given {@link PuzzleRushInputData}
     * and coordinate the appropriate logic to complete the Puzzle Rush use case.
     *
     * @param data An object containing the input data required to execute the Puzzle Rush logic.
     *             This data is encapsulated in the {@link PuzzleRushInputData} class.
     */
    void execute(PuzzleRushInputData data);
}
