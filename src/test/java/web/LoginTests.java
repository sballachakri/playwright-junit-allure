package web;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class LoginTests {
    @Test
    @Tag("login")
    @DisplayName("Login test")
    public void test3() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(2500));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://github.com/login");
// Interact with login form
            page.getByLabel("Username or email address").fill("username");
            page.getByLabel("Password").fill("password");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in"))
                    .click();
// Continue with the test

            // Save storage state into the file.
            context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));

// Create a new context with the saved storage state.
//            BrowserContext context = browser.newContext(
//                    new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json")));

// Get session storage and store as env variable
//            String sessionStorage = (String) page.evaluate("JSON.stringify(sessionStorage)");
//            System.getenv().put("SESSION_STORAGE", sessionStorage);

// Set session storage in a new context
//            String sessionStorage = System.getenv("SESSION_STORAGE");
//            context.addInitScript("(storage => {\n" +
//                    "  if (window.location.hostname === 'example.com') {\n" +
//                    "    const entries = JSON.parse(storage);\n" +
//                    "     for (const [key, value] of Object.entries(entries)) {\n" +
//                    "      window.sessionStorage.setItem(key, value);\n" +
//                    "    };\n" +
//                    "  }\n" +
//                    "})('" + sessionStorage + "')");
        }

    }

}
