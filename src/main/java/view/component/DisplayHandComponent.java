package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayHandComponent extends JPanel implements PropertyChangeListener {
    private final boolean modifyTiles;

    private final TileShower closedTiles;
    private final GroupShower closedGroups;
    private final GroupShower openGroups;

    public DisplayHandComponent(boolean modifyTiles) {
        this.modifyTiles = modifyTiles;

        this.closedTiles = new TileShower();
        this.closedGroups = new GroupShower();
        this.openGroups = new GroupShower();

        this.add(this.closedTiles);
        this.add(this.closedGroups);
        this.add(this.openGroups);
        this.add(new JPanel());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!(evt.getNewValue() instanceof IDisplayHandComponentState)) return;
        ITileModifierState state = (ITileModifierState) evt.getNewValue();

        this.closedTiles.removeAll();
        List<MahjongTile> tiles = new ArrayList<>(state.getClosedTiles());

        if (state.getWinningTile() != null) {
            tiles.add(state.getWinningTile());
        }
        this.closedTiles.displayTiles(tiles);

        this.closedGroups.removeAll();
        this.closedGroups.displayGroups(state.getClosedGroup());

        this.openGroups.removeAll();
        this.openGroups.displayGroups(state.getOpenGroups());

        this.validate();
        this.revalidate();
        this.repaint();
    }

    private static class TileShower extends JPanel {
        public void displayTiles(List<MahjongTile> tiles) {
            for (MahjongTile tile : tiles) {
                this.add(new MahjongTileInputButton(tile));
            }

            this.validate();
            this.revalidate();
            this.repaint();
        }
    }

    private static class GroupShower extends JPanel {
        public void displayGroups(List<MahjongGroup> tiles) {
            for (MahjongGroup group : tiles) {
                TileShower tileShower = new TileShower();
                tileShower.displayTiles(Arrays.asList(group.getTiles()));
                this.add(tileShower);
            }

            this.validate();
            this.revalidate();
            this.repaint();
        }
    }
}
