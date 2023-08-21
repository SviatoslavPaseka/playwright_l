package sauceDemoPages.enums;

public enum SortOption {
    NAME_A_Z("az"), NAME_Z_A("za"),
    PRICE_LH("lohi"), PRICE_H_L("hilo");


    private final String value;

    public String getValue() {
        return value;
    }

    SortOption(String value) {
        this.value = value;
    }
}
