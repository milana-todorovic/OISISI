/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
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

		this.setAesthetic();

		this.addMenu();
		this.addTabs();
		this.addToolbar();
		this.addStatusBar();

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
		// TODO Dodati tijelo kada funkcionalnost #menu_bar bude zavrsena

	}

	/**
	 * Dodaje traku sa alatima na glavni prozor aplikacije.
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
		 * zavrsene funkcionalnosti #student, #profesor, #predmet
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
		// TODO Dodati tijelo kada funkcionalnost #status_bar bude zavrsena

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
	 * U zavisnosti od trenutno selektovanog taba otvara dijalog za dodavanje
	 * studenta, predmeta, ili profesora.
	 */
	public void addNew() {
		switch (tabs.getSelectedTab()) {
		case STUDENTI:
			// TODO dodati kada bude implementirana funkcionalnost #dodavanje_studenta
			break;
		case PROFESORI:
			// TODO dodati kada bude implementirana funkcionalnost #dodavanje_profesora
			break;
		case PREDMETI:
			// TODO dodati kada bude implementirana funkcionalnost #dodavanje_predmeta
			break;
		}
	}

	/**
	 * U zavisnosti od trenutno selektovanog taba otvara dijalog za izmjenu
	 * selektovanog studenta, predmeta, ili profesora.
	 */
	public void edit() {
		if (tabs.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Nije izabrana stavka za izmenu!", title, JOptionPane.ERROR_MESSAGE);
			return;
		}

		switch (tabs.getSelectedTab()) {
		case STUDENTI:
			// TODO dodati kada bude implementirana funkcionalnost izmena_studenta
			break;
		case PROFESORI:
			// TODO dodati kada bude implementirana funkcionalnost izmena_profesora
			break;
		case PREDMETI:
			// TODO dodati kada bude implementirana funkcionalnost izmena_predmeta
			break;
		}
	}

	/**
	 * U zavisnosti od trenutno selektovanog taba poziva metodu za brisanje
	 * selektovanog studenta, predmeta, ili profesora.
	 */
	public void delete() {
		if (tabs.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Nije izabrana stavka za brisanje!", title, JOptionPane.ERROR_MESSAGE);
			return;
		}

		int choice = JOptionPane.showConfirmDialog(this,
				"Da li ste sigurni da \u017Elite da obri\u0161ete izabranu stavku?", title, JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			switch (tabs.getSelectedTab()) {
			case STUDENTI:
				// TODO dodati kada bude implementirana funkcionalnost brisanje_studenta
				break;
			case PROFESORI:
				// TODO dodati kada bude implementirana funkcionalnost brisanje_profesora
				break;
			case PREDMETI:
				// TODO dodati kada bude implementirana funkcionalnost brisanje_predmeta
				break;
			}
		}
	}

	/**
	 * Otvara dijalog za dodavanje studenta na predmet.
	 */
	public void addStudentToSubject() {
		if (tabs.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Nije izabran predmet na koji treba dodati studenta!", title,
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		/*
		 * TODO dodati tijelo kada bude implementirana funkcionalnost
		 * #dodavanje_studenta_na_predmet
		 */
	}

	/**
	 * Otvara dijalog za dodavanje profesora na predmet.
	 */
	public void addProfessorToSubject() {
		if (tabs.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Nije izabran predmet na koji treba dodati profesora!", title,
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		/*
		 * TODO dodati tijelo kada bude implementirana funkcionalnost
		 * #dodavanje_profesora_na_predmet
		 */
	}

}
