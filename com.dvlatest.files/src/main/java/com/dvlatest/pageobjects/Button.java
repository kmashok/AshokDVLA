package com.dvlatest.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Home
 *
 */
public class Button {
	
	public static void click(By button) throws IOException {
		WebElement element = (new WebDriverWait(Browser.getDriver(), 10))
				   .until(ExpectedConditions.elementToBeClickable(button));
		element.click();
		Helper.takeScreenshot("ButtonClicked");
	}
}
