package cadastros;

public class Servico {
	private String nome;
	private float valorHora;
	
	public Servico(String nome, float valorHora) {
		this.nome = nome;
		this.valorHora = valorHora;
	}

	public float getValorHora() {
		return valorHora;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
