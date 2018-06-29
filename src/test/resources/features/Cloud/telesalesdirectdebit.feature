@Regression_Cloud @TeleDirectDebit_Cloud
Feature: Telesales_User wishes to log into the system
  Test feature for Tele sales user wishes to log into the system without any errors into PPC


  Scenario: bl01_01_LoginSuccessful 
   	Given I open the homepage
    When I log into the system 
    Then I verify the url for landing page
        
    
  Scenario Outline: bl02_01_PerformValidSearch1Result 
  	Given I open the homepage
 	When I send cert num '<cert_number>' and click submit
    Then I am redirected to "search cert number results" page
    And I verify certificate number '<cert_number>' on search results page
    #And I check that it is correct certificate as '<cert_number>' on search results page
    And I should list several entries for this number as '<cert_number>' and '<expectedCount>'
    
    Examples:
	|cert_number 	|expectedCount	|
	|10000000003	|1				|

    
   Scenario Outline: bl02_04_PerformValidSearchMultipleResults 
   	Given I open the homepage
	When I send cert num '<cert_number>' and click submit
    Then I am redirected to "search cert number results" page
    And I verify certificate number '<cert_number>' on search results page
    And I should list several entries for this number as '<cert_number>' and '<expectedCount>'
    
    Examples:
	|cert_number 	|expectedCount	|
	|10000000641	|3				|
   
	
Scenario Outline: bl03_01_PerformValidSearch1Result1 
	Given I open the homepage
    When I send cert num '<cert_number>' and click submit
    Then I am redirected to "search cert number results" page
    And I verify certificate number '<cert_number>' on search results page
    And I click certificate number '<cert_number>' on search results page
    Then I check that it is correct certificate as '<cert_number>' on certificate details page
    And I check that it is correct certificate status as '<certStatus>'
    And I check that it is correct ddref as '<DDRef>'
    Then I check that it is correct due date as '<DDDue>'
    And I check that it is correct payment type as '<paymentType>'
    And I check that it is correct payment amount as '<paymentAmount>'   
	And I check that it is correct payment status as '<paymentStatus>'
	And I check that it is correct cost as '<cost>'
	Then I check total is empty
	And I check that it is correct outstanding balance as '<outstandingBalance>'
	And I check that it is correct surname as '<surname>'
	And I check that it is correct address line1 as '<addressline1>'
	And I check that it is correct notes as '<notes>'

    Examples:
	|cert_number 	|DDRef		|certStatus						 		|DDDue	    |paymentType	|paymentAmount	|paymentStatus						|cost	|outstandingBalance	|surname	|addressline1	|notes						|
	|10000000691	|DD10000060 |Certificate awaiting production Change |19			|Direct Debit	|£0.00			|Awaiting authorisation				|104.00	|£104.00			|Richard	|25				|testing new application	|
	
	
	Scenario Outline: bl02_05_PerformInValidSearchNoNumber 
   Given I open the homepage
    When I send cert num '<cert_number>' and click submit
    Then I am redirected to "search cert number results" page
    And I check that search error is present as '<error_message>'
    
    Examples:
	|cert_number 	|error_message												|
	|10000003003	|No exemptions were found for the specified search criteria |
	
	
	Scenario Outline: bl03_02_PerformValidSearch1Result2 
	Given I open the homepage
    When I send cert num '<cert_number>' and click submit
    Then I am redirected to "search cert number results" page
    And I verify certificate number '<cert_number>' on search results page
    And I click certificate number '<cert_number>' on search results page
    Then I check that it is correct certificate as '<cert_number>' on certificate details page
    And I check that it is correct certificate status as '<certStatus>'
    And I check that it is correct payment type as '<paymentType>'
    And I check that it is correct payment amount as '<paymentAmount>'   
	And I check that it is correct payment status as '<paymentStatus>'
	Then I check that it is correct cost as '<cost>'
	And I check that it is correct total as '<total>'
	And I check that it is correct surname as '<surname>'
	And I check that it is correct address line1 as '<addressline1>'
	And I check that it is correct notes as '<notes>'

    Examples:
	|cert_number 	|certStatus								|paymentType	|paymentAmount	|paymentStatus		|cost	|total		|surname	|addressline1	|notes		|
	|10000000693	|Certificate awaiting production Change	|Cheque Payment	|£104.00		|Awaiting banking	|104.00	|£104.00	|Richie		|53				|new test 	|

  Scenario Outline: bl04_01_PerformValidSearchUsingDDRef1 
  	Given I open the homepage
 	Then I click the button "submit" 
   	When I send dd ref '<DDRef>' and click submit
    And I verify certificate number '<cert_number>' on search results page
    
    Examples:
   	|DDRef 		|cert_number|
  	|DD10000060	|10000000691|
    
  Scenario Outline: bl04_01_PerformValidSearchUsingDDRef2 
  	Given I open the homepage
 	Then I click the button "submit" 
   	When I send dd ref '<DDRef>' and click submit
    And I verify certificate number '<cert_number>' on search results page
    
    Examples:
    |DDRef 		|cert_number|
    |DD10000061	|10000000692|
    
    
  Scenario Outline: bl06_01_NewApplicant   
   	Given I open the homepage
    When I send cert num '<cert_number>' and click submit
    Then I am redirected to "search cert number results" page
    And I verify certificate number '<cert_number>' on search results page
    And I click certificate number '<cert_number>' on search results page
	When I click new application on page certificate details
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
	And I click submit button for page Direct Debit confirmation
	Then I am redirected to "confirm Direct Debit" page
	And I get new certificate number
	
	Examples:
	|cert_number|sort code 	|account number |
	|10000000694|302556		|32029501		|
	
    
  Scenario Outline: bl05_01_PerformValidSearchUsingSurnameDOB1 
  	Given I open the homepage
 	Then I click the button "submit" 
 	When I send surname '<surname>' and dob '<dob>' and click submit
	And I verify certificate number '<cert_number>' on search results page
    
    Examples:
    |surname 	|cert_number|dob	|
    |Julia		|10000000692|010180	|
    
    
  Scenario Outline: bl05_01_PerformValidSearchUsingSurnameDOB2 
    Given I open the homepage
 	Then I click the button "submit" 
 	When I send surname '<surname>' and dob '<dob>' and click submit
	And I verify certificate number '<cert_number>' on search results page
    
    Examples:
    |surname 	|cert_number	|dob	|
    |Richard	|10000000691	|010180	|
    
    
	
	
#  	 	# ############# Due Date functionality not working at the moment 28th June 2017 ##############
#   		# ############# Need fixing ##############
##  Scenario Outline: bl08_01AmendDDDueDate 
##   	Given I open the homepage
##  	When I enter '<username>' and '<password>'
## 	And I click the button "login" 
## 	Then I click the button "submit" 
## 	When I send cert num '<cert_number>' and click submit
##    Then I am redirected to "search cert number results" page
##    And I verify certificate number '<cert_number>' on search results page
##    And I click certificate number '<cert_number>' on search results page
##    Then I check that it is correct certificate as '<cert_number>' on certificate details page
##    Then I click Edit button for due date
##    And I edit direct debit due date by '<days>' days
##    And I verify Edit button error present
##    Examples:
##	|cert_number 	|days	|
##	|20000007220	|	1	|
	
 