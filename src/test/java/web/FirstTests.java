package web;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTests {

    public static void main(String[] args) {
        try (Playwright playwright=Playwright.create()){
            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(2500));
            BrowserContext context=browser.newContext();

            Page page=browser.newPage();
            page.navigate("https://www.evri.com/");
            assertThat(page).hasTitle("Evri | Cheap Parcel Delivery & Courier Service UK");
            context.close();
            page.close();


        }

    }



}
