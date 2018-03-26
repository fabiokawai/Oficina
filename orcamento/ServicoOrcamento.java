package orcamento;

import cadastros.Servico;

public class ServicoOrcamento {
	
	private Servico servico;
	private int quantidade;
	
	public ServicoOrcamento(Servico servico, int quantidade) {
		super();
		this.servico = servico;
		this.quantidade = quantidade;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void incrementaQuantidade(){
		quantidade++;
	}
	
	public void reduzQuantidade(){
		quantidade--;
	}
	
}
