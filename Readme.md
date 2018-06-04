1. Clone the Repository using the URL

2. Maven Project Name: com.dvlatest.files

3. As a pre-requisite, please have a look into the Specflow feature file (Features\DVLA_Test_Features.feature) and edit the folder path as required under Scenario->Examples section.
Please note: if this folder structure do not exist, then it will be automatically be created by the Scenario.
For example, the test folder structure currently used in Examples section of feature file is: C:\ConfigureTest

3. Run Maven Clean and Maven Test on POM.xml file of the project

4. Following 3 Scenarios will be executed:
  a. Generate Vedhicle Data file.
      This scenario creates all the folder structures with varios files and types.
      Creates a vehicle data file - CarVehicleRegistrationDetails.txt inside C:\ConfigureTest.
      
  b. User verifies Car Details using the generated Car File.
      This scenario logs into dvla web site, reads the file CarVehicleRegistrationDetails.txt.  This will be the expected result.
      Verifies car details for a car using the data in the file and returns pass if assertion match.
      Screenshots of the DVLA related Selenium test are captured and added automatically under project/Screenshots folder as evidence.
  
  c. Output about file types/mime types is output to the console.
      This scenario scans through the folder structure C:\ConfigureTest and returns the File Types, MIME types, folder path, etc.
      Output about file types/mime types is output to the console.
  
5. Screenshots of the DVLA related Selenium test are captured and added automatically under project/Screenshots folder as evidence. Output about file types/mime types is output to the console.