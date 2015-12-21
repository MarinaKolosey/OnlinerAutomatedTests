package UI.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.CheckBox;
import webdriver.elements.Label;

import java.util.ArrayList;
import java.util.List;

/**
 * Catalog submenu of Favourites form
 */
public class FavouritesCatalogForm extends BaseForm {
    private static final String locator = "//a[text()='Каталог']";
    private static final String formTitle = "Catalog submenu of Favourites";
    List<WebElement> lblTitles;
    private final CheckBox chbAllFavourites = new CheckBox(By.id("selectAllBookmarks"),"Select All");
    private final Label lblRemove = new Label(By.xpath("//div/a[text()='Удалить']"), "Delete link");

    public FavouritesCatalogForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Get and save the titles of all items in the Favourites form
     * @return The list of item's titles
     */
    public List<String> favouritesTitles() {
        lblTitles = findElements("//td/strong[@class='pname']");
        List<String> favourites = new ArrayList<String>();
        for (WebElement lblTitle : lblTitles) {
            favourites.add(lblTitle.getText());
        }
        return favourites;
    }

    /**
     * Check if titles of the search results on the Mobiles form and titles of the items on the Favourites form are the same
     * @param elems The list of search results titles on the Mobiles form
     */
    public void checkIfFavouritesAreCorrect(List<String> elems) {
        boolean result = favouritesTitles().containsAll(elems);
        logger.info("Lists comparison result:"+result);
        Assert.assertTrue(result);
    }

    /**
     * Remove all items from the Favourite form and check if they removed successfully
     */
    public void removeAllFavourites() {
        chbAllFavourites.check();
        lblRemove.click();
        Assert.assertFalse(chbAllFavourites.isPresent(),"Bookmarks removed successfully");
        logger.info("Bookmarks removed successfully");
    }
}
