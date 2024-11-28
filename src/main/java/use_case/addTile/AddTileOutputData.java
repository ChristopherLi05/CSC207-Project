package use_case.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.ArrayList;
import java.util.List;

public class AddTileOutputData {
    private final List<MahjongTile> addedTile = new ArrayList<>();
    private final List<MahjongGroup> addedClosedGroup = new ArrayList<>();
    private final List<MahjongGroup> addedOpenGroup = new ArrayList<>();

    /**
     * Creates an AddTileOutputData object.
     */
    public AddTileOutputData() {
    }

    /**
     * Adds a tile to output data.
     * @param tile the tile to be added
     */
    public void addTile(MahjongTile tile) {
        this.addedTile.add(tile);
    }

    /**
     * Adds closed group to output data.
     * @param mahjongGroup the closed group to be added
     */
    public void addClosedGroup(MahjongGroup mahjongGroup) {
        this.addedClosedGroup.add(mahjongGroup);
    }

    /**
     * Adds open group to output data.
     * @param mahjongGroup the open group to be added
     */
    public void addOpenGroup(MahjongGroup mahjongGroup) {
        this.addedOpenGroup.add(mahjongGroup);
    }

    /**
     * @return the list of closed groups in output data
     */
    public List<MahjongGroup> getAddedClosedGroup() {
        return addedClosedGroup;
    }

    /**
     * @return the list of open groups in output data
     */
    public List<MahjongGroup> getAddedOpenGroup() {
        return addedOpenGroup;
    }

    /**
     * @return the list of added tiles in output data
     */
    public List<MahjongTile> getAddedTile() {
        return addedTile;
    }
}
