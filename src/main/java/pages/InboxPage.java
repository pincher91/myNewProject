package pages;

import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Step("Clicking on the dropdown")
    public InboxPage clickDropdown() {
        waitElementIsVisible(dropdown).click();
        return this;
    }

    @Step("Clicking on the list item")
    public InboxPage clickListItem() {
        waitElementIsVisible(listItem).click();
        return this;
    }

    @Step("Filling in the subject of the letter")
    public InboxPage fillSubjectOfLetter() {
        waitElementIsVisible(subjectOfLetter).sendKeys(SUBJECT);
        return this;
    }

    @Step("Filling in the text field")
    public InboxPage fillTextBox() {
        textBox.sendKeys(TEXT_OF_LETTER);
        return this;
    }

    @Step("Clicking on the send button")
    public InboxPage clickSendButton() {
        if (sendButton.getText().equals("Отправить")) {
            System.out.println("Success!!");
        } else {
            System.out.println("Fail");
        }
        sendButton.click();
        return this;
    }

    @Step("Sending a letter to yourself")
    public InboxPage sendLetterToYourself() {
        this.clickDropdown();
        this.clickListItem();
        this.fillSubjectOfLetter();
        this.fillTextBox();
        this.clickSendButton();
        return this;
    }

    @Step("The appearance of a letter in the folder sent to yourself")
    public boolean letterToYourselfPresents() {
        waitElementIsVisible(letterToYourself);
        return letterToYourself.isDisplayed();
    }

    @Step("Taking a screenshot")
    public void takeScreenshot() {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";

        File screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        File destination = new File("c:\\Users\\Jesus\\IdeaProjects\\myNewProject\\src\\main\\resources\\" + fileName);
        try {
            FileUtils
                    .copyFile(screenshot, destination);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}