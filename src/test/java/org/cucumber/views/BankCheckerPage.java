package org.cucumber.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.cucumber.ppctelesales.model.Account;
import org.cucumber.ppctelesales.model.Applicant;
import org.cucumber.ppctelesales.model.Certificate;
import org.cucumber.utils.Utilities;

public class BankCheckerPage {
	
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
	
	public static Certificate getCertificate() {

		Certificate cert = new Certificate();

		cert.CertificateDuration = Certificate.certificateDuration.ThreeMonths;
		cert.CertificateStart = "101016";
		cert.CertificateNotes = "";

		return cert;
	}

}
