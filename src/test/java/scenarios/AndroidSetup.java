package scenarios;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSetup {
    protected AndroidDriver driver;

    File appDir = new File("app");
    File app = new File(appDir, "base.apk");

    final String udid = "4b494ddc";

    protected void prepareAndroidForAppium() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.UDID, udid);

        this.driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub")
                , capabilities);
    }
}
