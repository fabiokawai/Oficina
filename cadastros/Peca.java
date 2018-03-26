package cadastros;

public class Peca {
	private String nome;
	private Carro carro;
	private int anoInicial;
	private int anoFinal;
	private float valor;
	
	public Peca(String nome, Carro carro, int anoInicial, int anoFinal, float valor) {
		this.nome = nome;
		this.carro = carro;
		this.anoInicial = anoInicial;
		this.anoFinal = anoFinal;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public int getAnoInicial() {
		return anoInicial;
	}

	public int getAnoFinal() {
		return anoFinal;
	}

	public Carro getCarro() {
		return carro;
	}

	public float getValor() {
		return valor;
	}
	

}
