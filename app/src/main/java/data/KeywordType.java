package data;

public enum KeywordType {
    SKILL(1),
    LOCATION(5),
    EDUCATION(5);

    private int matchWeighting;

    KeywordType(int matchWeighting) {
        this.matchWeighting = matchWeighting;
    }

    public int getMatchWeighting() {
        return matchWeighting;
    }
}