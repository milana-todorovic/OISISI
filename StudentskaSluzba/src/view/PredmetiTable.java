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
public class PredmetiTable extends JTable {

	private static final long serialVersionUID = -3478162967519031093L;

	public PredmetiTable() {
		super();
		this.setModel(new PredmetiTableModel());
		ListRenderer renderer = new ListRenderer(this, "Spisak studenata");
		this.setDefaultRenderer(ArrayList.class, renderer);
		this.setDefaultEditor(ArrayList.class, renderer);
	}

}
