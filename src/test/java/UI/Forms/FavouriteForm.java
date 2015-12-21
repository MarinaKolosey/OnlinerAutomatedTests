package UI.Forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Favourites form
 */
public class FavouriteForm extends BaseForm {
    private static final String locator = "//div[@class='b-hdtopic']";
    private static final String formTitle = "Favourites";
    private final Label lblCatalogSubmenu = new Label(By.xpath("//li/a[text()='Каталог']"),"Submenu Catalog");

    public FavouriteForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Open Catalog Submenu of Favourites form
     */
    public void openCatalogSubmenu() {
        lblCatalogSubmenu.click();
    }
}
