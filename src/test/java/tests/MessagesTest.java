package tests;

import UI.Forms.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;

/**
 * Created by Marina on 20.12.2015.
 */
public class MessagesTest extends BaseTest {
    private String login;
    private String password;
    private String username;
    private String username_email;
    private String subject;
    private String message;

    @Test
    @Parameters({"login", "password", "username", "username_email", "subject", "message"})
    public void readParams(String login, String password, String username, String username_email, String subject, String message) throws Throwable {
        this.login = login;
        this.password = password;
        this.username = username;
        this.username_email = username_email;
        this.subject = subject;
        this.message = message;
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
        mainForLoggedInUsersForm.openMessages();
        MessagesForm messagesForm = new MessagesForm();

        logStep(4);
        messagesForm.writeMessage(username_email, subject, message);
        messagesForm.checkMessageSent(subject);

        logStep(5);
        messagesForm.saveMessage();
        messagesForm.checkMessageSaved(subject);

        logStep(6);
        messagesForm.deleteSavedMessages();
        messagesForm.checkedRemovedSuccessfully();
    }
}