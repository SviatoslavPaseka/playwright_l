package sauceDemoPages.enums;

public enum ProductPhotoId {
    ITEM_4("item_4_img_link"),
    ITEM_0("item_0_img_link"),
    ITEM_1("item_1_img_link"),
    ITEM_5("item_5_img_link"),
    ITEM_2("item_2_img_link"),
    ITEM_3("item_3_img_link");

    private final String id;

    public String getId() {
        return id;
    }

    ProductPhotoId(String id) {
        this.id = id;
    }
}