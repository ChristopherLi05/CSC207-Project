package entity.calculator;

import entity.calculator.mahjong.MahjongTile;
import entity.calculator.mahjong.MahjongGroup;

import java.util.ArrayList;
import java.util.List;

public class HandStateFactory implements IHandStateFactory {
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

    // Hand is stored like this: 2s2s2s3s3s3s5s 4s4s4s;1s1s1s1s 5s
    // First group represents closed
    // Second group represents opened, open groups are seperated by ;
    // Third group represents tile that won the hand

    // seatWind/roundWind is also just represented as a mahjong tile

    /**
     * {@inheritDoc}
     */
    @Override
    public HandState createHandState(String closed, String closedGroup, String open, String winning, String dora, String ura, String seatWind, String roundWind, int flags) {
        // Basic input checking
        validateHandStrings(closed, open, winning, dora, ura, seatWind, roundWind, flags);

        List<MahjongTile> closedTiles = new ArrayList<>();
        for (int i = 0; i < closed.length(); i += 2) {
            closedTiles.add(getMahjongTile(closed, i));
        }

        List<MahjongGroup> closedGroups = new ArrayList<>();
        if (!closedGroup.isEmpty()) {
            String[] groups = closedGroup.split(";");
            for (String g : groups) {
                // Only closed group is a kan
                if (g.length() == 8) {
                    closedGroups.add(new MahjongGroup(getMahjongTile(g, 0), getMahjongTile(g, 2), getMahjongTile(g, 4), getMahjongTile(g, 6)));
                } else {
                    throw new IllegalArgumentException("Invalid Closed Group: " + g);
                }
            }
        }

        List<MahjongGroup> openGroups = new ArrayList<>();
        if (!open.isEmpty()) {
            String[] groups = open.split(";");
            for (String g : groups) {
                if (g.length() == 6) {
                    openGroups.add(new MahjongGroup(getMahjongTile(g, 0), getMahjongTile(g, 2), getMahjongTile(g, 4)));
                } else if (g.length() == 8) {
                    openGroups.add(new MahjongGroup(getMahjongTile(g, 0), getMahjongTile(g, 2), getMahjongTile(g, 4), getMahjongTile(g, 6)));
                } else {
                    throw new IllegalArgumentException("Invalid Open Group: " + g);
                }
            }
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

        return new HandState(closedTiles, closedGroups, openGroups, winningTile, doraList, uraList, seatWindTile, roundWindTile,
                ron, tsumo, riichi, doubleRiichi, ippatsu, chankan, rinshanKaihou, haitei, houtei);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandState createHandState(String serialization) {
        String[] strings = serialization.split(" ");

        if (strings.length != 9) {
            throw new IllegalArgumentException("Invalid hand serialization");
        }

        return createHandState(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6], strings[7], Integer.parseInt(strings[8]));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandState createHandState(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroups, List<MahjongGroup> openGroups,
                                     MahjongTile winningTile,
                                     List<MahjongTile> doraList, List<MahjongTile> uraList, MahjongTile seatWindTile, MahjongTile roundWindTile,
                                     boolean ron, boolean tsumo, boolean riichi, boolean doubleRiichi, boolean ippatsu,
                                     boolean chankan, boolean rinshanKaihou, boolean haitei, boolean houtei) {
        return new HandState(closedTiles, closedGroups, openGroups, winningTile, doraList, uraList, seatWindTile, roundWindTile,
                ron, tsumo, riichi, doubleRiichi, ippatsu, chankan, rinshanKaihou, haitei, houtei);
    }

    /**
     * Validates that a given serialization is valid
     * @param closed .
     * @param open .
     * @param winning .
     * @param dora .
     * @param ura .
     * @param seatWind .
     * @param roundWind .
     * @param flags .
     */
    private static void validateHandStrings(String closed, String open, String winning, String dora, String ura, String seatWind, String roundWind, int flags) {
        if (closed.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid closed state: " + closed);
        } else if (winning.length() != 2) {
            throw new IllegalArgumentException("Invalid winning tile: " + winning);
        } else if (dora.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid dora: " + dora);
        } else if (ura.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid ura: " + ura);
        }
    }

    /**
     * Helper method to get a mahjong tile given a string
     * @param handString string grouping
     * @param tileStringIndex index of tile we want to extract
     * @return tile if found
     */
    private static MahjongTile getMahjongTile(String handString, int tileStringIndex) {
        String serialization = handString.substring(tileStringIndex, tileStringIndex + 2);
        MahjongTile tile = MahjongTile.getMahjongTile(serialization);
        if (tile == null) {
            throw new IllegalArgumentException("Invalid mahjong tile: " + serialization + " (" + handString + ")");
        }
        return tile;
    }
}
