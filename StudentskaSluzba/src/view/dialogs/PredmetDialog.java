/**
 * 
 */
package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainController;
import model.Predmet;
import view.validity_utils.ErrorLabel;
import view.validity_utils.Validator;
import view.validity_utils.ValidityListener;

/**
 * Dijalog za dodavanje i izmjenu predmeta.
 * 
 * @author Milana Todorovic ra3-2017
 *
 */
public class PredmetDialog extends JDialog {

	private static final long serialVersionUID = 6152827497814076114L;

	private static final int ALL_VALID = 0b11;
	private static final int SIFRA_VALID = 0b01;
	private static final int NAZIV_VALID = 0b10;

	private int validity;

	private JFrame parent;
	private JTextField sifra;
	private ErrorLabel sifraError;
	private JTextField naziv;
	private ErrorLabel nazivError;
	private JComboBox<String> godina;
	private ErrorLabel godinaWarning;
	private JComboBox<String> semestar;
	private JButton dodaj;
	private JButton izmeni;

	private Predmet currentlyEditing;

	/**
	 * @param owner
	 */
	public PredmetDialog(JFrame parent) {
		super(parent, "", true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.parent = parent;

		int minwidth = this.makeItems();

		// dodaj.setVisible(false);
		// izmeni.setVisible(false);

		this.setMinimumSize(new Dimension(minwidth, 0));
	}

	/**
	 * Metoda koja rasporedjuje komponente unutar prozora.
	 * 
	 * @return minimalna sirina prozora
	 */
	private int makeItems() {
		this.makeTextFields();
		this.makeGodinaComboBox();

		String[] semestri = { "I (zimski)", "II (letnji)" };
		this.semestar = new JComboBox<String>(semestri);

		JPanel content = new JPanel(new GridBagLayout());
		content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		this.add(content, BorderLayout.CENTER);

		content.add(new JLabel("\u0160ifra predmeta*: "), new GridBagConstraints(0, 0, 1, 1, 0, 100,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.sifra, new GridBagConstraints(1, 0, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.sifraError, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Naziv predmeta*: "), new GridBagConstraints(0, 1, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.naziv, new GridBagConstraints(1, 1, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.nazivError, new GridBagConstraints(3, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Godina*: "), new GridBagConstraints(0, 2, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.godina, new GridBagConstraints(1, 2, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.godinaWarning, new GridBagConstraints(3, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Semestar*: "), new GridBagConstraints(0, 3, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.semestar, new GridBagConstraints(1, 3, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.add(makeAddButton());
		buttons.add(makeSaveChangesButton());
		buttons.add(Box.createHorizontalStrut(15));
		buttons.add(makeReturnButton());

		content.add(buttons, new GridBagConstraints(0, 4, 3, 1, 100, 100, GridBagConstraints.EAST,
				GridBagConstraints.VERTICAL, new Insets(15, 10, 0, 10), 0, 0));

		return buttons.getMinimumSize().width + 70;
	}

	/**
	 * Metoda koja inicijalizuje polja za unos teksta i validaciju.
	 */
	private void makeTextFields() {
		this.sifra = new JTextField();
		this.sifraError = new ErrorLabel(this.getBackground(), Color.RED);
		this.sifra.getDocument().addDocumentListener(new ValidityListener() {

			public void checkValidity(String s) {
				String s1 = s.trim();
				boolean valid;

				if (s1.isEmpty()) {
					sifraError.invalidNotNull();
					valid = false;
				} else if (!Validator.isAlphanumeric(s1)) {
					sifraError.invalidCharacter();
					valid = false;
				} else {
					Predmet found = MainController.getInstance().getPredmetiController().findByID(s1.toUpperCase());
					if (found == currentlyEditing || found == null) {
						sifraError.valid();
						valid = true;
					} else {
						sifraError.invalidUnique();
						valid = false;
					}
				}

				if (valid) {
					validity = validity | SIFRA_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				} else {
					validity = validity & ~(SIFRA_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				}
			}

		});

		this.naziv = new JTextField();
		this.nazivError = new ErrorLabel(this.getBackground(), Color.RED,
				"re\u010di ili brojevi razdvojeni razmacima ili crticom");
		this.naziv.getDocument().addDocumentListener(new ValidityListener() {

			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					nazivError.invalidNotNull();
					valid = false;
				} else if (!Validator.isAlphanumericWithSeparators(s1)) {
					nazivError.invalidCharacter();
					valid = false;
				} else if (!Validator.isNazivPredmeta(s1)) {
					nazivError.invalidFormat();
					valid = false;
				} else {
					nazivError.valid();
					valid = true;
				}

				if (!valid) {
					validity = validity & ~(NAZIV_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | NAZIV_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}
			}

		});
	}

	/**
	 * Metoda koja inicijalizuje combo box za izbor godine i upozorenje za korisnika
	 * ako ce izmena dovesti do brisanja veza.
	 */
	private void makeGodinaComboBox() {
		String[] godine = { "I (prva)", "II (druga)", "III (tre\u0107a)", "IV (\u010Detvrta)" };
		this.godina = new JComboBox<String>(godine);
		this.godinaWarning = new ErrorLabel(this.getBackground(), Color.ORANGE);

		this.godina.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (currentlyEditing != null && !currentlyEditing.getStudenti().isEmpty()
							&& currentlyEditing.getGodina() != (godina.getSelectedIndex() + 1)) {
						godinaWarning.invalid("Ovom izmenom se gube veze sa studentima " + currentlyEditing.getGodina()
								+ ". godine koji trenutno slu\u0161aju predmet.");
					} else
						godinaWarning.valid();
				}
			}

		});
	}

	/**
	 * @return dugme za dodavanje predmeta
	 */
	private JButton makeAddButton() {
		dodaj = new JButton("Dodaj");
		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Object> values = new HashMap<String, Object>();
				values.put(Predmet.keys[0], sifra.getText().trim().toUpperCase());
				values.put(Predmet.keys[1], naziv.getText().trim());
				values.put(Predmet.keys[2], godina.getSelectedIndex() + 1);
				values.put(Predmet.keys[3], godina.getSelectedIndex() * 2 + semestar.getSelectedIndex() + 1);

				if (MainController.getInstance().getPredmetiController().addPredmet(values)) {
					dispose();
				} else {
					JOptionPane.showMessageDialog(PredmetDialog.this, "Gre\u0161ka pri dodavanju!", "Gre\u0161ka!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		return dodaj;
	}

	/**
	 * @return dugme za cuvanje izmena na postojecem predmetu
	 */
	private JButton makeSaveChangesButton() {
		izmeni = new JButton("Sa\u010Duvaj izmene");
		izmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Object> values = new HashMap<String, Object>();
				values.put(Predmet.keys[0], sifra.getText().trim().toUpperCase());
				values.put(Predmet.keys[1], naziv.getText().trim());
				values.put(Predmet.keys[2], godina.getSelectedIndex() + 1);
				values.put(Predmet.keys[3], godina.getSelectedIndex() * 2 + semestar.getSelectedIndex() + 1);

				MainController.getInstance().getPredmetiController().updatePredmet(values);
				dispose();
			}
		});

		return izmeni;
	}

	/**
	 * @return dugme za zatvaranje prozora
	 */
	private JButton makeReturnButton() {
		JButton nazad = new JButton("Odustani");

		nazad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		return nazad;
	}

	/**
	 * Metoda koja priprema prozor za izmenu postojeceg predmeta i prikazuje ga.
	 * 
	 * @param predmet
	 */
	public void editMode(Predmet predmet) {
		this.setTitle("Izmena predmeta");

		validity = ALL_VALID;

		currentlyEditing = predmet;

		sifra.setText(predmet.getSifraPredmeta());
		naziv.setText(predmet.getNazivPredmeta());
		godina.setSelectedIndex(predmet.getGodina() - 1);
		semestar.setSelectedIndex((predmet.getSemestar() - 1) % 2);

		dodaj.setVisible(false);
		izmeni.setEnabled(true);
		izmeni.setVisible(true);

		Dimension d = parent.getSize();
		this.setSize(d.width / 3, d.height / 2);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

	/**
	 * Metoda koja priprema prozor za dodavanje novog predmeta i prikazuje ga.
	 */
	public void addMode() {
		this.setTitle("Dodavanje predmeta");

		validity = 0b00;

		currentlyEditing = null;

		sifra.setText("");
		sifraError.valid();
		naziv.setText("");
		nazivError.valid();
		godina.setSelectedIndex(0);
		semestar.setSelectedIndex(0);

		izmeni.setVisible(false);
		dodaj.setEnabled(false);
		dodaj.setVisible(true);

		Dimension d = parent.getSize();
		this.setSize(d.width / 3, d.height / 2);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

}
