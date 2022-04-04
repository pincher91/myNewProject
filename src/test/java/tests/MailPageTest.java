package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailPageTest extends BaseTest {

    @Test
    @Description("Authorization on the website")
    public void authorizationTest() {
        mailPage.authorization();
        Assert.assertTrue( mailPage.iconOfAccountPresents());
    }

    @Test
    @Description("Sending a letter to yourself")
    public void sendLetterToYourselfTest() {
        inboxPage.sendLetterToYourself();
        inboxPage.takeScreenshot();
        Assert.assertTrue(inboxPage.letterToYourselfPresents());
        inboxPage.takeScreenshot();
    }
}