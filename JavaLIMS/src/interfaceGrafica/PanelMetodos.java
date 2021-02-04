package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMetodos extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMetodos() {

		setBounds(275, 172, 1315, 717);
		setVisible(true);
		setLayout(null);
		
		
		JLabel lblTeste = new JLabel("METODOS");
		lblTeste.setBounds(100, 100, 100, 100);
		add(lblTeste);

	}

}
