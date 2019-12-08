/**
 * 
 */
package view;

import java.util.List;

import javax.swing.JFrame;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class DialogHandler {

	private ListDialog listDialog;

	/**
	 * Konstruktor koji instancira sve cesto koristene dijaloge
	 * 
	 * @param parent
	 */
	public DialogHandler(JFrame parent) {
		super();

		this.listDialog = new ListDialog(parent);
	}

	public void showListDialog(String title, List<?> value) {
		listDialog.show(title, value);
	}

}
