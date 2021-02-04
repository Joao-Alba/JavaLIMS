package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAnalise extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAnalise() {
		
		setBounds(275, 172, 1315, 717);
		setVisible(true);
		setLayout(null);
		
		
		JLabel lblTeste = new JLabel("ANALISE");
		lblTeste.setBounds(100, 100, 100, 100);
		add(lblTeste);

	}

}
