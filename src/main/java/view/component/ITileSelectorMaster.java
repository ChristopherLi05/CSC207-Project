package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.List;

public interface ITileSelectorMaster {
    List<MahjongTile> getClosedTiles();

    void addClosedTiles(List<MahjongTile> closedTiles);

    List<MahjongGroup> getClosedGroup();

    void addClosedGroup(List<MahjongGroup> closedGroup);

    List<MahjongGroup> getOpenGroups();

    void addOpenGroups(List<MahjongGroup> openGroups);

    MahjongTile getWinningTile();

    void addWinningTile(MahjongTile winningTile);
}