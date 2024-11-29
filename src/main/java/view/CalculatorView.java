package view;

import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import interface_adapter.ViewManager;
import interface_adapter.addTile.AddTileController;
import interface_adapter.calculator.CalculatorController;
import interface_adapter.calculator.CalculatorState;
import interface_adapter.calculator.CalculatorViewState;
import view.component.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import static entity.calculator.mahjong.MahjongTile.EAST_WIND;

/**
 * Calculator View
 */
public class CalculatorView extends AbstractPanel<CalculatorState> implements ActionListener, PropertyChangeListener {
    private final TileSelectorComponent tileSelectorComponent;
    private final DisplayHandComponent displayHandComponent;
    private AddTileController addTileController;
    private CalculatorController calculatorController;
    private JLabel scoreLabel;

    /**
     * Constructs CalculatorView with specified view state and view manager.
     * @param viewState the concrete observer that observes calculatorState
     * @param viewManager the manager that handles view transitions
     */
    public CalculatorView(CalculatorViewState viewState, ViewManager viewManager, IHandStateFactory handStateFactory) {
        super(viewState);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Calculator");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        this.add(new TabSwitcherComponent(viewManager));
        viewState.addPropertyChangeListener(this);

        // Initialize and add DisplayHandComponent at top
        displayHandComponent = new DisplayHandComponent(true);
        add(displayHandComponent);
        viewState.addPropertyChangeListener(displayHandComponent);

        // Initialize and add TileSelectorComponent at center
        tileSelectorComponent = new TileSelectorComponent(viewState, this);
        JPanel dontStretch = new JPanel(new FlowLayout());
        dontStretch.add(tileSelectorComponent);
        add(dontStretch);

        add(Box.createVerticalGlue());

        final JPanel buttons = new JPanel();
        JButton calculate = new JButton("calculate");
        calculate.setFont(new Font("Arial", Font.PLAIN, 30));
        scoreLabel = new JLabel("Score: ");
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        JButton reset = new JButton("reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 30));

        buttons.add(scoreLabel);
        buttons.add(calculate);
        buttons.add(reset);

        calculate.addActionListener(evt -> {
            List<MahjongTile> closedTiles = viewState.getState().getClosedTiles();
            List<MahjongGroup> closedGroups = viewState.getState().getClosedGroup();
            List<MahjongGroup> openGroups = viewState.getState().getOpenGroups();
            MahjongTile winningTile = viewState.getState().getWinningTile();

            HandState handstate =
                    handStateFactory.createHandState(closedTiles, closedGroups, openGroups, winningTile, new ArrayList<>(), new ArrayList<>(), EAST_WIND, EAST_WIND, true, false, false, false, false, false, false, false, false);
            calculatorController.execute(handstate);
        });

        reset.addActionListener(evt -> {
            displayHandComponent.reset(viewState.getState());
        });

        this.add(buttons, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Instruction");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout()); // Use BorderLayout for alignment

        // Create a multi-line label with HTML
        JLabel multiLineLabel = new JLabel("<html>Instruction<br>1. Put in the hand you want to know the value of.<br>2. Press calculate<br>3. Press Reset to reset hand</html>");
        multiLineLabel.setFont(new Font("Arial", Font.PLAIN, 25)); // Set font size
        multiLineLabel.setHorizontalAlignment(SwingConstants.CENTER); // Align text inside the label

        // Create a panel for the label
        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.add(multiLineLabel, BorderLayout.CENTER); // Align label to the right of the panel
        labelPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Optional padding

        // Add the panel to the right side of the frame
        this.add(labelPanel, BorderLayout.SOUTH);
    }

    /**
     * @return the DisplayHandComponent that displays the selected tiles and groups
     */
    public DisplayHandComponent getDisplayHandComponent() {
        return displayHandComponent;
    }

    /**
     * Handles actions performed within view.
     * @param e the action event that was triggered
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Execute controller.
        if (e.getSource() instanceof MahjongTileInputButton) {
            MahjongTile clickedTile = ((MahjongTileInputButton) e.getSource()).getMahjongTile();
            boolean isAka = getViewState().getState().isAka();
            ITileSelectorComponentState.SelectorType selectorType = getViewState().getState().getSelectorType();

            addTileController.execute(clickedTile, isAka, selectorType);
        }
    }

    /**
     * Sets controller for addTile use case
     * @param addTileController the controller for the addTile use case
     */
    public void setAddTileController(AddTileController addTileController) {
        this.addTileController = addTileController;
    }

    /**
     * Handles property changes in state.
     * @param evt the property change event that was triggered
     */
    public void setCalculatorController(CalculatorController calculatorController) {
        this.calculatorController = calculatorController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        scoreLabel.setText("Output: " + getViewState().getState().getMessageState());
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 30));
    }
}
