package interface_adapter.trainer;

import use_case.trainer.TrainerInputBoundry;
import use_case.trainer.TrainerInputData;

public class TrainerController {
    private final TrainerInputBoundry trainerUseCaseInteractor;

    public TrainerController(TrainerInputBoundry trainerUseCaseInteractor) {
        this.trainerUseCaseInteractor = trainerUseCaseInteractor;
    }


    public void execute(int attempt) {
        final TrainerInputData trainerInputData = new TrainerInputData(attempt);

        trainerUseCaseInteractor.execute(trainerInputData);
    }
}
