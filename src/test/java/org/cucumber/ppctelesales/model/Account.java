package org.cucumber.ppctelesales.model;

public class Account {

	public enum ThirdParty{
        y,
        n
    }
    
    public String SortCode;
    public String AccountNumber;
    public ThirdParty thirdParty;
    public String Title;
    public String Initial;
    public String Surname;
    public String startDate;
    
}
