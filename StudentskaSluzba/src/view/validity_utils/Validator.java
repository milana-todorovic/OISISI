/**
 * 
 */
package view.validity_utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

	public static Boolean isAlphanumericWithSpaceSlash(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9 /]*");
	}

	public static Boolean isAlphanumericWithDotUnderscore(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9.@_]*");
	}

	public static Boolean isAlphanumericWithCommaDashDotSpace(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9 ,-.]*");
	}

	public static Boolean isNumeric(String s) {
		return s.matches("[0-9]*");
	}

	public static Boolean isNumericWithDot(String s) {
		return s.matches("[0-9.]*");
	}

	public static Boolean isNumericWithDash(String s) {
		return s.matches("[0-9-]*");
	}

	public static Boolean isNumericWithSlashDash(String s) {
		return s.matches("[0-9/-]*");
	}

	public static Boolean isAlphabeticWithSeparators(String s) {
		return s.matches("[\\p{IsAlphabetic} -]*");
	}

	public static Boolean isAlphabeticWithSeparatorsDot(String s) {
		return s.matches("[\\p{IsAlphabetic} .-]*");
	}

	public static Boolean isNazivPredmeta(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9]+([ ]*[ -][ ]*[\\p{IsAlphabetic}0-9]+)*");
	}

	public static Boolean isImePrezime(String s) {
		return s.matches("[\\p{IsAlphabetic}]+([ -][\\p{IsAlphabetic}]+)*");
	}

	public static Boolean isAdresa(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9]+(([ ]*[\\., -][ ]*)[\\p{IsAlphabetic}0-9]+)*");
	}

	public static Boolean isEmailAdresa(String s) {
		return s.matches("[a-zA-Z][a-zA-z0-9._]*[a-zA-Z0-9]@[a-zA-Z]+(\\.[a-zA-Z]+)+");
	}

	public static Boolean isBrojIndeksa(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9]{2} [0-9]{1,3}/[2][0-9]{3}");
	}

	public static Boolean isBrojTel(String s) {
		return s.matches("[0-9]{3}/[0-9]{3,4}-[0-9]{3}");
	}

	public static Boolean isProsek(String s) {
		return s.matches("([6-9](\\.[0-9]+)?)|(10(\\.0+)?)");

	}

	public static Boolean isTitulaZvanje(String s) {
		return s.matches("[\\p{IsAlphabetic}]+([ ]*[ \\.-]?[ ]*[\\p{IsAlphabetic}]+)*\\.?");
	}

	public static Boolean isBrojLicne(String s) {
		return s.matches("[0-9]{9}");
	}

	public static Boolean matchesSearchFormat(String s) {
		return s.matches("(([^;:]+):([^;:]+);)*(([^;:]+):([^;:]+))?");
	}

	public static boolean isLocalDate(String s) {
		try {
			LocalDate parsed = LocalDate.parse(s);
			if (parsed.compareTo(LocalDate.now()) > 0)
				return false;
			else
				return true;
		} catch (DateTimeParseException e) {
			return false;
		}
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
