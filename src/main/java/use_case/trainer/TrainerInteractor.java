package use_case.trainer;

import entity.calculator.Calculator;

public class TrainerInteractor implements TrainerInputBoundry {
    private final TrainerOutputBoundry trainerPresenter;

    public TrainerInteractor(TrainerOutputBoundry trainerOutputBoundry) {
        this.trainerPresenter = trainerOutputBoundry;
        }

        @Override
        public void execute(TrainerInputData TrainerInputData) {
            final long attempt = TrainerInputData.getAttempt();
            //TODO How to get the correct answer from calculator
            //TODO calcululate the correct answer and store it
            final long correctAnswer =
            if (!correctAnswer.equals(attempt)) {
                trainerPresenter.prepareFailView("Incorrect Answer. Correct Answer is \"" + correctAnswer + "\".");
            }
            else {
                trainerPresenter.prepareSuccessView("!!Correct Answer!!");
        }
    }
}
