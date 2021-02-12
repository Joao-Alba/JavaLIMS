package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPadroes extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPadroes() {

		setBounds(275, 150, 1315, 717);
		setVisible(true);
		setLayout(null);
		
		
		JLabel lblTeste = new JLabel("PADROES");
		lblTeste.setBounds(100, 100, 100, 100);
		add(lblTeste);
		
	}

}
