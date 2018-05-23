package Pages;

import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Общий класс для всех тестов
 */
public abstract class TestFrame {

    protected AppiumDriver driver = null;
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities capabilities;
    private TestDevice device;

    /**
     * инициализация необходимых елементов
     */
    @BeforeClass
    public void init(){
        runService();
        checkAppiumServer(4723);
        runAppium();
    }

    /**
     * Stop server.
     */
    @AfterClass
    public void stopServer() {
        driver.quit();
        service.stop();
    }

    /**
     * рестарт браузера после каждого тест метода
     */
    @AfterMethod
    public void resetBrowser(){
        driver.resetApp();
    }


    /**
     * Run appium.
     */
    public void runAppium(){

        device = new TestDevice("Android","7.1.1","192.168.74.102:5555");

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device.PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.PLATFORM_NAME);
        capabilities.setCapability("noReset", "false");
        capabilities.setCapability("chromedriverExecutable","./src/main/resources/chromedriver.exe");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("app-package", "com.google.android.apps.chrome");
        capabilities.setCapability("app-activity", "com.google.android.apps.chrome.Main");

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private void runService() {
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
        service = AppiumDriverLocalService.buildService(builder);
        startServer();
    }

    private boolean checkAppiumServer(int port){
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    private void startServer(){
        service.start();
    }

}
