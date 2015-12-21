package UI.Forms;

import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Advertising Form
 */
public class AdvertisingForm extends BaseForm {

    private static final String locator = "//li/a[contains(text(),'Реклама')]";
    private static final String formTitle = "Advertising";
    private final Label lblAdvertisingMenu = new Label(By.xpath("//nav[@class='header-navigation']"),"Advertising page");

    public AdvertisingForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Check if main description there is on the page
     */
    public void checkAdvertisingElements(){
        Assert.assertTrue(lblAdvertisingMenu.isPresent(),"Advertising page opened");
    }

    /**
     * Go to the previous page
     */
    public void goBackMainPage(){
        browser.getDriver().navigate().back();
    }

}
