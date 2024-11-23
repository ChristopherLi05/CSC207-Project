package use_case.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.List;

public interface CalculatorDataAccessInterface {
    String getClosedTiles();

    void addClosedTiles(List<MahjongTile> closedTiles);

    String getClosedGroup();

    void addClosedGroup(List<MahjongGroup> closedGroup);

    String getOpenGroups();

    void addOpenGroups(List<MahjongGroup> openGroups);

    String getWinningTile();

    void addWinningTile(MahjongTile winningTile);
}
