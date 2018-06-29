@Regression_Cloud
Feature: Run Regression_User Can Setup 10Month DirectDebit For 12 Month PPC
  

  Scenario: Reg01_UserCanCreate3MonthPpcWithCreditOrDebitCard
  	Given I open the homepage
	Then I click the button "submit" 
    And I send search details and click submit
    Then I am redirected to "search results" page   
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Credit Debit card as payment type 
	Then I click applicant details submit
	And I am redirected to "credit debit payment details" page
	Then I send certificate duration for three months
	And I send certificate start date as current date
	When I click submit for credit debit details
	Then I am redirected to "check details" page
#	TODO And I click card payment call button 
#	And I click back button for payment card details

        
 Scenario Outline: Reg02_UserCanCreate3MonthPpcWithDirectDebit
 	Given I open the homepage
    And I send search details and click submit
    Then I am redirected to "search results" page   
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details with title others as '<otherTitle>'
	And I set Direct Debit as payment type 
	Then I click applicant details Valid Account submit
	Then I am redirected to "direct debit payment details" page
	And I send valid account details
	And I send account holder name
	And I send certificate start date
	And I wait for page to load
	Then I click submit for direct debit details

	Examples:
	|otherTitle|
	|Lt Cdr|


  Scenario: Reg03_UserCanCreate3MonthPpcWithCheque
   	Given I open the homepage
    And I send search details and click submit
    Then I am redirected to "search results" page   
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Cheque as payment type 
	Then I click applicant details submit
	And I am redirected to "cheque payment details" page
	Then I send certificate duration for three months
	And I send certificate start date as current date
	When I click submit for certificate details
	Then I am redirected to "check details" page

	
  Scenario: Reg04_UserCanCreate12MonthPpcWithCreditOrDebitCard
 	Given I open the homepage 
    And I send search details and click submit
    Then I am redirected to "search results" page   
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Credit Debit card as payment type 
	Then I click applicant details submit
	And I am redirected to "credit debit payment details" page
	Then I send certificate duration for twelve months
	And I send certificate start date as current date
	When I click submit for credit debit details
	Then I am redirected to "check details" page
#	TODO And I click card payment call button 
#	And I click back button for payment card details



 Scenario Outline: Reg05_UserCanCreate12MonthPpcWithDirectDebit
  	Given I open the homepage
    And I send search details and click submit
    Then I am redirected to "search results" page   
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details with title others as '<otherTitle>'
	And I set Direct Debit as payment type 
	Then I click applicant details Valid Account submit
	Then I am redirected to "direct debit payment details" page
	And I send valid account details
	And I send account holder name
	And I send certificate current start date for twelve months
	And I wait for page to load
	Then I click submit for direct debit details

	Examples:
	|otherTitle	|
	|Mr			|


  Scenario: Reg06_UserCanCreate12MonthPpcWithCheque
   	Given I open the homepage
    And I send search details and click submit
    Then I am redirected to "search results" page   
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Cheque as payment type 
	Then I click applicant details submit
	And I am redirected to "cheque payment details" page
	Then I send certificate duration for twelve months
	And I send certificate start date as current date
	When I click submit for certificate details
	Then I am redirected to "check details" page
	
	
@Validation	
  Scenario Outline: Val01_UserDoesNotEnterAnySearchCriteria
   	Given I open the homepage
	Then I click the button "submit" 
    When I click "Submit"
    Then I will get error message as '<error_msg1>' with '<error_msg1_id>'
    And I will get error message as '<error_msg2>' with '<error_msg2_id>'
    And I will get error message as '<error_msg3>' with '<error_msg3_id>'
    
Examples:
    |error_msg1					|error_msg1_id						|error_msg2				|error_msg2_id						|error_msg3					|error_msg3_id						|
    |Certificate number 		|.//*[@id='pageErrors']/li/ul/li[1]	|Direct Debit reference	|.//*[@id='pageErrors']/li/ul/li[2]	|Surname and Date of Birth	|.//*[@id='pageErrors']/li/ul/li[3]	|
	


@Validation
  Scenario Outline: Val02_UserEntersANonEnglishPostcode
  	Given I open the homepage
	When I click the button "submit"
	And I send search with non england postcode details
  	Then I will get error message as '<error_msg1>' with '<error_msg1_id>'

 	Examples:
 	|cert_number|error_msg1								|error_msg1_id				|
 	|10000000003|Warning - Postcode is not in England	|.//*[@id='pageErrors']/li	|
 

@Validation
   Scenario: Val03_UserEntersAnInvalidAccountNumber
    Given I open the homepage
    When I click the button "submit"
    And I send search details and click submit
	Then I click new application
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	And I clear account details
	When I send account eight characters details
	And I wait for page to load
	Then I check account error as invalid account number
	And I click cancel button


