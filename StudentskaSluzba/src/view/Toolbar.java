/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class Toolbar extends JPanel {

	private static final long serialVersionUID = -6204353317907193077L;

	/**
	 * Klasa koja podesava izgled dugmica na traci sa alatima.
	 *
	 */
	private class ToolbarButton extends JButton {

		private static final long serialVersionUID = 8910886936437188960L;

		/**
		 * @param tooltipText
		 * @param iconFileName - podrazumjeva se da se ikonice nalaze u source folderu
		 *                     resource
		 */
		public ToolbarButton(String tooltipText, String iconFileName) {
			super();
			this.setToolTipText(tooltipText);
			try {
				this.setIcon(new ImageIcon(Toolbar.class.getResource("/" + iconFileName)));
				this.setContentAreaFilled(false);
				this.setBorder(new EmptyBorder(10, 10, 10, 10));
			} catch (Exception e) {
			}
		}

	}

	private static final int SEARCH_NOT_ACTIVE = 0;
	private static final int SEARCH_ACTIVE = 1;

	private ToolbarButton add;
	private ToolbarButton edit;
	private ToolbarButton delete;
	private ToolbarButton addStudent;
	private ToolbarButton addProfessor;
	private JTextField search;
	private ToolbarButton startSearch;
	private ToolbarButton cancelSearch;

	private int[] searchState;
	private String[] searchText;

	public Toolbar(Tabs.TabNames state) {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		this.makeItems();
		this.initialiseActions();
		this.stateChanged(state);
	}

	/**
	 * Dodaje sve elemente na traku sa alatima.
	 */
	private void makeItems() {
		this.add = new ToolbarButton("Dodaj", "new.png");
		this.edit = new ToolbarButton("Izmeni", "edit.png");
		this.delete = new ToolbarButton("Obri\u0161i", "delete.png");
		this.addStudent = new ToolbarButton("Dodaj studenta na predmet", "student.png");
		this.addProfessor = new ToolbarButton("Dodaj profesora na predmet", "profesor.png");
		this.search = new JTextField(30);
		this.search.setMaximumSize(this.search.getPreferredSize());
		this.startSearch = new ToolbarButton("Pretra\u017Ei", "search.png");
		this.cancelSearch = new ToolbarButton("Zavr\u0161i pretragu", "cancel.png");

		this.searchState = new int[3];
		this.searchText = new String[3];
		for (int i = 0; i < 3; i++) {
			searchState[i] = SEARCH_NOT_ACTIVE;
			searchText[i] = "";
		}

		this.add(this.add);
		this.add(this.edit);
		this.add(this.delete);
		this.add(this.addStudent);
		this.add(this.addProfessor);
		this.add(Box.createHorizontalGlue());
		this.add(this.search);
		this.add(this.startSearch);
		this.add(this.cancelSearch);
	}

	private void initialiseActions() {
		this.add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().addNew();
			}

		});

		this.edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().edit();
			}

		});

		this.delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().delete();
			}

		});

		this.addStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().addStudentToSubject();
			}

		});

		this.addProfessor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().addProfessorToSubject();
			}

		});

		this.startSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Azuriranje stanja pretrage radi pravilnog prikaza pri promjeni taba
				int tab = MainFrame.getInstance().getSelectedTab().ordinal();
				searchState[tab] = SEARCH_ACTIVE;
				searchText[tab] = search.getText();
				search.setEnabled(false);
				startSearch.setVisible(false);
				cancelSearch.setVisible(true);

				/*
				 * TODO dodati odgovarajuce pozive kada budu implementirane funkcionalnosti
				 * #pretraga_studenata, #pretraga_profesora, #pretraga_predmeta
				 */
			}

		});

		this.cancelSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO dodati poziv metode kontrolera za zaustavljanje pretrage

				// Azuriranje stanja pretrage radi pravilnog prikaza pri promjeni taba
				int tab = MainFrame.getInstance().getSelectedTab().ordinal();
				searchState[tab] = SEARCH_NOT_ACTIVE;
				searchText[tab] = "";
				search.setText("");
				search.setEnabled(true);
				cancelSearch.setVisible(false);
				startSearch.setVisible(true);
			}

		});

		this.search.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				searchText[MainFrame.getInstance().getSelectedTab().ordinal()] = search.getText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchText[MainFrame.getInstance().getSelectedTab().ordinal()] = search.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

		});
	}

	/**
	 * Postavlja prikaz trake sa alatima u ispravno stanje pri promjeni taba.
	 * 
	 * @param state - trenutno selektovani tab
	 * 
	 */
	public void stateChanged(Tabs.TabNames state) {
		/*
		 * Dugmici za dodavanje profesora i studenta na predmet su vidljivi samo u tabu
		 * Predmeti
		 */
		switch (state) {
		case PREDMETI:
			this.addStudent.setVisible(true);
			this.addProfessor.setVisible(true);
			break;
		default:
			this.addStudent.setVisible(false);
			this.addProfessor.setVisible(false);
		}

		// Pretraga ostaje aktivna pri promjeni taba
		switch (searchState[state.ordinal()]) {
		case SEARCH_ACTIVE:
			search.setText(searchText[state.ordinal()]);
			search.setEnabled(false);
			startSearch.setVisible(false);
			cancelSearch.setVisible(true);
			break;
		case SEARCH_NOT_ACTIVE:
			search.setText(searchText[state.ordinal()]);
			search.setEnabled(true);
			cancelSearch.setVisible(false);
			startSearch.setVisible(true);
			break;
		}
	}

}
