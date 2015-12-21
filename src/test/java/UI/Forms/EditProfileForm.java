package UI.Forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

/**
 * The Edit Profile form
 */
public class EditProfileForm extends BaseForm {
    private static final String locator = "//ul[@class='b-utabs']";
    private static final String formTitle = "Edit Profile Page";
    private final TextBox tbInputCity = new TextBox(By.name("city"),"City");
    private final Button btnSaveChanges = new Button(By.xpath("//button[@type='submit']"),"Save changes");

    public EditProfileForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Edit the user's information
     * @param city City
     */
    public void changeInfo (String city) {
        tbInputCity.setText(city);
        btnSaveChanges.click();
    }

    /**
     * Go back to the Profile page
     */
    public void goBack() {
        browser.getDriver().navigate().back();
    }




}
