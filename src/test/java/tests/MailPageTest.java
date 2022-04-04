package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.Constant.Url.URL;

public class MailPageTest extends BaseTest {

    @Test
    public void SendingLetterToYourselfTest() {
        basePage.open(URL);
        mailPage
                .authorization();
        Assert.assertTrue(mailPage.iconOfAccount());

        inboxPage
                .sendLetterToYourself();
        Assert.assertTrue(inboxPage.letterToYourselfPresents());
    }
}