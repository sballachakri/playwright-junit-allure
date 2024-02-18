package misc;
import config.BaseTest;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PostsBrowsingTests extends BaseTest {

    @Test
    void shouldViewPostsOnHomePage() {
        System.out.println(baseUrl);
        page.navigate(baseUrl);
//        System.out.println(ConfigLoader.loadConfiguration().getSitUserEmail());
//        System.out.println(ConfigLoader.loadConfiguration().getSitPassword());


//        int postsCount = page.locator(".alert").count();
//        assertThat(postsCount).isGreaterThan(0);
    }

    @Test
    void shouldNavigateBetweenPostPagesUsingPaginator() {
        page.navigate(baseUrl);
//        page.locator("text='Next'").first().click();
//        page.locator("text='Previous'").first().click();
//        page.locator("text='Last'").first().click();
//        page.locator("text='First'").first().click();
    }

    @Test
    void shouldSearchPosts() {
        page.navigate(baseUrl);
//        page.locator("input[name='query']").fill("flyway");
//        page.locator("button:text('Search')").first().click();
        //int postsCount = page.locator(".alert").count();
       // assertThat(postsCount).isEqualTo(6);
    }

    @Test
    void shouldNavigateBetweenSearchPostsUsingPaginator() {
        page.navigate(baseUrl);
//        page.locator("input[name='query']").fill("boot");
//        page.locator("button:text('Search')").first().click();
//        int postsCount = page.locator(".alert").count();
//    //    assertThat(postsCount).isGreaterThan(0);
//        page.locator("text='Next'").first().click();
//        page.locator("text='Previous'").first().click();
//        page.locator("text='Last'").first().click();
//        page.locator("text='First'").first().click();
    }

    @Test
    void shouldViewPostsByCategory() {
        page.navigate(baseUrl);
        //page.locator(".list-group-item").first().click();
//        int postsCount = page.locator(".alert").count();
//        assertThat(postsCount).isGreaterThan(0);
    }
}