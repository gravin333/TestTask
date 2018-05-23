package Pages;


/**
 * Класс для создания параметров устройства
 */
public class TestDevice {
    /**
     * The Platform name.
     */
    String PLATFORM_NAME;
    /**
     * The Platform version.
     */
    String PLATFORM_VERSION;
    /**
     * The Device name.
     */
    String DEVICE_NAME;

    /**
     * Instantiates a new Test device.
     *
     * @param PLATFORM_NAME    the platform name
     * @param PLATFORM_VERSION the platform version
     * @param DEVICE_NAME      the device name
     */
    public TestDevice(String PLATFORM_NAME, String PLATFORM_VERSION, String DEVICE_NAME) {
        this.PLATFORM_NAME = PLATFORM_NAME;
        this.PLATFORM_VERSION = PLATFORM_VERSION;
        this.DEVICE_NAME = DEVICE_NAME;
    }
}
