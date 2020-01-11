/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import controller.MainController;
import view.actions.Actions;
import view.dialogs.DialogHandler;
import view.tables.predmeti.PredmetiTable;
import view.tables.profesori.ProfesoriTable;
import view.tables.studenti.StudentiTable;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 8456560429229699542L;

	private static MainFrame instance;
	private String title = "Studentska slu\u017Eba";
	private Tabs tabs;
	private Toolbar toolbar;

	private DialogHandler dialogHandler;
	private Actions actions;

	/**
	 * @return the instance
	 */
	public static MainFrame getInstance() {
		if (instance == null)
			instance = new MainFrame();

		return instance;
	}

	/**
	 * @throws HeadlessException
	 */
	private MainFrame() throws HeadlessException {
		super();

		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int) (0.75 * screenDimension.getWidth()), (int) (0.75 * screenDimension.getHeight()));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int choice = JOptionPane.showConfirmDialog(e.getComponent(),
						"Da li ste sigurni da \u017Eelite da zatvorite aplikaciju?", "Zatvaranje aplikacije",
						JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					if (!MainController.getInstance().saveDatabase())
						JOptionPane.showMessageDialog(e.getComponent(), "Doslo je do gre\u0161ke pri \u010duvanju podataka!",
								"Zatvaranje aplikacije", JOptionPane.INFORMATION_MESSAGE);
					setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
			}
		});

		this.setAesthetic();

		this.actions = new Actions();

		this.addMenu();
		this.addTabs();
		this.addToolbar();
		this.addStatusBar();

		this.dialogHandler = new DialogHandler(this);

		this.setVisible(true);
	}

	private void setAesthetic() {
		this.setTitle(title);
		// TODO Postaviti ikonicu?

		// Postavljanje teksta za dijaloge
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Ne");
		UIManager.put("OptionPane.cancelButtonText", "Otka\u017Ei");
		UIManager.put("OptionPane.okButtonText", "OK");
	}

	/**
	 * Dodaje traku sa menijima na glavni prozor aplikacije.
	 */
	private void addMenu() {
		MenuBar menu = new MenuBar(actions);
		this.setJMenuBar(menu);
	}

	/**
	 * Dodaje traku sa alatima na glavni prozor aplikacije.
	 */
	private void addToolbar() {
		this.toolbar = new Toolbar(Tabs.TabNames.STUDENTI, this.actions);
		this.add(toolbar, BorderLayout.NORTH);
	}

	/**
	 * Dodaje panel sa tabovima na glavni prozor aplikacije.
	 */
	private void addTabs() {

		tabs = new Tabs(new StudentiTable(), new ProfesoriTable(), new PredmetiTable());
		this.add(tabs, BorderLayout.CENTER);

		tabs.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				toolbar.stateChanged(tabs.getSelectedTab());

			}

		});
	}

	/**
	 * Dodaje statusnu traku na glavni prozor aplikacije.
	 */
	private void addStatusBar() {
		StatusBar statusBar = new StatusBar(title);
		this.add(statusBar, BorderLayout.SOUTH);
	}

	/**
	 * @return trenutno selektovani tab
	 */
	public Tabs.TabNames getSelectedTab() {
		return tabs.getSelectedTab();
	}

	/**
	 * @return trenutno selektovani red tabele u trenutno selektovanom tabu
	 */
	public int getSelectedRow() {
		return tabs.getSelectedRow();
	}

	/**
	 * @return trenutno selektovani red tabele u trenutno selektovanom tabu
	 */
	public void setSelectedRow(int index) {
		tabs.setSelectedRow(index);
	}

	/**
	 * @return model trenutno prikazane tabele
	 */
	public AbstractTableModel getTableModel() {
		return tabs.getTableModel();
	}

	/**
	 * @return sorter trenutno prikazane tabele
	 */
	public TableRowSorter<?> getRowSorter() {
		return tabs.getRowSorter();
	}

	/**
	 * @return the dialogHandler
	 */
	public DialogHandler getDialogHandler() {
		return dialogHandler;
	}

	/**
	 * Otvara prozor za dodavanje profesora, predmeta, ili studenta.
	 */
	public void launchAdd() {
		this.dialogHandler.launchAdd(this.getSelectedTab());
	}

	/**
	 * @return the actions
	 */
	public Actions getActions() {
		return actions;
	}

	/**
	 * Metoda za programsko pritiskanje dugmeta za zaustavljanje pretrage.
	 */
	public void cancelSearch() {
		toolbar.cancelSearch();
	}

}
