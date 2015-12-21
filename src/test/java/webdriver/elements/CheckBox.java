package webdriver.elements;

/**
 * Created by Marina on 15.12.2015.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Class, Describing element check-box
 */

public class CheckBox extends BaseElement {
    String itemTemplate = "//label/span[text() = '%s']";
    WebElement checkManufacturerItem;
    String manufacturerLink;

    /**
     *
     * @param locator
     * @param name
     */
    public CheckBox(final By locator, final String name) {
        super(locator, name);
    }

    public CheckBox(final String string, final String name) {
        super(string, name);
    }

    protected String getElementType() {
        return getLoc("loc.checkbox");
    }

    public boolean isEnabled(){
        return this.getElement().isEnabled();
    }

    public CheckBox (By locator) {
        super(locator);
    }

    public void checkInput(final String value) {
        waitForIsElementPresent();
        info(String.format(getLoc("loc.checkbox.checking") + " '%1$s'", value));
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor)browser.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
        }
    }

    public void check() {
        waitForIsElementPresent();
        element.click();
    }
    /*
     * Selects the criterion's check-box
     * @param itemLink Manufacturer
     */
   /*public void checkManufacturerItem(String itemLink) {
        checkManufacturerItem = browser.getDriver().findElement(By.xpath(String.format(itemTemplate,itemLink)));
        checkListItem.click();
    }*/
}

