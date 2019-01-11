package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DevicePlatform {

    private static final String
            PLATFORM_IOS = "iOS",
            PLATFORM_MOBILE_WEB="mobile_web",
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

    public RemoteWebDriver getDriver() throws Exception{
        URL url = new URL(APPIUM_URL);

        if(isAndroid()){
            return new AndroidDriver(url, this.getAndroidDesiredCapabilitues());
        } else if (isIOS()){
            return new IOSDriver(url, this.getIOSDesiredCapabilities());}
            else if (isMw()){
                return new ChromeDriver(this.getMwChromeOptions());
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

    public boolean isMw(){
        return isPlatform(PLATFORM_MOBILE_WEB);
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
        capabilities.setCapability("deviceName", "iPhone SE");
        capabilities.setCapability("platformVersion", "11.3");

        capabilities.setCapability("app", "/Users/ekaterinaperceva/Desktop/gradle/Wikipedia.app"); //исправить линк
        return capabilities;
    }

    private ChromeOptions getMwChromeOptions(){
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("deviceRation", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=340,640");
        return chromeOptions;
    }

    public String getPlatformVar() {
        return System.getenv("PLATFORM");
    }

    private boolean isPlatform(String myPlatform) {
        String platform = this.getPlatformVar();
        return myPlatform.equals(platform);
    }
}
