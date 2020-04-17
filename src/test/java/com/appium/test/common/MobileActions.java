package com.appium.test.common;

/**
 * <h1>MobileActions.java</h1>
 * Defines actions required for navigation in the Amazon app  
 *
 * @author  Panshul Srivastava
 * @version 1.0
 * @since   2020-04-17
 */

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class MobileActions {

	//Swipe by elements
	public static void swipeByElements(WebDriver driver, WebElement startElement, WebElement endElement) {
		int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

		int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

		new TouchAction((PerformsTouchActions) driver)
		.press(point(startX,startY))
		.waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(endX, endY))
		.release().perform();
	}

}
