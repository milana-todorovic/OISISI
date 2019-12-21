/**
 * 
 */
package controller;

import model.Database;
import model.Predmet;

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

}
