package view.component;

import entity.calculator.mahjong.MahjongTile;
import interface_adapter.calculator.CalculatorViewState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class TileSelectorComponent extends JPanel {
    private final Color UNTOGGLE_COLOR = new Color(0xFFFFFF);
    private final Color TOGGLE_COLOR = new Color(0x89CFF0);

    private final CalculatorViewState calculatorViewState;

    private final JButton chiiButton;
    private final JButton ponButton;
    private final JButton closedKanButton;
    private final JButton openKanButton;

    public TileSelectorComponent(CalculatorViewState calculatorViewState, ActionListener tileListener) {
        this.calculatorViewState = calculatorViewState;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Control panel with action type buttons and checkboxes
        JPanel controlPanel = new JPanel(new FlowLayout());

        JCheckBox containsAkaCheckbox = new JCheckBox("Contains Aka");
        containsAkaCheckbox.addActionListener(e -> calculatorViewState.getState().setAka(containsAkaCheckbox.isSelected()));
        controlPanel.add(containsAkaCheckbox);

        // Action type buttons
        chiiButton = new JButton("Chii");
        chiiButton.addActionListener(e -> toggleSelectorType(ITileSelectorComponentState.SelectorType.CHII));
        chiiButton.setFocusPainted(false);
        controlPanel.add(chiiButton);

        ponButton = new JButton("Pon");
        ponButton.addActionListener(e -> toggleSelectorType(ITileSelectorComponentState.SelectorType.PON));
        ponButton.setFocusPainted(false);
        controlPanel.add(ponButton);

        closedKanButton = new JButton("Closed Kan");
        closedKanButton.addActionListener(e -> toggleSelectorType(ITileSelectorComponentState.SelectorType.CLOSED_KAN));
        closedKanButton.setFocusPainted(false);
        controlPanel.add(closedKanButton);

        openKanButton = new JButton("Open Kan");
        openKanButton.addActionListener(e -> toggleSelectorType(ITileSelectorComponentState.SelectorType.OPEN_KAN));
        openKanButton.setFocusPainted(false);
        controlPanel.add(openKanButton);

        toggleSelectorType(ITileSelectorComponentState.SelectorType.NONE);

        // Adding button to control panel
        add(controlPanel);

        // Tile panel with grid layout for Mahjong tiles
        JPanel tilePanel = new JPanel(new GridLayout(4, 9));

        // Initialize buttons for each MahjongTile in enum
        for (MahjongTile tile : MahjongTile.values()) {
            MahjongTileInputButton button = new MahjongTileInputButton(tile);
            button.addActionListener(tileListener);
            tilePanel.add(button);
        }

        tilePanel.add(new JLabel(""), 30);
        tilePanel.add(new JLabel(""), 34);

        add(tilePanel);

        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    public void toggleSelectorType(ITileSelectorComponentState.SelectorType newSelectorType) {
        ITileSelectorComponentState.SelectorType oldSelectorType = calculatorViewState.getState().getSelectorType();
        calculatorViewState.getState().setSelectorType(oldSelectorType == newSelectorType ? ITileSelectorComponentState.SelectorType.NONE : newSelectorType);
        newSelectorType = calculatorViewState.getState().getSelectorType();

        this.chiiButton.setBackground(newSelectorType == ITileSelectorComponentState.SelectorType.CHII ? TOGGLE_COLOR : UNTOGGLE_COLOR);
        this.ponButton.setBackground(newSelectorType == ITileSelectorComponentState.SelectorType.PON ? TOGGLE_COLOR : UNTOGGLE_COLOR);
        this.closedKanButton.setBackground(newSelectorType == ITileSelectorComponentState.SelectorType.CLOSED_KAN ? TOGGLE_COLOR : UNTOGGLE_COLOR);
        this.openKanButton.setBackground(newSelectorType == ITileSelectorComponentState.SelectorType.OPEN_KAN ? TOGGLE_COLOR : UNTOGGLE_COLOR);
    }
}
