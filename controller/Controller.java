package controller;

import java.util.ArrayList;
import java.util.List;

import Telas.TelaCadastroCarro;
import Telas.TelaCadastroPeca;
import Telas.TelaCadastroServico;
import Telas.TelaPrincipal;
import cadastros.Carro;

public class Controller {
	
	
	private static Controller instance;
	private TelaPrincipal telaPrincipal;
	private TelaCadastroCarro telaCarro;
	private TelaCadastroPeca telaPeca;
	private TelaCadastroServico telaServico;
	
	
	private Controller()
	{
	}
	
	public static Controller getInstance()
	{
		if (instance == null)
		{
			instance = new Controller();
		}
		return instance;
	}
	
	public void init()
	{
		telaPrincipal = new TelaPrincipal();
		telaCarro = new TelaCadastroCarro();
		telaPeca = new TelaCadastroPeca();
		telaServico = new TelaCadastroServico();
		telaPrincipal.setVisible(true);
	}
	
	
	
	public void change2TelaCarro()
	{
		telaCarro.limparTela();
		telaPrincipal.setVisible(false);
		telaCarro.setVisible(true);
	}
	
	public void change2TelaPeca(){
		telaPeca.limparTela();
		telaPrincipal.setVisible(false);
		telaPeca.setVisible(true);
	}
	
	public void change2TelaServico(){
		telaServico.limparTela();
		telaPrincipal.setVisible(false);
		telaServico.setVisible(true);
	}
	
	public void return2TelaPrincipal(){
		telaCarro.setVisible(false);
		telaPeca.setVisible(false);
		telaServico.setVisible(false);
		telaPrincipal.setVisible(true);
	}
	
	
	public void saveCarro(String nome, String modelo, int ano)
	{
		telaPrincipal.criaCarro(nome, modelo, ano);
		
	}

	public void savePeca(String nome, int carroIndex, int anoInicial, int anoFinal, float valor){
		telaPrincipal.criaPeca(nome, carroIndex, anoInicial, anoFinal, valor);
	}
	
	public void saveServico(String nome, float valorHora){
		telaPrincipal.criaServico(nome, valorHora);
	}
	
	
	
	
	
	
	
	
}
