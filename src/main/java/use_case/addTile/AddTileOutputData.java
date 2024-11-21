package use_case.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AddTileOutputData {
    private final List<MahjongTile> selectedTiles = new ArrayList<>();

    public AddTileOutputData(Object newTiles) {
        if (newTiles instanceof MahjongGroup) {
            this.selectedTiles.addAll(Arrays.asList(((MahjongGroup) newTiles).getTiles()));
        }
        else if (newTiles instanceof MahjongTile) {
            this.selectedTiles.add((MahjongTile) newTiles);
        }
    }

    public Collection<MahjongTile> getSelectedTiles() {
        return selectedTiles;
    }
}
