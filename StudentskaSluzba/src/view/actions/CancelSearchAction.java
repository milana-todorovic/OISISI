/**
 * 
 */
package view.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import view.Toolbar;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class CancelSearchAction extends AbstractAction {

	private static final long serialVersionUID = 8604214630484114783L;
	
	private Toolbar tb;

	public CancelSearchAction(Toolbar tb) {
		putValue(SHORT_DESCRIPTION, "Zavr\u0161i pretragu (Ctrl+X)");
		putValue(SMALL_ICON, new ImageIcon("resource/cancel.png"));
		
		this.tb = tb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO dodati poziv metode kontrolera za zaustavljanje pretrage
		
		tb.searchCancelled();
	}

}
