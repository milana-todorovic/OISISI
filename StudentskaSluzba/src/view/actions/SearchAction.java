/**
 * 
 */
package view.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import controller.MainController;
import view.Toolbar;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class SearchAction extends AbstractAction {

	private static final long serialVersionUID = 9053670109484166109L;

	private Toolbar tb;

	public SearchAction(Toolbar tb) {
		putValue(NAME, "Pretra\u017Ei");
		putValue(SHORT_DESCRIPTION, "Pretra\u017Ei (Ctrl+F)");
		putValue(SMALL_ICON, new ImageIcon("resource/search.png"));

		this.tb = tb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String searchText = tb.searchStarted();
		
		MainController.getInstance().startSearch(searchText.trim());
	}

}
