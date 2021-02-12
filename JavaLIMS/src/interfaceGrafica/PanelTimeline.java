package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Popup;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import componentesInternos.DateLabelFormatter;

import javax.swing.JButton;
import javax.swing.JList;

public class PanelTimeline extends JPanel {
	
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static LocalDateTime now = LocalDateTime.now();
	private JDatePickerImpl datePickerFinal;

	/**
	 * Create the panel.
	 */
	public PanelTimeline() {

		setBounds(275, 150, 1315, 717);
		setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		setOpaque(false);
		setVisible(true);
		setLayout(null);
		
		JPanel pnlGrafico = new JPanel();
		pnlGrafico.setBounds(10, 139, 1295, 567);
		pnlGrafico.setBackground(Color.CYAN);
		add(pnlGrafico);
		pnlGrafico.setLayout(null);
		
		UtilDateModel model = new UtilDateModel();
		model.setDate(now.getYear(), now.getMonthValue() - 1, now.getDayOfMonth());
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		
		JDatePickerImpl datePickerInicio = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePickerInicio.getJFormattedTextField().setFont(new Font("Tahoma", Font.BOLD, 24));
		datePickerInicio.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		datePickerInicio.setOpaque(false);
		datePickerInicio.getJFormattedTextField().setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		datePickerInicio.getJFormattedTextField().setOpaque(false);
		datePickerInicio.setBounds(101, 38, 181, 23);
		datePickerInicio.setVisible(true);
		add(datePickerInicio);
		

		JDatePickerImpl datePickerFinal = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePickerFinal = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePickerFinal.getJFormattedTextField().setFont(new Font("Tahoma", Font.BOLD, 24));
		datePickerFinal.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		datePickerFinal.setOpaque(false);
		datePickerFinal.getJFormattedTextField().setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
		datePickerFinal.getJFormattedTextField().setOpaque(false);
		datePickerFinal.setBounds(422, 38, 181, 23);
		datePickerFinal.setVisible(true);
		add(datePickerFinal);

	}
	
}
