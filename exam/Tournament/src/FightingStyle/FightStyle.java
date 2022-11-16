package FightingStyle;

public enum FightStyle {
    KARATE, JUDO, MUAY_THAI, BOX;

    public static FightStyle getRandomFightStyle() {
        return values()[(int) (Math.random() * values().length)];
    }
}
