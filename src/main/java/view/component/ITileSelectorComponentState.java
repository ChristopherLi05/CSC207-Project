package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

public interface ITileSelectorComponentState {
    void addClosedTile(MahjongTile mahjongTile);

    void addClosedGroup(MahjongGroup mahjongGroup);

    void addOpenGroup(MahjongGroup mahjongGroup);

    void setWinningTile(MahjongTile mahjongTile);

    enum SelectorType {
        NONE, PON, CHII, CLOSED_KAN, OPEN_KAN;
    }
}