package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class RoutePage extends BasePage {
    public RoutePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Field for start of route
     */
    @AndroidFindBy(id = "com.google.android.apps.maps:id/directions_startpoint_textbox")
    private MobileElement startPointField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your location']")
    private MobileElement startFromMyLocationtButton;

    /**
     * Buttons to select type of route
     */
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Walking mode']")
    private MobileElement onFeetButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Driving mode']")
    private MobileElement byCarButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Transit mode']")
    private MobileElement byTransportButton;

    /**
     * Button of my location on the map
     */
    @AndroidFindBy(id = "com.google.android.apps.maps:id/qu_mylocation_container")
    private MobileElement locationButton;

    @Step
    public RoutePage selectOnFeet() {
        onFeetButton.click();
        return this;
    }

    @Step
    public RoutePage selectStart() {
        startPointField.click();
        waitElementToBeClickable(startFromMyLocationtButton);
        startFromMyLocationtButton.click();
        waitElementToBeClickable(locationButton);
        return this;
    }

    @Step
    public boolean isErrorShown() {
        String locator = "//android.widget.TextView[contains(@text,'No route found')]";
        return isElementPresentedByLocator(MobileBy.xpath(locator));
    }
}