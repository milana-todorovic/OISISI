/**
 * 
 */
package view;

import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.Box;
import javax.swing.InputMap;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.actions.Actions;
import view.actions.CancelSearchAction;
import view.actions.ProfessorSubjectAction;
import view.actions.SearchAction;
import view.actions.StudentSubjectAction;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class Toolbar extends JToolBar {

	private static final long serialVersionUID = -6204353317907193077L;

	private static final int SEARCH_NOT_ACTIVE = 0;
	private static final int SEARCH_ACTIVE = 1;

	private static final int STUDENTS_INDEX = 3;
	private static final int PROFESSORS_INDEX = 4;
	private static final int START_SEARCH_INDEX = 7;
	private static final int CANCEL_SEARCH_INDEX = 8;

	// Instance akcija koje koristi samo toolbar
	private StudentSubjectAction studentSubject;
	private ProfessorSubjectAction professorSubject;
	private SearchAction startSearch;
	private CancelSearchAction cancelSearch;

	private JTextField search;

	private int[] searchState;
	private String[] searchText;

	public Toolbar(Tabs.TabNames initialState, Actions actions) {
		super(SwingConstants.HORIZONTAL);
		this.setFloatable(false);

		this.makeItems(actions);
		this.stateChanged(initialState);
	}

	/**
	 * Dodaje sve elemente na traku sa alatima.
	 */
	private void makeItems(Actions actions) {
		this.studentSubject = new StudentSubjectAction();
		this.professorSubject = new ProfessorSubjectAction();
		this.startSearch = new SearchAction(this);
		this.cancelSearch = new CancelSearchAction(this);

		this.initSearchField();

		this.add(actions.getNewAction());
		this.add(actions.getEditAction());
		this.add(actions.getDeleteAction());
		this.add(this.studentSubject);
		this.add(this.professorSubject);
		this.add(Box.createHorizontalGlue());
		this.add(this.search);
		this.add(this.startSearch);
		this.add(this.cancelSearch);

		this.setAccelerators();
	}

	/**
	 * Inicijalzuje polje za pretragu i stanje pretrage.
	 */
	private void initSearchField() {
		this.search = new JTextField(30);
		this.search.setMaximumSize(this.search.getPreferredSize());

		this.searchState = new int[3];
		this.searchText = new String[3];
		for (int i = 0; i < 3; i++) {
			searchState[i] = SEARCH_NOT_ACTIVE;
			searchText[i] = "";
		}

		// tekst u polju ce se cuvati pri promjeni taba i kad nije aktivna pretraga
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
	 * Postavljanje akceleratora.
	 */
	private void setAccelerators() {
		/*
		 * Akceleratori za akcije koje toolbar dijeli sa menijem su vec podeseni u
		 * konstruktorima
		 */
		InputMap inputMap = this.getInputMap(WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), "student na predmet");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK), "profesor na predmet");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK), "pretraga");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK), "kraj pretrage");
		ActionMap actionMap = this.getActionMap();
		actionMap.put("student na predmet", this.studentSubject);
		actionMap.put("profesor na predmet", this.professorSubject);
		actionMap.put("pretraga", this.startSearch);
		actionMap.put("kraj pretrage", this.cancelSearch);
	}

	/**
	 * Postavlja traku sa alatima u ispravno stanje kada se pokrene pretraga. Poziva
	 * se iz metode actionPerformed() klase SearchAction.
	 * 
	 * @return parametri pretrage
	 */
	public String searchStarted() {
		int tab = MainFrame.getInstance().getSelectedTab().ordinal();
		searchState[tab] = SEARCH_ACTIVE;
		searchText[tab] = search.getText();
		search.setEnabled(false);
		this.startSearch.setEnabled(false); // mora zbog akceleratora
		this.getComponentAtIndex(START_SEARCH_INDEX).setVisible(false);
		this.cancelSearch.setEnabled(true);
		this.getComponentAtIndex(CANCEL_SEARCH_INDEX).setVisible(true);

		return searchText[tab];
	}

	/**
	 * Postavlja traku sa alatima u ispravno stanje kada se zavrsi pretraga. Poziva
	 * se iz metode actionPerformed() klase CancelSearchAction.
	 * 
	 */
	public void searchCancelled() {
		int tab = MainFrame.getInstance().getSelectedTab().ordinal();
		this.searchState[tab] = SEARCH_NOT_ACTIVE;
		this.searchText[tab] = "";
		this.search.setText("");
		this.cancelSearch.setEnabled(false);
		this.getComponentAtIndex(CANCEL_SEARCH_INDEX).setVisible(false);
		this.search.setEnabled(true);
		this.startSearch.setEnabled(true);
		this.getComponentAtIndex(START_SEARCH_INDEX).setVisible(true);
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
			this.studentSubject.setEnabled(true);
			this.getComponentAtIndex(STUDENTS_INDEX).setVisible(true);
			this.professorSubject.setEnabled(true);
			this.getComponentAtIndex(PROFESSORS_INDEX).setVisible(true);
			break;
		default:
			this.studentSubject.setEnabled(false);
			this.getComponentAtIndex(STUDENTS_INDEX).setVisible(false);
			this.professorSubject.setEnabled(false);
			this.getComponentAtIndex(PROFESSORS_INDEX).setVisible(false);
		}

		// Pretraga ostaje aktivna pri promjeni taba
		switch (searchState[state.ordinal()]) {
		case SEARCH_ACTIVE:
			this.search.setText(searchText[state.ordinal()]);
			this.search.setEnabled(false);
			this.startSearch.setEnabled(false);
			this.getComponentAtIndex(START_SEARCH_INDEX).setVisible(false);
			this.cancelSearch.setEnabled(true);
			this.getComponentAtIndex(CANCEL_SEARCH_INDEX).setVisible(true);
			break;
		case SEARCH_NOT_ACTIVE:
			this.search.setText(searchText[state.ordinal()]);
			this.cancelSearch.setEnabled(false);
			this.getComponentAtIndex(CANCEL_SEARCH_INDEX).setVisible(false);
			this.search.setEnabled(true);
			this.startSearch.setEnabled(true);
			this.getComponentAtIndex(START_SEARCH_INDEX).setVisible(true);
			break;
		}
	}

}
