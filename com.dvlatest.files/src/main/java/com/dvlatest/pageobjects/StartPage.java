package com.dvlatest.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;

import com.dvlatest.pageobjects.Button;
import com.dvlatest.pageobjects.Label;

public class StartPage {
	private By _start = By.xpath("//a[contains(.,'Start now')]");
	
	public void navigateToEnterRegPage() throws IOException, Exception {
		
		Button.click(this._start);
		
		EnterRegistrationPage enterReg = new EnterRegistrationPage();
		
		Thread.sleep(15000);
		
		Label.verifyLabelText(enterReg.getTitleObject(), "Enter the registration number");
	}
}
