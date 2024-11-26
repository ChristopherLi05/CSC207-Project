package entity.calculator;

import entity.calculator.mahjong.MahjongTile;
import entity.calculator.mahjong.MahjongGroup;

import java.util.List;

/**
 * Hand state representation in memory
 *
 * @param closedTiles   .
 * @param closedGroup   .
 * @param openGroups    .
 * @param winningTile   .
 * @param dora          .
 * @param ura           .
 * @param seatWind      .
 * @param roundWind     .
 * @param ron           .
 * @param tsumo         .
 * @param riichi        .
 * @param doubleRiichi  .
 * @param ippatsu       .
 * @param chankan       .
 * @param rinshanKaihou .
 * @param haitei        .
 * @param houtei        .
 */
public record HandState(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroup, List<MahjongGroup> openGroups,
                        MahjongTile winningTile,
                        List<MahjongTile> dora, List<MahjongTile> ura, MahjongTile seatWind, MahjongTile roundWind,
                        boolean ron, boolean tsumo, boolean riichi, boolean doubleRiichi, boolean ippatsu,
                        boolean chankan, boolean rinshanKaihou, boolean haitei, boolean houtei) {

    /**
     * Serializes the hand state that's compatible with handstatefactory
     *
     * @return serialized hand
     */
    public String serializeHand() {
        StringBuilder builder = new StringBuilder();

        for (MahjongTile tile : closedTiles) {
            builder.append(tile.getSerialization());
        }

        builder.append(" ");

        boolean flag = false;
        for (MahjongGroup group : closedGroup) {
            if (!flag) {
                flag = true;
            } else {
                builder.append(";");
            }

            builder.append(group.getSerialization());
        }

        builder.append(" ");

        flag = false;
        for (MahjongGroup group : openGroups) {
            if (!flag) {
                flag = true;
            } else {
                builder.append(";");
            }

            builder.append(group.getSerialization());
        }

        builder.append(" ");
        builder.append(winningTile.getSerialization());
        builder.append(" ");

        for (MahjongTile tile : dora) {
            builder.append(tile.getSerialization());
        }

        builder.append(" ");

        for (MahjongTile tile : ura) {
            builder.append(tile.getSerialization());
        }

        builder.append(" ");
        builder.append(seatWind.getSerialization());
        builder.append(" ");
        builder.append(roundWind.getSerialization());
        builder.append(" ");

        int flags = 0;
        if (ron) flags |= 1;
        if (tsumo) flags |= 2;
        if (riichi) flags |= 4;
        if (doubleRiichi) flags |= 8;
        if (ippatsu) flags |= 16;
        if (chankan) flags |= 32;
        if (rinshanKaihou) flags |= 64;
        if (haitei) flags |= 128;
        if (houtei) flags |= 256;
        builder.append(flags);

        return builder.toString();
    }

    /**
     * toString new implementation
     *
     * @return serialized hand
     */
    @Override
    public String toString() {
        return this.serializeHand();
    }
}
