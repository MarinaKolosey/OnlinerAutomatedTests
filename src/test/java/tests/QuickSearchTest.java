package tests;

import UI.Forms.QuickSearchForm;
import UI.Forms.LoginForm;
import UI.Forms.MainForLoggedInUsersForm;
import UI.Forms.MainForm;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

/**
 * Created by Marina on 14.12.2015.
 */
public class QuickSearchTest extends BaseTest {
    private String searchItem;
    private String login;
    private String password;
    private String username;

    @Test
    @Parameters({"searchItem","login","password","username"})
    public void readParams(String searchItem, String login,String password, String username) throws Throwable {
        this.searchItem = searchItem;
        this.login = login;
        this.password = password;
        this.username = username;
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
        loginForm.login(login,password);
        MainForLoggedInUsersForm mainForLoggedInUsersForm = new MainForLoggedInUsersForm();
        mainForLoggedInUsersForm.checkSuccessLogin(username);

        logger.step(3);
        mainForLoggedInUsersForm.inputSearchText(searchItem);
        QuickSearchForm quickSearchForm = new QuickSearchForm();

        logger.step(4);
        quickSearchForm.checkResultsMatch(searchItem);
    }
}
