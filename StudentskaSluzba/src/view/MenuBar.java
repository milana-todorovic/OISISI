package view;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import view.actions.AboutAction;
import view.actions.Actions;
import view.actions.CloseAction;
import view.actions.HelpAction;

/**
 * @author Ana Perisic ra1-2017
 * 
 */
public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -6328685449891145520L;

	public MenuBar(Actions actions) {

		JMenu file = new JMenu("Fajl");
		file.setMnemonic(KeyEvent.VK_F);

		file.add(actions.getNewAction());
		file.addSeparator();
		file.add(new CloseAction());

		JMenu edit = new JMenu("Izmeni");
		edit.setMnemonic(KeyEvent.VK_I);

		edit.add(actions.getEditAction());
		edit.addSeparator();
		edit.add(actions.getDeleteAction());

		JMenu help = new JMenu("Pomo\u0107");
		help.setMnemonic(KeyEvent.VK_P);
		help.add(new HelpAction());
		help.addSeparator();
		help.add(new AboutAction());		

		add(file);
		add(edit);
		add(help);
	}

}
