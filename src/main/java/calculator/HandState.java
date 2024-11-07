package calculator;

import calculator.mahjong.MahjongTile;
import calculator.mahjong.OpenGroup;

import java.util.List;

public record HandState(List<MahjongTile> closedTiles, List<OpenGroup> openGroups, MahjongTile winningTile,
                        List<MahjongTile> dora, List<MahjongTile> ura, MahjongTile seatWind, MahjongTile roundWind,
                        boolean ron, boolean tsumo, boolean riichi, boolean doubleRiichi, boolean ippatsu,
                        boolean chankan, boolean rinshanKaihou, boolean haitei, boolean houtei) {

    public String serializeHand() {
        StringBuilder builder = new StringBuilder();

        for (MahjongTile tile : closedTiles) {
            builder.append(tile.getSerialization());
        }

        builder.append(" ");

        for (OpenGroup group : openGroups) {
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
}
