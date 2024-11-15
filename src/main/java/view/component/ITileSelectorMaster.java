package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

public interface ITileSelectorMaster {
    void addClosedTile(MahjongTile mahjongTile);

    void addChiiGroup(MahjongGroup mahjongGroup);

    void addPonGroup(MahjongGroup mahjongGroup  );

    void addClosedKanGroup(MahjongGroup mahjongGroup);

    void addOpenKanGroup(MahjongGroup mahjongGroup);


    enum SelectorType {
        NONE, PON, CHII, CLOSED_KAN, OPEN_KAN;
    }
}