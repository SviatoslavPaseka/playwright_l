package UnderArmourPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;
    private final String itemNavList;
    private final Locator searchBar;

    private final Locator cmCollectionLeftProductPhoto;

    public HomePage(Page page) {
        this.page = page;
        this.itemNavList = "//a[@data-testid='%s']";
        this.searchBar = page.locator("//input[@data-testid='mobile-search-bar']");
        this.cmCollectionLeftProductPhoto = page.locator("//div[@class='swiper-slide swiper-slide-active module__list-item']/div/a/span/img");
    }
}
