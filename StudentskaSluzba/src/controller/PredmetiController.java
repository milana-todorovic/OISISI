/**
 * 
 */
package controller;

import java.util.Map;

import model.Database;
import model.Predmet;
import view.MainFrame;

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
		MainFrame.getInstance().getTableModel().fireTableDataChanged();
		MainFrame.getInstance().setSelectedRow(index);
	}

}
