package UI.Forms;

/**
 * Created by Marina on 14.12.2015.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webdriver.BaseForm;
import webdriver.elements.Label;

import java.util.Iterator;

/*
 * Main page of Onliner.by
 */
public class MainForm extends BaseForm {
    private static final String locator = "//a/img[@alt ='Onliner']";
    private static final String formTitle = "Home page Onliner.by";
    private final Label lblEnter = new Label(By.xpath("//div[text() = 'Вход ']"),"Enter");
    private final Label lblFacebook = new Label(By.xpath("//div[@title='Facebook']"),"Login with Facebook");

    public MainForm() {
        super(By.xpath(locator), formTitle);
    }

    public void assertIsOpen() {
        super.assertIsOpen();
    }

    /**
     * Click "Enter" button to Login
     */
    public void clickEnterButton () {
        lblEnter.click();
    }

    /**
     * Click "Facebook" link to Login with Facebook account
     */
    public void clickFacebookEnter() {
        lblFacebook.click();
    }

    /**
     * Navigate to Facebook page
     */
    public void goToFacebook() {
        WebDriver driver = browser.getDriver();
        Iterator<String> iter = driver.getWindowHandles().iterator();
        String itemWinHandle = iter.next();
        while (iter.hasNext()) {
            itemWinHandle = iter.next();
        }
        driver.switchTo().window(itemWinHandle);
        browser.waitForPageToLoad();
    }
}
