package com.dvlatest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Home
 *
 */
public class Textbox {
	public static void typeText(By textbox, String text) {
		WebElement element = (new WebDriverWait(Browser.getDriver(), 10))
				   .until(ExpectedConditions.presenceOfElementLocated(textbox));
		
		element.sendKeys(text);
	}
}
