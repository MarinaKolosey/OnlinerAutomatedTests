package UI.menu;

/**
 * Created by Marina on 15.12.2015.
 */
import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

/*
 * Navigation by Onliner Menu
 */
public class NavigateMenu extends BaseForm {
    String menuTemplate = "//a[text()='%s']";

    public NavigateMenu() {
        super(By.xpath("//ul[@class='b-main-navigation']"), "Menu Onliner.by");
    }

    /*
    * Opens required Menu's tab
    * @param menuLink Name of tab
    */
    public void openTab(String menuLink) {
        final Label lblMenuTab = new Label(By.xpath(String.format(menuTemplate,menuLink)), "Menu tab");
		lblMenuTab.click();
    }
}
