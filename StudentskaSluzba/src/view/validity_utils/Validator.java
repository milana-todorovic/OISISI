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
 *
 */
public class Validator {

	public static Boolean isAlphanumeric(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9]*");
	}

	public static Boolean isNazivPredmeta(String s) {
		return s.matches("[\\p{IsAlphabetic}0-9]+([ ]*-?[ ]*[\\p{IsAlphabetic}0-9]+)*");
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
