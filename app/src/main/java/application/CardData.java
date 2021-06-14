package application;

public class CardData {

    private String labelOne;
    private String labelTwo;

    public CardData() {
        this.labelOne = "Default";
        this.labelOne = "Default";
    }

    public CardData(String labelOne, String labelTwo) {
        this.labelOne = labelOne;
        this.labelTwo = labelTwo;
    }

    public String getLabelOne() {
        return labelOne;
    }

    public String getLabelTwo() {
        return labelTwo;
    }

    public void setLabelOne(String labelOne) {
        this.labelOne = labelOne;
    }

    public void setLabelTwo(String labelTwo) {
        this.labelTwo = labelTwo;
    }
}
