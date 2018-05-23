package Pages;

import Hepler.SupportActions;
import io.appium.java_client.AppiumDriver;

/**
 * Общий класс для всех тестируемых страниц
 */
public abstract class Page {
    /**
     * The Driver.
     */
    protected AppiumDriver driver;
    /**
     * The Actions.
     */
    protected SupportActions actions = null;

    /**
     * Instantiates a new Page.
     *
     * @param driver the driver
     */
    public Page(AppiumDriver driver) {
        this.driver=driver;
        actions = new SupportActions(driver);
    }


}
