package entity.calculator.mahjong;

public enum MahjongTile {
    ONE_MAN("1m", "tile/Man1.png", MahjongSuit.MAN, 1),
    TWO_MAN("2m", "tile/Man2.png", MahjongSuit.MAN, 2),
    THREE_MAN("3m", "tile/Man3.png", MahjongSuit.MAN, 3),
    FOUR_MAN("4m", "tile/Man4.png", MahjongSuit.MAN, 4),
    FIVE_MAN("5m", "tile/Man5.png", MahjongSuit.MAN, 5),
    RED_FIVE_MAN("rm", "tile/Man5-Dora.png", MahjongSuit.MAN, 5, true),
    SIX_MAN("6m", "tile/Man6.png", MahjongSuit.MAN, 6),
    SEVEN_MAN("7m", "tile/Man7.png", MahjongSuit.MAN, 7),
    EIGHT_MAN("8m", "tile/Man8.png", MahjongSuit.MAN, 8),
    NINE_MAN("9m", "tile/Man9.png", MahjongSuit.MAN, 9),
    ONE_SOU("1s", "tile/Sou1.png", MahjongSuit.SOU, 1),
    TWO_SOU("2s", "tile/Sou2.png", MahjongSuit.SOU, 2),
    THREE_SOU("3s", "tile/Sou3.png", MahjongSuit.SOU, 3),
    FOUR_SOU("4s", "tile/Sou4.png", MahjongSuit.SOU, 4),
    FIVE_SOU("5s", "tile/Sou5.png", MahjongSuit.SOU, 5),
    RED_FIVE_SOU("rs", "tile/Sou5-Dora.png", MahjongSuit.SOU, 5, true),
    SIX_SOU("6s", "tile/Sou6.png", MahjongSuit.SOU, 6),
    SEVEN_SOU("7s", "tile/Sou7.png", MahjongSuit.SOU, 7),
    EIGHT_SOU("8s", "tile/Sou8.png", MahjongSuit.SOU, 8),
    NINE_SOU("9s", "tile/Sou9.png", MahjongSuit.SOU, 9),
    ONE_PIN("1p", "tile/Pin1.png", MahjongSuit.PIN, 1),
    TWO_PIN("2p", "tile/Pin2.png", MahjongSuit.PIN, 2),
    THREE_PIN("3p", "tile/Pin3.png", MahjongSuit.PIN, 3),
    FOUR_PIN("4p", "tile/Pin4.png", MahjongSuit.PIN, 4),
    FIVE_PIN("5p", "tile/Pin5.png", MahjongSuit.PIN, 5),
    RED_FIVE_PIN("rp", "tile/Pin5-Dora.png", MahjongSuit.PIN, 5, true),
    SIX_PIN("6p", "tile/Pin6.png", MahjongSuit.PIN, 6),
    SEVEN_PIN("7p", "tile/Pin7.png", MahjongSuit.PIN, 7),
    EIGHT_PIN("8p", "tile/Pin8.png", MahjongSuit.PIN, 8),
    NINE_PIN("9p", "tile/Pin9.png", MahjongSuit.PIN, 9),
    GREEN_DRAGON("gd", "tile/Hatsu.png", MahjongSuit.DRAGON),
    RED_DRAGON("rd", "tile/Chun.png", MahjongSuit.DRAGON),
    WHITE_DRAGON("wd", "tile/Haku.png", MahjongSuit.DRAGON),
    EAST_WIND("ew", "tile/Ton.png", MahjongSuit.WIND),
    SOUTH_WIND("sw", "tile/Nan.png", MahjongSuit.WIND),
    WEST_WIND("ww", "tile/Shaa.png", MahjongSuit.WIND),
    NORTH_WIND("nw", "tile/Pei.png", MahjongSuit.WIND);

    private final String serialize;
    private final String filePath;
    private final int value;
    private final boolean terminal;
    private final MahjongSuit suit;
    private final boolean aka;

    MahjongTile(String serialize, String filePath, MahjongSuit suit) {
        this(serialize, filePath, suit, -1, false);
    }

    MahjongTile(String serialize, String filePath, MahjongSuit suit, int value) {
        this(serialize, filePath, suit, value, false);
    }

    MahjongTile(String serialize, String filePath, MahjongSuit suit, int value, boolean aka) {
        this.serialize = serialize;
        this.filePath = filePath;
        this.value = value;
        this.suit = suit;
        this.terminal = value == 1 || value == 9;
        this.aka = aka;
    }

    public String getSerialization() {
        return serialize;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getValue() {
        return value;
    }

    public MahjongSuit getSuit() {
        return suit;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public boolean isAka() {
        return aka;
    }

    public static MahjongTile getMahjongTile(String serialize) {
        for (MahjongTile tile : MahjongTile.values()) {
            if (tile.getSerialization().equals(serialize)) {
                return tile;
            }
        }

        return null;
    }

    public static MahjongTile getMahjongTile(int value, MahjongSuit suit, boolean isAka) {
        for (MahjongTile tile : MahjongTile.values()) {
            if (tile.getValue() == value && tile.getSuit() == suit && tile.isAka() == isAka) {
                return tile;
            }
        }

        return null;
    }
}
