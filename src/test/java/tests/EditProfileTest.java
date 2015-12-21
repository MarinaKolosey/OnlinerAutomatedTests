package tests;

import UI.Forms.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

/**
 * Created by Marina on 15.12.2015.
 */
public class EditProfileTest extends BaseTest {
    private String login;
    private String password;
    private String city;

    @Test
    @Parameters({"login","password","city"})
    public void readParams(String login, String password, String city) throws Throwable {
        this.login = login;
        this.password = password;
        this.city = city;
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

        logger.step(3);
        mainForLoggedInUsersForm.openProfile();
        ProfileForm profileForm = new ProfileForm();

        logStep(4);
        profileForm.openEditForm();
        EditProfileForm editProfileForm = new EditProfileForm();

        logStep(5);
        editProfileForm.changeInfo(city);
        editProfileForm.goBack();

        logStep(6);
        profileForm.checkChangesSaved(city);
    }
}
