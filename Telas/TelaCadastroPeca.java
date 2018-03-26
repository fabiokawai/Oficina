package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import cadastros.Carro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;

public class TelaCadastroPeca extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomePeca;
	private JTextField txtAnoInicial;
	private JTextField txtAnoFinal;
	private JTextField txtValor;
	
	JComboBox cbModeloCarro = new JComboBox();
	public TelaCadastroPeca() {
		setResizable(false);
		setTitle("Cadastro de Pe\u00E7a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomedaPeca = new JLabel("Nome da Pe\u00E7a:");
		lblNomedaPeca.setBounds(10, 11, 98, 14);
		contentPane.add(lblNomedaPeca);
		
		JLabel lblModelodoCarro = new JLabel("Modelo do Carro:");
		lblModelodoCarro.setBounds(10, 47, 98, 14);
		contentPane.add(lblModelodoCarro);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 83, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 116, 46, 14);
		contentPane.add(lblValor);
		
		txtNomePeca = new JTextField();
		txtNomePeca.setToolTipText("Nome da Pe\u00E7a");
		txtNomePeca.setBounds(117, 8, 185, 20);
		contentPane.add(txtNomePeca);
		txtNomePeca.setColumns(10);
		
		
		cbModeloCarro.setToolTipText("Modelo do Carro");
		cbModeloCarro.setBounds(118, 44, 184, 20);
		contentPane.add(cbModeloCarro);
		
		txtAnoInicial = new JTextField();
		txtAnoInicial.setToolTipText("Ano inicial");
		txtAnoInicial.setBounds(116, 80, 90, 20);
		contentPane.add(txtAnoInicial);
		txtAnoInicial.setColumns(10);
		
		txtAnoFinal = new JTextField();
		txtAnoFinal.setToolTipText("Ano final");
		txtAnoFinal.setBounds(216, 80, 86, 20);
		contentPane.add(txtAnoFinal);
		txtAnoFinal.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setToolTipText("Valor da pe\u00E7a");
		txtValor.setBounds(117, 113, 185, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setBounds(117, 149, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Chamar a tela Principal
				Controller.getInstance().return2TelaPrincipal();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Controller.getInstance().savePeca(txtNomePeca.getText(), cbModeloCarro.getSelectedIndex(), Integer.parseInt(txtAnoInicial.getText()), Integer.parseInt(txtAnoFinal.getText()), Float.parseFloat(txtValor.getText()));
					Controller.getInstance().return2TelaPrincipal();
				} catch (NumberFormatException e1) {
				}
			}
		});
		
		
		btnSalvar.setToolTipText("Salvar Pe\u00E7a");
		btnSalvar.setBounds(213, 149, 89, 23);
		contentPane.add(btnSalvar);
		
		
	}
	
	public void limparTela(){
		cbModeloCarro.removeAllItems();
		for (Carro carro : TelaPrincipal.listaCarro) {
			cbModeloCarro.addItem(carro.getModelo());
		}
		txtNomePeca.setText("");
		txtAnoInicial.setText("");
		txtAnoFinal.setText("");
		txtValor.setText("");
	}
	
}
