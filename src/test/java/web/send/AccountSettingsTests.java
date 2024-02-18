package web.send;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.BaseTest;
import config.ConfigLoader;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountSettingsTests extends BaseTest {
    @Test
    @Tags({@Tag("send"), @Tag("login")})
    @DisplayName("Login with user email and password")
    public void loginTest() {
        configuration = ConfigLoader.loadConfiguration();
        page.navigate(baseUrl + "send");
        rejectCookies();
        clickLoginOnHomePage();
        //WORKS
//        enterUserEmail(configuration.getSitUserEmail());
//        enterPassword(configuration.getSitPassword());
        ///PROD
        enterUserEmail("ballachakri@gmail.com");
        enterPassword("Khalifa123.");
        clickLoginButton();
        Locator locator = page.locator("div[class='nav__user-name']");
        embedScreenshot(page);
        assertThat(locator).containsText("Chakra");
    }

    @Step("Click log in on home page")
    public void clickLoginOnHomePage() {
        Locator loginButtonOnHomePage = page.getByTestId("login-button-top");
        loginButtonOnHomePage.click();
        embedScreenshot(page);
    }


    @Step("Enter user email : {0}")
    public void enterUserEmail(String email) {
        Locator emailTextField = page.locator("input[name='email']");
        emailTextField.fill(email);
        embedScreenshot(page);
    }

    @Step("Enter user password : {0}")
    public void enterPassword(String password) {
        Locator passwordTextField = page.locator("input[name='password']");
        passwordTextField.fill(password);
        embedScreenshot(page);
    }

    @Step("Click log in button")
    public void clickLoginButton() {
        Locator loginButton = page.locator("button[name='submit']");
        loginButton.click();
        embedScreenshot(page);
    }


}
