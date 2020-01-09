package view.dialogs.dodavanjeStudentaNaPredmet;

import javax.swing.RowFilter;

/**
 * 
 * @author Ana Perisic ra1-2017
 *
 */
public class StringContainsFilter extends RowFilter<MiniStudentiTableModel, Integer> {

	private String s;

	public StringContainsFilter(String s) {
		super();
		this.s = s;
	}

	@Override
	public boolean include(Entry<? extends MiniStudentiTableModel, ? extends Integer> entry) {
		return entry.getStringValue(0).toLowerCase().contains(s.toLowerCase());
	}

}
