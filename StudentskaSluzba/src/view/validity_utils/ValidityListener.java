/**
 * 
 */
package view.validity_utils;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 * Modifikacija DocumentListener-a koja provjerava validnost dokumeta pri svakoj
 * promjeni.
 * 
 * @author Milana Todorovic ra3-2017
 *
 */
public abstract class ValidityListener implements DocumentListener {

	@Override
	public void insertUpdate(DocumentEvent e) {
		try {
			checkValidity(e.getDocument().getText(0, e.getDocument().getLength()));
		} catch (BadLocationException e1) {
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		try {
			checkValidity(e.getDocument().getText(0, e.getDocument().getLength()));
		} catch (BadLocationException e1) {
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
	}

	public abstract void checkValidity(String s);

}
