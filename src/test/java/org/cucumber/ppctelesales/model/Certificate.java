package org.cucumber.ppctelesales.model;

public class Certificate {
	
	public certificateDuration CertificateDuration;
	public String CertificateStart;
	public String CertificateNotes;

	public enum certificateDuration {

		ThreeMonths, TwelveMonths
	}

}
