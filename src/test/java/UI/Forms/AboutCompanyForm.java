package UI.Forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * About Company form
 */
public class AboutCompanyForm extends BaseForm {

    private static final String locator = "//h3[@class='b-posts-1-item__title']/span[text()='О сайте']";
    private static final String formTitle = "About Company";
    private final Label lblInfo = new Label(By.xpath("//p/strong"));

    public AboutCompanyForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Check if the main description there is on the page
     * @param descriptionText Text
     * @return True if the description there is on the page, False if the description is missed
     */
    public boolean checkAboutElements(String descriptionText){
        boolean description = lblInfo.getText().contains(descriptionText);
        logger.info(String.format("The 'About Company' page opened, result '%s'", String.valueOf(description)));
        return description;
    }

}
