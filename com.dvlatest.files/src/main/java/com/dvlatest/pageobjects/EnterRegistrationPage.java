package com.dvlatest.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;

import com.dvlatest.pageobjects.Button;
import com.dvlatest.pageobjects.Label;
import com.dvlatest.pageobjects.Textbox;

public class EnterRegistrationPage {
	private By _registration = By.xpath("//span[contains(.,'Registration number')]/../../input");
	private By _title = By.xpath("//h1[contains(.,'Enter the registration number')]");
	private By _continue = By.xpath("//button[contains(.,'Continue')]");
	
	public void enterRegistration(String registration) {
		Textbox.typeText(this._registration, registration);
	}
	
	public void clickContinue() throws IOException, Throwable {
		ConfirmVehiclePage confirmVehicle = new ConfirmVehiclePage();
		Button.click(this._continue);
		Thread.sleep(15000);
		Label.verifyLabelText(confirmVehicle.getTitleObject(), "Is this the vehicle you are looking for");
	}
	
	public By getTitleObject() {
		return this._title;
	}
}
