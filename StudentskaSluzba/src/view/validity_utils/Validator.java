/**
 * 
 */
package view.validity_utils;

import java.util.Map;

/**
 * Klasa koja nudi metode za provjeru poklapanja stringa sa odredjenim
 * formatima.
 * 
 * @author Milana Todorovic ra3-2017
 *
 */
public class Validator {

	public static Boolean isAlphanumeric(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9]*");
	}

	public static Boolean isNazivPredmeta(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9 -]*");
	}

	public static Boolean matchesSearchFormat(String s) {
		return s.matches("(([^;:]+):([^;:]+);)*(([^;:]+):([^;:]+))?");
	}

	public static Boolean searchParamsValid(String s, Map<String, Integer> validParams) {
		String[] splits = s.split(";");
		for (String string : splits) {
			if (!validParams.containsKey(string.substring(0, string.indexOf(":")).toLowerCase().trim()))
				return false;
		}
		return true;
	}

}
