package entity.calculator.mahjong;

public enum MahjongSuit {
    MAN(false), PIN(false), SOU(false), DRAGON(true), WIND(true);

    private final boolean honor;

    MahjongSuit(boolean honor) {
        this.honor = honor;
    }

    public boolean isHonor() {
        return honor;
    }
}
