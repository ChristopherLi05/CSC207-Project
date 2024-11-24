package use_case.addTile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AddTileOutputData {
    private final List<MahjongTile> addedTile = new ArrayList<>();
    private final List<MahjongGroup> addedClosedGroup = new ArrayList<>();
    private final List<MahjongGroup> addedOpenGroup = new ArrayList<>();

    public AddTileOutputData() {
    }

    public void addTile(MahjongTile tile) {
        this.addedTile.add(tile);
    }

    public void addClosedGroup(MahjongGroup mahjongGroup) {
        this.addedClosedGroup.add(mahjongGroup);
    }

    public void addOpenGroup(MahjongGroup mahjongGroup) {
        this.addedOpenGroup.add(mahjongGroup);
    }

    public List<MahjongGroup> getAddedClosedGroup() {
        return addedClosedGroup;
    }

    public List<MahjongGroup> getAddedOpenGroup() {
        return addedOpenGroup;
    }

    public List<MahjongTile> getAddedTile() {
        return addedTile;
    }
}
