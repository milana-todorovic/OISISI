/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * Renderer namenjen za prikaz listi. Unutar celije se iscrtava dugme, a
 * pritiskom na njega sadrzaj liste se prikazuje u ListDialog-u.
 * 
 * @author Milana Todorovic ra3-2017
 *
 */
public class ListRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, MouseListener {

	private static final long serialVersionUID = 6698412334481961318L;
	private JButton rendererButton;
	private JButton editorButton;
	private boolean editing;
	private JTable table;
	@SuppressWarnings("unused")
	private String title;
	private List<?> value;

	public ListRenderer(JTable table, String title) {
		this.rendererButton = new JButton("Prika\u017Ei...");
		this.editorButton = new JButton("Prika\u017Ei...");
		this.table = table;
		this.editing = false;
		this.title = title;

		this.rendererButton.setBorderPainted(false);
		this.rendererButton.setOpaque(true);
		this.editorButton.setBorderPainted(false);
		this.editorButton.setOpaque(true);
		editorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				// new ListDialog(MainFrame.getInstance(), title, value);
				MainFrame.getInstance().getDialogHandler().showListDialog(title, value);
			}

		});
	}

	@Override
	public Object getCellEditorValue() {
		return value;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.editing = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.editing && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		this.editing = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		this.value = (List<?>) value;

		return this.editorButton;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		return this.rendererButton;
	}

}
