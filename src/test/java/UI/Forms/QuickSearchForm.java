package UI.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.elements.Label;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

/**
 * Quick Search form with search results
 */
public class QuickSearchForm extends BaseForm {
    private static final String locator = "//div[@class='modal-dialog']";
    private static final String formTitle = "Search Page";
    private final Label lblTitleText = new Label (By.className("product__title-link"));

    public QuickSearchForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Validate if the search result matches to the search string
     * @param searchItem The search string
     * @return True if the search result matches to the search string, False if the search result doesn't match to the search string
     */
    public boolean checkSearchResult (String searchItem) {
        boolean resultMatch = (containsIgnoreCase(lblTitleText.getText(), searchItem));
        logger.info(String.format("Search result should contain '%s', result '%s'", searchItem, String.valueOf(resultMatch)));
        return resultMatch;
    }

    /**
     * Get the count of the search results
     * @return The count of the search results
     */
    public int getResultsCount() {
        return browser.getDriver().findElements(By.className("product__title-link")).size();
    }

    /**
     * Switch to modal frame
     */
    public void switchToModalFrame() {
        WebElement modalFrame = browser.getDriver().findElement(By.className("modal-iframe"));
        browser.getDriver().switchTo().frame(modalFrame);
    }

    /**
     * Switch back to main window
     */
    public void switchToMainWindow() {
        browser.getDriver().switchTo().defaultContent();
    }

    /**
     * Validate if ALL search results match to the search string
     * @param searchItem The search string
     */
    public void checkResultsMatch (String searchItem) {
        switchToModalFrame();
        int count = getResultsCount();
        for (int i=1;i<=count;i++) {
            checkSearchResult(searchItem);
        }
        switchToMainWindow();
    }
}