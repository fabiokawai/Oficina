package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cadastros.Carro;
import controller.Controller;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class TelaCadastroCarro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCarro;
	private JTextField txtModelo;
	private JTextField txtAno;
	

	
	public TelaCadastroCarro() {
		setTitle("Cadastro de Carro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomedoCarro = new JLabel("Nome do Carro:");
		lblNomedoCarro.setBounds(21, 21, 88, 14);
		contentPane.add(lblNomedoCarro);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(21, 57, 46, 14);
		contentPane.add(lblModelo);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(21, 92, 46, 14);
		contentPane.add(lblAno);
		
		txtNomeCarro = new JTextField();
		txtNomeCarro.setToolTipText("Nome do Carro");
		txtNomeCarro.setBounds(116, 18, 187, 20);
		contentPane.add(txtNomeCarro);
		txtNomeCarro.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setToolTipText("Modelo");
		txtModelo.setBounds(116, 54, 187, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setToolTipText("Ano");
		txtAno.setBounds(116, 89, 187, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setToolTipText("Cancelar ");
		btnCancelar.setBounds(116, 129, 88, 23);
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
		btnSalvar.setToolTipText("Salvar novo carro");
		btnSalvar.setBounds(214, 129, 89, 23);
		contentPane.add(btnSalvar);
		
		btnSalvar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try{
					
				//Salva o carro
				Controller.getInstance().saveCarro(txtNomeCarro.getText(), txtModelo.getText(), Integer.parseInt(txtAno.getText()));
				//Chamar a tela Principal
				Controller.getInstance().return2TelaPrincipal();
				}
				catch (Exception e) {
				}
			}
		});
		
		
	}
	
	public void limparTela(){
		txtNomeCarro.setText("");
		txtModelo.setText("");
		txtAno.setText("");
	}
}
