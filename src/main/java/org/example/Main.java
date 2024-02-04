package org.example;

import com.microsoft.playwright.*;

public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium()
                  //  .launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1110));
                    .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(1110));

            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            browser.close();
            playwright.close();


        }
    }
}