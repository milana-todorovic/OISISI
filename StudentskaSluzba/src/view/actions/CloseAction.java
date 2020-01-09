/**
 * 
 */
package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import view.MainFrame;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class CloseAction extends AbstractAction {

	private static final long serialVersionUID = -6551476711480419837L;

	public CloseAction() {
		putValue(NAME, "Zatvori");
		putValue(MNEMONIC_KEY, KeyEvent.VK_Z);
		putValue(SMALL_ICON, new ImageIcon("resource/cancel.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().dispatchEvent(new WindowEvent(MainFrame.getInstance(), WindowEvent.WINDOW_CLOSING));
	}

}
