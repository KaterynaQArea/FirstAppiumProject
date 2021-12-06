import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidTest {

    @Test
    public void androidTest() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("app", System.getProperty("user.dir") + "/SauceLabsTestApp.apk");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("deviceName", "Pixel XL API 29");
        desiredCapabilities.setCapability("appActivity", ".SplashActivity");
        desiredCapabilities.setCapability("appPackage", "com.swaglabsmobileapp");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileElement usernameField = driver.findElementByAccessibilityId("test-Username");
        usernameField.sendKeys("standard_user");

        MobileElement passwordField = driver.findElementByAccessibilityId("test-Password");
        passwordField.sendKeys("secret_sauce");

        MobileElement loginButton = driver.findElementByAccessibilityId("test-LOGIN");
        loginButton.click();

        MobileElement menuIcon = driver.findElementByAccessibilityId("test-Menu");
        menuIcon.click();

        MobileElement allItems = driver.findElementByAccessibilityId("test-ALL ITEMS");
        allItems.click();

        MobileElement filterIcon = driver.findElementByAccessibilityId("test-Modal Selector Button");
        filterIcon.click();

        MobileElement sortByNameFromZtoA = driver.findElementByXPath("//android.widget.TextView[@text=\"Name (Z to A)\"]");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sortByNameFromZtoA.click();

        MobileElement listViewIcon = driver.findElementByAccessibilityId("test-Toggle");
        listViewIcon.click();

        MobileElement addFirstProduct = driver.findElementByAccessibilityId("test-ADD TO CART");
        addFirstProduct.click();

        MobileElement cartButton = driver.findElementByAccessibilityId("test-Cart");
        cartButton.click();

        MobileElement checkoutButton = driver.findElementByAccessibilityId("test-CHECKOUT");
        checkoutButton.click();

        MobileElement nameField = driver.findElementByAccessibilityId("test-First Name");
        nameField.sendKeys("Kateryna");

        MobileElement lastnameField = driver.findElementByAccessibilityId("test-Last Name");
        lastnameField.sendKeys("Samilyk");

        MobileElement zipcodeField = driver.findElementByAccessibilityId("test-Zip/Postal Code");
        zipcodeField.sendKeys("61105");

        MobileElement continueButton = driver.findElementByAccessibilityId("test-CONTINUE");
        continueButton.click();

        driver.quit();
    }
}
