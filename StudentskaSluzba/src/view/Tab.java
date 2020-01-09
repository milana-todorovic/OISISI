/**
 * 
 */
package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class Tab extends JPanel {

	private static final long serialVersionUID = 5969935635528507723L;

	private JTable table;

	public Tab(JTable table) {
		super();

		this.setLayout(new BorderLayout());

		this.table = table;
		/*
		 * TODO Ako je potrebno pozvati neke metode iz JTable za sve tri tabele, staviti
		 * ovde
		 */
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(new EmptyBorder(30, 20, 20, 20));
		scroll.getViewport().add(table, null);
		this.add(scroll, BorderLayout.CENTER);
	}

	/**
	 * @return selektovani red u tabeli
	 */
	public int getSelectedRow() {
		int index = table.getSelectedRow();
		return (index == -1) ? index : table.convertRowIndexToModel(index);
	}

	/**
	 * Selektuje parametar index u tabeli ako je moguce, ako nije brise selekciju.
	 * 
	 * @param index
	 */
	public void setSelectedRow(int index) {
		try {
			int viewIndex = table.convertRowIndexToView(index);
			table.setRowSelectionInterval(viewIndex, viewIndex);
		} catch (IllegalArgumentException | IndexOutOfBoundsException e) {
			table.clearSelection();
		}
	}

	/**
	 * @return model tabele
	 */
	public AbstractTableModel getModel() {
		return (AbstractTableModel) table.getModel();
	}

	/**
	 * @return sorter tabele
	 */
	public TableRowSorter<?> getRowSorter() {
		return (TableRowSorter<?>) table.getRowSorter();
	}

}
