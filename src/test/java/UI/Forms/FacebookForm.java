package UI.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

/**
 * Login form of Facebook
 */
public class FacebookForm extends BaseForm {
    private static final String locator = "//h2[@id='homelink']";
    private static final String formTitle = "Facebook";
    TextBox tbFacefookEmail = new TextBox(By.id("email"),"Email");
    TextBox tbFacebookPassword = new TextBox(By.id("pass"),"Password");
    Button btnFacebookEnter = new Button(By.xpath("//input[@name='login']"),"Enter");
    Button btnConfirm = new Button(By.xpath("//button[@name='__CONFIRM__\']"),"OK");

    public FacebookForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Login with Facebook account
     * @param login The user's login to Facebook account
     * @param password_facebook The user's password to Facebook account
     */
    public void loginWithFacebook(String login,String password_facebook) {
        tbFacefookEmail.setText(login);
        tbFacebookPassword.setText(password_facebook);
        btnFacebookEnter.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            if (btnConfirm.isPresent()) {
                btnConfirm.click();
            }
        } catch (NoSuchWindowException e) {
            logger.info("Window have been closed");
        }
    }

    /**
     * Go back to the Main page
     * @param tvWinHandle Handle of the main page
     */
    public void goToPreviousWindow(String tvWinHandle){
        WebDriver driver = browser.getDriver();
        driver.switchTo().window(tvWinHandle);
    }
}
