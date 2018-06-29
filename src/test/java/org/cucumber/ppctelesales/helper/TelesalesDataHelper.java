package org.cucumber.ppctelesales.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.cucumber.ppctelesales.model.Account;
import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.ppctelesales.model.Certificate;
import org.cucumber.ppctelesales.model.Mother;
import org.cucumber.ppctelesales.model.Payment;
import org.cucumber.ppctelesales.model.Search;
//import org.cucumber.ppctelesales.model.User;
import org.cucumber.utils.Utilities;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class TelesalesDataHelper {
	
	/**
	 * returns search object with no previous certificate number or direct debit
	 * reference
	 * 
	 * @return
	 */

//	Inputs values into the exemption search form 	
	public static Search getSearch() {

		Search search = new Search();

		search.CertificateNumber = "";
		search.DirectDebitReference = "";
		search.Dob = "";
		search.Postcode = "";
		search.Surname = "";
		search.EmailAddress = "";
		search.NhsNumber = "";

		search.CertificateNumber = "00000000000";
//		search.Surname = Utilities.getRandomAlphaNumeric(10,Utilities.RandomType.Alpha);
//	    search.Dob = "101080";
//		search.Postcode = Utilities.getRandomPostCode(Utilities.PostCodeCountry.England);

		return search;
	}
	
	public static Search enterCertNum(String certNo) {

		Search search = new Search();

		search.CertificateNumber = "";
		search.DirectDebitReference = "";
		search.Dob = "";
		search.Postcode = "";
		search.Surname = "";
		search.EmailAddress = "";
		search.NhsNumber = "";

		search.CertificateNumber = certNo;
//		search.Surname = Utilities.getRandomAlphaNumeric(10,Utilities.RandomType.Alpha);
//		search.Dob = "101080";
//		search.Postcode = Utilities.getRandomPostCode(Utilities.PostCodeCountry.England);

		return search;
	}
	
	public static Search enterDDRef(String ddRef) {

		Search search = new Search();

		search.CertificateNumber = "";
		search.DirectDebitReference = "";
		search.Dob = "";
		search.Postcode = "";
		search.Surname = "";
		search.EmailAddress = "";
		search.NhsNumber = "";

		search.DirectDebitReference = ddRef;

		return search;
	}
	
	public static Search enterSurnameAndDOB(String surname, String dob) {

		Search search = new Search();

		search.CertificateNumber = "";
		search.DirectDebitReference = "";
		search.Dob = "";
		search.Postcode = "";
		search.Surname = "";
		search.EmailAddress = "";
		search.NhsNumber = "";

		search.Dob = dob;
		search.Surname = surname;

		return search;
	}
	
	public static Search enterEmailAddress(String emailaddress) {

		Search search = new Search();

		search.CertificateNumber = "";
		search.DirectDebitReference = "";
		search.Dob = "";
		search.Postcode = "";
		search.Surname = "";
		search.EmailAddress = "";
		search.NhsNumber = "";

		search.EmailAddress = emailaddress;

		return search;
	}
	
	public static Search enterNhsNumber(String nhsnumber) {

		Search search = new Search();

		search.CertificateNumber = "";
		search.DirectDebitReference = "";
		search.Dob = "";
		search.Postcode = "";
		search.Surname = "";
		search.EmailAddress = "";
		search.NhsNumber = "";

		search.NhsNumber = nhsnumber;

		return search;
	}
	
	/**
	 * returns search object with a valid previous certificate number
	 * 
	 * @return
	 */
	
	public static Search getValidSearchViaCertNumber(String certNumber) {

		Search search = new Search();

		search.CertificateNumber = "";
		search.DirectDebitReference = "";
		search.Dob = "";
		search.Postcode = "";
		search.Surname = "";
		search.EmailAddress = "";
		search.NhsNumber = "";

		search.CertificateNumber = certNumber;

		return search;
	}	
	
	/**
	 * returns search object with a valid previous DD ref number
	 * 
	 * @return
	 */
	
	public static Search getValidSearchViaDDref(String ddRef) {

		Search search = new Search();

		search.CertificateNumber = "";
		search.DirectDebitReference = "";
		search.Dob = "";
		search.Postcode = "";
		search.Surname = "";
		search.EmailAddress = "";
		search.NhsNumber = "";

		search.DirectDebitReference = ddRef;

		return search;
	}	
	
	/**
	 * returns search object with a valid previous Surname and Dob
	 * 
	 * @return
	 */
	
	public static Search getValidSearchViaSurnameDob(String surname, String dob) {

		Search search = new Search();

		search.CertificateNumber = "";
		search.DirectDebitReference = "";
		search.Dob = "";
		search.Postcode = "";
		search.Surname = "";
		search.EmailAddress = "";
		search.NhsNumber = "";

		search.Surname = surname;
		search.Dob = dob;
		
		return search;
	}	
	
//	Inputs values into the edit exemption form for matex 
	public static Mother enterEmailAddressNotes(String notes, String emailaddress) {

		Mother mother = new Mother();
			
		mother.Add1 = "";
		mother.Add2 = "";
		mother.Town = "";
		mother.Add4 = "";
		mother.PostCode = "";
		mother.Surname = "";
		mother.Forename = "";
		mother.Dob = "";
		mother.TelephoneNumber = "";
		mother.EmailAddress = "";
		mother.DueDate = "";
		mother.NhsNumber = "";
		mother.Notes = "";
		
		mother.Notes = notes;
		mother.EmailAddress = emailaddress;
			
		return mother;
	}
	
	public static Mother editEmailAddress(String emailaddress) {

		Mother mother = new Mother();

		mother.Add1 = "";
		mother.Add2 = "";
		mother.Town = "";
		mother.Add4 = "";
		mother.PostCode = "";
		mother.Surname = "";
		mother.Forename = "";
		mother.Dob = "";
		mother.TelephoneNumber = "";
		mother.EmailAddress = "";
		mother.DueDate = "";
		mother.NhsNumber = "";
		mother.Notes = "";
				
		mother.EmailAddress = emailaddress;
		
		return mother;
	}
	
//  Inputs a value into the payment amount field on the refund details screen 
	public static Payment enterPaymentAmount(String payment_amount) {

		Payment payment = new Payment();
			
		payment.PaymentAmount = "";
		
		payment.PaymentAmount = payment_amount;
	
		return payment;
	}
		
	
	public static Applicant getApplicant() {

		Applicant applicant = new Applicant();

		applicant.Add1 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		applicant.Add2 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		applicant.Add3 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		applicant.Add4 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		applicant.PostCode = "ne1 1dd";

		applicant.Title = Applicant.title.Mr;
		applicant.OtherTitle = "";
		applicant.Surname = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		applicant.Forename = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		applicant.Dob = "01/01/1980";
		applicant.TelephoneNumber = "0" + Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Num);
		applicant.NhsNumber = "";
		applicant.Notes = Utilities.getRandomAlphaNumeric(50, Utilities.RandomType.Alpha);

		applicant.PaymentType = Applicant.paymentType.CreditDebitCard;

		return applicant;
	}

	public static Mother getMother() {

		Mother mother = new Mother();

		mother.Add1 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		mother.Add2 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		mother.Town = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		mother.Add4 = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		mother.PostCode = "ne1 1dd";

		mother.Surname = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		mother.Forename = Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Alpha);
		mother.Dob = "01/01/1980";
		mother.TelephoneNumber = "0" + Utilities.getRandomAlphaNumeric(10, Utilities.RandomType.Num);
		mother.NhsNumber = "";
		mother.Notes = Utilities.getRandomAlphaNumeric(50, Utilities.RandomType.Alpha);


		return mother;
	}
	
	public static Certificate getCertificate() {

		Certificate cert = new Certificate();

		cert.CertificateDuration = Certificate.certificateDuration.ThreeMonths;
		cert.CertificateStart = "101016";
		cert.CertificateNotes = "";

		return cert;
	}

	public static Certificate getCertificate(String startDate) {

		Certificate cert = new Certificate();

		cert.CertificateDuration = Certificate.certificateDuration.ThreeMonths;
		cert.CertificateStart = startDate;
		cert.CertificateNotes = "";

		return cert;
	}
	
	public static Certificate getCertificateTwelveMonths(String startDate) {

		Certificate cert = new Certificate();

		cert.CertificateDuration = Certificate.certificateDuration.TwelveMonths;
		cert.CertificateStart = startDate;
		cert.CertificateNotes = "";

		return cert;
	}
	
	
	public static Certificate getCertificateTwelveMonths() {

		Certificate cert = new Certificate();

		cert.CertificateDuration = Certificate.certificateDuration.TwelveMonths;
		cert.CertificateStart = "101016";
		cert.CertificateNotes = "";

		return cert;
	}

	/**
	 * returns a random valid account object
	 * 
	 * @return
	 */
	public static Account getValidAccount() {

		List<Pair<String, String>> accounts = validAccounts();

		Random random = new Random();
		int index = random.nextInt(accounts.size());
		Pair<String, String> account = accounts.get(index);

		Account acc = new Account();

		acc.SortCode = account.getKey().toString();
		acc.AccountNumber = account.getValue().toString();
		acc.thirdParty = Account.ThirdParty.n;
		
		return acc;
	}

	/**
	 * Uses LLoyds as the Sort code 
	 * returns a valid object
	 * 
	 * @return
	 */
	public static Account getValidLLoydsAccount() {

		List<Pair<String, String>> accounts = validAccounts();

		Random random = new Random();
		int index = random.nextInt(accounts.size());
		Pair<String, String> account = accounts.get(index);

		Account acc = new Account();

	    acc.SortCode = "302556";            
	    acc.AccountNumber = "32029501";		
		acc.thirdParty = Account.ThirdParty.n;
		
		return acc;
	}
	
	/**
	 * Uses RBS as the Sort code 
	 * returns a valid object
	 * 
	 * @return
	 */
	public static Account getValidRBSAccount() {

		List<Pair<String, String>> accounts = validAccounts();

		Random random = new Random();
		int index = random.nextInt(accounts.size());
		Pair<String, String> account = accounts.get(index);

		Account acc = new Account();

	    acc.SortCode = "163032";            
	    acc.AccountNumber = "10050518";
	    
		acc.thirdParty = Account.ThirdParty.n;
		
		return acc;
	}
	
	/**
	 * Uses NatWest as the Sort code 
	 * returns a valid object
	 * 
	 * @return
	 */
	public static Account getValidNatWestAccount() {

		List<Pair<String, String>> accounts = validAccounts();

		Random random = new Random();
		int index = random.nextInt(accounts.size());
		Pair<String, String> account = accounts.get(index);

		Account acc = new Account();

	    acc.SortCode = "604005";            
        acc.AccountNumber = "24605999";
        
		acc.thirdParty = Account.ThirdParty.n;
		
		return acc;
	}
	
	/**
	 * Uses Halifix as the Sort code, but the card does not accept direct credit
	 * returns a valid object
	 * 
	 * @return
	 */
	public static Account getDirectCredit() {

		List<Pair<String, String>> accounts = validAccounts();

		Random random = new Random();
		int index = random.nextInt(accounts.size());
		Pair<String, String> account = accounts.get(index);

		Account acc = new Account();

	    acc.SortCode = "111545";            
        acc.AccountNumber = "00000003";
        
		acc.thirdParty = Account.ThirdParty.n;
		
		return acc;
	}
	
	/**
	 * returns an object, that contains a valid account code, but no sort code
	 * 
	 * @return
	 */
	public static Account getNoSortCodeAccount() {

		List<Pair<String, String>> accounts = validAccounts();

		Random random = new Random();
		int index = random.nextInt(accounts.size());
		Pair<String, String> account = accounts.get(index);

		Account acc = new Account();

        acc.SortCode = "";            
        acc.AccountNumber = "32029501";
        
		acc.thirdParty = Account.ThirdParty.n;
		
		return acc;
	}	
	
	/**
	 * returns an account object which does not accept direct debits
	 * 
	 * @return
	 */
	public static Account getAccountDoesNotAcceptDirectDebit() {

		Account acc = new Account();

		acc.AccountNumber = "00707810";
		acc.SortCode = "090415";

		acc.thirdParty = Account.ThirdParty.n;

		return acc;
	}

	/**
	 * returns an account object which contains a valid sort code and account code, but they are not linked together
	 * 
	 * @return
	 */
	public static Account getNotLinkedAccount() {

		Account acc = new Account();

	    acc.SortCode = "302556";            
	    acc.AccountNumber = "10050518";

		acc.thirdParty = Account.ThirdParty.n;

		return acc;
	}
    
	/**
	 * returns an account with an invalid account number
	 * 
	 * @return
	 */
	public static Account getInvalidAccount() {

		Account acc = new Account();

		acc.AccountNumber = "00707810";
		acc.SortCode = "300002";

		acc.thirdParty = Account.ThirdParty.n;

		return acc;
	}
	
	/**
	 * returns an account with an invalid sort code
	 * 
	 * @return
	 */
	public static Account getInvalidSortCodeAccount() {

		Account acc = new Account();

		acc.AccountNumber = "32029501";
		acc.SortCode = "123456";

		acc.thirdParty = Account.ThirdParty.n;

		return acc;
	}	
	
	/**
	 * returns an account with a sort code containing characters
	 * 
	 * @return
	 */
	public static Account getCharSortCodeAccount() {

		Account acc = new Account();

	    acc.SortCode = "helloo";  //an invalid sort code
        acc.AccountNumber = "3202555"; //an invalid account code
		acc.thirdParty = Account.ThirdParty.n;

		return acc;
	}
	
	/**
	 * returns an account with a sort code containing '-' characters
	 * 
	 * @return
	 */
	public static Account getPartCompletedSortCodeValidAccount() {

		Account acc = new Account();

	    acc.SortCode = "12-34-";  //an invalid sort code
        acc.AccountNumber = "3202555"; //an invalid account code
		acc.thirdParty = Account.ThirdParty.n;

		return acc;
	}	
	
	/**
	 * returns an account with a Account that contains 8 characters
	 * 
	 * @return
	 */
	public static Account getAccount8Chars() {

		Account acc = new Account();

		acc.SortCode = "302556";  //a valid sort code
        acc.AccountNumber = "000222898"; //an invalid account code
        
		acc.thirdParty = Account.ThirdParty.n;

		return acc;
	}		

	/**
	 * returns an account with a Account that contains 5 characters
	 * 
	 * @return
	 */
	public static Account getAccount5Chars() {

		Account acc = new Account();

		acc.SortCode = "302556";  //a valid sort code
        acc.AccountNumber = "22898"; //an invalid account code
        
		acc.thirdParty = Account.ThirdParty.n;

		return acc;
	}
	
	/**
	 * returns an account with a Account that contains all characters
	 * 
	 * @return
	 */
	public static Account getAccountAllChars() {

		Account acc = new Account();

		acc.SortCode = "302556";  //a valid sort code
        acc.AccountNumber = "helloo"; //an invalid account code
        
		acc.thirdParty = Account.ThirdParty.n;

		return acc;
	}	
		
	/**
	 * list of valid account numbers and sort codes, update this when you have
	 * the correct test data from the new provider
	 * 
	 * @return
	 */
	public static List<Pair<String, String>> validAccounts() {

		// /"F:\Professional Services\E2E Testing\End To End Testing\BP079 DD
		// Replacement
		// \MainRelease_Nov15\Dummy Card & Direct Debit Account Nos"

		// note we're using a pair here because a map won't work,
		// the sort code is the same for each account in the current test data
		// map requires a unique key:

		List<Pair<String, String>> accounts = new ArrayList<>();

		Pair<String, String> acc1 = new ImmutablePair<String, String>("302556", "32029501");
		Pair<String, String> acc2 = new ImmutablePair<String, String>("302556", "59946655");
		Pair<String, String> acc3 = new ImmutablePair<String, String>("302556", "75079226");
		Pair<String, String> acc4 = new ImmutablePair<String, String>("302556", "53981653");
		Pair<String, String> acc5 = new ImmutablePair<String, String>("302556", "76099040");
		Pair<String, String> acc6 = new ImmutablePair<String, String>("302556", "62180249");

		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc3);
		accounts.add(acc4);
		accounts.add(acc5);
		accounts.add(acc6);

		return accounts;
	}

}
