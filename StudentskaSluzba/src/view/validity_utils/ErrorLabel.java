/**
 * 
 */
package view.validity_utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * Labela koja predstavlja indikator validnosti tekstualnog polja.
 * 
 * @author Milana Todorovic ra3-2017
 *
 */
public class ErrorLabel extends JLabel {

	private static final long serialVersionUID = 5653834200990424650L;

	public static final String ALPHANUM_VIOLATED = "Polje moze da sadr\u017Ei samo alfanumericke znakove!";
	public static final String NOT_NULL_VIOLATED = "Polje je obavezno!";
	public static final String UNIQUE_VIOLATED = "Vrednost polja mora biti jedinstvena!";
	public static final String FORMAT_VIOLATED = "Dozvoljeni formati unosa: ";

	private Color validColor;
	private Color invalidColor;
	private String formats;

	public ErrorLabel(Color validColor, Color invalidColor, String formats) {
		super("!");

		this.invalidColor = invalidColor;
		this.validColor = validColor;
		this.formats = formats;

		Font font = this.getFont();
		this.setFont(new Font(font.getName(), Font.BOLD, 18));
		this.setForeground(invalidColor);
	}

	public ErrorLabel(Color validColor, Color invalidColor) {
		this(validColor, invalidColor, null);
	}

	public void invalidAlphanum() {
		this.setToolTipText(ALPHANUM_VIOLATED);
		this.setForeground(invalidColor);
	}

	public void invalidUnique() {
		this.setToolTipText(UNIQUE_VIOLATED);
		this.setForeground(invalidColor);
	}

	public void invalidNotNull() {
		this.setToolTipText(NOT_NULL_VIOLATED);
		this.setForeground(invalidColor);
	}

	public void invalidFormat() {
		this.setToolTipText(FORMAT_VIOLATED + formats);
		this.setForeground(invalidColor);
	}

	public void valid() {
		this.setForeground(validColor);
	}

}
