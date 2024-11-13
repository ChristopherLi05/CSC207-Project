package entity.calculator.mahjong;

public enum MahjongTile {
    ONE_MAN("1m", MahjongSuit.MAN, 1),
    TWO_MAN("2m", MahjongSuit.MAN, 2),
    THREE_MAN("3m", MahjongSuit.MAN, 3),
    FOUR_MAN("4m", MahjongSuit.MAN, 4),
    FIVE_MAN("5m", MahjongSuit.MAN, 5),
    RED_FIVE_MAN("rm", MahjongSuit.MAN, 5, true),
    SIX_MAN("6m", MahjongSuit.MAN, 6),
    SEVEN_MAN("7m", MahjongSuit.MAN, 7),
    EIGHT_MAN("8m", MahjongSuit.MAN, 8),
    NINE_MAN("9m", MahjongSuit.MAN, 9),
    ONE_SOU("1s", MahjongSuit.SOU, 1),
    TWO_SOU("2s", MahjongSuit.SOU, 2),
    THREE_SOU("3s", MahjongSuit.SOU, 3),
    FOUR_SOU("4s", MahjongSuit.SOU, 4),
    FIVE_SOU("5s", MahjongSuit.SOU, 5),
    RED_FIVE_SOU("rs", MahjongSuit.SOU, 5, true),
    SIX_SOU("6s", MahjongSuit.SOU, 6),
    SEVEN_SOU("7s", MahjongSuit.SOU, 7),
    EIGHT_SOU("8s", MahjongSuit.SOU, 8),
    NINE_SOU("9s", MahjongSuit.SOU, 9),
    ONE_PIN("1p", MahjongSuit.PIN, 1),
    TWO_PIN("2p", MahjongSuit.PIN, 2),
    THREE_PIN("3p", MahjongSuit.PIN, 3),
    FOUR_PIN("4p", MahjongSuit.PIN, 4),
    FIVE_PIN("5p", MahjongSuit.PIN, 5),
    RED_FIVE_PIN("rp", MahjongSuit.PIN, 5, true),
    SIX_PIN("6p", MahjongSuit.PIN, 6),
    SEVEN_PIN("7p", MahjongSuit.PIN, 7),
    EIGHT_PIN("8p", MahjongSuit.PIN, 8),
    NINE_PIN("9p", MahjongSuit.PIN, 9),
    GREEN_DRAGON("gd", MahjongSuit.DRAGON),
    RED_DRAGON("rd", MahjongSuit.DRAGON),
    WHITE_DRAGON("wd", MahjongSuit.DRAGON),
    EAST_WIND("ew", MahjongSuit.WIND),
    SOUTH_WIND("sw", MahjongSuit.WIND),
    WEST_WIND("ww", MahjongSuit.WIND),
    NORTH_WIND("nw", MahjongSuit.WIND);

    private final String serialize;
    private final int value;
    private final boolean terminal;
    private final MahjongSuit suit;
    private final boolean aka;

    MahjongTile(String serialize, MahjongSuit suit) {
        this(serialize, suit, -1, false);
    }

    MahjongTile(String serialize, MahjongSuit suit, int value) {
        this(serialize, suit, value, false);
    }

    MahjongTile(String serialize, MahjongSuit suit, int value, boolean aka) {
        this.serialize = serialize;
        this.value = value;
        this.suit = suit;
        this.terminal = value == 1 || value == 9;
        this.aka = aka;
    }

    public String getSerialization() {
        return serialize;
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
}
