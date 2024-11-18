package entity.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.ArrayList;
import java.util.List;

public class HandGrouping {
    private final List<MahjongGroup> groups = new ArrayList<>();
    private final List<MahjongTile> ungroupedTiles;
    private MahjongTile[] pair = null;

    public HandGrouping(List<MahjongTile> ungroupedTiles) {
        this.ungroupedTiles = ungroupedTiles;
    }

    public MahjongTile[] getPair() {
        return pair;
    }

    public void setPair(MahjongTile tile1, MahjongTile tile2) {
        this.pair = new MahjongTile[]{tile1, tile2};
    }

    public List<MahjongGroup> getGroups() {
        return groups;
    }

    public void addGroup(MahjongGroup group) {
        groups.add(group);
    }

    public List<MahjongTile> getUngroupedTiles() {
        return ungroupedTiles;
    }

    public HandGrouping copy() {
        HandGrouping grouping = new HandGrouping(ungroupedTiles);
        grouping.setPair(pair[0], pair[1]);
        for (MahjongGroup group : groups) {
            grouping.addGroup(group);
        }

        return grouping;
    }
}