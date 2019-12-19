/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Ana Perisic ra1-2017
 *
 */
public class StatusBar extends JPanel {

	private static final long serialVersionUID = -7960319300551657388L;

	public StatusBar(String title) {
		super();

		BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(box);

		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JLabel tekst = new JLabel(title);
		this.add(tekst);

		this.add(Box.createGlue());

		JLabel vreme = new JLabel(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
		this.add(vreme);
		this.add(Box.createHorizontalStrut(10));
		JLabel datum = new JLabel(LocalDate.now().toString());
		this.add(datum);

		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vreme.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
				datum.setText(LocalDate.now().toString());
			}

		});

		timer.start();
	}

}
