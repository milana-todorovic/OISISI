package view.dialogs.dodavanjeStudentaNaPredmet;

import javax.swing.table.AbstractTableModel;

import controller.MainController;
import model.Student;

/**
 * 
 * @author Ana Perisic ra1-2017
 *
 */
public class MiniStudentiTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -5216273073731773166L;

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public int getRowCount() {
		return MainController.getInstance().getStudentiController().getBrojStudenata();

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
		return Student.class;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student student = MainController.getInstance().getStudentiController().getStudent(rowIndex);
		return student;
	}

}
