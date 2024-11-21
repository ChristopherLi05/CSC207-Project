package use_case.tabswitcher;

public class TabSwitcherInteractor implements TabSwitcherInputBoundary {
    private final TabSwitcherOutputBoundary tabswitcherPresenter;

    public TabSwitcherInteractor(TabSwitcherOutputBoundary tabswitcherPresenter) {
        this.tabswitcherPresenter = tabswitcherPresenter;
    }

    @Override
    public void calculator() {
        tabswitcherPresenter.prepareCalculatorView();
    }

    public void trainer() {
        tabswitcherPresenter.prepareTrainerView();
    }

    public void puzzlerush() {
        tabswitcherPresenter.preparePuzzleRushView();
    }

}
