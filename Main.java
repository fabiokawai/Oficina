import java.util.ArrayList;
import java.util.List;

import Telas.TelaCadastroCarro;
import Telas.TelaCadastroPeca;
import Telas.TelaCadastroServico;
import Telas.TelaPrincipal;
import cadastros.Carro;
import cadastros.Peca;
import cadastros.Servico;
import controller.Controller;
import orcamento.Orcamento;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		Controller.getInstance().init();
		//

		listaPeca.add(criaPeca("Freio", listaCarro.get(0), 2015, 2017, 1500));
		listaPeca.add(criaPeca("Banco", listaCarro.get(0), 2015, 2017, 1600));
		
		listaServico.add(criaServico("Pintura", 600));
		listaServico.add(criaServico("Alinhamento", 700));
		
		orcamento.addListaPecas(listaPeca.get(0));
		orcamento.addListaPecas(listaPeca.get(1));
		orcamento.addListaPecas(listaPeca.get(1));
		orcamento.addListaPecas(listaPeca.get(1));
		
		orcamento.addListaServicos(listaServico.get(0));
		orcamento.addListaServicos(listaServico.get(1));
		orcamento.addListaServicos(listaServico.get(2));
		orcamento.addListaServicos(listaServico.get(2));


		System.out.println(orcamento.getValor());

		System.out.println("\n\n" + listaCarro.get(5).getNome() + "\n\n");
		
		for (Carro carro : listaCarro) {
			System.out.println(carro.getNome() + " " + carro.getModelo() + " " + carro.getAno());
		}

		geraListaPecaCarro(listaCarro.get(0));
		
		for (Peca peca : listaPecaCarro) {
			System.out.println("Peça: " + peca.getNome() + "\nAno: " + peca.getAnoInicial() + " - " + peca.getAnoFinal());
		}
//
	}

	
	
	public static Servico criaServico(String nome, float valorHora){
		Servico servico = new Servico(nome, valorHora);
		return servico;
	}
	
	public static Peca criaPeca(String nome, Carro carro, int anoInicial, int anoFinal, float valor){
		Peca peca = new Peca(nome, carro, anoInicial, anoFinal, valor);
		return peca;
	}
	
/*
	public static void geraListaPecaCarro(Carro carro){
		listaPecaCarro.clear();
		for (Peca peca : listaPeca) {
			if (peca.getCarro().equals(carro) && peca.getAnoInicial()<=carro.getAno() && peca.getAnoFinal()>=carro.getAno()){
				listaPecaCarro.add(peca);
			}
		}
	}*/
}
