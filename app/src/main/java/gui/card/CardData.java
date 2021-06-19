package gui.card;

import utility.UniqueId;

public class CardData {

    private String mainLabel;
    private String secondaryLabel;
    private String itemUniqueId;


    public CardData() {
        this.mainLabel = "Default";
        this.secondaryLabel = "Default";
        this.itemUniqueId = "Default";
    }

    public CardData(String mainLabel, String secondaryLabel, String itemUniqueId) {
        this.mainLabel = mainLabel;
        this.secondaryLabel = secondaryLabel;
        this.itemUniqueId = itemUniqueId;
    }

    public String getMainLabel() {
        return mainLabel;
    }

    public void setMainLabel(String mainLabel) {
        this.mainLabel = mainLabel;
    }

    public String getSecondaryLabel() {
        return secondaryLabel;
    }

    public void setSecondaryLabel(String secondaryLabel) {
        this.secondaryLabel = secondaryLabel;
    }

    public String getItemUniqueId() {
        return itemUniqueId;
    }

    public void setItemUniqueId(String itemUniqueId) {
        this.itemUniqueId = itemUniqueId;
    }
}
