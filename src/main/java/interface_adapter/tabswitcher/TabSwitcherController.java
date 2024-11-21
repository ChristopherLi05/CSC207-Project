package interface_adapter.tabswitcher;

import use_case.tabswitcher.TabSwitcherInputBoundary;

public class TabSwitcherController {
    private TabSwitcherInputBoundary tabswitcherUseCaseInteractor;

    public TabSwitcherController(TabSwitcherInputBoundary tabswitcherUseCaseInteractor) {
        this.tabswitcherUseCaseInteractor = tabswitcherUseCaseInteractor;
    }

    public void calculator() {
        tabswitcherUseCaseInteractor.calculator();
    }

    public void trainer() {
        tabswitcherUseCaseInteractor.trainer();
    }

    public void puzzlerush() {
        tabswitcherUseCaseInteractor.puzzlerush();
    }
}
