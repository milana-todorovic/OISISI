/**
 * 
 */
package view.dialogs.dodavanjeProfesoraNaPredmet;

import javax.swing.RowFilter;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class StringContainsFilter extends RowFilter<MiniProfesoriTableModel, Integer> {

	private String s;

	/**
	 * @param s
	 */
	public StringContainsFilter(String s) {
		super();
		this.s = s;
	}

	@Override
	public boolean include(Entry<? extends MiniProfesoriTableModel, ? extends Integer> entry) {
		return entry.getStringValue(0).toLowerCase().contains(s.toLowerCase());
	}

}
