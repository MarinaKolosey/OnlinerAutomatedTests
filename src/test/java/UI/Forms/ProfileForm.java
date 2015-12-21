package UI.Forms;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * The user's profile form
 */
public class ProfileForm extends BaseForm {
    private static final String locator = "//dl[@class='uprofile-info']";
    private static final String formTitle = "Profile";
    private final Label lblClickEdit = new Label(By.xpath("//a[text() = 'Редактировать личные данные']"),"Edit link");
    String itemProfileTemplate = "//div/dl/dt[contains(.,'%s')]/following-sibling::dd";
    String itemProfile= "Из города";
    private final Label lblCity = new Label(By.xpath(String.format(itemProfileTemplate,itemProfile)), "Profile");

    public ProfileForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Opens the Edit Profile form
     */
    public void openEditForm () {
        lblClickEdit.click();
    }

    /**
     * Check if changes saved successfully
     * @param city City
     */
    public void checkChangesSaved (String city) {
        lblCity.doAssert((StringUtils.containsIgnoreCase(lblCity.getText(),city)),"Saved successfully", "Not saved");
    }
}
