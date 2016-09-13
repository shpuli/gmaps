package scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.RestaurantPage;
import pages.RoutePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.net.MalformedURLException;

@Features("Search in US")
public class FindRestrauntTest extends AndroidSetup {
    final String testedPlaceStreet = "3544 Van Buren St";
    final String testedPlaceDistrict = "Gary, IN 46408, USA";

    @Before
    public void setUp() throws MalformedURLException {
        prepareAndroidForAppium();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Stories("Find restaurant around the place")
    @Test
    public void searchingRestaurantsTest() {
        MainPage main;
        RestaurantPage restaurant;
        main = new MainPage(driver).searchLocation(testedPlaceStreet, testedPlaceDistrict);
        main.clearSearch();
        main.searchRestaurants();
        restaurant = main.gotoRestaurant();

        assert restaurant.isRestaurantInDesiredDistrict(testedPlaceDistrict)
                : "Restaurant is not near this place";
    }

    @Stories("Not to find route to the place")
    @Test
    public void noRouteToStatesTest() {
        MainPage main;
        RoutePage route;
        main =  new MainPage(driver).searchLocation(testedPlaceStreet,testedPlaceDistrict);
        route = main.gotoRoute();
        route.selectOnFeet();
        route.selectStart();

        assert route.isErrorShown() : "Found way to USA";
    }
}