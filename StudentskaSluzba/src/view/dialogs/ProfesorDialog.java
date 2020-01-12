package view.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainController;
import model.Profesor;
import view.validity_utils.ErrorLabel;
import view.validity_utils.Validator;
import view.validity_utils.ValidityListener;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class ProfesorDialog extends JDialog {

	private static final long serialVersionUID = 7736562367530255620L;

	private static final int ALL_VALID = 0b1111111111;
	private static final int IME_VALID = 0b0000000001;
	private static final int PREZIME_VALID = 0b0000000010;
	private static final int DATUMRODJ_VALID = 0b0000000100;
	private static final int ADRESA_VALID = 0b0000001000;
	private static final int ADRESAKANC_VALID = 0b0000010000;
	private static final int EMAIL_VALID = 0b0000100000;
	private static final int BROJTEL_VALID = 0b0001000000;
	private static final int TITULA_VALID = 0b0010000000;
	private static final int ZVANJE_VALID = 0b0100000000;
	private static final int BROJLICNE_VALID = 0b1000000000;
	private int validity;

	private JFrame parent;
	private JTextField ime;
	private ErrorLabel imeError;
	private JTextField prezime;
	private ErrorLabel prezimeError;
	private JTextField datumRodjenja;
	private ErrorLabel datumRodjenjaError;
	private JTextField adresa;
	private ErrorLabel adresaError;
	private JTextField brojTel;
	private ErrorLabel brojTelError;
	private JTextField emailAdresa;
	private ErrorLabel emailAdresaError;
	private JTextField adresaKancelarije;
	private ErrorLabel adresaKancelarijeError;
	private JTextField brojLicneKarte;
	private ErrorLabel brojLicneError;
	private JTextField titula;
	private ErrorLabel titulaError;
	private JTextField zvanje;
	private ErrorLabel zvanjeError;
	private JButton dodaj;
	private JButton izmeni;

	private Profesor currentlyEditing;

	public ProfesorDialog(JFrame parent) {
		super(parent, "", true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.parent = parent;
		this.makeItems();
	}

	private void makeItems() {
		GridBagLayout gb = new GridBagLayout();
		JPanel content = new JPanel(gb);

		content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		this.add(content, BorderLayout.CENTER);

		this.ime = new JTextField();
		this.imeError = new ErrorLabel(this.getBackground(), Color.RED, "re\u010di razdvojene razmakom ili crticom");
		this.prezime = new JTextField();
		this.prezimeError = new ErrorLabel(this.getBackground(), Color.RED,
				"re\u010di razdvojene razmakom ili crticom");
		this.datumRodjenja = new JTextField();
		this.datumRodjenjaError = new ErrorLabel(this.getBackground(), Color.RED, "yyyy-MM-dd");
		this.adresa = new JTextField();
		this.adresaError = new ErrorLabel(this.getBackground(), Color.RED,
				"re\u010di ili brojevi razdvojeni razmacima, crticom, zarezom, ili ta\u010dkom");
		this.brojTel = new JTextField();
		this.brojTelError = new ErrorLabel(this.getBackground(), Color.RED, "xxx/xxx-xxx, xxx/xxxx-xxx");

		this.emailAdresa = new JTextField();
		this.emailAdresaError = new ErrorLabel(this.getBackground(), Color.RED,
				"[slova, brojevi, donja crta, ta\u010dka]\"@\"domen");
		this.titula = new JTextField();
		this.titulaError = new ErrorLabel(this.getBackground(), Color.RED,
				"re\u010di razdvojene razmacima, crticom ili ta\u010dkom");
		this.zvanje = new JTextField();
		this.zvanjeError = new ErrorLabel(this.getBackground(), Color.RED,
				"re\u010di razdvojene razmacima, crticom ili ta\u010dkom");
		this.brojLicneKarte = new JTextField();
		this.brojLicneError = new ErrorLabel(this.getBackground(), Color.RED, "9 cifara");
		this.adresaKancelarije = new JTextField();
		this.adresaKancelarijeError = new ErrorLabel(this.getBackground(), Color.RED,
				"re\u010di ili brojevi razdvojeni razmacima, crticom, zarezom, ili ta\u010dkom");

		this.validacija();

		content.add(new JLabel("Ime*: "), new GridBagConstraints(0, 0, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.ime, new GridBagConstraints(1, 0, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.imeError, new GridBagConstraints(3, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Prezime*: "), new GridBagConstraints(0, 1, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.prezime, new GridBagConstraints(1, 1, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.prezimeError, new GridBagConstraints(3, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Datum ro\u0111enja*: "), new GridBagConstraints(0, 2, 1, 1, 0, 100,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.datumRodjenja, new GridBagConstraints(1, 2, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.datumRodjenjaError, new GridBagConstraints(3, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Adresa stanovanja*: "), new GridBagConstraints(0, 3, 1, 1, 0, 100,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.adresa, new GridBagConstraints(1, 3, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.adresaError, new GridBagConstraints(3, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Broj telefona*: "), new GridBagConstraints(0, 4, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.brojTel, new GridBagConstraints(1, 4, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.brojTelError, new GridBagConstraints(3, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("E-mail adresa*: "), new GridBagConstraints(0, 5, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.emailAdresa, new GridBagConstraints(1, 5, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.emailAdresaError, new GridBagConstraints(3, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Adresa kancelarije*: "), new GridBagConstraints(0, 6, 1, 1, 0, 100,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.adresaKancelarije, new GridBagConstraints(1, 6, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.adresaKancelarijeError, new GridBagConstraints(3, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Broj li\u010Dne karte*: "), new GridBagConstraints(0, 7, 1, 1, 0, 100,
				GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.brojLicneKarte, new GridBagConstraints(1, 7, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.brojLicneError, new GridBagConstraints(3, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Titula*: "), new GridBagConstraints(0, 8, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.titula, new GridBagConstraints(1, 8, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.titulaError, new GridBagConstraints(3, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Zvanje*: "), new GridBagConstraints(0, 9, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.zvanje, new GridBagConstraints(1, 9, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.zvanjeError, new GridBagConstraints(3, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

		buttons.add(makeConfirmButton());
		buttons.add(makeEditButton());
		buttons.add(Box.createHorizontalStrut(15));
		buttons.add(makeReturnButton());

		content.add(buttons, new GridBagConstraints(0, 12, 3, 1, 100, 100, GridBagConstraints.EAST,
				GridBagConstraints.VERTICAL, new Insets(15, 10, 0, 10), 0, 0));

	}

	private JButton makeConfirmButton() {
		dodaj = new JButton("Dodaj");
		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Object> values = new HashMap<String, Object>();
				values.put(Profesor.keys[0], ime.getText().trim());
				values.put(Profesor.keys[1], prezime.getText().trim());

				values.put(Profesor.keys[2], LocalDate.parse(datumRodjenja.getText().trim()));

				values.put(Profesor.keys[3], adresa.getText().trim());
				values.put(Profesor.keys[4], brojTel.getText().trim());
				values.put(Profesor.keys[5], emailAdresa.getText().trim());
				values.put(Profesor.keys[6], adresaKancelarije.getText().trim());
				values.put(Profesor.keys[7], brojLicneKarte.getText().trim());
				values.put(Profesor.keys[8], titula.getText().trim());
				values.put(Profesor.keys[9], zvanje.getText().trim());

				if (MainController.getInstance().getProfesoriController().addProfesor(values)) {
					dispose();
				} else {
					JOptionPane.showMessageDialog(ProfesorDialog.this, "Gre\u0161ka pri dodavanju!", "Gre\u0161ka!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		return dodaj;

	}

	private JButton makeEditButton() {
		izmeni = new JButton("Izmeni");

		izmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Object> values = new HashMap<String, Object>();
				values.put(Profesor.keys[0], ime.getText().trim());
				values.put(Profesor.keys[1], prezime.getText().trim());

				values.put(Profesor.keys[2], LocalDate.parse(datumRodjenja.getText().trim()));

				values.put(Profesor.keys[3], adresa.getText().trim());
				values.put(Profesor.keys[4], brojTel.getText().trim());
				values.put(Profesor.keys[5], emailAdresa.getText().trim());
				values.put(Profesor.keys[6], adresaKancelarije.getText().trim());
				values.put(Profesor.keys[7], brojLicneKarte.getText().trim());
				values.put(Profesor.keys[8], titula.getText().trim());
				values.put(Profesor.keys[9], zvanje.getText().trim());

				MainController.getInstance().getProfesoriController().updateProfesor(values);
				dispose();

			}
		});

		return izmeni;
	}

	private JButton makeReturnButton() {
		JButton odustani = new JButton("Odustani");

		odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		return odustani;
	}

	public void validacija() {
		this.ime.getDocument().addDocumentListener(new ValidityListener() {

			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					imeError.invalidNotNull();
					valid = false;
				} else if (!Validator.isAlphabeticWithSeparators(s1)) {
					imeError.invalidCharacter();
					valid = false;
				} else if (!Validator.isImePrezime(s1)) {
					imeError.invalidFormat();
					valid = false;
				} else {
					imeError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(IME_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | IME_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}

			}

		});
		this.prezime.getDocument().addDocumentListener(new ValidityListener() {
			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					prezimeError.invalidNotNull();
					valid = false;
				} else if (!Validator.isAlphabeticWithSeparators(s1)) {
					prezimeError.invalidCharacter();
					valid = false;
				} else if (!Validator.isImePrezime(s1)) {
					prezimeError.invalidFormat();
					valid = false;
				} else {
					prezimeError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(PREZIME_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | PREZIME_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}

			}
		});
		this.adresa.getDocument().addDocumentListener(new ValidityListener() {
			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					adresaError.invalidNotNull();
					valid = false;
				} else if (!Validator.isAlphanumericWithCommaDashDotSpace(s1)) {
					adresaError.invalidCharacter();
					valid = false;
				} else if (!Validator.isAdresa(s1)) {
					adresaError.invalidFormat();
					valid = false;
				} else {
					adresaError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(ADRESA_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | ADRESA_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}

			}
		});
		this.adresaKancelarije.getDocument().addDocumentListener(new ValidityListener() {
			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					adresaKancelarijeError.invalidNotNull();
					valid = false;
				} else if (!Validator.isAlphanumericWithCommaDashDotSpace(s1)) {
					adresaKancelarijeError.invalidCharacter();
					valid = false;
				} else if (!Validator.isAdresa(s1)) {
					adresaKancelarijeError.invalidFormat();
					valid = false;
				} else {
					adresaKancelarijeError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(ADRESAKANC_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | ADRESAKANC_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}

			}
		});
		this.brojLicneKarte.getDocument().addDocumentListener(new ValidityListener() {
			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					brojLicneError.invalidNotNull();
					valid = false;
				} else if (!Validator.isNumeric(s1)) {
					brojLicneError.invalidCharacter();
					valid = false;
				} else if (!Validator.isBrojLicne(s1)) {
					brojLicneError.invalidFormat();
					valid = false;
				} else {
					Profesor found = MainController.getInstance().getProfesoriController().findByLicna(s1);
					if (found == currentlyEditing || found == null) {
						brojLicneError.valid();
						valid = true;
					} else {
						brojLicneError.invalidUnique();
						valid = false;
					}
				}
				if (!valid) {
					validity = validity & ~(BROJLICNE_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | BROJLICNE_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}

			}
		});
		this.brojTel.getDocument().addDocumentListener(new ValidityListener() {
			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					brojTelError.invalidNotNull();
					valid = false;
				} else if (!Validator.isNumericWithSlashDash(s1)) {
					brojTelError.invalidCharacter();
					valid = false;
				} else if (!Validator.isBrojTel(s1)) {
					brojTelError.invalidFormat();
					valid = false;
				} else {
					brojTelError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(BROJTEL_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | BROJTEL_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}

			}
		});
		this.emailAdresa.getDocument().addDocumentListener(new ValidityListener() {
			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					emailAdresaError.invalidNotNull();
					valid = false;
				} else if (!Validator.isAlphanumericWithDotUnderscore(s1)) {
					emailAdresaError.invalidCharacter();
					valid = false;
				} else if (!Validator.isEmailAdresa(s1)) {
					emailAdresaError.invalidFormat();
					valid = false;
				} else {
					emailAdresaError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(EMAIL_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | EMAIL_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}

			}
		});
		this.titula.getDocument().addDocumentListener(new ValidityListener() {

			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					titulaError.invalidNotNull();
					valid = false;
				} else if (!Validator.isAlphabeticWithSeparatorsDot(s1)) {
					titulaError.invalidCharacter();
					valid = false;
				} else if (!Validator.isTitulaZvanje(s1)) {
					titulaError.invalidFormat();
					valid = false;
				} else {
					titulaError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(TITULA_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | TITULA_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}

			}

		});
		this.zvanje.getDocument().addDocumentListener(new ValidityListener() {

			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					zvanjeError.invalidNotNull();
					valid = false;
				} else if (!Validator.isAlphabeticWithSeparatorsDot(s1)) {
					zvanjeError.invalidCharacter();
					valid = false;
				} else if (!Validator.isTitulaZvanje(s1)) {
					zvanjeError.invalidFormat();
					valid = false;
				} else {
					zvanjeError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(ZVANJE_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | ZVANJE_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}

			}

		});

		this.datumRodjenja.getDocument().addDocumentListener(new ValidityListener() {
			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					datumRodjenjaError.invalidNotNull();
					valid = false;
				} else if (!Validator.isNumericWithDash(s1)) {
					datumRodjenjaError.invalidCharacter();
					valid = false;
				} else if (!Validator.isLocalDate(s1)) {
					datumRodjenjaError.invalidFormat();
					valid = false;
				} else {
					datumRodjenjaError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(DATUMRODJ_VALID);
					dodaj.setEnabled(false);
					izmeni.setEnabled(false);
				} else {
					validity = validity | DATUMRODJ_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
						izmeni.setEnabled(true);
					}
				}

			}
		});

	}

	public void editMode(Profesor profesor) {
		this.setTitle("Izmena profesora");

		this.validity = ALL_VALID;

		this.currentlyEditing = profesor;

		ime.setText(profesor.getIme());
		prezime.setText(profesor.getPrezime());
		adresa.setText(profesor.getAdresaStanovanja());
		emailAdresa.setText(profesor.getEmailAdresa());
		brojTel.setText(profesor.getBrTelefona());
		adresaKancelarije.setText(profesor.getAdresaKancelarije());
		titula.setText(profesor.getTitula());
		zvanje.setText(profesor.getZvanje());
		datumRodjenja.setText(profesor.getDatumRodjenja().toString());
		brojLicneKarte.setText(profesor.getBrojLicneKarte());

		dodaj.setVisible(false);
		izmeni.setEnabled(true);
		izmeni.setVisible(true);

		Dimension d = parent.getSize();
		this.setSize(d.width / 3, (int) (d.height * 0.75));
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

	public void addMode() {
		this.setTitle("Dodavanje profesora");

		this.validity = 0b0000000000;
		this.currentlyEditing = null;

		ime.setText("");
		imeError.valid();
		prezime.setText("");
		prezimeError.valid();
		adresa.setText("");
		adresaError.valid();
		emailAdresa.setText("");
		emailAdresaError.valid();
		brojTel.setText("");
		brojTelError.valid();
		brojLicneKarte.setText("");
		brojLicneError.valid();
		titula.setText("");
		titulaError.valid();
		zvanje.setText("");
		zvanjeError.valid();
		datumRodjenja.setText("");
		datumRodjenjaError.valid();
		adresaKancelarije.setText("");
		adresaKancelarijeError.valid();

		izmeni.setVisible(false);
		dodaj.setEnabled(false);
		dodaj.setVisible(true);

		Dimension d = parent.getSize();
		this.setSize(d.width / 3, (int) (d.height * 0.75));
		this.setLocationRelativeTo(parent);
		this.setVisible(true);

	}

}
