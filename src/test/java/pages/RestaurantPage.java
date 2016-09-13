package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class RestaurantPage extends BasePage{

    public RestaurantPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean isRestaurantInDesiredDistrict(String district) {
        String locator = "//android.widget.TextView[contains(@text,'" + district + "')]";
        return isElementPresentedByLocator(MobileBy.xpath(locator));
    }
}