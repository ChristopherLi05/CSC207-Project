package use_case.trainer;

public interface TrainerOutputBoundry {

    void prepareSuccessView(String successMessage);

    /**
     * Prepares the failure view for the Change Password Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

}
