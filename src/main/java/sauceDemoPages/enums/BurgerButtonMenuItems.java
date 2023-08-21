package sauceDemoPages.enums;

public enum BurgerButtonMenuItems {
    ALL_ITEMS("inventory_sidebar_link"),
    ABOUT("about_sidebar_link"),
    LOGOUT("logout_sidebar_link"),
    RESET_APP_STATE("reset_sidebar_link");

    private final String id;

    public String getId() {
        return id;
    }

    BurgerButtonMenuItems(String id) {
        this.id = id;
    }
}