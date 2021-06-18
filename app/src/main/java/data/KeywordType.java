package data;

public enum KeywordType {
    SKILL(1),
    LOCATION(5),
    EDUCATION(5),
    CATEGORY(5),
    PAYTYPE(0),
    QUALIFICATION(3);

    private final int matchWeighting;

    KeywordType(int matchWeighting) {
        this.matchWeighting = matchWeighting;
    }

    public int getMatchWeighting() {
        return matchWeighting;
    }

}