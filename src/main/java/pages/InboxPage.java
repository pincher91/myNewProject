package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.Constant.Phrases.SUBJECT;
import static constants.Constant.Phrases.TEXT_OF_LETTER;

public class InboxPage extends BasePage {

    public InboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='compose-dropdown']")
    private WebElement dropdown;
    @FindBy(xpath = "//span[text()='Написать себе']")
    private WebElement listItem;
    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement subjectOfLetter;
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textBox;
    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement sendButton;
    @FindBy(xpath = "//span[@class='mt-snt-tmslf__subject-value' and text()='Просто письмо']")
    private WebElement letterToYourself;

    public pages.InboxPage clickDropdown() {
        waitElementIsVisible(dropdown).click();
        return this;
    }

    public pages.InboxPage clickListItem() {
        waitElementIsVisible(listItem).click();
        return this;
    }

    public pages.InboxPage fillSubjectOfLetter() {
        waitElementIsVisible(subjectOfLetter).sendKeys(SUBJECT);
        return this;
    }

    public pages.InboxPage fillTextBox() {
        textBox.sendKeys(TEXT_OF_LETTER);
        return this;
    }

    public pages.InboxPage clickSendButton() {
        sendButton.click();
        return this;
    }

    public pages.InboxPage sendLetterToYourself() {
        this.clickDropdown();
        this.clickListItem();
        this.fillSubjectOfLetter();
        this.fillTextBox();
        this.clickSendButton();
        return this;
    }

    public boolean letterToYourselfPresents() {
        waitElementIsVisible(letterToYourself);
        return letterToYourself.isDisplayed();
    }
}