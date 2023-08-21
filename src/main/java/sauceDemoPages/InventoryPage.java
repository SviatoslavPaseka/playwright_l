package sauceDemoPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import sauceDemoPages.enums.BurgerButtonMenuItems;
import sauceDemoPages.enums.ItemLinks;
import sauceDemoPages.enums.ProductPhotoId;
import sauceDemoPages.enums.SortOption;

public class InventoryPage {
    private final Page page;

    private final String burgerButtonMenu;

    private final String productLink;

    private final String productDescription;

    private final String productPrice;

    private final String addToCartButton;

    private final String productPhoto;

    private final String sortingProductOption;

    private final Locator sortContainer;

    public InventoryPage(Page page){
        this.page = page;
        this.burgerButtonMenu = "//a[@id='%s']";
        this.productLink = "//a[@id='%s']";
        this.productDescription = productLink + "/following-sibling::div";
        this.productPrice = productLink + "/ancestor::div[1]/following-sibling::div/div";
        this.addToCartButton = productLink + "/ancestor::div[1]/following-sibling::div/button";
        this.productPhoto = "//a[@id='%s']";
        this.sortingProductOption = "//option[@value='%s']";
        this.sortContainer = page.locator("//select");
    }

    public String getProductName(ItemLinks itemLink){
        return page.locator(String.format(productLink, itemLink.getaId())).textContent();
    }

    public String getProductDescriptionText(ItemLinks itemLink){
        return page.locator(String.format(productDescription, itemLink.getaId())).textContent();
    }

    public Double getProductPrice(ItemLinks itemLink){
        return Double.parseDouble(page.locator(String.format(productPrice, itemLink.getaId())).textContent().replaceAll("[$]", ""));
    }

    public void clickAddToCartButton(ItemLinks itemLink){
        page.locator(String.format(addToCartButton, itemLink.getaId())).click();
    }

    public void chooseSortOption(SortOption sortOption){
        page.locator(String.format(sortingProductOption, sortOption.getValue())).click();
    }

    public void clickOnProductPhoto(ProductPhotoId productPhotoId){
        page.locator(String.format(productPhoto, productPhotoId.getId())).click();
    }

    public void clickOnBurgerButtonMenuItem(BurgerButtonMenuItems burgerButtonMenuItems){
        page.locator(String.format(burgerButtonMenu, burgerButtonMenuItems.getId())).click();
    }


}