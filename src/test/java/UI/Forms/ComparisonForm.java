package UI.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Label;

import java.util.ArrayList;
import java.util.List;

/**
 * Comparison form
 */
public class ComparisonForm extends BaseForm {
    private static final String locator = "//h1[text()='Сравнение товаров']";
    private static final String formTitle = "Comparison form";
    List<WebElement> lblCompareTitles;
    private final Label lblClean = new Label(By.xpath("//a[@class='product-table__clear button button_small button_gray']"),"Clean comparison");

    public ComparisonForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Get and save the titles of all items in the Comparison form
     * @return The list of item's titles
     */
    public List<String> comparisonTitles() {
        lblCompareTitles = findElements("//span[@class='product-summary__caption']");
        List<String> comparisonResults = new ArrayList<String>();
        for (WebElement lblCompareTitle : lblCompareTitles) {
            comparisonResults.add(lblCompareTitle.getText());
        }
        return comparisonResults;
    }

    /**
     * Check if titles of the search results on the Mobiles form and titles of the items on the Comparison form are the same
     * @param elems The list of search results titles on the Mobiles form
     */
    public void checkIfComparisonTitlesAreCorrect(List<String> elems) {
        boolean result = comparisonTitles().containsAll(elems);
        logger.info("Lists comparison result:"+result);
        Assert.assertTrue(result);
    }

    /**
     * Remove all items from the Comparison form and check if they removed successfully
     */
    public void removeResultsFromComparison() {
        lblClean.click();
        Assert.assertFalse(lblClean.isPresent());
        logger.info("Comparison cleaned successfully");
    }
}
