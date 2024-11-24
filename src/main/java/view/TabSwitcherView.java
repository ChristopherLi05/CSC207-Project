package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TabSwitcherView extends JPanel {
    private final JButton calculator;
    private final JButton trainer;
    private final JButton puzzlerush;

    public TabSwitcherView() {

        final JPanel buttons = new JPanel();
        calculator = new JButton("Calculator");
        buttons.add(calculator);
        trainer = new JButton("Trainer");
        buttons.add(trainer);
        puzzlerush = new JButton("Puzzle Rush");
        buttons.add(puzzlerush);

//        calculator.addActionListener();
//        trainer.addActionListener();
//        puzzlerush.addActionListener();

        this.add(buttons);
    }
}
