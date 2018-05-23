package Hepler;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс для общей логики без привязки к какой либо из страниц
 */
public class SupportActions {

    AppiumDriver<WebElement> driver = null;

    /**
     * Instantiates a new Support actions.
     *
     * @param driver the driver
     */
    public SupportActions(AppiumDriver<WebElement> driver) {
        this.driver = driver;

    }

    /**
     * Change context to chromium.
     */
    public void changeContextToCHROMIUM(){
        driver.context("CHROMIUM");
    }

    /**
     * Change context to native app.
     */
    public void changeContextToNATIVE_APP(){
        driver.context("NATIVE_APP");
    }

    /**
     * Wait for element.
     *
     * @param element the element
     * @param seconds the seconds
     */
    public void waitForElement(WebElement element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
