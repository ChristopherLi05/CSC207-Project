package view;

import interface_adapter.ViewState;
import interface_adapter.tabswitcher.TabSwitcherState;
import interface_adapter.tabswitcher.TabSwitcherController;


import javax.swing.*;

public class TabSwitcherView extends AbstractPanel<TabSwitcherState>{
    private final JButton Calculator;
    private final JButton Trainer;
    private final JButton Puzzle_Rush;

    private final TabSwitcherController tabSwitcherController;

    public TabSwitcherView(ViewState<TabSwitcherState> viewState) {
        super(viewState);

    }

}
