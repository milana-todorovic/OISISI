/**
 * 
 */
package view.dialogs.dodavanjeProfesoraNaPredmet;

import javax.swing.table.AbstractTableModel;

import controller.MainController;
import model.Profesor;

/**
 * Model tabele koja sadrzi String predstave profesora u bazi.
 * 
 * @author Milana Todorovic ra3-2017
 *
 */
public class MiniProfesoriTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -1047010747702653738L;

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public int getRowCount() {
		return MainController.getInstance().getProfesoriController().getBrojProfesora();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int column) {
		return "";
	}

	@Override
	public Class<?> getColumnClass(int c) {
		return String.class;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Profesor profesor = MainController.getInstance().getProfesoriController().getProfesor(rowIndex);
		return profesor.toString();
	}

}
