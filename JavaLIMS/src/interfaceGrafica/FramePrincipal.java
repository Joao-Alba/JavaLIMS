
package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JButton;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	public ImageIcon iconSelectedBranco = new ImageIcon(FramePrincipal.class.getResource("/res/IconSelectBranco.png"));
	public ImageIcon iconSelectedCinza = new ImageIcon(FramePrincipal.class.getResource("/res/IconSelectCinza.png"));
	public int functionSelected = 0;
	public JLabel lblSelectInventario = new JLabel("");
	public JLabel lblSelectLaboratorio = new JLabel("");
	public JLabel lblSelectTimeline = new JLabel("");
	public JLabel lblSelectPadroes = new JLabel("");
	public JLabel lblSelectComentarios = new JLabel("");
	public JLabel lblSelectMetodos = new JLabel("");
	public JLabel lblSelectAnalise = new JLabel("");
	private final JList lstEmpresas = new JList();
	public PanelAnalise panelAnalise = new PanelAnalise();
	public PanelMetodos panelMetodos = new PanelMetodos();
	public PanelInventario panelInventario = new PanelInventario();
	public PanelLaboratorio panelLaboratorio = new PanelLaboratorio();
	public PanelTimeline panelTimeline = new PanelTimeline();
	public PanelPadroes panelPadroes = new PanelPadroes();
	public PanelComentarios panelComentarios = new PanelComentarios();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(panelAnalise);
		panelAnalise.setVisible(false);
		contentPane.add(panelMetodos);
		panelMetodos.setVisible(false);
		contentPane.add(panelInventario);
		panelInventario.setVisible(false);
		contentPane.add(panelLaboratorio);
		panelLaboratorio.setVisible(false);
		contentPane.add(panelTimeline);
		panelTimeline.setVisible(false);
		contentPane.add(panelPadroes);
		panelPadroes.setVisible(false);
		contentPane.add(panelComentarios);
		panelComentarios.setVisible(false);
		
		JScrollPane scrollEmpresas = new JScrollPane();
		scrollEmpresas.setBorder(null);
		scrollEmpresas.setBounds(45, 187, 203, 667);
		scrollEmpresas.setBackground(new Color(213, 239, 236));
		contentPane.add(scrollEmpresas);
		lstEmpresas.setModel(new AbstractListModel() {
			String[] values = new String[] {"oi", "oi", "oi"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		lstEmpresas.setBackground(new Color(213, 239, 236));
		scrollEmpresas.setViewportView(lstEmpresas);

		JLabel btnExit = new JLabel("X");
		btnExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnExit.setForeground(new Color(0, 51, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBounds(1548, 11, 42, 36);
		contentPane.add(btnExit);

		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar o programa?", "Confirmation",
						JOptionPane.YES_NO_OPTION) == 0) {
					FramePrincipal.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setForeground(new Color(102, 150, 204));
			}

			public void mouseExited(MouseEvent e) {
				btnExit.setForeground(new Color(0, 51, 0));
			}
		});
		btnExit.getMouseListeners();
		lblSelectComentarios.setBounds(1407, 55, 161, 57);
		contentPane.add(lblSelectComentarios);
		lblSelectComentarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				functionSelected = 7;
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
				
				panelSelect(panelComentarios, panelAnalise, panelMetodos, panelInventario, panelLaboratorio, panelTimeline, panelPadroes, panelComentarios);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSelectComentarios.setIcon(iconSelectedCinza);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSelectComentarios.setIcon(null);
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
			}
		});
		lblSelectPadroes.setBounds(1205, 55, 161, 57);
		contentPane.add(lblSelectPadroes);
		lblSelectPadroes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				functionSelected = 6;
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
				
				panelSelect(panelPadroes, panelAnalise, panelMetodos, panelInventario, panelLaboratorio, panelTimeline, panelPadroes, panelComentarios);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSelectPadroes.setIcon(iconSelectedCinza);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSelectPadroes.setIcon(null);
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
			}
		});
		lblSelectTimeline.setBounds(1018, 55, 161, 57);
		contentPane.add(lblSelectTimeline);
		lblSelectTimeline.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				functionSelected = 5;
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
				
				panelSelect(panelTimeline, panelAnalise, panelMetodos, panelInventario, panelLaboratorio, panelTimeline, panelPadroes, panelComentarios);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSelectTimeline.setIcon(iconSelectedCinza);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSelectTimeline.setIcon(null);
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
			}
		});
		lblSelectLaboratorio.setBounds(823, 55, 161, 57);
		contentPane.add(lblSelectLaboratorio);
		lblSelectLaboratorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				functionSelected = 4;
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
				
				panelSelect(panelLaboratorio, panelAnalise, panelMetodos, panelInventario, panelLaboratorio, panelTimeline, panelPadroes, panelComentarios);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSelectLaboratorio.setIcon(iconSelectedCinza);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSelectLaboratorio.setIcon(null);
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
			}
		});
		lblSelectAnalise.setBounds(275, 55, 161, 57);
		contentPane.add(lblSelectAnalise);
		lblSelectMetodos.setBounds(429, 55, 161, 57);
		contentPane.add(lblSelectMetodos);
		lblSelectInventario.setBounds(619, 55, 161, 57);
		contentPane.add(lblSelectInventario);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(FramePrincipal.class.getResource("/res/Main screen.png")));
		lblFundo.setBounds(0, 0, 1600, 900);
		contentPane.add(lblFundo);
		
		JPanel panel = new JPanel();
		panel.setBounds(275, 172, 1315, 717);
		contentPane.add(panel);
		
		lblSelectInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				functionSelected = 3;
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
				
				panelSelect(panelInventario, panelAnalise, panelMetodos, panelInventario, panelLaboratorio, panelTimeline, panelPadroes, panelComentarios);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSelectInventario.setIcon(iconSelectedCinza);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSelectInventario.setIcon(null);
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
			}
		});
		lblSelectMetodos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				functionSelected = 2;
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
				
				panelSelect(panelMetodos, panelAnalise, panelMetodos, panelInventario, panelLaboratorio, panelTimeline, panelPadroes, panelComentarios);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSelectMetodos.setIcon(iconSelectedCinza);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSelectMetodos.setIcon(null);
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
			}
		});
		lblSelectAnalise.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				functionSelected = 1;
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
				
				panelSelect(panelAnalise, panelAnalise, panelMetodos, panelInventario, panelLaboratorio, panelTimeline, panelPadroes, panelComentarios);
								
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSelectAnalise.setIcon(iconSelectedCinza);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSelectAnalise.setIcon(null);
				updateFunctionIcon(functionSelected, iconSelectedBranco, lblSelectAnalise, lblSelectMetodos,
						lblSelectInventario, lblSelectLaboratorio, lblSelectTimeline, lblSelectPadroes,
						lblSelectComentarios);
			}
		});
		setLocationRelativeTo(null);
	}

	public static void updateFunctionIcon(int selectedFunction, ImageIcon iconSelected, JLabel lblSelectAnalise,
			JLabel lblSelectMetodo, JLabel lblSelectInventario, JLabel lblSelectLaboratorio, JLabel lblSelectTimeline,
			JLabel lblSelectPadroes, JLabel lblSelectComentarios) {

		lblSelectAnalise.setIcon(null);
		lblSelectMetodo.setIcon(null);
		lblSelectInventario.setIcon(null);
		lblSelectLaboratorio.setIcon(null);
		lblSelectTimeline.setIcon(null);
		lblSelectPadroes.setIcon(null);
		lblSelectComentarios.setIcon(null);

		switch (selectedFunction) {
		case 1:
			lblSelectAnalise.setIcon(iconSelected);
			break;
		case 2:
			lblSelectMetodo.setIcon(iconSelected);
			break;
		case 3:
			lblSelectInventario.setIcon(iconSelected);
			break;
		case 4:
			lblSelectLaboratorio.setIcon(iconSelected);
			break;
		case 5:
			lblSelectTimeline.setIcon(iconSelected);
			break;
		case 6:
			lblSelectPadroes.setIcon(iconSelected);
			break;
		case 7:
			lblSelectComentarios.setIcon(iconSelected);
			break;

		}
	}
	
	public static void panelSelect(JPanel panelSelected, JPanel panelAnalise, JPanel panelMetodos, JPanel panelInventario, JPanel panelLaboratorio, JPanel panelTimeline, JPanel panelPadroes, JPanel panelComentarios) {
		
		panelAnalise.setVisible(false);
		panelMetodos.setVisible(false);
		panelInventario.setVisible(false);
		panelLaboratorio.setVisible(false);
		panelTimeline.setVisible(false);
		panelPadroes.setVisible(false);
		panelComentarios.setVisible(false);
		
		panelSelected.setVisible(true);
		
	}
}
