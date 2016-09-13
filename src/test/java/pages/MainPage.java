package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Search by location field
     */
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement searchField;

    /**
     * Clear search field button
     */
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Clear']")
    private MobileElement clearSearchButton;

    /**
     * Red buttons in search menu for searching restaurants around
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Restaurants']")
    private MobileElement restaurantsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gas Stations']")
    private MobileElement gasButton;

    /**
     * Small preview of the street
     */
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Street view thumbnail']")
    private MobileElement streetView;

    /**
     * Find route button
     */
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Directions']")
    private MobileElement routeButton;

    /**
     * List of found places
     */
    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView")
    private MobileElement placesSearchResultList;

    /**
     * First element in list of found places
     */
    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[@index='0']")
    private MobileElement placesSearchResultItem;

    @Step
    public void openSearch(){
        searchField.click();
    };

    @Step
    public MainPage searchLocation(String street, String district) {
        this.openSearch();
        searchField.sendKeys(street + district);
        String inSearchLocator = "//android.widget.ScrollView//android.widget.TextView[@text='" + street + "']";
        waitForVisibilityOf(MobileBy.xpath(inSearchLocator));
        driver.findElement(MobileBy.xpath(inSearchLocator)).click();
        waitElementToBeClickable(streetView);
        return this;
    }

    @Step
    public MainPage searchRestaurants() {
        this.openSearch();
        waitElementToBeClickable(restaurantsButton);
        restaurantsButton.click();
        waitElementToBeClickable(placesSearchResultList);
        return this;
    }

    @Step
    public MainPage clearSearch() {
        clearSearchButton.click();
        return this;
    }

    @Step
    public RestaurantPage gotoRestaurant() {
        placesSearchResultItem.click();
        return new RestaurantPage(driver);
    }

    @Step
    public RoutePage gotoRoute() {
        routeButton.click();
        return new RoutePage(driver);
    }
}