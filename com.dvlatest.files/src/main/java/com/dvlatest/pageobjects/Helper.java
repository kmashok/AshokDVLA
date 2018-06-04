package com.dvlatest.pageobjects;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Helper {
	public static void takeScreenshot(String fileName) throws IOException {
		File scrFile = ((TakesScreenshot)Browser.getDriver()).getScreenshotAs(OutputType.FILE);
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());		
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + fileName + "_" + timeStamp + ".png"));
	}
}

