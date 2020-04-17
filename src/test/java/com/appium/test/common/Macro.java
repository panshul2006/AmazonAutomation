package com.appium.test.common;

/**
 * <h1>Macro.java</h1>
 * Defines test case methods required for automation execution  
 *
 * @author  Panshul Srivastava
 * @version 1.0
 * @since   2020-04-16 
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

public class Macro {

	public static void login(WebDriver driver, String username, String password) throws InterruptedException {
		System.out.println("Performing Login verification...");
		Thread.sleep(5000);
		try {
			if (Model.isSSOSignInContinuePresent(driver)) {
				Model.clickSSOSignInContinue(driver);
				Thread.sleep(5000);
			}
			if (Model.isLoginScreenPresent(driver)) {
				Model.clickLogin(driver);
				Thread.sleep(3000);
				performLogin(driver, username, password);
				Thread.sleep(3000);
			}
			if (Model.isMenuPresent(driver)) {
				Thread.sleep(2000);
				Model.invokeMenu(driver);
				Thread.sleep(2000);
				String loginStatus = Model.getLoginStatus(driver);
				if (!loginStatus.equals("Hello. Sign In")) {
					Reporter.log("Login Successful", true);
					Assert.assertTrue(true);
				}
				else {
					Model.clickLoginOnMenu(driver);
					Thread.sleep(3000);
					performLogin(driver, username, password);
					loginStatus = Model.getLoginStatus(driver);
					if (!loginStatus.equals("Hello. Sign In")) {
						Reporter.log("Login Successful", true);
						Assert.assertTrue(true);
					}
					else
					{
						Reporter.log("Login Unsuccessful", true);
						Assert.assertTrue(false);
					}
				}
			}
			else {
				Reporter.log("Login Verification Failed", true);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void search(WebDriver driver, String product) throws InterruptedException {
		System.out.println("Performing Product Search verification...");
		if (!Model.isSearchBarPresent(driver)) {
			System.out.println("Search bar not present, returning to home page...");
			Model.clickLogo(driver);
			Thread.sleep(3000);
		}
		else
		{
			Model.enterSearchText(driver, product);
			Thread.sleep(5000);
			if (!Model.isSearchResultsPresent(driver)) {
				Reporter.log("Search Unsuccessful", true);
				Assert.assertTrue(false);
			}
			else
			{
				System.out.println("Search Results Present");
				Model.selectSearchResult((AndroidDriver) driver, 13);
			}
		}
	}

	private static void performLogin(WebDriver driver, String username, String password) throws InterruptedException {
		System.out.println("Beginning Login Procedure...");
		Model.enterUsername(driver, username);
		Model.clickSignInContinue(driver);
		Thread.sleep(3000);
		Model.enterPassword(driver, password);
		Model.clickSignInSubmit(driver);
		Thread.sleep(5000);
	}

	public static void navigateHome(WebDriver driver) {
		Model.clickLogo(driver);
	}
}
