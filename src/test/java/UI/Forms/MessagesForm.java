package UI.Forms;

import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.CheckBox;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

/**
 * Messages form
 */
public class MessagesForm extends BaseForm {

    private static final String locator = "//h1[@class='m-title']";
    private static final String formTitle = "Messages";
    private final Label lblWrite = new Label(By.xpath("//a[@class='vnav__create__link']"),"Write message");
    String messageItemTemplate = "//input[@name='%s']";
    String messageUsernameLink = "username";
    String messageSubjectLink = "subject";
    private final TextBox txbUsername = new TextBox(By.xpath(String.format(messageItemTemplate,messageUsernameLink)),"Username");
    private final TextBox txbSubject = new TextBox(By.xpath(String.format(messageItemTemplate,messageSubjectLink)),"Subject");
    private final TextBox txbMessage = new TextBox(By.xpath("//div/textarea[@id='compose_text']"),"Message");
    private final Button btnSend = new Button(By.xpath("//button[@name='post']"),"Send");
    String numberTemplate = "//li[@id='%s']/a/following-sibling::sup";
    String numberSentLink = "l_sentbox";
    String numberSaveLink = "l_savebox";
    private final Label lblNumberSent = new Label(By.xpath(String.format(numberTemplate,numberSentLink)),"Count of sent messages");
    private final Label lblNumberSave = new Label(By.xpath(String.format(numberTemplate,numberSaveLink)),"Count of saved messages");
    String tabTemplate = "//li/a[text()='%s']";
    String tabSentMessages = "Отправленные";
    String tabSavedMessages ="Сохранённые";
    private final Label lblSentMessages = new Label(By.xpath(String.format(tabTemplate,tabSentMessages)),"Sent Messages");
    private final Label lblSaveMessages = new Label(By.xpath(String.format(tabTemplate,tabSavedMessages)),"Saved Messages");
    private final Label lblSubject = new Label(By.xpath("//li/div[@class='lpm-subj']/a"));
    private final CheckBox chbSelectAll = new CheckBox(By.className("f-cb"),"Check All sent messages");
    private final Label lblSaveLink = new Label(By.className("pm_save"),"Save messages");
    private final Label lblDelete = new Label(By.xpath("//span[@class ='pmchk__del delete_pm']"),"Delete All");

    public MessagesForm() {
        super(By.xpath(locator), formTitle);
    }

    /**
     * Write and send the message
     * @param username_email Username who receives the message
     * @param subject The message subject
     * @param message The message text
     */
    public void writeMessage(String username_email, String subject, String message) {
        lblWrite.click();
        txbUsername.setText(username_email);
        txbSubject.setText(subject);
        txbMessage.setText(message);
        btnSend.click();
    }

    /**
     * Check if the message sent
     * @param subject The email subject
     */
    public void checkMessageSent(String subject) {
        Assert.assertEquals(lblNumberSent.getText(),"1");
        lblSentMessages.click();
        Assert.assertEquals(lblSubject.getText(),subject);
        logger.info("Message sent successfully");
    }

    /**
     * Save the sent message
     */
    public void saveMessage() {
        chbSelectAll.check();
        lblSaveLink.click();
    }

    /**
     * Check if the message saved successfully
     * @param subject The email subject
     */
    public void checkMessageSaved(String subject){
        Assert.assertEquals(lblNumberSave.getText(),"1");
        lblSaveMessages.click();
        Assert.assertEquals(lblSubject.getText(),subject);
        logger.info("Message saved successfully");
    }

    /**
     * Delete saved messages
     */
    public void deleteSavedMessages() {
        chbSelectAll.check();
        lblDelete.click();
        browser.getDriver().switchTo().alert().accept();
        browser.getDriver().switchTo().defaultContent();
    }

    /**
     * Check if the messages removed successfully
     */
    public void checkedRemovedSuccessfully(){
        Assert.assertEquals(lblNumberSave.getText(),"0");
        logger.info("Messages removed successfully");
    }
}
