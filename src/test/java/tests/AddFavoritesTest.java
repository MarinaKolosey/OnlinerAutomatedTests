package tests;

import UI.Forms.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

/**
 * Created by Marina on 15.12.2015.
 */
public class AddFavoritesTest extends BaseTest {
    private String login;
    private String password;
    private String menuLink;
    private String manufacturerLink;
    private String yearLink;
    private String username;

    @Test
    @Parameters({"login","password","menuLink", "manufacturerLink","yearLink","username"})
    public void readParams(String login,String password, String menuLink,String manufacturerLink, String yearLink, String username) throws Throwable {
        this.login = login;
        this.password = password;
        this.menuLink = menuLink;
        this.manufacturerLink = manufacturerLink;
        this.yearLink = yearLink;
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

        logStep(3);
        mainForLoggedInUsersForm.getMenu().openTab(menuLink);
        MobilesForm mobilesForm = new MobilesForm();

        logStep(4);
        mobilesForm.checkManufacturerCriteria(manufacturerLink);
        mobilesForm.checkYearCriteria(yearLink);

        logStep(5);
        mobilesForm.addResultsToFavourite();
        mobilesForm.openFavouriteTab();
        FavouriteForm favouriteForm = new FavouriteForm();
        favouriteForm.openCatalogSubmenu();
        FavouritesCatalogForm favouritesCatalogForm = new FavouritesCatalogForm();
        favouritesCatalogForm.checkIfFavouritesAreCorrect(mobilesForm.resultsTitles());

        logStep(6);
        favouritesCatalogForm.removeAllFavourites();
    }
}

