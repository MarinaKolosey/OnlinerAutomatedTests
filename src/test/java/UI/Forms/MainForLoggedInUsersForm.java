package UI.Forms;

import UI.menu.NavigateMenu;
import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

/**
 * Main page Onliner.by for logged in users
 */
public class MainForLoggedInUsersForm extends BaseForm {
    private static final String locator = "//a/img[@alt ='Onliner']";
    private static final String formTitle = "Home page Onliner.by for logged in users";
    private final Label lblUsernane = new Label(By.xpath("//p/a[contains(@data-bind,'nickname')]"),"Username");
    private final TextBox tbFastSearch = new TextBox(By.className("fast-search__input"),"Search");
    private final Label lblLogout = new Label(By.xpath("//a[@class='exit']"),"Logout");
    private final Label lblMessages = new Label(By.xpath("//ul/li/a[text()='Cообщения']"),"Messages Link");
    String footerTemplate = "//div/ul/li/a[text()='%s']";
    String aboutLink = "О компании";
    String vacancyLink = "Вакансии";
    String advertisingLink = "Реклама";
    private final Label lblAbout = new Label(By.xpath(String.format(footerTemplate,aboutLink)),"About Company");
    private final Label lblVacancy = new Label(By.xpath(String.format(footerTemplate,vacancyLink)),"Vacancy");
    private final Label lblAdvertising = new Label(By.xpath(String.format(footerTemplate,advertisingLink)),"Advertising");
    private final Label lblYear = new Label(By.xpath("//div/small[@class='b-footert-info__copyright']"),"Copyright year");
    private NavigateMenu navigateMenu = new NavigateMenu();

    public MainForLoggedInUsersForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Check if user logged in successfully
     * @param username Username of the user
     */
    public void checkSuccessLogin (String username) {
        Assert.assertTrue(lblUsernane.getText().contains(username));
        logger.info("Login success");
    }

    /**
     * Input search string in the quick search field
     * @param searchItem The search string
     */
    public void inputSearchText (String searchItem) {
        tbFastSearch.setText(searchItem);
    }

    /**
     * Logout
     */
    public void logout(){
        lblLogout.click();
        logger.info("Logout success");
    }

    /**
     * Open the user's profile
     */
    public void openProfile () {
        lblUsernane.click();
    }

    /**
     * Open the "Messages" tab
     */
    public void openMessages() {
        lblMessages.click();
        browser.waitForPageToLoad();
    }

    /**
     * Check if the footer's links there are on the page
     */
    public void checkFooterLinksPresent(){
        Assert.assertTrue(lblAbout.isPresent(),"About Company");
        Assert.assertTrue(lblVacancy.isPresent(),"Vacancy");
        Assert.assertTrue(lblAdvertising.isPresent(),"Advertising");
    }

    /**
     * Open the "About Company" page
     */
    public void openAboutCompany() {
        lblAbout.click();
    }

    /**
     * Open the "Vacancy" page
     */
    public void openVacancy() {
        lblVacancy.click();
    }

    /**
     * Open the "Advertising" page
     */
    public void openAdvertising(){
        lblAdvertising.click();
    }

    /*
     * Get Menu tab
     * @return Tab's name of Menu
     */
    public NavigateMenu getMenu() {
        return navigateMenu;
    }

    /**
     * Check if copyright link contains the valid year
     * @param yearCopyright The valid year in copyright link
     */
    public void checkYearFooter(String yearCopyright) {
        String copyrightValue = lblYear.getText();
        Assert.assertTrue(copyrightValue.contains(yearCopyright));
        logger.info("Copyright year is valid");
    }
}
