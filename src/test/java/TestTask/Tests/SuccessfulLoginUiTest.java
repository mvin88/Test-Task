package TestTask.Tests;

import TestTask.FunctionalTest;
import TestTask.Pages.BasePage;
import TestTask.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static TestTask.TestUser.normalUser;

public class SuccessfulLoginUiTest extends FunctionalTest {

    private User testUser;
    private BasePage basePage = new BasePage();


    @Before
    public void setUp() {
        testUser = normalUser;
        basePage
                .getBasePage();
    }

    @Test
    public void login_shouldBe_successful_when_correct_email_and_password() {
        basePage
                .enterEmail(testUser.getUserName())
                .enterPassword(testUser.getPassword())
                .logIn();
    }

    @After
    public void tearDown() {

    }

}

