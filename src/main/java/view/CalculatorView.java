package view;

import app.IApp;
import entity.calculator.mahjong.MahjongTile;
import view.component.MahjongTileInputButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

public class CalculatorView extends AbstractPanel implements ActionListener {
    public CalculatorView(IApp master) {
        super(master);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof MahjongTileInputButton) {
            MahjongTileInputButton button = (MahjongTileInputButton) e.getSource();
            MahjongTile tile = button.getMahjongTile();

            // displayHandComponent.addTile(...);
        }
    }
}
