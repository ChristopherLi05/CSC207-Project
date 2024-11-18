package view;

import app.IApp;
import entity.calculator.mahjong.MahjongGroup;
import view.component.DisplayHandComponent;
import view.component.HandModifierComponent;
import view.component.TileSelectorComponent;

import java.awt.*;
import java.beans.PropertyChangeEvent;

public class TrainerView extends AbstractPanel<> {
    public TrainerView(IApp master) {
        super(master);

        private final TileSelectorComponent tileSelectorComponent;
        private final DisplayHandComponent displayHandComponent;
        private final HandModifierComponent handModifierComponent;

    public TrainerView(IApp master) {
            super(master);
            setLayout(new BorderLayout());

            // Initialize and add DisplayHandComponent at top
            displayHandComponent = new DisplayHandComponent();
            add(displayHandComponent, BorderLayout.NORTH);

            // Initialize and add TileSelectorComponent at center
            tileSelectorComponent = new TileSelectorComponent();
            add(tileSelectorComponent, BorderLayout.CENTER);

            // Initialize and add HandModifierComponent at right
            handModifierComponent = new HandModifierComponent();
            add(handModifierComponent, BorderLayout.EAST);
    }

}
    @Override
    public void submitscore(long attempt) {

    }
}
