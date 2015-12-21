package UI.Forms;

import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Label;

/**
 * Vacancy form
 */
public class VacancyForm extends BaseForm {
    private static final String locator = "//h3[@class='b-posts-1-item__title']/span[text()='Вакансии']";
    private static final String formTitle = "Vacancy";
    private final Label lblMainInfo = new Label(By.xpath("//div/h2[text()='Наши вакантные позиции']"),"Our vacancies");

    public VacancyForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Check if the main description there is on the page
     */
    public void checkVacancyElements(){
        Assert.assertTrue(lblMainInfo.isPresent(),"Vacancy page opened");
    }

}
