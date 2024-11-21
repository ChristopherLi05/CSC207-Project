package view;


import interface_adapter.trainer.TrainerState;
import interface_adapter.trainer.TrainerViewState;

public class TrainerView extends AbstractPanel<TrainerState> {
    public TrainerView(TrainerViewState viewState) {
        super(viewState);
    }
}
