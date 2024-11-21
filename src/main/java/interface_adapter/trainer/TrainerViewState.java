package interface_adapter.trainer;

import interface_adapter.ViewState;

public class TrainerViewState extends ViewState<TrainerState> {
    public TrainerViewState(String viewName, TrainerState state) {
        super(viewName, state);
    }
}
