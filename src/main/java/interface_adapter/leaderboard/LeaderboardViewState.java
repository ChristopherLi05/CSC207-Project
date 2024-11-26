package interface_adapter.leaderboard;

import interface_adapter.ViewState;

/**
 * The {@code LeaderboardViewState} class represents the view state for the leaderboard in the application.
 * It extends {@code ViewState} and contains labels for the title, name, and score columns in the leaderboard view.
 */
public class LeaderboardViewState extends ViewState<LeaderboardState> {
    public final String TITLE_LABEL;
    public final String NAME_LABEL;
    public final String SCORE_LABEL;

    /**
     * Constructs a new {@code LeaderboardViewState} with the specified view name and state,
     * using default labels for the leaderboard columns.
     *
     * @param viewName the name of the view
     * @param state the current {@code LeaderboardState} representing the leaderboard data
     */
    public LeaderboardViewState(String viewName, LeaderboardState state) {
        this(viewName, state, "Leaderboard", "Name", "Score");
    }

    /**
     * Constructs a new {@code LeaderboardViewState} with the specified view name, state,
     * and custom labels for the leaderboard columns.
     *
     * @param viewName the name of the view
     * @param state the current {@code LeaderboardState} representing the leaderboard data
     * @param TITLE_LABEL the label for the title column
     * @param NAME_LABEL the label for the name column
     * @param SCORE_LABEL the label for the score column
     */
    public LeaderboardViewState(String viewName, LeaderboardState state, String TITLE_LABEL, String NAME_LABEL, String SCORE_LABEL) {
        super(viewName, state);

        this.TITLE_LABEL = TITLE_LABEL;
        this.NAME_LABEL = NAME_LABEL;
        this.SCORE_LABEL = SCORE_LABEL;
    }
}
