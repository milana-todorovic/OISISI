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
public class PredmetiTable extends JTable {

	private static final long serialVersionUID = -3478162967519031093L;

	private TableRowSorter<PredmetiTableModel> sorter;

	public PredmetiTable() {
		super();
		PredmetiTableModel model = new PredmetiTableModel();
		this.setModel(model);

		sorter = new TableRowSorter<PredmetiTableModel>(model);
		sorter.setSortable(model.getColumnCount() - 1, false);
		sorter.setSortable(model.getColumnCount() - 3, false);
		this.setRowSorter(sorter);

		ListRenderer renderer = new ListRenderer(this, "Spisak studenata");
		this.setDefaultRenderer(ArrayList.class, renderer);
		this.setDefaultEditor(ArrayList.class, renderer);
		this.addMouseListener(renderer);
	}

}
