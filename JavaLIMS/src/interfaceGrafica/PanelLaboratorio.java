package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLaboratorio extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLaboratorio() {

		setBounds(275, 172, 1315, 717);
		setVisible(true);
		setLayout(null);
		
		
		JLabel lblTeste = new JLabel("LABORATORIO");
		lblTeste.setBounds(100, 100, 100, 100);
		add(lblTeste);

	}

}
