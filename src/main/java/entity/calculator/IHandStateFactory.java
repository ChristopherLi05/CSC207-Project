package entity.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.List;

/**
 * Factory for creating hand states
 */
public interface IHandStateFactory {
    /**
     * Deserializes classes after they've been broken into their component forms
     *
     * @param closed      serialization
     * @param closedGroup serialization
     * @param open        serialization
     * @param winning     serialization
     * @param dora        serialization
     * @param ura         serialization
     * @param seatWind    serialization
     * @param roundWind   serialization
     * @param flags       serialization
     * @return hand state represented by serialization
     */
    HandState createHandState(String closed, String closedGroup, String open, String winning, String dora, String ura, String seatWind, String roundWind, int flags);

    /**
     * Deserializes classes
     *
     * @param serialization serialization
     * @return hand state represented by serialization
     */
    HandState createHandState(String serialization);


    /**
     * Creates hand state given objects
     *
     * @param closedTiles   .
     * @param closedGroups  .
     * @param openGroups    .
     * @param winningTile   .
     * @param doraList      .
     * @param uraList       .
     * @param seatWindTile  .
     * @param roundWindTile .
     * @param ron           .
     * @param tsumo         .
     * @param riichi        .
     * @param doubleRiichi  .
     * @param ippatsu       .
     * @param chankan       .
     * @param rinshanKaihou .
     * @param haitei        .
     * @param houtei        .
     * @return new hand state
     */
    HandState createHandState(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroups, List<MahjongGroup> openGroups,
                              MahjongTile winningTile,
                              List<MahjongTile> doraList, List<MahjongTile> uraList, MahjongTile seatWindTile, MahjongTile roundWindTile,
                              boolean ron, boolean tsumo, boolean riichi, boolean doubleRiichi, boolean ippatsu,
                              boolean chankan, boolean rinshanKaihou, boolean haitei, boolean houtei);
}
