package UI.Forms;

/**
 * Created by Marina on 15.12.2015.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.elements.CheckBox;
import webdriver.elements.Label;

import java.util.ArrayList;
import java.util.List;

/*
 * Mobiles page
 */
public class MobilesForm extends BaseForm {
    private static final String locator = "//h1[@class = 'schema-header__title']";
    private static final String formTitle = "Mobiles Form";
    String itemTemplate = "//label/span[text() = '%s']";
    String manufacturerLink = "Apple";
    private final CheckBox chbManufacturer = new CheckBox(By.xpath(String.format(itemTemplate, manufacturerLink)), "Manufacturer");
    String yearLink = "2015";
    private CheckBox chbYear;
    private  Label lblFavourite = new Label(By.xpath("//ul/li/a[text()='Закладки']"), "Favourite");
    private final Label lblComparisonClick = new Label(By.xpath("//*[@id='compare-button-container']//a[contains(@data-bind,\"compareModel\")]/span"),"Comparison link");

    public MobilesForm() {
        super(By.xpath(locator), formTitle);
    }

    public void assertIsOpen() {
        super.assertIsOpen();
    }

    /**
     * Select the manufacturer
     * @param manufacturerLink The manufacturer
     */
    public void checkManufacturerCriteria(String manufacturerLink) {
        chbManufacturer.checkInput(manufacturerLink);
        chbManufacturer.check();
    }

    /**
     * Select the release year
     * @param yearLink Release year
     */
    public void checkYearCriteria(String yearLink) {
        chbYear = new CheckBox(By.xpath(String.format(itemTemplate, yearLink)), "Year");
        chbYear.checkInput(yearLink);
        browser.scrollPage(100);
        chbYear.check();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get and save the results titles
     * @return The list of the results titles
     */
    public List<String> resultsTitles() {
        List<WebElement> elems = findElements("//span[@data-bind='html: product.full_name']");
        List<String> results = new ArrayList<String>();
        for (WebElement elem : elems) {
            results.add(elem.getText());
        }
        return results;
    }

    /**
     * Get the count of found mobiles
     * @return The count of found mobiles
     */
    public int getMobilesResultsCount() {
        int resultsCount = findElements("//span[@data-bind='html: product.full_name']").size();
        info(String.format("The count of found mobiles is: '%d'", resultsCount));
	    return resultsCount;
    }

    /**
     * Open the page of search result
     * @param i Index of the search result
     */
    public void clickOnResult(int i) {
        Label lblSearchResult = new Label(By.xpath(String.format("(//span[@data-bind='html: product.full_name'])[%d]", i)), "Result");
        lblSearchResult.click();
    }

    /**
     * Add ALL search results in "Favourites" tab
     */
    public void addResultsToFavourite() {
        int count = getMobilesResultsCount();
        for (int i = 1; i <= count; i++) {
            clickOnResult(i);
            SearchResultForm searchResultForm = new SearchResultForm();
            searchResultForm.addToFavourites();
            searchResultForm.goBackToMobilesForm();
        }
    }

    /**
     * Open "Favourites" tab
     */
    public void openFavouriteTab() {
        lblFavourite.click();
    }

    /**
     * Add ALL search results to comparison
     */
    public void addResultsToComparison() {
        int count = getMobilesResultsCount();
        for (int i = 1; i <= count; i++) {
            clickOnResult(i);
            SearchResultForm searchResultForm = new SearchResultForm();
            searchResultForm.addToComparison();
            searchResultForm.goBackToMobilesForm();
        }
    }

    /**
     * Open Comparison tab
     */
    public void openComparisonTab() {
        lblComparisonClick.click();
    }
}