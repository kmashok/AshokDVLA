package com.dvlatest.pageobjects;

/**
 * 
 */

import java.io.File;
import java.io.IOException;



/**
 * @author Home
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	private static WebDriver _driver;
	
	public static void openURL2(String URL) throws IOException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "lib" + File.separator + "geckodriver.exe");
		_driver = new FirefoxDriver();
		_driver.get(URL);
		Helper.takeScreenshot("OpenURL");
	}
	
	public static void openURL(String URL) throws IOException {
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		_driver = new ChromeDriver();
		_driver.manage().window().maximize();
		_driver.get(URL);
		Helper.takeScreenshot("OpenURL");
	}
	


	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return _driver;
	}

}

