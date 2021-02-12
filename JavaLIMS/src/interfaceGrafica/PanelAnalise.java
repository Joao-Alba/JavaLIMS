package interfaceGrafica;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import componentesInternos.DateLabelFormatter;
import componentesInternos.JTextFieldMod;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.Month;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Label;
import javax.swing.ImageIcon;
import java.awt.Choice;
import java.awt.Canvas;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class PanelAnalise extends JPanel {

	public static int qntdColumns = 1;
	public static int qntdRows = 1;
	public static ArrayList<JTextFieldMod> dadosAnalise = new ArrayList<JTextFieldMod>();
	private static JTextFieldMod txtInicial;
	public static JLabel lblData = new JLabel();
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static LocalDateTime now = LocalDateTime.now();
	public static boolean quadrado1Completo = false;
	public static boolean calendarAtivo;
	private SpringLayout springLayout;

	/**
	 * Create the panel.
	 */
	public PanelAnalise() {

		setForeground(Color.CYAN);
		setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		setOpaque(false);

		setBounds(275, 150, 1305, 730);
		setLayout(null);

		JButton btnAddRow = new JButton("Add amostra");
		btnAddRow.setBounds(587, 680, 131, 23);
		btnAddRow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (quadrado1Completo == false) {
					try {
					for (int i = 0; i < 2; i++) {
							add(completarQuadrado1(i));
						}
					} catch (NullPointerException Exception) {
						quadrado1Completo = false;
						JOptionPane.showMessageDialog(txtInicial, "Por favor, complete os dados corretamente.");
					}
				} else {
					for (int i = 0; i < dadosAnalise.size(); i++) {
						remove(dadosAnalise.get(i));
					}
					add(addRow());
					for (int i = 0; i < dadosAnalise.size(); i++) {
						add(dadosAnalise.get(i));

					}
				}
				revalidate();
				repaint();

			}
		});
		add(btnAddRow);

		JButton btnAddColumn = new JButton("Add analito");
		btnAddColumn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (quadrado1Completo == false) {
					try {
						for (int i = 0; i < 2; i++) {
							add(completarQuadrado1(i));
						}
					} catch (NullPointerException Exception) {
						quadrado1Completo = false;
						JOptionPane.showMessageDialog(txtInicial, "Por favor, complete os dados corretamente.");
					}
				} else {
					for (int i = 0; i < dadosAnalise.size(); i++) {
						remove(dadosAnalise.get(i));
					}
					add(addColumn());
					for (int i = 0; i < dadosAnalise.size(); i++) {
						add(dadosAnalise.get(i));
					}
				}
				revalidate();
				repaint();
			}
		});
		btnAddColumn.setBounds(1178, 359, 117, 23);
		add(btnAddColumn);

		txtInicial = new JTextFieldMod("0,00");
		txtInicial.setBounds(180, 180, 110, 50);
		txtInicial.setCoordX(0);
		txtInicial.setCoordY(0);
		add(txtInicial);
		txtInicial.setColumns(10);
		dadosAnalise.add(txtInicial);

		lblData.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblData.setBounds(180, 32, 72, 35);
		lblData.setText("Data: ");
		add(lblData);

		UtilDateModel model = new UtilDateModel();
		model.setDate(now.getYear(), now.getMonthValue() - 1, now.getDayOfMonth());
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setFont(new Font("Tahoma", Font.BOLD, 24));
		datePicker.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		datePicker.setOpaque(false);
		datePicker.getJFormattedTextField().setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		datePicker.getJFormattedTextField().setOpaque(false);
		datePicker.setBounds(256, 38, 181, 23);
		datePicker.setVisible(true);
		add(datePicker);

	}

	public static JLabel addRow() {

		JTextFieldMod txtAnalise = new JTextFieldMod("0,00");
		txtAnalise.setVisible(true);
		txtAnalise.setBounds(180, 180 + (qntdRows * 60), 110, 50);
		dadosAnalise.add(txtAnalise);

		for (int i = 1; i < qntdColumns; i++) {
			txtAnalise = new JTextFieldMod("0,00");
			txtAnalise.setVisible(true);
			txtAnalise.setBounds(180 + (i * 120), 180 + (qntdRows * 60), 110, 50);
			dadosAnalise.add(txtAnalise);
		}

		qntdRows++;

		applyCoords();

		JLabel lblAmostra = new JLabel(JOptionPane.showInputDialog(txtInicial, "Entre com o nome da amostra."));

		JTextFieldMod maiorY = txtInicial;

		for (int i = 0; i < dadosAnalise.size(); i++) {
			if (dadosAnalise.get(i).getCoordY() > maiorY.getCoordY()) {
				maiorY = dadosAnalise.get(i);
			}
		}

		lblAmostra.setBounds(maiorY.getX() - 110, maiorY.getY(), maiorY.getWidth(), maiorY.getHeight());
		if (lblAmostra.getText().equals("")) {
			lblAmostra.setText("Amostra");
		}
		lblAmostra.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmostra.setForeground(new Color(17, 69, 89));
		lblAmostra.setVisible(true);

		return lblAmostra;
	}

	public static JLabel addColumn() {

		JTextFieldMod txtAnalise = new JTextFieldMod("0,00");
		txtAnalise.setVisible(true);
		txtAnalise.setBounds(180 + (qntdColumns * 120), 180, 110, 50);
		dadosAnalise.add(txtAnalise);

		for (int i = 1; i < qntdRows; i++) {
			txtAnalise = new JTextFieldMod("0,00");
			txtAnalise.setVisible(true);
			txtAnalise.setBounds(180 + (qntdColumns * 120), 180 + (i * 60), 110, 50);
			dadosAnalise.add(txtAnalise);
		}

		qntdColumns++;

		applyCoords();

		JLabel lblAnalito = new JLabel(JOptionPane.showInputDialog(txtInicial, "Entre com o nome do analito."));

		JTextFieldMod maiorX = txtInicial;

		for (int i = 0; i < dadosAnalise.size(); i++) {
			if (dadosAnalise.get(i).getCoordX() > maiorX.getCoordX()) {
				maiorX = dadosAnalise.get(i);
			}
		}

		lblAnalito.setBounds(maiorX.getX(), maiorX.getY() - 50, maiorX.getWidth(), maiorX.getHeight());
		if (lblAnalito.getText().equals("")) {
			lblAnalito.setText("Analito");
		}
		lblAnalito.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnalito.setForeground(new Color(17, 69, 89));
		lblAnalito.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAnalito.setVisible(true);

		return lblAnalito;
	}

	public static void applyCoords() {

		int menor = Integer.MAX_VALUE;
		int menorAnterior = Integer.MIN_VALUE;

		for (int i = 0; i < qntdColumns; i++) {

			menor = Integer.MAX_VALUE;

			for (int j = 0; j < dadosAnalise.size(); j++) {
				if (dadosAnalise.get(j).getLocation().getX() < menor
						&& dadosAnalise.get(j).getLocation().getX() > menorAnterior) {
					menor = (int) dadosAnalise.get(j).getLocation().getX();
				}
			}

			for (int j = 0; j < dadosAnalise.size(); j++) {
				if (dadosAnalise.get(j).getLocation().getX() == menor) {
					dadosAnalise.get(j).setCoordX(i);
				}
			}

			menorAnterior = menor;
		}

		menor = Integer.MAX_VALUE;
		menorAnterior = Integer.MIN_VALUE;

		for (int i = 0; i < qntdRows; i++) {

			menor = Integer.MAX_VALUE;

			for (int j = 0; j < dadosAnalise.size(); j++) {
				if (dadosAnalise.get(j).getLocation().getY() < menor
						&& dadosAnalise.get(j).getLocation().getY() > menorAnterior) {
					menor = (int) dadosAnalise.get(j).getLocation().getY();
				}
			}

			for (int j = 0; j < dadosAnalise.size(); j++) {
				if (dadosAnalise.get(j).getLocation().getY() == menor) {
					dadosAnalise.get(j).setCoordY(i);
				}
			}

			menorAnterior = menor;
		}

		System.out.println("Rows: " + qntdRows);
		System.out.println("Columns: " + qntdColumns);
	}

	public static JLabel completarQuadrado1(int i) {

		if (i == 0) {
			JLabel lblAnalito = new JLabel(
					JOptionPane.showInputDialog(txtInicial, "Entre com o nome do analito inicial."));
			if (lblAnalito.getText().equals("")) {
				lblAnalito.setText("Analito");
			}
			lblAnalito.setBounds(txtInicial.getX(), txtInicial.getY() - 50, txtInicial.getWidth(),
					txtInicial.getHeight());
			lblAnalito.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblAnalito.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnalito.setForeground(new Color(17, 69, 89));
			quadrado1Completo = true;
			return lblAnalito;
		} else {
			JLabel lblAmostra = new JLabel(
					JOptionPane.showInputDialog(txtInicial, "Entre com o nome da amostra inicial."));
			if (lblAmostra.getText().equals("")) {
				lblAmostra.setText("Amostra");
			}
			lblAmostra.setBounds(txtInicial.getX() - 110, txtInicial.getY(), txtInicial.getWidth(),
					txtInicial.getHeight());
			lblAmostra.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblAmostra.setForeground(new Color(17, 69, 89));
			quadrado1Completo = true;
			return lblAmostra;
		}

	}
}
