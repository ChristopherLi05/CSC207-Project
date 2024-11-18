package interface_adapter.leaderboard;

import interface_adapter.ViewState;

public class LeaderboardViewState extends ViewState<LeaderboardState> {
    public final String TITLE_LABEL;
    public final String NAME_LABEL;
    public final String SCORE_LABEL;

    public LeaderboardViewState(String viewName, LeaderboardState state) {
        this(viewName, state, "Leaderboard", "Name", "Score");
    }

    public LeaderboardViewState(String viewName, LeaderboardState state, String TITLE_LABEL, String NAME_LABEL, String SCORE_LABEL) {
        super(viewName, state);

        this.TITLE_LABEL = TITLE_LABEL;
        this.NAME_LABEL = NAME_LABEL;
        this.SCORE_LABEL = SCORE_LABEL;
    }
}
