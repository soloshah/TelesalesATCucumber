@TeleDirectDebit_Sys
Feature: Run BC01_1_UserCanSetup10MonthDirectDebitFor12MonthPPC
  Demo feature for User Can Setup ten Month Direct Debit For twelve Month PPC

### *** RUN TELESALES AUTOMATION RESET SQL - STORED IN THE MATEX/TEST/ PROJECT FOLDER *** ###

  Scenario Outline: Check Red message displayed wheen nothing is entered on the DDRef search page
	Given I open the homepage
	Then I click the button "submit" 
 	And I will get error message as '<error_msg1>' with '<error_msg1_id>'
 	And I will get error message as '<error_msg2>' with '<error_msg2_id>'
 	And I will get error message as '<error_msg3>' with '<error_msg3_id>'
 	And I will get error message as '<error_msg4>' with '<error_msg4_id>'
 	And I will get error message as '<error_msg5>' with '<error_msg5_id>'
    
  Examples:
  | certNum 		|error_msg1				    	|error_msg1_id						          |error_msg2			       	|error_msg2_id			            		|error_msg3				         	|error_msg3_id		           				|error_msg4				         	|error_msg4_id		           				|error_msg5				         	|error_msg5_id		           				|
  | 10000000621	|Certificate number 		|.//*[@id='pageErrors']/li/ul/li[1]	|Direct Debit reference	|.//*[@id='pageErrors']/li/ul/li[2]	|Surname and Date of Birth	|.//*[@id='pageErrors']/li/ul/li[3]	|NHS Number                 |//*[@id="pageErrors"]/li/ul/li[4]  |Email Address							|//*[@id="pageErrors"]/li/ul/li[5]  | 					
    

  Scenario Outline: BC01_1 User Can Setup 10Month DirectDebit For 12Month PPC
  And I send search details and click submit
 	Then I am redirected to "search results" page   
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details LLoyds Account submit
	Then I am redirected to "direct debit payment details" page
	When I send LLoyds account details
	And I send account holder name
	And I send certificate start date
	And I wait for page to load
	Then I check correct bank name as "LLOYDS BANK PLC"
	And I check correct bank address as "RETAIL LIVE & USABILITY"
	When I click submit for direct debit details
	Then I check correct sort code as '<sort code>'
	And I check correct account number as '<account number>'
	And I click cancel button
	
	Examples:
	|sort code 	|account number |
	|302556		  |32029501		    |
	    
	
  Scenario Outline: BC01_2 User Can Setup 10Month DirectDebit For 12Month PPC
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details RBS Account submit
	Then I am redirected to "direct debit payment details" page
	When I send RBS account details
	And I send account holder name
	And I send certificate start date
	And I wait for page to load
	Then I check correct bank name as "THE ROYAL BANK OF SCOTLAND"
	And I check correct bank address as "SALE"
	When I click submit for direct debit details
	Then I check correct sort code as '<sort code>'
	And I check correct account number as '<account number>'
	And I click cancel button
	
	Examples:
	|sort code 	|account number |
	|163032		  |10050518		    |


  Scenario Outline: BC01_3 User Can Setup 10Month DirectDebit For 12Month PPC
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details Natwest Account submit
	Then I am redirected to "direct debit payment details" page
	When I send Natwest account details
	And I send account holder name
	And I send certificate start date
	And I wait for page to load
	Then I check correct bank name as "NATIONAL WESTMINSTER BANK"
	And I check correct bank address as "STRAND, LONDON"
	When I click submit for direct debit details
	Then I check correct sort code as '<sort code>'
	And I check correct account number as '<account number>'
	And I click cancel button
	
	Examples:
	|sort code 	|account number |
	|604005		  |24605999    		|
	
 
  Scenario Outline: BC01_4 Not Direct Credit
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details Halifax Account submit
	Then I am redirected to "direct debit payment details" page
	When I send Halifax account details
	And I send account holder name
	And I send certificate start date
	And I wait for page to load
	Then I check correct bank name as "HALIFAX (A TRADING NAME OF"
	And I check correct bank address as "BANKING ARREARS (AGENTS)"
	When I click submit for direct debit details
	Then I check correct sort code as '<sort code>'
	And I check correct account number as '<account number>'
	And I click cancel button
	
	Examples:
	|sort code 	|account number |
	|111545		  |00000003		    |

 
  Scenario Outline: BC02_1 User Forgets To Enter Sort Code
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	Then I am redirected to "direct debit payment details" page
	And I clear account details
	When I send no sort code account details
	And I wait for page to load
	Then I check server error '<server_error>'
	And I click cancel button
	
	Examples:
	| server_error 																		                                |
	| The server encountered an error whilst attempting to validate the bank account	|

	
  Scenario: BC02_4 User Enters An Invalid Sort Code
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	Then I am redirected to "direct debit payment details" page
	And I clear account details
	When I send invalid account details
	And I wait for page to load
	Then I check account error as Sort Code not recognised
	And I click cancel button
	
	
	Scenario: BC02_5 User Enters An Invalid Sort Code
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	Then I am redirected to "direct debit payment details" page
	And I clear account details
	When I send part completed sort code valid account details
	And I wait for page to load
	Then I check account error as Sort Code not number
	And I click cancel button
	

  Scenario: BC02_6 User Enters An Invalid Sort Code
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	Then I am redirected to "direct debit payment details" page
	And I clear account details
	When I send part char sort code account details
	And I wait for page to load
	Then I check account error as Sort Code not number
	And I click cancel button


  Scenario: BC03_1 User Enters An Invalid Account Number
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	Then I am redirected to "direct debit payment details" page
	And I clear account details
	When I send account eight characters details
	And I wait for page to load
	Then I check account error as invalid account number
	And I click cancel button


  Scenario: BC03_2 User Enters An Invalid Account Number
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	Then I am redirected to "direct debit payment details" page
	And I clear account details
	When I send account five characters details
	And I wait for page to load
	Then I check account error as account number short
	And I click cancel button


  Scenario: BC03_2 User Enters An Invalid Account Number
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	Then I am redirected to "direct debit payment details" page
	And I clear account details
	When I send account five characters details
	And I wait for page to load
	Then I check account error as account number short
	And I click cancel button


  Scenario: BC03_4 User Enters An Invalid Account Number
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	Then I am redirected to "direct debit payment details" page
	And I clear account details
	When I send account all characters details
	And I wait for page to load
	Then I check account error as account number not numeric
	And I click cancel button


  Scenario: BC04_1 User Can Setup 10Month Direct Debit For 12Month PPC Not DD Card
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	Then I am redirected to "direct debit payment details" page
	And I clear account details
	When I send account does not accept direct debit
	And I wait for page to load
	Then I check account error as non DD account
	And I click cancel button


  Scenario: BC06_1 User Enters Valid Sort Invalid Account
  And I send search details and click submit
  Then I am redirected to "search results" page 
	When I click new application
	Then I am redirected to "applicant details" page
	And I send applicant details
	And I set Direct Debit as payment type 
	Then I click applicant details submit
	Then I am redirected to "direct debit payment details" page
	And I clear account details
	When I send account as not linked account details
	And I wait for page to load
	Then I check account error as not linked and invalid account
	And I click cancel button

	
#### This may timeout if it takes longer then 60 seconds   
  Scenario Outline: bl08_01AmendDDDueDateWithValidDate
  #Given I open the homepage
  When I send cert num '<cert_number>' and click submit
  Then I am redirected to "search cert number results" page
  And I verify certificate number '<cert_number>' on search results page
  And I click certificate number '<cert_number>' on search results page
  Then I check that it is correct certificate as '<cert_number>' on certificate details page
  Then I click Edit button for due date
  And I edit direct debit due date by '<days>' days
  Then I submit new direct debit details
  Then I check that it is correct due date as '<duedate>'
  Then I click "Cancel Button"

  Examples:
	|cert_number 	  |days	 | duedate |
	|20000013472	  |-5	   | 20		   |
  	
  	
  Scenario Outline: bl08_01AmendDDDueDayWithInvalidDate 
  When I send cert num '<cert_number>' and click submit
  Then I am redirected to "search cert number results" page
  And I verify certificate number '<cert_number>' on search results page
  And I click certificate number '<cert_number>' on search results page
  Then I check that it is correct certificate as '<cert_number>' on certificate details page
  Then I click Edit button for due date
  And I edit direct debit due date by '<days>' days
  And I verify error message is displayed as '<duedayerror>'
  Then I click back button for payment card details
  
  Examples:
	|cert_number 	  |days	  | duedayerror 																			|
	|20000007220 	  |	-15	  | Due day cannot be within 12 working days of today |
	