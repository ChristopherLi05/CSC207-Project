package view;

import interface_adapter.ViewState;
import interface_adapter.tabswitcher.TabSwitcherState;
import interface_adapter.tabswitcher.TabSwitcherController;


import javax.swing.*;

public class TabSwitcherView extends AbstractPanel<TabSwitcherState>{
    private final JButton calculator;
    private final JButton trainer;
    private final JButton puzzle_rush;

    private final TabSwitcherController tabSwitcherController;

    public TabSwitcherView(ViewState<TabSwitcherState> viewState) {
        super(viewState);

        final JPanel buttons = new JPanel();
        calculator = new JButton("Calculator");
        buttons.add(calculator);
        trainer = new JButton("Trainer");
        buttons.add(trainer);
        puzzle_rush = new JButton("Puzzle Rush");
        buttons.add(puzzle_rush);

//        calculator.addActionListener();
//        trainer.addActionListener();
//        puzzle_rush.addActionListener();

        this.add(buttons);
    }

}
