package entity.calculator.mahjong;

public class TileGroupFactory {
    /**
     * Adds closed tile based on input data.
     * @param inputData the data needed to create the closed tile
     * @return the closed tile
     */
    public MahjongTile addClosedTile(MahjongTile inputData) {
        return inputData;
    }

    /**
     * Creates Chii group given a tile and whether or not it is an aka.
     * @param tile  the given tile
     * @param isAka whether the given tile is aka (red)
     * @return the Chii group, or null if the group cannot be formed
     */
    public MahjongGroup addChii(MahjongTile tile, boolean isAka) {
        if (tile.getValue() < 1 || tile.getValue() > 7) {
            return null;
        }

        MahjongTile[] tiles = new MahjongTile[3];
        tiles[0] = tile;

        for (int i = 1; i < 3; i++) {
            if (i + tile.getValue() == 5 && isAka) {
                tiles[i] = MahjongTile.getMahjongTile(i + tile.getValue(), tile.getSuit(), true);
            } else {
                tiles[i] = MahjongTile.getMahjongTile(i + tile.getValue(), tile.getSuit(), false);
            }
        }

        return new MahjongGroup(tiles);
    }

    /**
     * Creates Pon group given a tile and whether or not it is an aka.
     * @param tile  the given tile
     * @param isAka whether the given tile is aka (red)
     * @return the Pon group
     */
    public MahjongGroup addPon(MahjongTile tile, boolean isAka) {
        MahjongGroup group;

        if (tile.isAka()) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), false);
            group = new MahjongGroup(tile, tempTile, tempTile);
        } else if (tile.getValue() == 5 && isAka) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), true);
            group = new MahjongGroup(tempTile, tile, tile);
        } else {
            group = new MahjongGroup(tile, tile, tile);
        }

        return group;
    }

    /**
     * Creates Kan group given a tile and whether or not it is an aka.
     * @param tile  the given tile
     * @param isAka whether the given tile is aka (red)
     * @return the Kan group
     */
    public MahjongGroup createKanGroup(MahjongTile tile, boolean isAka) {
        MahjongGroup group;

        if (tile.isAka()) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), false);
            group = new MahjongGroup(tile, tempTile, tempTile, tempTile);
        } else if (tile.getValue() == 5 && isAka) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), true);
            group = new MahjongGroup(tempTile, tile, tile, tile);
        } else {
            group = new MahjongGroup(tile, tile, tile, tile);
        }

        return group;
    }
}
