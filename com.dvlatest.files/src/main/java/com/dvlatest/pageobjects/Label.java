package com.dvlatest.pageobjects;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Home
 *
 */
public class Label {
	public static String getText(By label) {
		WebElement element = (new WebDriverWait(Browser.getDriver(), 10))
				   .until(ExpectedConditions.presenceOfElementLocated(label));
		return element.getText();
	}
	
	public static boolean verifyLabelText(By label, String expected) throws IOException {
		//Thread.sleep(15000);
		if (Browser.getDriver().findElement(label).getText().contains(expected)) {
			Helper.takeScreenshot("TextVerified");
			return true;
		}
		
		return false;
	}
}
