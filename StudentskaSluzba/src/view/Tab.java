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
		return table.getSelectedRow();
	}

}
