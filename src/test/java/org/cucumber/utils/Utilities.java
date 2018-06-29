package org.cucumber.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public final class Utilities {
	
	public enum RandomType {
		AlphaNum, Alpha, Num, NumNoZero
	}

	public enum PostCodeCountry {
		England, Scotland, Welsh, NIreland
	}

	public static String getEnglishPostCodeChars() {

		String[] english = { "NE", "DH", "SR", "TS", "DL", "HG", "LS", "YO",
				"HU", "WF", "CA", "LA", "BD", "FY", "OL", "BL", "WN", "WA",
				"CW", "SK", "DN", "NG", "DE", "LE", "PE", "NR", "IP",
				"CO", "OX", "RG", "GU", "RH", "TN", "ME", "EX", "TA", "BA",
				"DT" };
		return english[new Random().nextInt(english.length)];
	}

	public static String getScottishPostCodeChars() {

		String[] scotland = { "KW", "IV", "AB", "PH", "DD", "PA", "FK", "KY",
				"G", "ML", "EH", "TD", "DG" };

		return scotland[new Random().nextInt(scotland.length)];
	}

	public static String getWelshPostCodeChars() {

		String[] welsh = { "LL", "SY", "LD", "SA", "CF", "NP" };

		return welsh[new Random().nextInt(welsh.length)];
	}

	public static String getNIrelandPostCodeChars() {
		return "BT";
	}

	public static String getRandomAlphaNumeric(int len, RandomType type) {

		String chars = "";

		switch (type) {

		case AlphaNum:
			chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			break;
		case Alpha:
			chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			break;
		case Num:
			chars = "0123456789";
			break;
		case NumNoZero:
			chars = "123456789";
			break;
		}

		Random rnd = new Random();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	/**
	 * generates a random post code but they aren't necessarily valid post
	 * codes, don't use in situations where you want a happy path through the
	 * application
	 * 
	 * @return
	 */
	public static String getRandomPostCode() {

		String firstPart;
		String secondPart;

		firstPart = getRandomAlphaNumeric(2, RandomType.Alpha)
				+ getRandomAlphaNumeric(1, RandomType.NumNoZero);

		secondPart = getRandomAlphaNumeric(1, RandomType.NumNoZero)
				+ getRandomAlphaNumeric(2, RandomType.Alpha);

		return firstPart + " " + secondPart;
	}

	/**
	 * generate a UK country specific random post code
	 * 
	 * @param country
	 * @return
	 */
	public static String getRandomPostCode(PostCodeCountry country) {

		String firstPart = null;
		String secondPart;

		switch (country) {
		case England:
			firstPart = getEnglishPostCodeChars();
			break;
		case Scotland:
			firstPart = getScottishPostCodeChars();
			break;
		case Welsh:
			firstPart = getWelshPostCodeChars();
			break;
		case NIreland:
			firstPart = getNIrelandPostCodeChars();
			break;
		}

		firstPart = firstPart + getRandomAlphaNumeric(1, RandomType.NumNoZero);

		secondPart = getRandomAlphaNumeric(1, RandomType.NumNoZero)
				+ getRandomAlphaNumeric(2, RandomType.Alpha);

		return firstPart + " " + secondPart;
	}

	/**
	 * returns a string formatted date of either plus or minus one month from
	 * todays date, set minusOne to true if you want a date 1 month prior to
	 * today
	 * 
	 * @param minusOne
	 * @param noSlashes
	 * @return
	 */
	public static String getPlusMinusOneMonthStartDate(boolean minusOne,
			boolean noSlashes) {

		Calendar cal = Calendar.getInstance();

		if (minusOne) {
			cal.roll(Calendar.MONTH, 1); // subtract a month if true
		} else {
			cal.add(Calendar.MONTH, 1); // else add a month
		}

		SimpleDateFormat date;

		if (noSlashes) {
			date = new SimpleDateFormat("ddMMyyyy");
		} else {
			date = new SimpleDateFormat("dd/MM/yyyy");
		}

		String formattedDate = date.format(cal.getTime());

		return formattedDate;
	}
	
	
	/**
	 * returns a string formatted date of todays date 
	 * @param noSlashes
	 * @return
	 */
	public static String getCurrentDateStartDate(boolean noSlashes) {

		Calendar cal = Calendar.getInstance();
		
		cal.roll(Calendar.MONTH, 0);

		SimpleDateFormat date;

		if (noSlashes) {
			date = new SimpleDateFormat("ddMMyyyy");
		} else {
			date = new SimpleDateFormat("dd/MM/yyyy");
		}

		String formattedDate = date.format(cal.getTime());

		return formattedDate;
	}

}
