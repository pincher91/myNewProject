package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.Constant.AuthorizationData.PASSWORD;
import static constants.Constant.AuthorizationData.USERNAME;

public class MailPage extends BasePage {

    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'logged-out-one-click')]//button[text()='Войти']")
    private WebElement sinInButton;
    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement iframe;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement emailTxtBox;
    @FindBy(xpath = "//span[text()='Ввести пароль']")
    private WebElement enterPasswordButton;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = ".//*[@data-test-id='submit-button']//span")
    private WebElement accountSignInButton;
    @FindBy(xpath = "//span[contains(@class,'ph-project__user-name') and text()='lesson_10@mail.ru']")
    private WebElement iconOfAccount;


    @Step("Clicking on Sign in button")
    public MailPage clickSingIn() {
        sinInButton.click();
        return this;
    }

    @Step("Switching to the authorization form")
    public MailPage switchToIframe() {
        waitFrameIsAvailableAndSwitchToIt(iframe);
        return this;
    }

    @Step("Entering the user name")
    public MailPage enterUserName() {
        emailTxtBox.sendKeys(USERNAME);
        return this;
    }

    @Step("Clicking on Enter the password button")
    public MailPage clickEnterPasswordButton() {
        enterPasswordButton.click();
        return this;
    }

    @Step("Entering the password")
    public MailPage enterPassword() {
        password.sendKeys(PASSWORD);
        return this;
    }

    @Step("Clicking on the account sign in button")
    public InboxPage clickAccountSignInButton() {
        accountSignInButton.click();
        return new InboxPage(driver);
    }

    @Step("Authorization on the website")
    public InboxPage authorization() {
        this.clickSingIn();
        this.switchToIframe();
        this.enterUserName();
        this.clickEnterPasswordButton();
        this.enterPassword();
        this.clickAccountSignInButton();
        driver.switchTo().defaultContent();
        return new InboxPage(driver);
    }

    @Step("Checking the visibility of the account icon")
    public boolean iconOfAccountPresents() {
        if (iconOfAccount.isDisplayed()) iconOfAccount.getText();
        String heading = iconOfAccount.getText();
        System.out.println(heading);
        return iconOfAccount.isDisplayed();
    }
}