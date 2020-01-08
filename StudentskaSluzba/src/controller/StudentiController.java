/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import model.Database;
import model.Student;
import view.MainFrame;
import view.StudentiTableModel;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class StudentiController {

	public int getBrojStudenata() {
		return Database.getInstance().getBrojStudenata();
	}

	public Student getStudent(int index) {
		return Database.getInstance().getStudent(index);
	}

	public void remove(int index) {
		Database.getInstance().removeStudent(index);
	}

	public boolean addStudent(Map<String, Object> values) {

		if (Database.getInstance().addStudent(values)) {
			int index = getBrojStudenata() - 1;
			MainFrame.getInstance().cancelSearch();
			MainFrame.getInstance().getTableModel().fireTableRowsInserted(index, index);
			MainFrame.getInstance().setSelectedRow(index);
			return true;
		} else {
			return false;
		}
	}

	public void updateStudent(Map<String, Object> values) {
		int index = MainFrame.getInstance().getSelectedRow();
		Database.getInstance().updateStudent(index, values);
		MainFrame.getInstance().cancelSearch();
		MainFrame.getInstance().getTableModel().fireTableDataChanged();
		MainFrame.getInstance().setSelectedRow(index);
	}

	public void startSearch(String searchParam) {
		String[] splits = searchParam.split(";");
		ArrayList<RowFilter<StudentiTableModel, Integer>> filters = new ArrayList<RowFilter<StudentiTableModel, Integer>>();
		Map<String, Integer> keys = StudentiTableModel.validKeywords;

		for (String string : splits) {
			int separator = string.indexOf(":");
			filters.add(RowFilter.regexFilter("(?ui)" + string.substring(separator + 1).trim(),
					keys.get(string.substring(0, separator).trim())));
		}

		RowFilter<StudentiTableModel, Integer> filter = RowFilter.andFilter(filters);
		@SuppressWarnings("unchecked")
		TableRowSorter<StudentiTableModel> sorter = ((TableRowSorter<StudentiTableModel>) MainFrame.getInstance()
				.getRowSorter());
		sorter.setRowFilter(filter);
	}

	public Student findByInd(String brIndeksa) {
		return Database.getInstance().findStudentByInd(brIndeksa);
	}

}
