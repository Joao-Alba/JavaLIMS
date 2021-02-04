package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTimeline extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTimeline() {

		setBounds(275, 150, 1315, 717);
		setVisible(true);
		setLayout(null);
		
		
		JLabel lblTeste = new JLabel("TIMELINE");
		lblTeste.setBounds(100, 100, 100, 100);
		add(lblTeste);

	}
}
