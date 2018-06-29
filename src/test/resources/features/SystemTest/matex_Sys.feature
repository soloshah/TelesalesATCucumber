@Matex_Sys
Feature: Tele sales user wishes to log into the system
  Test feature for Tele sales user wishes to log into the system without any errors into PPC
  
### *** RUN TELESALES AUTOMATION RESET SQL - STORED IN THE MATEX/TEST/ PROJECT FOLDER *** ###
  
  Scenario Outline: bl07_01_PerformAValidMatexDigitalSearch
  Given I open the homepage
  When I send cert num '<cert_number>' and click submit
  Then I am redirected to "search cert number results" page
  And I verify certificate number '<cert_number>' on search results page
  And I click certificate number '<cert_number>' on search results page
  Then I check that it is correct certificate as '<cert_number>' on certificate details page
  And I check that it is correct certificate status as '<certStatus>'
  And I check that it is correct certificate type as '<certType>'
  And I check that it is correct certificate fulfilment as '<certFulfilment>'
  And I check that it is correct certificate start as '<certStart>'
  And I check that it is correct certificate expiry as '<certExpiry>'
  And I check that it is correct application date as '<appDate>'
  And I check that it is correct hcp identifier as '<hcpIdentifier>'
  Then I click "Cancel Button" 
   
	Examples:
	|cert_number 	| certStatus         | certType | certFulfilment | certStart  | certExpiry | appDate    | hcpIdentifier  | 
	|20000015625	| Certificate issued | MAT      | Email					 | 02-09-2017 | 24-12-2018 | 02-10-2017 | AAAA1111		   |
	
	
  Scenario Outline: bl07_01_PerformAValidMatexAssistedDigitalSearch
  When I send cert num '<cert_number>' and click submit
  Then I am redirected to "search cert number results" page
  And I verify certificate number '<cert_number>' on search results page
  And I click certificate number '<cert_number>' on search results page
  Then I check that it is correct certificate as '<cert_number>' on certificate details page
  And I check that it is correct certificate status as '<certStatus>'
  And I check that it is correct certificate type as '<certType>'
  And I check that it is correct certificate fulfilment as '<certFulfilment>'
  And I check that it is correct certificate start as '<certStart>'
  And I check that it is correct certificate expiry as '<certExpiry>'
  And I check that it is correct application date as '<appDate>'
  And I check that it is correct hcp identifier as '<hcpIdentifier>'
  Then I click "Cancel Button" 

  Examples:	
  |cert_number | certStatus         | certType | certFulfilment | certStart  | certExpiry | appDate    | hcpIdentifier  |
	|20000017653 | Certificate issued | MAT      | Card				  	| 05-11-2017 | 10-11-2018 | 05-12-2017 | CCCC3333		    |
	
	
	Scenario Outline: bl07_01_PerformAValidMatexPaperSearch
  When I send cert num '<cert_number>' and click submit
  Then I am redirected to "search cert number results" page
  And I verify certificate number '<cert_number>' on search results page
  And I click certificate number '<cert_number>' on search results page
  Then I check that it is correct certificate as '<cert_number>' on certificate details page
  And I check that it is correct certificate status as '<certStatus>'
  And I check that it is correct certificate type as '<certType>'
  And I check that it is correct certificate fulfilment as '<certFulfilment>'
  And I check that it is correct certificate start as '<certStart>'
  And I check that it is correct certificate expiry as '<certExpiry>'
  And I check that it is correct application date as '<appDate>'
  Then I click "Cancel Button" 

	Examples:	
  |cert_number 	| certStatus         | certType | certFulfilment | certStart  | certExpiry | appDate    |  
	|20000005966	| Certificate issued | MAT      | Card					 | 29-12-2012 | 31-12-2018 | 29-01-2013 |  
	  	   
	  	   
###### WAITING FOR NEW REISSUE AND ISSUE ID'S TO BE DEPLOYED
	#Scenario Outline: bl07_02_ReissueAssistedDigitalMatexCert
  #Given I open the homepage
  #When I send cert num '<cert_number>' and click submit
  #Then I am redirected to "search cert number results" page
  #And I verify certificate number '<cert_number>' on search results page
  #And I click certificate number '<cert_number>' on search results page
  #Then I check that it is correct certificate as '<cert_number>' on certificate details page
  #Then I click "Reissue Button"
  #When I send notes '<notes>'
  #Then I click "Reissue Link"
  #Then I click the reissue button on the edit exemption page
  #And I check that it is correct certificate status as '<certStatus>'
  #Then I click "Cancel Button" 
  #	  
#	  Examples:	
    #|cert_number 	| certStatus                      | notes 																				|
 #	  |20000014615	| Certificate awaiting production | AUTOMATED MATEX ASSISTED DIGITAL REISSUE TEST |
#
#	  Scenario Outline: bl07_02_ReissueDigitalMatexCert
    #Given I open the homepage
    #When I send cert num '<cert_number>' and click submit
    #Then I am redirected to "search cert number results" page
    #And I verify certificate number '<cert_number>' on search results page
    #And I click certificate number '<cert_number>' on search results page
    #Then I check that it is correct certificate as '<cert_number>' on certificate details page
    #Then I click "Reissue Button"
    #When I send notes '<notes>'
    #Then I click "Reissue Link"
   #Then I click the reissue button on the edit exemption page
    #And I check that it is correct certificate status as '<certStatus>'
    #Then I click "Cancel Button" 
       #	  
#	  Examples:	
    #|cert_number 	| certStatus         | notes 																|
 #	  |20000015613	| Certificate issued | AUTOMATED MATEX DIGITAL REISSUE TEST |
#
#
#	  Scenario Outline: bl07_02_ReissuePaperMatexCert
    #Given I open the homepage
    #When I send cert num '<cert_number>' and click submit
    #Then I am redirected to "search cert number results" page
    #And I verify certificate number '<cert_number>' on search results page
    #And I click certificate number '<cert_number>' on search results page
    #Then I check that it is correct certificate as '<cert_number>' on certificate details page
    #Then I click "Reissue Button"
    #When I send notes '<notes>'
    #Then I click the reissue button on the edit exemption page
    #And I check that it is correct certificate status as '<certStatus>'
    #Then I click "Cancel Button" 
       #	  
#	  Examples:	
    #|cert_number 	| certStatus                      | notes 																				|
 #	  |20000005964	| Certificate awaiting production | AUTOMATED MATEX PAPER DIGITAL REISSUE TEST    |
#
#
#	  Scenario Outline: bl07_02_IssuePaperMatexCert
    #Given I open the homepage
    #When I send cert num '<cert_number>' and click submit
    #Then I am redirected to "search cert number results" page
    #And I verify certificate number '<cert_number>' on search results page
    #And I click certificate number '<cert_number>' on search results page
    #Then I check that it is correct certificate as '<cert_number>' on certificate details page
    #Then I click "Issue Button"
    #When I send notes '<notes>'
    #Then I click the issue button on the edit exemption page
    #And I check that it is correct certificate status as '<certStatus>'
    #Then I click "Cancel Button" 
       #	  
#	  Examples:	
    #|cert_number 	| certStatus                      | notes																					|
 #	  |20000005985	| Certificate awaiting production | AUTOMATED MATEX PAPER DIGITAL ISSUE TEST    |
#

#### Addtional test cases 

###### DONT RUN
#	Scenario Outline: bl07_03_EditAndSaveAMatexRecord
  #Given I open the homepage
  #When I send cert num '<cert_number>' and click submit
  #Then I am redirected to "search cert number results" page
  #And I verify certificate number '<cert_number>' on search results page
  #And I click certificate number '<cert_number>' on search results page
  #Then I check that it is correct certificate as '<cert_number>' on certificate details page
  #Then I click "Edit Button"
  #And I send email address '<email_address>' and notes '<notes>'
  #And I send notes '<notes>' 
  #Then I click "Save Button"
  #And I check action has been successfully performed as '<action>'
  #Then I click "Cancel Button" 
  #
#	Examples:	
  #|cert_number 	| email_address                 | notes															 | action									      		             |
 #	|20000015705	| louis.lampard@gmail.com			  | AUTOMATED MATEX EDIT AND SAVE TEST | Certificate has been saved successfully       |														
###############  