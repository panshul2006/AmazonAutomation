package com.appium.test.appium;

/**
 * <h1>Amazon_test.java</h1>
 * Defines initialization of Appium capabilities and calls to login and product search test cases  
 *
 * @author  Panshul Srivastava
 * @version 1.0
 * @since   2020-04-17 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import com.appium.test.common.Macro;

public class Amazon_test {
	static AndroidDriver driver;
	static Properties prop;

	/**
	 * Initialize Appium instance and load properties file
	 * 
	 */
	@BeforeSuite
	public static void setup() throws MalformedURLException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "src/test/java/com/appium/test/");
		File app = new File(appDir, "testdata.properties");
		DesiredCapabilities caps = new DesiredCapabilities();
		File file = new File(app.getAbsolutePath());
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		DesiredCapabilities cap =new DesiredCapabilities();
		cap.setCapability("deviceName","YourDevice");
		cap.setCapability("udid", prop.getProperty("udid"));
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", prop.getProperty("platformversion"));
		cap.setCapability("appPackage","com.amazon.mShop.android.shopping");
		cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");
		URL url = new URL(prop.getProperty("appium_url"));
		driver =new AndroidDriver(url,cap);
		System.out.println("Application started..");
	}

	/**
	 * Test definition to call Login test case
	 * @param driver - Passes instance of AndroidDriver to the login method
	 * @param prop.getProperty("username") - Fetches value of username from properties file and passes to the login method
	 * @param prop.getProperty("password") - Fetches value of password from properties file and passes to the login method
	 * @return void Method returns no value
	 */
	@Test
	public void test01_login() throws InterruptedException {
		Macro.login(driver, prop.getProperty("username"), prop.getProperty("password"));
	}

	/**
	 * Test definition to call ProductSearch test case
	 * @param driver - Passes instance of AndroidDriver to the login method
	 * @param prop.getProperty("product") - Fetches value of product to be searched from properties file and passes to the search method
	 * @return void Method returns no value
	 */
	@Test
	public void test02_productSearch() throws InterruptedException {
		Macro.search(driver, prop.getProperty("product"));
		Thread.sleep(2000);
	}

	/**
	 * Close the Appium instance
	 * 
	 */
	@AfterSuite
	public static void teardown(){
		System.out.println("Ending Test");
		driver.close();
	}

}