package calculator;

import calculator.mahjong.MahjongTile;
import calculator.mahjong.OpenGroup;

import java.util.ArrayList;
import java.util.List;

public class HandStateFactory {
    // Flags:
    // 0x1 = Ron
    // 0x2 = Tsumo
    // 0x4 = Riichi
    // 0x8 = Double Riichi
    // 0x10 = Ippatsu
    // 0x20 = Chankan
    // 0x40 = Rinshan Kaihou
    // 0x80 = Haitei
    // 0x100 = Houtei

    // Hand is stored like this: 1s1s1s2s2s2s3s3s3s5s 4s4s4s 5s
    // First group represents closed
    // Second group represents opened - will always be length of multiple 6, will always be grouped in thirds
    // Third group represents tile that won the hand

    // seatWind/roundWind is also just represented as a mahjong tile
    public HandState createHandState(String closed, String open, String winning, String dora, String ura, String seatWind, String roundWind, int flags) {
        // Basic input checking
        validateHandStrings(closed, open, winning, dora, ura, seatWind, roundWind, flags);

        List<MahjongTile> closedTiles = new ArrayList<>();
        for (int i = 0; i < closed.length(); i += 2) {
            closedTiles.add(getMahjongTile(closed, i));
        }

        List<OpenGroup> openGroups = new ArrayList<>();
        for (int i = 0; i < open.length(); i += 6) {
            openGroups.add(new OpenGroup(getMahjongTile(open, i), getMahjongTile(open, i + 2), getMahjongTile(open, i + 4)));
        }

        MahjongTile winningTile = getMahjongTile(winning, 0);

        List<MahjongTile> doraList = new ArrayList<>();
        for (int i = 0; i < dora.length(); i += 2) {
            doraList.add(getMahjongTile(dora, i));
        }

        List<MahjongTile> uraList = new ArrayList<>();
        for (int i = 0; i < ura.length(); i += 2) {
            uraList.add(getMahjongTile(ura, i));
        }

        MahjongTile seatWindTile = getMahjongTile(seatWind, 0);
        MahjongTile roundWindTile = getMahjongTile(roundWind, 0);

        boolean ron = (flags & 0x1) > 0;
        boolean tsumo = (flags & 0x2) > 0;
        boolean riichi = (flags & 0x4) > 0;
        boolean doubleRiichi = (flags & 0x8) > 0;
        boolean ippatsu = (flags & 0x10) > 0;
        boolean chankan = (flags & 0x20) > 0;
        boolean rinshanKaihou = (flags & 0x40) > 0;
        boolean haitei = (flags & 0x80) > 0;
        boolean houtei = (flags & 0x100) > 0;

        return new HandState(closedTiles, openGroups, winningTile, doraList, uraList, seatWindTile, roundWindTile,
                ron, tsumo, riichi, doubleRiichi, ippatsu, chankan, rinshanKaihou, haitei, houtei);
    }

    public HandState createHandState(String serialization) {
        String[] strings = serialization.split(" ");

        if (strings.length != 8) {
            throw new IllegalArgumentException("Invalid hand serialization");
        }

        return createHandState(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6], Integer.parseInt(strings[7]));
    }

    private static void validateHandStrings(String closed, String open, String winning, String dora, String ura, String seatWind, String roundWind, int flags) {
        if (closed.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid closed state: " + closed);
        } else if (open.length() % 6 != 0) {
            throw new IllegalArgumentException("Invalid open state: " + open);
        } else if (winning.length() != 2) {
            throw new IllegalArgumentException("Invalid winning tile: " + winning);
        } else if (closed.length() + winning.length() != 26) {
            throw new IllegalArgumentException("Invalid hand combination: " + closed + " " + open);
        } else if (dora.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid dora: " + dora);
        } else if (ura.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid ura: " + ura);
        }
    }

    private static MahjongTile getMahjongTile(String handString, int tileStringIndex) {
        String serialization = handString.substring(tileStringIndex, tileStringIndex + 2);
        MahjongTile tile = MahjongTile.getMahjongTile(serialization);
        if (tile == null) {
            throw new IllegalArgumentException("Invalid mahjong tile: " + serialization + " (" + handString + ")");
        }
        return tile;
    }
}
