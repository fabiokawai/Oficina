package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

import cadastros.Carro;
import cadastros.Peca;
import cadastros.Servico;
import orcamento.Orcamento;
import orcamento.PecaOrcamento;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import controller.Controller;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private javax.swing.JScrollPane scrollTable;
	static List<Carro> listaCarro = new ArrayList<Carro>();
	static List<Servico> listaServico = new ArrayList<Servico>();
	static List<Peca> listaPeca = new ArrayList<Peca>();
	static List<Peca> listaPecaCarro = new ArrayList<Peca>();

	Orcamento orcamento = new Orcamento();
	JLabel totalOrcamento = new JLabel("0.0");
	JComboBox comboBox = new JComboBox();
	

	JList listPecasOrcamento = new JList();
	JList listServicosOrcamento = new JList();
	JList listPecas = new JList();
	JList listServicos = new JList();

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		setResizable(false);
		setTitle("Sistema de Or\u00E7amentos Automotivo");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		comboBox.setToolTipText("Selecione um Carro");
		comboBox.setBounds(10, 40, 139, 20);
		contentPane.add(comboBox);

		JButton btnCadCarro = new JButton("Cadastrar Carro");
		btnCadCarro.setToolTipText("Cadastrar carro");
		btnCadCarro.setBounds(10, 124, 139, 23);
		contentPane.add(btnCadCarro);

		btnCadCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Chamar a tela Cadastrar Carro
				Controller.getInstance().change2TelaCarro();
			}
		});

		JButton btnCadPeca = new JButton("Cadastrar Pe\u00E7a");
		btnCadPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().change2TelaPeca();
			}
		});

		btnCadPeca.setToolTipText("Cadastrar pe\u00E7a");
		btnCadPeca.setBounds(10, 158, 139, 23);
		contentPane.add(btnCadPeca);


		JButton btnCadServico = new JButton("Cadastrar Servi\u00E7o");

		btnCadServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().change2TelaServico();
			}
		});

		btnCadServico.setToolTipText("Cadastrar servi\u00E7o");
		btnCadServico.setBounds(10, 192, 139, 23);
		contentPane.add(btnCadServico);

		JLabel lblSelecioneUmVeculo = new JLabel("Selecione um Carro:");
		lblSelecioneUmVeculo.setBounds(10, 15, 127, 14);
		contentPane.add(lblSelecioneUmVeculo);

		JPanel pnServicos = new JPanel();
		pnServicos.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnServicos.setBounds(159, 40, 221, 132);
		contentPane.add(pnServicos);

		listServicos.setToolTipText("Selecione o Servi\u00E7o");
		pnServicos.add(listServicos);

		JPanel pnPecas = new JPanel();
		pnPecas.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnPecas.setBounds(395, 40, 297, 132);
		contentPane.add(pnPecas);

		listPecas.setToolTipText("Selecione as Pe\u00E7as");
		pnPecas.add(listPecas);

		JPanel pnServicoRealizado = new JPanel();
		pnServicoRealizado.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnServicoRealizado.setBounds(159, 238, 221, 132);
		contentPane.add(pnServicoRealizado);

		listServicosOrcamento.setToolTipText("Servi\u00E7os do Or\u00E7amento");
		pnServicoRealizado.add(listServicosOrcamento);

		JPanel pnPecaUtilizada = new JPanel();
		pnPecaUtilizada.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnPecaUtilizada.setBounds(395, 238, 297, 132);
		contentPane.add(pnPecaUtilizada);

		listPecasOrcamento.setToolTipText("Pe\u00E7as do Or\u00E7amento");
		pnPecaUtilizada.add(listPecasOrcamento);

		JButton btnExcluiServicoOrcamento = new JButton("-");

		btnExcluiServicoOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalOrcamento.setText(String.valueOf(orcamento.getValor()));
			}
		});

		btnExcluiServicoOrcamento.setToolTipText("Exclui Servi\u00E7o do Or\u00E7amento");
		btnExcluiServicoOrcamento.setBounds(234, 192, 41, 23);
		contentPane.add(btnExcluiServicoOrcamento);

		JButton btnAdiconaServicoOrcamento = new JButton("+");

		btnAdiconaServicoOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalOrcamento.setText(String.valueOf(orcamento.getValor()));

			}
		});

		btnAdiconaServicoOrcamento.setToolTipText("Adiciona Servi\u00E7o no Or\u00E7amento");
		btnAdiconaServicoOrcamento.setBounds(274, 192, 41, 23);
		contentPane.add(btnAdiconaServicoOrcamento);

		JButton btnExcluiPecaOrcamento = new JButton("-");

		btnExcluiPecaOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalOrcamento.setText(String.valueOf(orcamento.getValor()));
			}
		});

		btnExcluiPecaOrcamento.setToolTipText("Exclui Pe\u00E7a do Or\u00E7amento");
		btnExcluiPecaOrcamento.setBounds(502, 192, 41, 23);
		contentPane.add(btnExcluiPecaOrcamento);

		JButton btnAdicionaPecaOrcamento = new JButton("+");

		btnAdicionaPecaOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalOrcamento.setText(String.valueOf(orcamento.getValor()));
			}
		});

		btnAdicionaPecaOrcamento.setToolTipText("Adiciona Pe\u00E7a no Or\u00E7amento");
		btnAdicionaPecaOrcamento.setBounds(542, 192, 41, 23);
		contentPane.add(btnAdicionaPecaOrcamento);

		JLabel lblTotalDoServio = new JLabel("Valor total do or\u00E7amento:    R$");
		lblTotalDoServio.setBounds(367, 402, 175, 14);
		contentPane.add(lblTotalDoServio);

		totalOrcamento.setBounds(546, 402, 46, 14);
		contentPane.add(totalOrcamento);

		JLabel lblServico = new JLabel("Servi\u00E7o");
		lblServico.setBounds(159, 25, 65, 14);
		contentPane.add(lblServico);

		JLabel lblValorPorHora = new JLabel("Valor por hora");
		lblValorPorHora.setBounds(297, 25, 83, 14);
		contentPane.add(lblValorPorHora);

		JLabel lblPeca = new JLabel("Pe\u00E7a");
		lblPeca.setBounds(395, 25, 46, 14);
		contentPane.add(lblPeca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(512, 25, 46, 14);
		contentPane.add(lblModelo);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(592, 25, 46, 14);
		contentPane.add(lblAno);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(661, 25, 46, 14);
		contentPane.add(lblValor);

		JLabel lblPecaSelecionada = new JLabel("Pe\u00E7a selecionada");
		lblPecaSelecionada.setBounds(395, 223, 107, 14);
		contentPane.add(lblPecaSelecionada);

		JLabel label_1 = new JLabel("Modelo");
		label_1.setBounds(512, 223, 46, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Ano");
		label_2.setBounds(592, 223, 46, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Valor");
		label_3.setBounds(661, 223, 46, 14);
		contentPane.add(label_3);

		JLabel lblServicoSelecionado = new JLabel("Servi\u00E7o selecionado");
		lblServicoSelecionado.setBounds(159, 223, 116, 14);
		contentPane.add(lblServicoSelecionado);

		JLabel label_5 = new JLabel("Valor por hora");
		label_5.setBounds(297, 223, 83, 14);
		contentPane.add(label_5);
	}

	public void criaCarro(String nome, String modelo, int ano) {
		Carro carro = new Carro(nome, modelo, ano);
		listaCarro.add(carro);
		this.comboBox.addItem(carro.getNome().toString());
	}

	public void criaPeca(String nome, int carroIndex, int anoInicial, int anoFinal, float valor) {
		Peca peca = new Peca(nome, listaCarro.get(carroIndex), anoInicial, anoFinal, valor);
		listaPeca.add(peca);
	}

	public void criaServico(String nome, float valorHora) {
		Servico servico = new Servico(nome, valorHora);
		listaServico.add(servico);
	}

	
	// funcao Teste Programa
	public void imprime() {
		System.out.println("Carros:");
		for (Carro carro : listaCarro) {
			System.out.println(carro.getNome() + "\n" + carro.getModelo() + "\n" + carro.getAno() + "\n");
		}
		System.out.println("\nPeças:");
		for (Peca peca : listaPeca) {
			System.out.println(peca.getNome() + "\n" + peca.getAnoInicial() + " - " + peca.getAnoFinal() + "\n"
					+ peca.getValor() + "\n");
		}
		System.out.println("\nServiços:");
		for (Servico servico : listaServico) {
			System.out.println(servico.getNome() + "\n" + servico.getValorHora() + "\n");
		}

	}

}
