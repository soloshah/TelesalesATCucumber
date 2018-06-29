package org.cucumber.ppctelesales.model;

public class Applicant {
	
	public title Title;
	public String OtherTitle;
	public String Surname;
	public String Forename;
	public String Add1;
	public String Add2;
	public String Add3;
	public String Add4;
	public String PostCode;
	public String Dob;
	public String TelephoneNumber;
	public String NhsNumber;
	public String Notes;
	public paymentType PaymentType;

	public enum title {
		Mr, Mrs, Miss, Ms, Other, NotSet
	}

	public enum paymentType {
		CreditDebitCard, DirectDebit, Cheque
	}

}
