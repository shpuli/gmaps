package scenarios;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSetup {
    protected AndroidDriver driver;

//    final String testAppPackage = "com.android.vending";
    final String testAppPackage = "com.google.android.apps.maps";

    String udid = "4b494ddc";

    protected void prepareAndroidForAppium() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.APP, testAppPackage);
//        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, ".AssetBrowserActivity");
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "portrait");

        this.driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub")
                , capabilities);
    }
}
