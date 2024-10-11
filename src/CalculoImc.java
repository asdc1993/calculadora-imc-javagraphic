import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class CalculoImc extends JFrame {
		/**
	 * Teste Github Actions.
	 */

	private JPanel contentPane;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtImc;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoImc frame = new CalculoImc();
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
	public CalculoImc() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculoImc.class.getResource("/br/com/imc/icones/imc.png")));
		setTitle("Calculadora IMC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(73, 27, 96, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(73, 78, 96, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(32, 30, 48, 14);
		contentPane.add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(32, 81, 48, 14);
		contentPane.add(lblAltura);
		
		JLabel lblImc1 = new JLabel("Imc");
		lblImc1.setBounds(32, 128, 48, 14);
		contentPane.add(lblImc1);
		
		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular(); 
			}
		});
		btnCalcular.setIcon(new ImageIcon(CalculoImc.class.getResource("/br/com/imc/icones/imc.png")));
		btnCalcular.setBounds(204, 60, 64, 64);
		contentPane.add(btnCalcular);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(CalculoImc.class.getResource("/br/com/imc/icones/sair.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar(); 
			}
		});
		btnLimpar.setBounds(302, 60, 64, 64);
		contentPane.add(btnLimpar);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(CalculoImc.class.getResource("/br/com/imc/icones/tabela_imc.jpg")));
		lblStatus.setBounds(31, 180, 423, 210);
		contentPane.add(lblStatus);
		
		txtImc = new JTextField();
		txtImc.setBounds(73, 125, 96, 20);
		contentPane.add(txtImc);
		txtImc.setColumns(10);
	}
	//método para calcular o IMC 
	private void calcular() {
		DecimalFormat formatador = new DecimalFormat("0.00"); 
		double peso, altura, imc;
		peso = Double.parseDouble(txtPeso.getText().replace(",",".")); 
		altura = Double.parseDouble(txtAltura.getText().replace(",","."));
		imc = peso / (altura+altura); 
		txtImc.setText(formatador.format(imc));
		if (imc < 18.5 ) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imc/icones/tabela_imc_abaixo.jpg"))); 
		}else if(imc >= 18.5 && imc < 25) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imc/icones/tabela_imc_normal.jpg"))); 
		}else if(imc >= 25 && imc < 30) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imc/icones/tabela_imc_acima.jpg")));
		}else {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imc/icones/tabela_imc_obeso.jpg")));
		}
	}
	
		//método para limpar campos
		private void limpar() {
			txtPeso.setText(null);
			txtAltura.setText(null);
			txtImc.setText(null);
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imc/icones/tabela_imc.jpg"))); 
	}
}
 
