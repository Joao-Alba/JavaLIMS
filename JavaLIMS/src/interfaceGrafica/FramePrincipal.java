
package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tabelas.Empresa;

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
import java.util.ArrayList;

import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.ComponentOrientation;

public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	public static ImageIcon iconSelectedBranco = new ImageIcon(FramePrincipal.class.getResource("/res/IconSelectBranco.png"));
	public static ImageIcon iconSelectedCinza = new ImageIcon(FramePrincipal.class.getResource("/res/IconSelectCinza.png"));
	public static ImageIcon iconEmpresa = new ImageIcon(FramePrincipal.class.getResource("/res/EmpresaBackground.png"));
	public static ImageIcon iconMainScreenText = new ImageIcon(FramePrincipal.class.getResource("/res/MainScreen.png"));
	public static ImageIcon iconMainScreenSemText = new ImageIcon(FramePrincipal.class.getResource("/res/MainScreenSemText.png"));
	public int functionSelected = 0;
	public JLabel lblSelectInventario = new JLabel("");
	public JLabel lblSelectLaboratorio = new JLabel("");
	public JLabel lblSelectTimeline = new JLabel("");
	public JLabel lblSelectPadroes = new JLabel("");
	public JLabel lblSelectComentarios = new JLabel("");
	public JLabel lblSelectMetodos = new JLabel("");
	public JLabel lblSelectAnalise = new JLabel("");
	public PanelAnalise panelAnalise = new PanelAnalise();
	public PanelMetodos panelMetodos = new PanelMetodos();
	public PanelInventario panelInventario = new PanelInventario();
	public PanelLaboratorio panelLaboratorio = new PanelLaboratorio();
	public PanelTimeline panelTimeline = new PanelTimeline();
	public PanelPadroes panelPadroes = new PanelPadroes();
	public PanelComentarios panelComentarios = new PanelComentarios();
	public static JLabel lblAddEmpresa = new JLabel("+ Adicionar empresa");
	public static ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	public static ArrayList<JLabel> labelsEmpresas = new ArrayList<JLabel>();
	public static JLabel lblMainBackground = new JLabel("");
	public static JScrollPane scrollEmpresas = new JScrollPane();
	public static JPanel pnlEmpresas = new JPanel();
	
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
		setUndecorated(false);
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
		
		lblAddEmpresa.setBounds(54, 188, 191, 40);
		contentPane.add(lblAddEmpresa);
		lblAddEmpresa.setIcon(iconEmpresa);
		lblAddEmpresa.setForeground(new Color(17, 69, 89));
		lblAddEmpresa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddEmpresa.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAddEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlEmpresas.add(addEmpresa());
				revalidate();
				repaint();
			}
		});
		lblAddEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		
		scrollEmpresas.setBorder(null);
		scrollEmpresas.setBounds(45, 187, 203, 619);
		scrollEmpresas.setBackground(new Color(213, 239, 236));
		contentPane.add(scrollEmpresas);
		
		scrollEmpresas.setViewportView(pnlEmpresas);
		pnlEmpresas.setBackground(new Color(213, 239, 236));
		pnlEmpresas.setLayout(null);

		JLabel btnExit = new JLabel("X");
		btnExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnExit.setForeground(new Color(0, 51, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBounds(1548, 11, 42, 36);
		contentPane.add(btnExit);

		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FramePrincipal.this.dispose();
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

		lblMainBackground.setIcon(iconMainScreenText);
		lblMainBackground.setBounds(0, 0, 1600, 900);
		contentPane.add(lblMainBackground);
		
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
		
		lblMainBackground.setIcon(iconMainScreenSemText);
		
		panelSelected.setVisible(true);
		
	}
	
	public static JLabel addEmpresa() {
		
		Empresa empresa = new Empresa();
		
		lblAddEmpresa.setLocation(lblAddEmpresa.getX(), lblAddEmpresa.getY() + 50);
		
		if(lblAddEmpresa.getY() > 810) {
			lblAddEmpresa.setLocation(lblAddEmpresa.getX(), 810);
		}

		
		empresa.setNome(JOptionPane.showInputDialog(scrollEmpresas, "Entre com o nome da empresa"));
		
		JLabel lblEmpresa = new JLabel();
		lblEmpresa.setVisible(true);
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setForeground(new Color(17, 69, 89));
		lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmpresa.setBounds(10, (empresas.size() * 50), 191, 40);
		lblEmpresa.setText(empresa.getNome());
		lblEmpresa.setHorizontalTextPosition(JLabel.CENTER);
		lblEmpresa.setIcon(iconEmpresa);
		lblEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(lblEmpresa, "Apagar empresa " + lblEmpresa.getText() + "?") == 0) {
					empresas.remove(empresa);
					for(int i = 0; i < empresas.size(); i++) {
						if(labelsEmpresas.get(i).getText().equalsIgnoreCase(empresas.get(i).getNome())) {
							labelsEmpresas.remove(i);
							empresas.remove(i);
						}
					}
				}
				
			}
		});
		
		empresas.add(empresa);
		labelsEmpresas.add(lblEmpresa);
		
		return lblEmpresa;
	}
}
