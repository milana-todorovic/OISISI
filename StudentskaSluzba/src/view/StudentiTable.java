/**
 * 
 */
package view;

import java.util.ArrayList;

import javax.swing.JTable;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class StudentiTable extends JTable {

	private static final long serialVersionUID = 8822624983929257245L;

	public StudentiTable() {
		super();
		this.setModel(new StudentiTableModel());
		ListRenderer renderer = new ListRenderer(this, "Spisak predmeta");
		this.setDefaultRenderer(ArrayList.class, renderer);
		this.setDefaultEditor(ArrayList.class, renderer);
		this.addMouseListener(renderer);
	}
}
