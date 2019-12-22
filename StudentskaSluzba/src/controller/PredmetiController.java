/**
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import model.Database;
import model.Predmet;
import view.MainFrame;
import view.PredmetiTableModel;

/**
 * @author Milana Todorovic ra3-2017
 *
 */
public class PredmetiController {

	public int getBrojPredmeta() {
		return Database.getInstance().getBrojPredmeta();
	}

	public Predmet getPredmet(int index) {
		return Database.getInstance().getPredmet(index);
	}

	public void remove(int index) {
		Database.getInstance().removePredmet(index);
	}

	public Predmet findByID(String sifra) {
		return Database.getInstance().findPredmetById(sifra);
	}

	public boolean addPredmet(Map<String, Object> values) {
		if (Database.getInstance().addPredmet(values)) {
			int index = getBrojPredmeta() - 1;
			MainFrame.getInstance().cancelSearch();
			MainFrame.getInstance().getTableModel().fireTableRowsInserted(index, index);
			MainFrame.getInstance().setSelectedRow(index);
			return true;
		} else {
			return false;
		}
	}

	public void updatePredmet(Map<String, Object> values) {
		int index = MainFrame.getInstance().getSelectedRow();
		Database.getInstance().updatePredmet(index, values);
		MainFrame.getInstance().cancelSearch();
		MainFrame.getInstance().getTableModel().fireTableDataChanged();
		MainFrame.getInstance().setSelectedRow(index);
	}

	public void startSearch(String searchParam) {
		String[] splits = searchParam.split(";");
		ArrayList<RowFilter<PredmetiTableModel, Integer>> filters = new ArrayList<RowFilter<PredmetiTableModel, Integer>>();
		Map<String, Integer> keys = PredmetiTableModel.validKeywords;

		for (String string : splits) {
			int separator = string.indexOf(":");
			filters.add(RowFilter.regexFilter("(?i)" + string.substring(separator + 1).trim(),
					keys.get(string.substring(0, separator).trim())));
		}

		RowFilter<PredmetiTableModel, Integer> filter = RowFilter.andFilter(filters);
		@SuppressWarnings("unchecked")
		TableRowSorter<PredmetiTableModel> sorter = ((TableRowSorter<PredmetiTableModel>) MainFrame.getInstance()
				.getRowSorter());
		sorter.setRowFilter(filter);
	}

}
