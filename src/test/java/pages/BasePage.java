package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step
    protected void waitForVisibilityOf(By by) {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Step
    protected boolean isElementPresentedByLocator(By by) {
        try {
            (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Step
    protected void waitElementToBeClickable(WebElement element) {
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.elementToBeClickable(element));
    }
}