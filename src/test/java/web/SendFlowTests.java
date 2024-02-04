package web;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class SendFlowTests {
    @Test
    @Tag("get-title")
    @DisplayName("Get Evri home page title and assert")
    public void getTitle() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(2500));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.evri.com/");
            System.out.println(page.url());
            Locator reject=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reject all"));
            if(reject.isEnabled()) {
                reject.click();
                System.out.println("clicked");
            }

            Locator fromPostCode=page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName("From postcode"));
            System.out.println(fromPostCode.isVisible());
            fromPostCode.fill("LS27 0WH");
             Locator toPostCode=page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName("To postcode"));
             System.out.println(toPostCode.isVisible());
            toPostCode.fill("HD7 5RS");
            Locator weights=page.getByText("Please select");
                    weights.click();

         //   System.out.println(weights.isEnabled());
       //     page.locator("css=div[data-test-id='dropdown-selected-text-value']").selectOption("1kg - 2kg");




//            page.locator("#dropdown-container").click();
//            page.locator("css=")
//            dropdown.selectOption({value: "slice59")
//            Locator selectWeight=page.getByRole(AriaRole.COMBOBOX,
//                    new Page.GetByRoleOptions().setName("Please select"));
//            System.out.println(selectWeight.isEnabled());




//                        page.screenshot(new Page.ScreenshotOptions()
//                    .setPath(Paths.get("homepage"+"screenshot.png")));
            assertThat(page).hasTitle("Evri | Cheap Parcel Delivery & Courier Service UK");
            context.close();
            page.close();
        }
    }
}