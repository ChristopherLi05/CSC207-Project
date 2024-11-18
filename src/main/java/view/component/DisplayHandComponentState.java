package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.List;

public interface DisplayHandComponentState {

    List<MahjongTile> getClosedTiles();

    List<MahjongGroup> getClosedGroup();

    List<MahjongGroup> getOpenGroups();

    MahjongTile getWinningTile();
}
