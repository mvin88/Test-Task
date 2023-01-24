package TestTask.Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasePage {

    public static final String BASE_URL = "http://u920152e.beget.tech/";

    private SelenideElement timeCounter = $(byId("timer-counter"));
    private SelenideElement authHead = $(byClassName("form_auth_block_head_text"));
    private SelenideElement emailField = $(byName("auth_email"));
    private SelenideElement passField = $(byName("auth_pass"));
    private SelenideElement loginButton = $(byClassName("form_auth_button"));

    public static Logger log = LogManager.getLogger();

    public BasePage waitForPageLoading() {
        timeCounter.should(exist);
        authHead.should(exist);
        return this;
    }

    public BasePage enterEmail(String email) {
        try {
            emailField.setValue(email);

        } catch (Exception e){
            log.error("Can't enter e-mail");
        }
        return this;
    }

    public BasePage enterPassword(String password) {
        try {
            passField.setValue(password);
        } catch (Exception e){
            log.error("Can't enter password");
        }
        return this;
    }

    public BasePage logIn() {
        try {
            loginButton.click();
        } catch (Exception e){
            log.error("Couldn't login into account");
        }
        return this;
    }

    public BasePage checkURL() {
        assertThat(isThisPage(), is(true));
        return this;
    }

    private boolean isThisPage() {
        return WebDriverRunner.url().contains(BASE_URL);
    }

    public BasePage getBasePage() {
        return (BasePage) open(BASE_URL, BasePage.class)
                .waitForPageLoading()
                .checkURL();
    }

}
