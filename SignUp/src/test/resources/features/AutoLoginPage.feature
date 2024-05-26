
Feature: Storyful Signup Page Feature

#@manju
  Scenario: User Registration with valid credentials
    Given user is on signup page
    And user clicks on accept cookies
    When user enters first name "Manjunath" 
    And user enters last name "Jnanadev"
    And user enters email "manjunathj.026@gmail.com"
    And user enters password "Kavana@1726"
    And user clicks terms and conditions check box
    And user clicks reCAPTCHA check box
    Then user should be signed in successfully
    
  Scenario: User Registration with invalid email
  	Given user is on signup page
  	And user clicks on accept cookies
    When user enters first name "Manjunath" 
    And user enters last name "Jnanadev"
    And user enters email "abc.gmail.com "
    And user enters password "Kavana@1726"
    And user clicks terms and conditions check box
    Then user should see the error message "Invalid email address format"
 #@manju   
  	Scenario: User leaves first name field empty
  	Given user is on signup page
  	And user clicks on accept cookies
    When user enters first name "" 
    And user enters last name "Jnanadev"
    And user enters email "abc.gmail.com "
    And user enters password "Kavana@1726"
    And user clicks terms and conditions check box
    Then user should see the sign up button disabled
  #@manju  
    Scenario: User leaves last name field empty
  	Given user is on signup page
  	And user clicks on accept cookies
    When user enters first name "Manjunath" 
    And user enters last name ""
    And user enters email "abc.gmail.com "
    And user enters password "Kavana@1726"
    And user clicks terms and conditions check box
    Then user should see the sign up button disabled
 
  	Scenario: User navigates to sign in page
		Given user is on signup page
		And user clicks on accept cookies
	  When user clicks on sign in button
	  Then user navigates to sign in page
    
 		Scenario Outline: User Registration with invalid password
		Given user is on signup page
		And user clicks on accept cookies
		When user enters first name "Manjunath" 
	  And user enters last name "Jnanadev"
	  And user enters email "manjunathj.026@gmail.com"
	  And user enters password "<password>"
	  Then the password "<passwordCriteria>" criteria should be gray
	  
	  Examples: 
	  
	  | password | passwordCriteria  |
	  | James@abc | 1 number |
	  | james@123 | 1 uppercase character |
	  | JAMES@123 | 1 lowercase character |
	  | James@2| 8 characters long |
	  | James1234 | 1 special character |
  