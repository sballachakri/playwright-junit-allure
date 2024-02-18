package config;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import java.nio.file.Paths;

public abstract class BaseTest {
    public static Playwright playwright;
    public static Browser browser;
    public static Configuration configuration;
    public static String baseUrl;
    // New instance for each test method.
    public BrowserContext context;
    public Page page;

    @BeforeAll
    static void launchBrowser() {
        configuration = ConfigLoader.loadConfiguration();
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(configuration.isHeadlessMode())
                        .setSlowMo(configuration.getSloMo()));
        baseUrl = configuration.getBaseUrl();
        System.out.println("baseUrl=================>" + baseUrl);
        playwright.selectors().setTestIdAttribute("data-test-id");
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 850));
        page = context.newPage();
        //    page.navigate(baseUrl);

// Save storage state into the file.
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));

// Create a new context with the saved storage state.
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json")));
    }

    //TODO - CHECK - RETURNS ERROR
    @AfterEach
    // void closeContext(Page page) {
    void closeContext() {
        embedScreenshot(page);
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @Attachment
    public byte[] embedScreenshot(Page page) {
        //return page.screenshot();
        return page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
    }

    public void rejectCookies() {
        Locator reject = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reject all"));
        if (reject.isEnabled()) {
            reject.click();
            embedScreenshot(page);
        }
    }
}