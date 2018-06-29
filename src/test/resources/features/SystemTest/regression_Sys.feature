@Regression_Sys
Feature: Run BC01_1_UserCanSetup10MonthDirectDebitFor12MonthPPC
  Demo feature for User Can Setup ten Month Direct Debit For twelve Month PPC

### *** RUN TELESALES AUTOMATION RESET SQL - STORED IN THE MATEX/TEST/ PROJECT FOLDER *** ###

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
	And I click "Cancel" 
        
	
  Scenario Outline: Reg02_UserCanCreate3MonthPpcWithDirectDebit
  And I send search details and click submit
  Then I am redirected to "search results" page   
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details with title others as '<otherTitle>'
	And I set Direct Debit as payment type 
	Then I click applicant details Valid Account submit
	Then I am redirected to "direct debit payment details" page
	And I send valid account details
	And I click "Cancel"

	Examples:
	|otherTitle|
	|Lt Cdr|


  Scenario: Reg03_UserCanCreate3MonthPpcWithCheque
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
	And I click "Cancel"

	
  Scenario: Reg04_UserCanCreate12MonthPpcWithCreditOrDebitCard
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
	And I click "Cancel"


  Scenario Outline: Reg05_UserCanCreate12MonthPpcWithDirectDebit
  And I send search details and click submit
  Then I am redirected to "search results" page   
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details with title others as '<otherTitle>'
	And I set Direct Debit as payment type 
	Then I click applicant details Valid Account submit
	Then I am redirected to "direct debit payment details" page
	And I send valid account details
	And I click "Cancel"

	Examples:
	|otherTitle	|
	|Mr			    |


  Scenario: Reg06_UserCanCreate12MonthPpcWithCheque
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
	And I click "Cancel"
	
	Scenario Outline: Reg07_CreateChequeRefund
	#Given I open the homepage
	When I send cert num '<cert_number>' and click submit
  Then I am redirected to "search cert number results" page
  And I verify certificate number '<cert_number>' on search results page
  And I click certificate number '<cert_number>' on search results page
  And I create a new payment
  And I send payment amount '<payment_amount>'
  And I click the add payment to issue cheque refund
  #And I check that it is correct total as '<total>'
	And I click "Cancel Button"
	
 	Examples:
 	|cert_number | payment_amount | total   |
 	|20000018321 | 10.40					| 93.40   |


@Validation	
  Scenario Outline: Val01_UserDoesNotEnterAnySearchCriteria
	Then I click the button "submit" 
  When I click "Submit"
  Then I will get error message as '<error_msg1>' with '<error_msg1_id>'
  And I will get error message as '<error_msg2>' with '<error_msg2_id>'
  And I will get error message as '<error_msg3>' with '<error_msg3_id>'
  And I will get error message as '<error_msg4>' with '<error_msg4_id>'
  And I will get error message as '<error_msg5>' with '<error_msg5_id>'
  And I click "Cancel"
    
  Examples:
  |error_msg1				    	|error_msg1_id						          |error_msg2			      	|error_msg2_id						          |error_msg3		      	  		|error_msg3_id				      		    |error_msg4				         	|error_msg4_id		           				|error_msg5				         	|error_msg5_id		           				|
  |Certificate number 		|.//*[@id='pageErrors']/li/ul/li[1]	|Direct Debit reference	|.//*[@id='pageErrors']/li/ul/li[2]	|Surname and Date of Birth	|.//*[@id='pageErrors']/li/ul/li[3]	|NHS Number                 |//*[@id="pageErrors"]/li/ul/li[4]  |Email Address							|//*[@id="pageErrors"]/li/ul/li[5]  | 					
	

@Validation
  Scenario Outline: Val02_UserEntersANonEnglishPostcode
	When I click the button "submit"
	And I send search with non england postcode details
	Then I will get error message as '<error_msg1>' with '<error_msg1_id>'
	And I click "Cancel"


 	Examples:
 	|cert_number |error_msg1							             	|error_msg1_id				      |
 	|10000000003 |Warning - Postcode is not in England	|.//*[@id='pageErrors']/li	|
 

@Validation
  Scenario: Val03_UserEntersAnInvalidAccountNumber
  When I click the button "submit"
  And I send search details and click submit
	Then I click new application
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	And I click cancel button

