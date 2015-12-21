package UI.Forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

/**
 * Login form
 */
public class LoginForm extends BaseForm {
    private static final String locator = "//div[@class='auth-box__switcher']";
    private static final String formTitle = "Login Page";
    private final TextBox tbLogin = new TextBox(By.xpath("//input[@type='text']"),"Login");
    private final TextBox tbPassword = new TextBox(By.xpath("//input[@type='password']"),"Password");
    private final Button btnLogin = new Button(By.xpath("//button[@type='submit']"),"Submit");

    public LoginForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Login
     * @param login The user's login
     * @param password The user's password
     */
    public void login (String login,String password) {
        tbLogin.setText(login);
        tbPassword.setText(password);
        btnLogin.click();
    }
}
