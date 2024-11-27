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

    /**
     * Constructs DisplayHandComponent object with specified modification setting
     * @param modifyTiles whether the tiles in the hand can be modified
     */
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

    /**
     * Handles property changes in calculator state.
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!(evt.getNewValue() instanceof ITileModifierState)) return;
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
        /**
         * Displays given list of tiles in component.
         * @param tiles the list of Mahjong tiles to display
         */
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
        /**
         * Displays the given list of Mahjong groups in component.
         * @param tiles the list of Mahjong groups to display
         */
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
