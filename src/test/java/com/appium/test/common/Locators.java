package com.appium.test.common;

/**
 * <h1>Locators.java</h1>
 * Defines path of elements required in automation execution which are called in Model.java file  
 *
 * @author  Panshul Srivastava
 * @version 1.0
 * @since   2020-04-16 
 */

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public class Locators {
	public static By signInHome = By.id("com.amazon.mShop.android.shopping:id/sign_in_button");
	public static By hamburgerMenu = By.xpath("//android.widget.FrameLayout[@content-desc=\"Navigation panel, button, double tap to open side panel\"]");
	public static By usernameInput = By.id("ap_email_login");
	public static By passwordInput = By.id("ap_password");
	public static By signInContinueButton = By.xpath("//*[contains(@text,'Continue')]");
	public static By ssoSignInContinue = By.id("com.amazon.mShop.android.shopping:id/sso_continue");
	public static By settingsButton = By.xpath("//*[contains(@text,'Settings')");
	public static By signInSubmitButton = By.id("signInSubmit");
	public static By searchBox = MobileBy.id("com.amazon.mShop.android.shopping:id/rs_search_src_text");
	public static By searchResults = By.id("search");
	public static By signInText = By.id("com.amazon.mShop.android.shopping:id/gno_greeting_text_view");
	public static By logo = By.id("com.amazon.mShop.android.shopping:id/chrome_action_bar_home_logo");
	public static By product1 = By.xpath("//android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[3]");
	public static By product2 = By.xpath("//android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[13]");
}