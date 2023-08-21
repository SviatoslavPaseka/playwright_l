package sauceDemoPages.enums;

public enum ItemLinks {
    I4("item_4_title_link"),
    I0("item_0_title_link"),
    I1("item_1_title_link"),
    I5("item_5_title_link"),
    I2("item_2_title_link"),
    I3("item_2_title_link");

    private final String aId;

    public String getaId() {
        return aId;
    }

    ItemLinks(String aId) {
        this.aId = aId;
    }
}