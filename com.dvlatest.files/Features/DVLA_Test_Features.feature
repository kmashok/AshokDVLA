Feature: Test

Scenario Outline: Generate Vedhicle Data file
	Given User creates a folder structure <folderPath>
	Then User reads the contents of the file <folderPath>
Examples:
|folderPath|
|C:\\ConfigureTest|

Scenario Outline: User verifies Car Details using the generated Car File
	Given User creates a folder structure <folderPath>
	Then User reads the contents of the file <folderPath>
	Then User should then be able to verify Car details <folderPath>
Examples:
|folderPath|
|C:\\ConfigureTest|

Scenario Outline: Obtain File Type, File MIME types
	Given User creates a folder structure <folderPath>
	Then Display File types and MIME types for all Files in <folderPath>
	Then User reads the contents of the file <folderPath>
Examples:
|folderPath|
|C:\\ConfigureTest|




	