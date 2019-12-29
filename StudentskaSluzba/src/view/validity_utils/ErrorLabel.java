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

	public static final String CHARACTER_INVALID = "Nedozvoljeni karakter!";
	public static final String NOT_NULL_VIOLATED = "Polje je obavezno!";
	public static final String UNIQUE_VIOLATED = "Vrednost polja mora biti jedinstvena!";
	public static final String FORMAT_VIOLATED = "Dozvoljeni formati unosa: ";
	public static final String SEARCH_PARAMS_VIOLATED = "Nedozvoljeni parametri pretrage!";

	private Color validColor;
	private Color invalidColor;
	private String formats;
	private boolean toggleVisibility;

	public ErrorLabel(Color validColor, Color invalidColor, String formats, boolean toggleVisibility) {
		super("!");

		this.invalidColor = invalidColor;
		this.validColor = validColor;
		this.formats = formats;
		this.toggleVisibility = toggleVisibility;

		Font font = this.getFont();
		this.setFont(new Font(font.getName(), Font.BOLD, 18));
		this.setForeground(validColor);
		if (toggleVisibility)
			this.setVisible(false);
	}

	public ErrorLabel(Color validColor, Color invalidColor, String formats) {
		this(validColor, invalidColor, formats, false);
	}

	public ErrorLabel(Color validColor, Color invalidColor) {
		this(validColor, invalidColor, null);
	}

	public void invalidCharacter() {
		this.setToolTipText(CHARACTER_INVALID);
		this.setForeground(invalidColor);
		if (toggleVisibility)
			this.setVisible(true);
	}

	public void invalidUnique() {
		this.setToolTipText(UNIQUE_VIOLATED);
		this.setForeground(invalidColor);
		if (toggleVisibility)
			this.setVisible(true);
	}

	public void invalidNotNull() {
		this.setToolTipText(NOT_NULL_VIOLATED);
		this.setForeground(invalidColor);
		if (toggleVisibility)
			this.setVisible(true);
	}

	public void invalidFormat() {
		this.setToolTipText(FORMAT_VIOLATED + formats);
		this.setForeground(invalidColor);
		if (toggleVisibility)
			this.setVisible(true);
	}

	public void invalidSearchParams() {
		this.setToolTipText(SEARCH_PARAMS_VIOLATED);
		this.setForeground(invalidColor);
		if (toggleVisibility)
			this.setVisible(true);
	}
	
	public void invalid(String customTooltip) {
		this.setToolTipText(customTooltip);
		this.setForeground(invalidColor);
		if (toggleVisibility)
			this.setVisible(true);
	}

	public void valid() {
		this.setToolTipText(null);
		this.setForeground(validColor);
		if (toggleVisibility)
			this.setVisible(false);
	}

}
