package tests;

/**
 * Created by Marina on 15.12.2015.
 */
import UI.Forms.FacebookForm;
import UI.Forms.LoginForm;
import UI.Forms.MainForLoggedInUsersForm;
import UI.Forms.MainForm;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

public class LoginSuccessTest extends BaseTest {
    private String login;
    private String password;
    private String username;
    private String password_facebook;

    @Test
    @Parameters({"login","password","username","password_facebook"})
    public void readParams(String login,String password, String username, String password_facebook) throws Throwable {
        this.login = login;
        this.password = password;
        this.username = username;
        this.password_facebook = password_facebook;
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

        logger.step(3);
        LoginForm loginForm = new LoginForm();
        loginForm.login(login,password);
        MainForLoggedInUsersForm mainForLoggedInUsersForm = new MainForLoggedInUsersForm();
        mainForLoggedInUsersForm.checkSuccessLogin(username);

        logStep(4);
        mainForLoggedInUsersForm.logout();
        String tvWinHandle = browser.getDriver().getWindowHandle();

        logStep(5);
        mainForm.clickFacebookEnter();
        mainForm.goToFacebook();
        FacebookForm facebookForm = new FacebookForm();
        facebookForm.loginWithFacebook(login,password_facebook);
        facebookForm.goToPreviousWindow(tvWinHandle);
        mainForLoggedInUsersForm.checkSuccessLogin(username);
    }
}
