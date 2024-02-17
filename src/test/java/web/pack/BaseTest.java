package web.pack;

import com.microsoft.playwright.*;
import config.ConfigLoader;
import config.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

public abstract class BaseTest {
    static Playwright playwright;
    static Browser browser;
    static Configuration configuration;
    static String baseUrl;

    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        configuration = ConfigLoader.loadConfiguration();
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(configuration.isHeadlessMode())
                        .setSlowMo(configuration.getSloMo()));
        baseUrl= configuration.getBaseUrl();
        System.out.println("baseUrl=================>"+baseUrl);
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 850));
        page = context.newPage();
        page.navigate(baseUrl);

// Save storage state into the file.
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));

// Create a new context with the saved storage state.
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json")));






    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }
}