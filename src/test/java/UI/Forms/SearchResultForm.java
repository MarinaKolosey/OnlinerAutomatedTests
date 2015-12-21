package UI.Forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Created by Marina on 16.12.2015.
 */
public class SearchResultForm extends BaseForm {
    private static final String locator = "//ul[@class ='b-offers-subnav']";
    private static final String formTitle = "Search Result";
    String controlTemplate = "//label/span[text() = '%s']";
    String controlLink = "В закладки";
    private final Label lblFavorite = new Label (By.xpath(String.format(controlTemplate,controlLink)), "Favorite");
    private final Label lblComparison = new Label(By.xpath("//label/span[text() = 'Добавить к сравнению']"), "Add To Comparison");

    public SearchResultForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Add the search result to Favourites
     */
    public void addToFavourites () {
        lblFavorite.click();
    }

    /**
     * Add the search result to comparison
     */
    public void addToComparison () {
        lblComparison.click();
    }

    /**
     * Go back to the "Mobiles" form
     */
    public void goBackToMobilesForm() {
        browser.getDriver().navigate().back();
    }
}
