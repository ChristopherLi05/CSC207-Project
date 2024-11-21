package use_case.trainer;

import entity.calculator.Calculator;

public class TrainerInteractor implements TrainerInputBoundry {
    private final TrainerOutputBoundry trainerPresenter;

    public TrainerInteractor(TrainerOutputBoundry trainerOutputBoundry) {
        this.trainerPresenter = trainerOutputBoundry;
    }

    @Override
    public void execute(TrainerInputData inputData) {
        int attempt = inputData.getAttempt();
        int correctAnswer = Calculator.calculateScore(inputData.getHandState());
        if (correctAnswer != attempt) {
            trainerPresenter.prepareFailView("Incorrect Answer. Correct Answer is \"" + correctAnswer + "\".");
        } else {
            trainerPresenter.prepareSuccessView("!!Correct Answer!!");
        }
    }
}
