/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setTitle(title);
		// TODO Postaviti ikonicu?

		this.addMenu();
		this.addTabs();
		this.addToolbar();
		this.addStatusBar();

		this.setVisible(true);
	}

	/**
	 * Dodaje meni na glavni prozor aplikacije.
	 */
	private void addMenu() {
		// TODO Dodati tijelo kada funkcionalnost #menu_bar bude zavrsena.

	}

	/**
	 * Dodaje toolbar na glavni prozor aplikacije.
	 */
	private void addToolbar() {
		this.toolbar = new Toolbar(Tabs.TabNames.STUDENTI);
		this.add(toolbar, BorderLayout.NORTH);
	}

	/**
	 * Dodaje panel sa tabovima na glavni prozor aplikacije.
	 */
	private void addTabs() {
		/*
		 * TODO Zamjeniti pozive konstruktora JTable() tacnim pozivima kada budu
		 * zavrsene funkcionalnosti #student, #profesor, #predmet.
		 */
		tabs = new Tabs(new JTable(), new JTable(), new JTable());
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
		// TODO Dodati tijelo kada funkcionalnost #status_bar bude zavrsena.

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

}
