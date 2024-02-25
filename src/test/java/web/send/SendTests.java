package web.send;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import config.BaseTest;
import java.util.stream.Stream;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Tag("SendFlowTests")
public class SendTests extends BaseTest {
    @Test
    @Tags({@Tag("send"), @Tag("get-title")})
    @DisplayName("Navigate to send page")
    public void getTitle() {
        System.out.println(page.url());
        page.navigate(baseUrl + "send");
        rejectCookies();
        embedScreenshot(page);
        assertThat(page).hasTitle("Send a Parcel in the UK | Cheap Parcel Service | Evri");
    }

    @ParameterizedTest
    @MethodSource("getParcelWeightBands")
    @Tags({@Tag("send"), @Tag("send-a-parcel")})
    @DisplayName("Send a parcel - parcel weight band : '{0}'")
    public void sendParcel(String weightBands) {
        page.navigate(baseUrl + "send");
        rejectCookies();
        enterFromPostcode("LS27 0WH");
        enterToPostcode("HD7 5RS");
        selectParcelWeight(weightBands);
        clickSendAParcelButton();
        selectStandardSpeedOfDelivery();

    }

    @Step("Enter from postcode : ''{0}''")
    public void enterFromPostcode(String fromPostcode) {
        Locator fromPostCode = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("From postcode"));
        assertThat(fromPostCode).isVisible();
        fromPostCode.fill(fromPostcode);
        embedScreenshot(page);
    }

    @Step("Enter to postcode : ''{0}''")
    public void enterToPostcode(String toPostcode) {
        Locator toPostCode = page.getByRole(AriaRole.TEXTBOX,
                new Page.GetByRoleOptions().setName("To postcode"));
        assertThat(toPostCode).isVisible();
        toPostCode.fill(toPostcode);
        embedScreenshot(page);
    }

    @Step("Select parcel weight : ''{0}''")
    public void selectParcelWeight(String parcelWeight) {
        Locator weightsDropdown = page.getByText("Please select");
        embedScreenshot(page);
        assertThat(weightsDropdown).isEnabled();
        weightsDropdown.click();
        Locator weight = page.getByText(parcelWeight);
        weight.click();
        embedScreenshot(page);

    }

    @Step("Click 'send a parcel' button")
    public void clickSendAParcelButton() {
        Locator sendAParcelButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get a price"));
        embedScreenshot(page);
        assertThat(sendAParcelButton).isEnabled();
        sendAParcelButton.click();
    }

    @Step("Select standard speed of delivery")
    public void selectStandardSpeedOfDelivery() {
        Locator standard = page.getByTestId("speed-select-standard-option-label");
        standard.click();
        embedScreenshot(page);

    }

    private static Stream<Arguments> getParcelWeightBands() {
        return Stream.of(
                arguments("Under 1kg"),
                arguments("1kg - 2kg"),
                arguments("2kg - 5kg"),
                arguments("5kg - 10kg"),
                arguments("10kg - 15kg")
        );
    }



}