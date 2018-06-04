package com.dvlatest.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;


public class ConfirmVehiclePage {
	private By _make = By.xpath("//li[2]/span[2]/strong");
	private By _color = By.xpath("//li[3]/span[2]/strong");
	private By _title = By.xpath("//h1[contains(.,'Is this the vehicle')]");
	
	public void verifyCarDetails(String make, String color) throws IOException {
		Label.verifyLabelText(this._make, make);
		Label.verifyLabelText(this._color, color);
		
		
	}
	
	public By getTitleObject() {
		return this._title;
	}	
}

