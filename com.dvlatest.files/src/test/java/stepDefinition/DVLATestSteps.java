package stepDefinition;

//import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.CommandExecutor;
//import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import com.dvla.filehandling.ServiceLibrary;
import com.dvlatest.pageobjects.Browser;
import com.dvlatest.pageobjects.ConfirmVehiclePage;
//import com.dvlatest.automationLibrary.ServiceLibraryApplication;
import com.dvlatest.pageobjects.EnterRegistrationPage;
import com.dvlatest.pageobjects.StartPage;

public class DVLATestSteps {
    @Autowired
    ServiceLibrary library;
    
	WebDriver driver;
	String actRegNum="";
	String actMake="";
	String actColour="";
	String editBox = "//*[@id='Vrm']";
	//String editBox = "button[@name='Continue']//../div/input";
	String regNumValueElem = "//*[@id='pr3']/div/ul/li[1]/span[2]";
	String makeValueElem = "//*[@id='pr3']/div/ul/li[2]/span[2]/strong";
	String colourValueElem = "//*[@id='pr3']/div/ul/li[3]/span[2]/strong";
	//"//ul/li/span[@class='reg-mark']
//	"///li/span[.='Make']/following-sibling::span/strong"
//	"//li/span[.='Colour']/following-sibling::span/strong"
	
	@Given("^Open firefox and start application$")
	public void open_firefox_and_start_application() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","src/test/resources/geckodriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
		
		driver.findElement(By.xpath("//*[@id='get-started']/a[.='Start now']")).click();
		Thread.sleep(5000);
		

		driver.findElement(By.xpath(editBox)).isDisplayed();
		driver.findElement(By.xpath(editBox)).click();
		driver.findElement(By.xpath(editBox)).clear();
		driver.findElement(By.xpath(editBox)).sendKeys("RX15 TWE");
		driver.findElement(By.xpath("//button[.='Continue']")).click();
		
		actRegNum = driver.findElement(By.xpath(regNumValueElem)).getText();
		actMake = driver.findElement(By.xpath(makeValueElem)).getText();
		actColour = driver.findElement(By.xpath(colourValueElem)).getText();
		
		System.out.println(actRegNum);
		System.out.println(actMake);
		System.out.println(actColour);
		
		actRegNum.equals("RX15 TWE");
		actMake.equals("MERCEDES-BENZ");
		actColour.equals("SILVER");

		driver.close();

//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
		
		//URL seleniumServerUrl = new URL("http://localhost:4444");
		//URL serverUnderTest = new URL("http://www.google.com");
		//CommandExecutor executor = new SeleneseCommandExecutor(seleniumServerUrl, serverUnderTest, DesiredCapabilities.chrome());
		//WebDriver driver = new RemoteWebDriver(executor);
	}

	@When("^I enter valid \"(.*?)\" and valid \"(.*?)\"$")
	public void i_enter_valid_and_valid(String arg1, String arg2) throws Throwable {
		
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {

	}
	
	@Given("^user enters car registration number '(.*)'$")
	public void user_enters_car_registration_number(String registration) throws Throwable {
		StartPage startPage = new StartPage();
		EnterRegistrationPage enterReg = new EnterRegistrationPage();
		
		//Browser browser = new Browser();
		Browser.openURL("https://www.gov.uk/get-vehicle-information-from-dvla");
		startPage.navigateToEnterRegPage();
		enterReg.enterRegistration(registration);
	}

	@When("^he clicks Continue button$")
	public void he_clicks_Continue_button() throws Throwable {
		EnterRegistrationPage enterReg = new EnterRegistrationPage();
		enterReg.clickContinue();
		Thread.sleep(15000);
	}

	@Then("^he should see car make '(.*)' and colour '(.*)'$")
	public void he_should_see_car_make_and_model(String make, String color) throws Throwable {
		ConfirmVehiclePage confirmVehicle = new ConfirmVehiclePage();
		Thread.sleep(15000);
		confirmVehicle.verifyCarDetails(make, color);
		
		
	}
	
	//*********************************
	@Given("^User creates a folder structure (.*)$")
	public void user_creates_a_folder_structure (String folPath) throws Throwable {
		//generate folders and files
		ServiceLibrary.createFolderStructure(folPath);
		//ServiceLibrary.listFilesAndFilesSubDirectories(folPath);
	}

	@Then("^User reads the contents of the file (.*)$")
	public void user_reads_the_contents_of_the_file (String folPath) throws Throwable {
	    //ServiceLibrary.getFileExtension("C:\\ConfigureTest\\CarVehicleRegistrationDetails.txt");
		String carDetail1 = ServiceLibrary.returnArrayOfCars(folPath + "\\CarVehicleRegistrationDetails.txt", 1);
		String carDetail2 = ServiceLibrary.returnArrayOfCars(folPath + "\\CarVehicleRegistrationDetails.txt", 2);
		System.out.println("CAR 1 = " + carDetail1);
		System.out.println("CAR 2 = " + carDetail2);
	}
		
		
	@Then("^User should then be able to verify Car details (.*)$")
	public void user_should_then_be_able_to_verify_Car_details (String folPath) throws Throwable {
		//generate folders and files
		user_creates_a_folder_structure (folPath);
		//ServiceLibrary.listFilesAndFilesSubDirectories(folPath);
		
		//obtain data from generated file
		String carNum = ServiceLibrary.returnArrayOfCars(folPath + "\\CarVehicleRegistrationDetails.txt", 1);
		String[] carArray = carNum.split(",");
		
		String registration = carArray[0];
		user_enters_car_registration_number(registration);
		
		he_clicks_Continue_button();
		
		String make = carArray[1];
		String color = carArray[9];
		
		ConfirmVehiclePage confirmVehicle = new ConfirmVehiclePage();
		Thread.sleep(15000);
		confirmVehicle.verifyCarDetails(make, color);
	}
	
	@Then("^Display File types and MIME types for all Files in (.*)$")
	public void display_File_types_and_MIME_types_for_all_Files_in (String folPath) throws Throwable {
		ServiceLibrary.listFilesAndFilesSubDirectories(folPath);
	}
	
	@Then("^he should then be able to verify Car details2'$")
	public void he_should_then_be_able_to_verify_Car_details2() throws Throwable {
		ConfirmVehiclePage confirmVehicle = new ConfirmVehiclePage();
		Thread.sleep(15000);
		
		//generate folders and files
		ServiceLibrary.listFilesAndFilesSubDirectories("C:\\ConfigureTest");
		
		//obtain data from generated file
		
		
		String make = "merc";
		String color = "silver";
		confirmVehicle.verifyCarDetails(make, color);
		
		
	}

}
