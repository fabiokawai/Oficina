package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaCadastroServico extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeServico;
	private JTextField txtValorHora;



	public TelaCadastroServico() {
		setResizable(false);
		setTitle("Cadastro de Servi\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeServico = new JLabel("Nome do Servi\u00E7o:");
		lblNomeServico.setBounds(10, 21, 101, 14);
		contentPane.add(lblNomeServico);
		
		JLabel lblValorPhora = new JLabel("Valor P/Hora:");
		lblValorPhora.setBounds(10, 59, 85, 14);
		contentPane.add(lblValorPhora);
		
		txtNomeServico = new JTextField();
		txtNomeServico.setToolTipText("Nome do Servi\u00E7o");
		txtNomeServico.setBounds(121, 18, 187, 20);
		contentPane.add(txtNomeServico);
		txtNomeServico.setColumns(10);
		
		txtValorHora = new JTextField();
		txtValorHora.setToolTipText("Valor por Hora");
		txtValorHora.setBounds(121, 56, 187, 20);
		contentPane.add(txtValorHora);
		txtValorHora.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().return2TelaPrincipal();
			}
		});
		
		
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setBounds(121, 96, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Controller.getInstance().saveServico(txtNomeServico.getText(), Float.parseFloat(txtValorHora.getText()));
					Controller.getInstance().return2TelaPrincipal();
				} catch (NumberFormatException e1) {
				}
			}
		});
		
		btnSalvar.setToolTipText("Salvar Servi\u00E7o");
		btnSalvar.setBounds(219, 96, 89, 23);
		contentPane.add(btnSalvar);
	}



	public void limparTela() {
		txtNomeServico.setText("");
		txtValorHora.setText("");
	}

}
