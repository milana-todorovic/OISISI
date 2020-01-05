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
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import view.validity_utils.ErrorLabel;
import view.validity_utils.Validator;
import view.validity_utils.ValidityListener;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class StudentDialog extends JDialog {

	private static final long serialVersionUID = 1008692373276742321L;

	private static final int ALL_VALID = 0b111111111;
	private static final int IME_VALID = 0b000000001;
	private static final int PREZIME_VALID = 0b000000010;
	private static final int ADRESA_VALID = 0b000000100;
	private static final int BROJTEL_VALID = 0b000001000;
	private static final int BROJIND_VALID = 0b000010000;
	private static final int EMAIL_VALID = 0b000100000;
	private static final int PROSEK_VALID = 0b001000000;
	private static final int DATUPIS_VALID = 0b010000000;
	private static final int DATRODJ_VALID = 0b100000000;
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
	private JTextField brojInd;
	private ErrorLabel brojIndError;
	private JTextField emailAdresa;
	private ErrorLabel emailAdresaError;
	private JTextField prosek;
	private ErrorLabel prosekError;
	private JTextField datumUpisa;
	private ErrorLabel datumUpisaError;
	private JComboBox<String> godina;
	private JRadioButton budzetRB;
	private JRadioButton samofinansiranjeRB;
	private JButton dodaj;

	public StudentDialog(JFrame parent) {
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

		String[] godina = { "I (prva)", "II (druga)", "III (tre\u0107a)", "IV (\u010Detvrta)" };

		this.ime = new JTextField();
		this.imeError = new ErrorLabel(this.getBackground(), Color.RED, "reci razdvojene razmacima ili crticom");
		this.prezime = new JTextField();
		this.prezimeError = new ErrorLabel(this.getBackground(), Color.RED, "reci razdvojene razmacima ili crticom");
		this.datumRodjenja = new JTextField();
		this.datumRodjenjaError = new ErrorLabel(this.getBackground(), Color.RED, "yyyy-MM-dd");
		this.adresa = new JTextField();
		this.adresaError = new ErrorLabel(this.getBackground(), Color.RED,
				"reci ili brojevi razdvojeni razmacima ili crticom");
		this.brojTel = new JTextField();
		this.brojTelError = new ErrorLabel(this.getBackground(), Color.RED, "realan broj izmedju 9 i 20");
		this.brojInd = new JTextField();
		this.brojIndError = new ErrorLabel(this.getBackground(), Color.RED,
				"oznaka smera razdvojena brojem upisa pa crticom pa godinom upisa");
		this.emailAdresa = new JTextField();
		this.emailAdresaError = new ErrorLabel(this.getBackground(), Color.RED,
				"slova i brojevi bez razmaka,moguc separator _ ili tacka,@domen");
		this.prosek = new JTextField();
		this.prosekError = new ErrorLabel(this.getBackground(), Color.RED, "cifre razdvojene . ");
		this.datumUpisa = new JTextField();
		this.datumUpisaError = new ErrorLabel(this.getBackground(), Color.RED, "yyyy-MM-dd");
		this.godina = new JComboBox<String>(godina);
		this.budzetRB = new JRadioButton("Bu\u01C6et");
		this.samofinansiranjeRB = new JRadioButton("Samofinansiranje");
		budzetRB.setSelected(true);
		this.validacija();

		ButtonGroup group = new ButtonGroup();
		group.add(budzetRB);
		group.add(samofinansiranjeRB);

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

		content.add(new JLabel("Broj indeksa*: "), new GridBagConstraints(0, 6, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.brojInd, new GridBagConstraints(1, 6, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.brojIndError, new GridBagConstraints(3, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Prosek*: "), new GridBagConstraints(0, 7, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.prosek, new GridBagConstraints(1, 7, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.prosekError, new GridBagConstraints(3, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Datum upisa*: "), new GridBagConstraints(0, 8, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.datumUpisa, new GridBagConstraints(1, 8, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
		content.add(this.datumUpisaError, new GridBagConstraints(3, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(new JLabel("Godina studija*: "), new GridBagConstraints(0, 9, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		content.add(this.godina, new GridBagConstraints(1, 9, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

		content.add(this.budzetRB, new GridBagConstraints(0, 10, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));

		content.add(this.samofinansiranjeRB, new GridBagConstraints(0, 11, 1, 1, 0, 100, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));

		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

		buttons.add(makeConfirmButton());
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

			}
		});

		return dodaj;

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
				} else if (!Validator.isImePrezimeStudenta(s1)) {
					imeError.invalidFormat();
					valid = false;
				} else {
					imeError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(IME_VALID);
					dodaj.setEnabled(false);
				} else {
					validity = validity | IME_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
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
				} else if (!Validator.isImePrezimeStudenta(s1)) {
					prezimeError.invalidFormat();
					valid = false;
				} else {
					prezimeError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(PREZIME_VALID);
					dodaj.setEnabled(false);
				} else {
					validity = validity | PREZIME_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
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
				} else if (!Validator.isAlphanumericWithSeparators(s1)) {
					adresaError.invalidCharacter();
					valid = false;
				} else if (!Validator.isAdresaStudenta(s1)) {
					adresaError.invalidFormat();
					valid = false;
				} else {
					adresaError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(ADRESA_VALID);
					dodaj.setEnabled(false);
				} else {
					validity = validity | ADRESA_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
					}
				}

			}
		});
		this.brojInd.getDocument().addDocumentListener(new ValidityListener() {
			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					brojIndError.invalidNotNull();
					valid = false;
				} else if (!Validator.isAlphanumericWithDash(s1)) {
					brojIndError.invalidCharacter();
					valid = false;
				} else if (!Validator.isBrojIndeksa(s1)) {
					brojIndError.invalidFormat();
					valid = false;
				} else {
					brojIndError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(BROJIND_VALID);
					dodaj.setEnabled(false);
				} else {
					validity = validity | BROJIND_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
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
				} else if (!Validator.isNumeric(s1)) {
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
				} else {
					validity = validity | BROJTEL_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
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
				} else {
					validity = validity | EMAIL_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
					}
				}

			}
		});
		this.prosek.getDocument().addDocumentListener(new ValidityListener() {
			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					prosekError.invalidNotNull();
					valid = false;
				} else if (!Validator.isNumericWithDot(s1)) {
					prosekError.invalidCharacter();
					valid = false;
				} else if (!Validator.isProsek(s1)) {
					prosekError.invalidFormat();
					valid = false;
				} else {
					prosekError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(PROSEK_VALID);
					dodaj.setEnabled(false);
				} else {
					validity = validity | PROSEK_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
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
					validity = validity & ~(DATRODJ_VALID);
					dodaj.setEnabled(false);
				} else {
					validity = validity | DATRODJ_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
					}
				}

			}
		});
		this.datumUpisa.getDocument().addDocumentListener(new ValidityListener() {
			public void checkValidity(String s) {
				String s1 = s.trim();
				Boolean valid;

				if (s1.isEmpty()) {
					datumUpisaError.invalidNotNull();
					valid = false;
				} else if (!Validator.isNumericWithDash(s1)) {
					datumUpisaError.invalidCharacter();
					valid = false;
				} else if (!Validator.isLocalDate(s1)) {
					datumUpisaError.invalidFormat();
					valid = false;
				} else {
					datumUpisaError.valid();
					valid = true;
				}
				if (!valid) {
					validity = validity & ~(DATUPIS_VALID);
					dodaj.setEnabled(false);
				} else {
					validity = validity | DATUPIS_VALID;
					if (validity == ALL_VALID) {
						dodaj.setEnabled(true);
					}
				}

			}
		});

	}

	public void addMode() {
		this.setTitle("Dodavanje studenta");

		this.validity = 0b000000000;

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
		brojInd.setText("");
		brojIndError.valid();
		prosek.setText("");
		prosekError.valid();
		datumRodjenja.setText("");
		datumRodjenjaError.valid();
		datumUpisa.setText("");
		datumUpisaError.valid();
		godina.setSelectedIndex(0);
		budzetRB.setSelected(true);

		dodaj.setEnabled(false);

		Dimension d = parent.getSize();
		this.setSize(d.width / 2, (int) (d.height * 0.75));
		this.setLocationRelativeTo(parent);
		this.setVisible(true);

	}

}
