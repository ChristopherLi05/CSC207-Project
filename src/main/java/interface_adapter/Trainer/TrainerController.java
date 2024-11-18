package interface_adapter.Trainer;

import use_case.trainer.TrainerInputBoundry;
import use_case.trainer.TrainerInputData;

public class TrainerController {
    private final TrainerInputBoundry trainerUseCaseInteractor;

    public TrainerController(TrainerInputBoundry trainerUseCaseInteractor) {
        this.trainerUseCaseInteractor = trainerUseCaseInteractor;
    }


    public void execute(long attempt) {
        final TrainerInputData trainerInputData = new TrainerInputData(attempt);

        trainerUseCaseInteractor.execute(trainerInputData);
    }
}
