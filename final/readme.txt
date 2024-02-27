*****************************************************PROJECT DESCRIPTION*****************************************************************

Problem Statement : Find travel insurance plan for students
1. display three lowest international  travel insurance plan with amount and insurance provider company
2. Group of  2 student people (Age 22,21)
3. For any European country
(WebSite: policyBazaar.com)

  
Detailed Description: Hackathon Project

1. Find travel insurance plan for students, for 2 people (Age 22 & 21) & any European country, fill further dummy details & display three lowest international  travel insurance plan with amount and insurance provider company
2. Get a Car Insurance quote, proceed without  car number, keep filling details, give invalid email or phone number & capture the error message
3. Retrieve all Health Insurance menu items and store in a List; Display the same

Key Automation Scope:

Capturing the screenshot
Generating logs
Reading values from excel and configuration file
Printing all the values in console and excel sheet
Generating extent report and cucumber report


**********************************************************STEPS TO EXECUTE*************************************************************

-unzip the folder
-On eclipse, goto file->import->select the maven->click on existing maven project->next->browse the location where u unzip the folder-> click on finish
-Now go to the TestNG.xml file and run as TestNGSuite.
-Or to run it in junit, go to stepRunner package under src/test/java 
-Now the file will Execute and we get the expected output as shown below.

*******************************************************FILES DESCRIPTION**************************************************************

1.src/test/java - There are Four packages present in this folder.
-> base:This includes the baseClass which contains driver Setup , dataDriven class which has the methods to read and write data and screenshot class which will generate screenshot at every step.  
    
-> pageObject:In this package we have page object classes for the travel insurance page, travel insurance result page, car insurance page,health insurance page.
     
-> stepDefinition:In this package we have step definition class for the validation of all the page object classes and hooks class .

-> stepRunner: Includes the class responsible for running the feature file along with stepDefinition package and create the extent report and cucumber reports.


2.src/test/resources- In this folder, we have
-> configuration file :which includes the browser setup, URL and other user details.

-> extent properties file :which includes the location where the extent report is to be generated

-> log4j2 xml file :responsible for creating logs 

-> policyBazaar xlsx file :file from where the data is read and written

3.JRE System Library: In this File we have all dependencies of JAR.files.         

4.Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. when a Maven build is executed,
Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.

5.FeatureFile folder: contains the feature file of the cucumber

6.logs folder : where the logs will be generated

7.Report: In this folder the Report.html is present which is the cucumber report of the project

8.screenshot folder: where the screenshots will be generated

9.target: It will contain rerun text file which will contain failed test cases

10.test-output: It will contain extent report.
 
11.pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies,
build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes the goal.

 
***************************************************************************************************************************************

                                                        OUTPUT ON CONSOLE

***************************************************************************************************************************************
Top 3 travel insurance companies:
Reliance
Bajaj Allianz
Care Health

Top 3 travel insurance company plan names and price:
Student Silver :₹2,788
Student Elite :₹2,874
Student Explore Plus :₹3,484

****************************************************************************************************************************************
Error :Please enter a valid e-mail ID.

****************************************************************************************************************************************
Health Insurance Options:
Family Health Insurance
Senior Citizen Health Insurance
Health Insurance for Parents
Best Health Insurance Plans
Maternity Insurance
Health Insurance Portability
Mediclaim Policy
Critical Illness Insurance
Health Insurance Calculator
Health Insurance Companies
Health Insurance for NRIs
Health Insurance Claim
===============================================
PASSED: runScenario("Car Insurance", "PolicyBazaar.com")
        Runs Cucumber Scenarios
PASSED: runScenario("Travel Insurance", "PolicyBazaar.com")
        Runs Cucumber Scenarios
PASSED: runScenario("Health Insurance", "PolicyBazaar.com")
        Runs Cucumber Scenarios

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================

