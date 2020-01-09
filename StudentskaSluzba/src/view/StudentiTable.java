/**
 * 
 */
package view;

import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class StudentiTable extends JTable {

	private static final long serialVersionUID = 8822624983929257245L;

	private TableRowSorter<StudentiTableModel> sorter;

	public StudentiTable() {
		super();
		StudentiTableModel model = new StudentiTableModel();
		this.setModel(model);

		sorter = new TableRowSorter<StudentiTableModel>(model);
		sorter.setComparator(0, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String oznakaSmera1 = o1.substring(0, 3);
				String oznakaSmera2 = o2.substring(0, 3);

				if (oznakaSmera1.equals(oznakaSmera2)) {
					String o1godBroj = o1.substring(3);
					String o2godBroj = o2.substring(3);

					String[] splits1 = o1godBroj.split("/");
					String[] splits2 = o2godBroj.split("/");

					if (splits1[1].equals(splits2[1])) {
						if (Integer.parseInt(splits1[0]) < Integer.parseInt(splits2[0])) {
							return -1;
						} else if (Integer.parseInt(splits1[0]) > Integer.parseInt(splits2[0])) {
							return 1;
						} else {
							return 0;
						}
					} else if (Integer.parseInt(splits1[1]) < Integer.parseInt(splits2[1])) {
						return -1;
					} else {
						return 1;
					}

				} else {
					return o1.compareTo(o2);
				}
			}

		});
		sorter.setSortable(model.getColumnCount() - 1, false);
		sorter.setSortable(model.getColumnCount() - 3, false);
		sorter.setSortable(model.getColumnCount() - 4, false);
		sorter.setSortable(model.getColumnCount() - 5, false);
		sorter.setSortable(model.getColumnCount() - 9, false);

		this.setRowSorter(sorter);

		ListRenderer renderer = new ListRenderer(this, "Spisak predmeta");
		this.setDefaultRenderer(ArrayList.class, renderer);
		this.setDefaultEditor(ArrayList.class, renderer);
		this.addMouseListener(renderer);
	}
}
