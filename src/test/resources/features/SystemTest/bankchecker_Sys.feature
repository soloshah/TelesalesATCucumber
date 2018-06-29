@BankChecker_Sys
Feature: Tele sales user wishes to log into the system
  Test feature for Tele sales user wishes to log into the system without any errors into PPC
  
### *** RUN TELESALES AUTOMATION RESET SQL - STORED IN THE MATEX/TEST/ PROJECT FOLDER *** ###

  Scenario: bl01_01_LoginSuccessful 
  Given I open the homepage
  When I log into the system 
  Then I verify the url for landing page
                 
                      
  Scenario Outline: bl02_01_PerformValidSearch1Result 
 	When I send cert num '<cert_number>' and click submit
  Then I am redirected to "search cert number results" page
  And I verify certificate number '<cert_number>' on search results page
  And I should list several entries for this number as '<cert_number>' and '<expectedCount>'
  Then I click back button for payment card details
   
  Examples:
	|cert_number 	|expectedCount	|
	|20000007188	|1			       	|
    
    
  Scenario Outline: bl02_04_PerformValidSearchMultipleResults 
	When I send cert num '<cert_number>' and click submit
  Then I am redirected to "search cert number results" page
  And I verify certificate number '<cert_number>' on search results page
  And I should list several entries for this number as '<cert_number>' and '<expectedCount>'
  Then I click back button for payment card details
   
  Examples:
	|cert_number 	|expectedCount	|
	|20000006926	|14				      |
  
  
  Scenario Outline: bl03_01_PerformValidSearch1Result1 
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
  Then I click "Cancel Button" 

  Examples:
	|cert_number 	|DDRef	  	|certStatus				              		 		|DDDue	|paymentType	|paymentAmount	|paymentStatus					        	|cost	  |outstandingBalance	|surname	|addressline1	|notes												                      |
	|20000007188	|DD11458435 |Certificate awaiting production Change |28			|Direct Debit	|£0.00			    |Direct Debit Instruction lodged	|104.00	|£104.00			      |New	   	|14		    		|PcwkoCibtGFimJDbLOSVwqLQWOMoOTgtZaSzHWGsKzrTDpQJnu	|
	
	
	Scenario Outline: bl03_01_PerformValidSearch1Result1 
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
  Then I click "Cancel Button" 

  Examples:
	|cert_number 	|DDRef	  	|certStatus				              		 		|DDDue	|paymentType	|paymentAmount	|paymentStatus					        	|cost	  |outstandingBalance	|surname	|addressline1	|notes												                      |
	|20000007188	|DD11458435 |Certificate awaiting production Change |28			|Direct Debit	|£0.00		    	|Direct Debit Instruction lodged	|104.00	|£104.00	      		|New		  |14			     	|PcwkoCibtGFimJDbLOSVwqLQWOMoOTgtZaSzHWGsKzrTDpQJnu	|
	 

	
	Scenario Outline: bl02_05_PerformInValidSearchNoNumber 
  When I send cert num '<cert_number>' and click submit
  Then I am redirected to "search cert number results" page
  And I check that search error is present as '<error_message>'
  Then I click back button for payment card details
    
  Examples:
	|cert_number 	|error_message											                      	|
	|10000003003	|No exemptions were found for the specified search criteria |
	
	
  Scenario Outline: bl04_01_PerformValidSearchUsingDDRef1 
 	Then I click the button "submit" 
  When I send dd ref '<DDRef>' and click submit
  And I verify certificate number '<cert_number>' on search results page
  Then I click back button for payment card details
   
  Examples:
  |DDRef 	  	|cert_number|
  |DD11458435	|20000007188|
  
    
  Scenario Outline: bl05_01_PerformValidSearchUsingSurnameDOB1 
 	Then I click the button "submit" 
 	When I send surname '<surname>' and dob '<dob>' and click submit
	And I verify certificate number '<cert_number>' on search results page
	Then I click back button for payment card details
    
  Examples:
  |surname 	|cert_number |dob		    |
  |Honey		|20000007190 |26041978	|

  
  Scenario Outline: bl05_01_PerformValidSearchUsingNhsNumber
 	Then I click the button "submit" 
  When I send nhs number '<nhs_number>' and click submit
  And I verify certificate number '<cert_number>' on search results page
  Then I click back button for payment card details
    
  Examples:
  |nhs_number  	|cert_number	|
  |3479716768		|20000009245	|
   
   
	Scenario Outline: bl05_01_PerformValidSearchUsingEmailAddress
 	Then I click the button "submit" 
  When I send email address '<email_address>' and click submit
  And I verify certificate number '<cert_number>' on search results page
  Then I click back button for payment card details
    
  Examples:
  |email_address 	          |cert_number	|
  |joselu.sanchez@gmail.com |20000015639	|
  	
#### Addtional test cases 

###### DONT RUN
  #Scenario Outline: bl05_01_PerformValidSearchUsingSurnameDOB2 
  #Then I click the button "submit" 
  #When I send surname '<surname>' and dob '<dob>' and click submit
  #And I verify certificate number '<cert_number>' on search results page
  #Then I click back button for payment card details
    #
  #Examples:
  #|surname 	|cert_number	|dob	  	|
  #|New		  |20000007188	|25121978	|
###############  

###### DONT RUN    
  #Scenario Outline: bl04_01_PerformValidSearchUsingDDRef2 
  #When I send dd ref '<DDRef>' and click submit
  #And I verify certificate number '<cert_number>' on search results page
  #Then I click back button for payment card details
  #
  #Examples:
  #|DDRef 		|cert_number|
  #|DD11458437	|20000007190|
###############   

###### DONT RUN 	
#	Scenario Outline: bl03_02_PerformValidSearch1Result2 
  #When I send valid search details via certificate number as '<cert_number>'
  #Then I am redirected to "search cert number results" page
  #Then I check that it is correct certificate as '<cert_number>' on search results page
  #And I click certificate number '<cert_number>' on search results page
  #Then I check that it is correct certificate as '<cert_number>' on certificate details page
  #And I check that it is correct certificate status as '<certStatus>'
  #And I check that it is correct payment type as '<paymentType>'
  #And I check that it is correct payment amount as '<paymentAmount>'   
#	And I check that it is correct payment status as '<paymentStatus>'
#	Then I check that it is correct cost as '<cost>'
#	And I check that it is correct total as '<total>'
#	And I check that it is correct surname as '<surname>'
#	And I check that it is correct address line1 as '<addressline1>'
#	Then I click "Cancel Button" 
#
   #Examples:
#	|cert_number 	|certStatus						          |paymentType	  |paymentAmount	|paymentStatus		|cost	  |total	|surname	|addressline1	|
#	|10000000588	|Certificate awaiting production|Cheque Payment	|104.00	    		|Awaiting banking	|104.00	|104.00	|SPtWv		|94			    	|
###############
 