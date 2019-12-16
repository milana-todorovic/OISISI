/**
 * 
 */
package view;

import java.util.ArrayList;

import javax.swing.JTable;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class ProfesoriTable extends JTable {

	private static final long serialVersionUID = 2696405798928324610L;

	public ProfesoriTable() {
		super();
		this.setModel(new ProfesoriTableModel());
		ListRenderer renderer = new ListRenderer(this, "Spisak predmeta");
		this.setDefaultRenderer(ArrayList.class, renderer);
		this.setDefaultEditor(ArrayList.class, renderer);
		this.addMouseListener(renderer);
	}

}
