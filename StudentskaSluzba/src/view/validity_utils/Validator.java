/**
 * 
 */
package view.validity_utils;

/**
 * Klasa koja nudi metode za provjeru poklapanja stringa sa odredjenim
 * formatima.
 * 
 * @author Milana Todorovic ra3-2017
 *
 */
public class Validator {

	public static Boolean isAlphanumeric(String s) {
		return s.matches("[a-zA-Z0-9]*");
	}

}
