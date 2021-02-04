package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInventario extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelInventario() {

		setBounds(275, 172, 1315, 717);
		setVisible(true);
		setLayout(null);
		
		
		JLabel lblTeste = new JLabel("INVENTARIO");
		lblTeste.setBounds(100, 100, 100, 100);
		add(lblTeste);

	}

}
