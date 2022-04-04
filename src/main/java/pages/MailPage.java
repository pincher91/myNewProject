package pages;

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
    private WebElement login;
    @FindBy(xpath = "//span[text()='Ввести пароль']")
    private WebElement enterPasswordButton;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = ".//*[@data-test-id='submit-button']//span")
    private WebElement signInFormButton;
    @FindBy(xpath = "//span[contains(@class,'ph-project__user-name') and text()='lesson_10@mail.ru']")
    private WebElement iconOfAccount;

    public pages.MailPage clickSingIn() {
        sinInButton.click();
        return this;
    }

    public pages.MailPage switchToIframe() {
        waitFrameIsAvailableAndSwitchToIt(iframe);
        return this;
    }

    public pages.MailPage fillInputLogin() {
        login.sendKeys(USERNAME);
        return this;
    }

    public pages.MailPage clickEnterPasswordButton() {
        enterPasswordButton.click();
        return this;
    }

    public pages.MailPage fillInputPassword() {
        password.sendKeys(PASSWORD);
        return this;
    }

    public InboxPage clickSignInFormButton() {
        signInFormButton.click();
        return new InboxPage(driver);
    }

    public InboxPage authorization() {
        this.clickSingIn();
        this.switchToIframe();
        this.fillInputLogin();
        this.clickEnterPasswordButton();
        this.fillInputPassword();
        this.clickSignInFormButton();
        driver.switchTo().defaultContent();
        return new InboxPage(driver);
    }

    public boolean iconOfAccount() {
        return iconOfAccount.isDisplayed();
    }
}