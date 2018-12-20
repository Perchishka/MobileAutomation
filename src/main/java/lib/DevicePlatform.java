package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DevicePlatform {

    private static final String
            PLATFORM_IOS = "iOS",
            PLATFORM_ANDROID = "android",
            APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static DevicePlatform instance;

    private DevicePlatform(){}

    public static DevicePlatform getInstance() {
        if(instance == null){
            instance = new DevicePlatform();
        }
        return instance;
    }

    public AppiumDriver getDriver() throws Exception{
        URL url = new URL(APPIUM_URL);

        if(isAndroid()){
            return new AndroidDriver(url, this.getAndroidDesiredCapabilitues());
        } else if (isIOS()){
            return new IOSDriver(url, this.getIOSDesiredCapabilities());
        } else{
            throw new Exception("Cannot detect type of driver. Pltform value: "+ getPlatformVar());
        }
    }

    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS(){
        return isPlatform(PLATFORM_IOS);
    }

    private DesiredCapabilities getAndroidDesiredCapabilitues() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        // для андройда валью может быть любым а для айоса должно четко соответствовать названию девайса
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\JAVA\\WORK\\mobileAutomation\\libs\\org.wikipedia.apk");
        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        // для андройда валью может быть любым а для айоса должно четко соответствовать названию девайса
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("platformVersion", "11.1");

        capabilities.setCapability("app", "C:\\JAVA\\WORK\\mobileAutomation\\libs\\org.wikipedia.apk"); //исправить линк
        return capabilities;
    }

    private String getPlatformVar() {
        return System.getenv("PLATFORM");
    }

    private boolean isPlatform(String myPlatform) {
        String platform = this.getPlatformVar();
        return myPlatform.equals(platform);
    }
}
