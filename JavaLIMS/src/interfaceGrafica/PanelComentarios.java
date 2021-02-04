package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelComentarios extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelComentarios() {

		setBounds(275, 172, 1315, 717);
		setVisible(true);
		setLayout(null);
		
		
		JLabel lblTeste = new JLabel("COMENTARIO");
		lblTeste.setBounds(100, 100, 100, 100);
		add(lblTeste);

	}

}
