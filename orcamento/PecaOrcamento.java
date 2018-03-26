package orcamento;
import cadastros.Peca;

public class PecaOrcamento {
	
	private Peca peca;
	private int quantidade;
	
	public PecaOrcamento(Peca peca, int quantidade) {
		this.peca = peca;
		this.quantidade = quantidade;
	}
	
	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
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
