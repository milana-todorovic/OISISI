/**
 * 
 */
package view;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class ProfesoriTable extends JTable {

	private static final long serialVersionUID = 2696405798928324610L;

	private TableRowSorter<ProfesoriTableModel> sorter;

	public ProfesoriTable() {
		super();
		ProfesoriTableModel model = new ProfesoriTableModel();
		this.setModel(model);

		sorter = new TableRowSorter<ProfesoriTableModel>(model);
		sorter.setSortable(10, false);
		sorter.setSortable(9, false);
		sorter.setSortable(8, false);
		sorter.setSortable(7, false);
		sorter.setSortable(6, false);
		sorter.setSortable(5, false);
		sorter.setSortable(4, false);
		sorter.setSortable(3, false);
		this.setRowSorter(sorter);

		ListRenderer renderer = new ListRenderer(this, "Spisak predmeta");
		this.setDefaultRenderer(ArrayList.class, renderer);
		this.setDefaultEditor(ArrayList.class, renderer);
		this.addMouseListener(renderer);
	}

}
