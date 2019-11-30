/**
 * 
 */
package view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class Toolbar extends JPanel {

	private static final long serialVersionUID = -6204353317907193077L;

	/**
	 * Klasa koja podesava izgled dugmica na toolbaru.
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

	private ToolbarButton add;
	private ToolbarButton edit;
	private ToolbarButton delete;
	private ToolbarButton addStudent;
	private ToolbarButton addProfessor;
	private JTextField search;
	private ToolbarButton startSearch;
	private ToolbarButton cancelSearch;

	public Toolbar(Tabs.TabNames state) {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		this.makeItems();
		// TODO dodati listenere i akceleratore na dugmice
		this.stateChanged(state);
	}

	/**
	 * Dodaje sve elemente na toolbar.
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
		this.cancelSearch = new ToolbarButton("Zaustavi pretragu", "cancel.png");

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

	/**
	 * Postavlja prikaz toolbara u ispravno stanje pri promjeni taba.
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

		// TODO dodati pracenje stanja pretrage u tabovima
		this.cancelSearch.setVisible(false);
	}

}
