package runner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.dvla.filehandling.ServiceLibrary;
import com.dvla.fileapplication.ServiceLibraryFileApplication;

//import com.dvlatest.automation.ServiceLibrary;
//import com.dvlatest.automationLibrary.ServiceLibraryApplication;

import com.dvlatest.pageobjects.Browser;
import com.dvlatest.pageobjects.ConfirmVehiclePage;
import com.dvlatest.pageobjects.EnterRegistrationPage;
import com.dvlatest.pageobjects.StartPage;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;


//@RunWith(SpringRunner.class)
@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue={"stepDefinition"})
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest(classes = ServiceLibraryFileApplication.class)
public class ServiceLibraryIntegrationTests {

    @Autowired
    ServiceLibrary library;
    
    @Test
    public void testing() {
    	
    	System.out.println("WELCOME TO SPRING !!!! ");
    	

    }
    
    
}


