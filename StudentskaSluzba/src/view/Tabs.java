/**
 * 
 */
package view;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class Tabs extends JTabbedPane {

	private static final long serialVersionUID = -2949880040869967205L;

	public static enum TabNames {
		STUDENTI, PROFESORI, PREDMETI;
		private String[] names = { "Studenti", "Profesori", "Predmeti" };

		@Override
		public String toString() {
			return names[this.ordinal()];
		}

		/**
		 * @param i - indeks taba
		 * @return - logicka vrijednost taba na zadatom indeksu
		 */
		private static TabNames get(int i) {
			switch (i) {
			case 2:
				return PREDMETI;
			case 1:
				return PROFESORI;
			default:
				return STUDENTI;
			}
		}
	}

	public Tabs(JTable studentiTabela, JTable profesoriTabela, JTable predmetiTabela) {
		super();

		this.add(TabNames.STUDENTI.toString(), new Tab(studentiTabela));
		this.add(TabNames.PROFESORI.toString(), new Tab(profesoriTabela));
		this.add(TabNames.PREDMETI.toString(), new Tab(predmetiTabela));
	}

	/**
	 * @return trenutno selektovani tab, konvertovan u konstantu enumeracije
	 *         TabNames
	 */
	public TabNames getSelectedTab() {
		return TabNames.get(this.getSelectedIndex());
	}

	/**
	 * @return trenutno selektovani red tabele u trenutno selektovanom tabu
	 */
	public int getSelectedRow() {
		Tab selected = (Tab) this.getSelectedComponent();
		return selected.getSelectedRow();
	}
	
	public void updateTable() {
		Tab selected = (Tab) this.getSelectedComponent();
		selected.updateTable();
	}

}
