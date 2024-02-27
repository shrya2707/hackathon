
Feature: PolicyBazaar.com 

 
  Scenario: Travel Insurance
    Given user is present on policybazaar.com
    When user clicks on travel insurance option from all the options available on the main page
    And user enters the country 
    And user selects the start date and end date of the trip
    And user enters the number of Students traveling along with their age
    And user enters pre-existing medical condition if any
    And user enters mobile number and clicks on submit button
    Then user is navigated to results page
    When user selects student plan from the filter options 
    Then Student Travel Information slider page is opened
    When user selects the Student Visa for both the student travellers
    And user enters the duration of the trip and clicks on apply changes 
    And user selects premium low to high filter from sort by dropdown
    Then insurance plans are displayed and top3 cheapest plan names along with their is captured
    And user is navigated to main page
    
    
   Scenario: Car Insurance
    Given user is present on policybazaar.com
    When user clicks on car insurance option from all the options available on the main page
    When user clicks on buying a new car option 
    And user selects the city and car number
    And user selects the car brand 
    And user selects the car model type and other features
    And user fills the personal details with invalid email
    Then invalid email error is shown
    And user is navigated to main policybazaar page
    
   Scenario: Health Insurance
    Given user is present on policybazaar.com
    When user hovers over the insurance plans on main page
    And finds health insurance option from the list
    Then all the options under health insurance are displayed
    
     
  
    

  
    
