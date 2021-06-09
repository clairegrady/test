package application;

public class Keyword {

    private String value;
    private KeywordType type;

    public Keyword(String value, KeywordType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public KeywordType getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(KeywordType type) {
        this.type = type;
    }
}