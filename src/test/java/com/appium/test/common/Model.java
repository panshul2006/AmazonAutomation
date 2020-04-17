package com.appium.test.common;

/**
 * <h1>Model.java</h1>
 * Defines actions required in automation execution which are called in Macro.java file  
 *
 * @author  Panshul Srivastava
 * @version 1.0
 * @since   2020-04-16 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.appium.test.common.Locators;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class Model {

	public static boolean isSSOSignInContinuePresent(WebDriver driver) {
		if (driver.findElements(Locators.ssoSignInContinue).size()!=0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void clickSSOSignInContinue(WebDriver driver) {
		System.out.println("Clicking on Continue to proceed with SSO Login");
		driver.findElement(Locators.ssoSignInContinue).click();
	}

	public static boolean isLoginScreenPresent(WebDriver driver) {
		if (driver.findElements(Locators.signInHome).size()!=0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isMenuPresent(WebDriver driver) {
		if (driver.findElements(Locators.hamburgerMenu).size()!=0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isSearchBarPresent(WebDriver driver) {
		if (driver.findElements(Locators.searchBox).size()!=0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isSearchResultsPresent(WebDriver driver) {
		if (driver.findElements(Locators.searchResults).size()!=0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static String getLoginStatus(WebDriver driver) {
		return driver.findElement(Locators.signInText).getText();
	}

	public static void clickLoginOnMenu(WebDriver driver) {
		driver.findElement(Locators.signInText).click();
	}

	public static void clickLogin(WebDriver driver) {
		System.out.println("Click on Sign In");
		driver.findElement(Locators.signInHome).click();
	}

	public static void invokeMenu(WebDriver driver) {
		System.out.println("Invoking Menu");
		driver.findElement(Locators.hamburgerMenu).click();
	}

	public static void enterUsername(WebDriver driver, String username) {
		System.out.println("Entering username");
		driver.findElement(Locators.usernameInput).sendKeys(username);
	}

	public static void clickSignInContinue(WebDriver driver) {
		System.out.println("Click on Continue");
		driver.findElement(Locators.signInContinueButton).click();
	}

	public static void enterPassword(WebDriver driver, String password) {
		System.out.println("Entering password");
		driver.findElement(Locators.passwordInput).sendKeys(password);
	}

	public static void clickSignInSubmit(WebDriver driver) {
		System.out.println("Click on Submit");
		driver.findElement(Locators.signInSubmitButton).click();
	}

	public static void enterSearchText(WebDriver driver, String product) throws InterruptedException {
		System.out.println("Entering search text");
		driver.findElement(Locators.searchBox).sendKeys(product);
		Thread.sleep(3000);
		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	public static void selectSearchResult(WebDriver driver, int resultNumber) throws InterruptedException {
		System.out.println("Selecting search result");
		WebElement element1 = driver.findElement(Locators.product1);
		WebElement element2 = driver.findElement(Locators.product2);
		try {
		MobileActions.swipeByElements(driver, element1, element2);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		/*TouchActions action = new TouchActions(driver);
		action.scroll(element, 10, 100);
		action.perform();*/
	}

	public static void clickLogo(WebDriver driver) {
		System.out.println("Click on Logo");
		driver.findElement(Locators.logo).click();
	}
}
