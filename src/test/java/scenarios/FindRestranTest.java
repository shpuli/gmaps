package scenarios;

import io.appium.java_client.MobileBy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class FindRestranTest extends AndroidSetup {

    @Before
    public void setUp() throws MalformedURLException {
        prepareAndroidForAppium();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void omgTest(){
        driver.findElement(MobileBy.className("android.widget.EditText"));
    }
}
