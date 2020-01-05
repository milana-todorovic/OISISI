/**
 * 
 */
package view.validity_utils;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Klasa koja nudi metode za provjeru poklapanja stringa sa odredjenim
 * formatima.
 * 
 * @author Milana Todorovic ra3-2017
 * @author Ana Perisic ra1-2017
 *
 */
public class Validator {

	public static Boolean isAlphanumeric(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9]*");
	}

	public static Boolean isAlphanumericWithSeparators(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9 -]*");
	}

	public static Boolean isAlphanumericWithSeparator(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9-]*");
	}

	public static Boolean isAlphanumericWithDot(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9.@]*");
	}

	public static Boolean isNumeric(String s) {
		return s.matches("[0-9]*");
	}

	public static Boolean isNumericWithComma(String s) {
		return s.matches("[0-9,]*");
	}

	public static Boolean isNumericWithSep(String s) {
		return s.matches("[0-9-]*");
	}

	public static Boolean isAlphabeticWithSeparators(String s) {
		return s.matches("[\\p{IsAlphabetic} -]*");
	}

	public static Boolean isNazivPredmeta(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9]+([ ]*-?[ ]*[\\p{IsAlphabetic}0-9]+)*");
	}

	public static Boolean isImePrezimeStudenta(String s) {
		return s.matches("[\\p{IsAlphabetic}]+([ ]*-?[ ]*[\\p{IsAlphabetic}]+)*");
	}

	public static Boolean isAdresaStudenta(String s) {
		return s.matches("([\\p{IsAlphabetic}]+[ ]*)+[0-9]+[a-zA-Z]*(-[0-9]+)*");
	}

	public static Boolean isEmailAdresa(String s) {
		return s.matches("[\\p{IsAlphabetic}]+.?[\\p{IsAlphabetic}]+[0-9]*@([a-z]+.)+[a-z]+");
	}

	public static Boolean isBrojIndeksa(String s) {
		return s.matches("(([\\p{IsAlphabetic}][0-9])|([\\p{IsAlphabetic}][a-zA-Z]))[0-9]{1,3}-[2][0][0-9]{2}");
	}

	public static Boolean isBrojTel(String s) {
		return s.matches("[0-9]{9,20}");
	}

	public static Boolean isProsek(String s) {
		return s.matches("([6-9],[0-9][0-9])|([1][0],[0][0])");
	}

	public static Boolean matchesSearchFormat(String s) {
		return s.matches("(([^;:]+):([^;:]+);)*(([^;:]+):([^;:]+))?");
	}

	public static Boolean searchParamsValid(String s, Map<String, Integer> validParams) {
		String[] splits = s.split(";");
		for (String string : splits) {
			String[] innerSplit = string.split(":");
			if (!validParams.containsKey(innerSplit[0].toLowerCase().trim()))
				return false;
			if (innerSplit.length == 2) {
				try {
					Pattern.compile(innerSplit[1].trim());
				} catch (PatternSyntaxException e) {
					return false;
				}
			}
		}
		return true;
	}

}
