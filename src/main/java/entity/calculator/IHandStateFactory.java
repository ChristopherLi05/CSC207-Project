package entity.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.List;

public interface IHandStateFactory {
    HandState createHandState(String closed, String closedGroup, String open, String winning, String dora, String ura, String seatWind, String roundWind, int flags);

    HandState createHandState(String serialization);

    public HandState createHandState(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroups, List<MahjongGroup> openGroups,
                                     MahjongTile winningTile,
                                     List<MahjongTile> doraList, List<MahjongTile> uraList, MahjongTile seatWindTile, MahjongTile roundWindTile,
                                     boolean ron, boolean tsumo, boolean riichi, boolean doubleRiichi, boolean ippatsu,
                                     boolean chankan, boolean rinshanKaihou, boolean haitei, boolean houtei);
}
