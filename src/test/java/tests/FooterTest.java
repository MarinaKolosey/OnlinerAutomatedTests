package tests;

import UI.Forms.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

/**
 * Created by Marina on 20.12.2015.
 */
public class FooterTest extends BaseTest {
    private String login;
    private String password;
    private String username;
    private String descriptionText;
    private String yearCopyright;

    @Test
    @Parameters({"login", "password", "username","descriptionText", "yearCopyright"})
    public void readParams(String login, String password, String username, String descriptionText, String yearCopyright) throws Throwable {
        this.login = login;
        this.password = password;
        this.username = username;
        this.descriptionText = descriptionText;
        this.yearCopyright = yearCopyright;
        xTest();
    }

    @Test(enabled = false)
    public void xTest() throws Throwable {
        super.xTest();
    }

    public void runTest() {
        logger.step(1);
        MainForm mainForm = new MainForm();

        logger.step(2);
        mainForm.clickEnterButton();
        LoginForm loginForm = new LoginForm();
        loginForm.login(login, password);
        MainForLoggedInUsersForm mainForLoggedInUsersForm = new MainForLoggedInUsersForm();
        mainForLoggedInUsersForm.checkSuccessLogin(username);

        logStep(3);
        mainForLoggedInUsersForm.checkFooterLinksPresent();

        logStep(4);
        mainForLoggedInUsersForm.openAboutCompany();
        AboutCompanyForm aboutCompanyForm = new AboutCompanyForm();
        aboutCompanyForm.checkAboutElements(descriptionText);

        logStep(5);
        mainForLoggedInUsersForm.openVacancy();
        VacancyForm vacancyForm = new VacancyForm();
        vacancyForm.checkVacancyElements();

        logStep(6);
        mainForLoggedInUsersForm.openAdvertising();
        AdvertisingForm advertisingForm = new AdvertisingForm();
        advertisingForm.checkAdvertisingElements();
        advertisingForm.goBackMainPage();

        logStep(7);
        mainForLoggedInUsersForm.checkYearFooter(yearCopyright);
    }
}