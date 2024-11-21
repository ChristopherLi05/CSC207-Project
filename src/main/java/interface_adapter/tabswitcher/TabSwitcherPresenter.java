package interface_adapter.tabswitcher;

import interface_adapter.ViewManager;
import interface_adapter.calculator.CalculatorState;
import interface_adapter.login.LoginViewState;
import interface_adapter.signup.SignupViewState;
import use_case.tabswitcher.TabSwitcherOutputBoundary;

import interface_adapter.calculator.CalculatorViewState;
import interface_adapter.trainer.TrainerViewState;
import interface_adapter.puzzlerush.PUzzleRushViewState;

public class TabSwitcherPresenter implements TabSwitcherOutputBoundary {
    private final TabSwitcherViewState tabswitcherViewState;
    private final CalculatorViewState calculatorViewState;
    private final TrainerViewState trainerViewState;
    private final PuzzleRushViewState puzzlerushViewState;
    private final ViewManager viewManager;

    public TabSwitcherViewState(TabSwitcherViewState tabswitcherViewState,
                                CalculatorViewState calculatorViewState,
                                TrainerViewState trainerViewState,
                                PuzzleRushViewState puzzlerushViewState,
                                ViewManager viewManager) {
        this.tabswitcherViewState = tabswitcherViewState;
        this.calculatorViewState = calculatorViewState;
        this.trainerViewState = trainerViewState;
        this.puzzlerushViewState = puzzlerushViewState;
        this.viewManager = viewManager;
    }

    @Override
    public void prepareCalculatorView() {
        final CalculatorState calculatorState = calculatorViewState.getState();
        this.calculatorViewState.setState(calculatorState);
        this.calculatorViewState.firePropertyChanged();

        this.viewManager.setView(calculatorViewState.getViewName());
    }

    @Override
    public void prepareTrainerView() {
        final TrainerState trainerState = trainerViewState.getState();
        this.trainerViewState.setState(trainerState);
        this.trainerViewState.firePropertyChanged();

        this.viewManager.setView(trainerViewState.getViewName());
    }

    @Override
    public void preparePuzzleRushView() {
        final PuzzlRushState puzzlerushState = puzzlerushViewState.getState();
        this.puzzlerushViewState.setState(puzzlerushState);
        this.puzzlerushViewState.firePropertyChanged();

        this.viewManager.setView(puzzlerushViewState.getViewName());
    }
}
