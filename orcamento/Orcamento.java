package orcamento;

import java.util.ArrayList;
import java.util.List;

import cadastros.Carro;
import cadastros.Peca;
import cadastros.Servico;

public class Orcamento {
	private float valor = 0;
	private List<PecaOrcamento> listaPecasOrcamento = new ArrayList<PecaOrcamento>();
	private List<ServicoOrcamento> listaServicosOrcamento = new ArrayList<ServicoOrcamento>();
	private List<Carro> listaCarros = new ArrayList<Carro>();
	
	public float getValor() {
		valor = 0;
		for (ServicoOrcamento servico : listaServicosOrcamento) {
			valor+= servico.getQuantidade()*servico.getServico().getValorHora();
		}
		for (PecaOrcamento peca : listaPecasOrcamento) {
			valor+= peca.getQuantidade()*peca.getPeca().getValor();
		}
		return valor;
	}
	
	public void addListaPecas(Peca peca){
		boolean result = false;
		for (PecaOrcamento pecaOrcamento : listaPecasOrcamento) {
			if(pecaOrcamento.getPeca().equals(peca)){
				pecaOrcamento.incrementaQuantidade();
				result = true;
				break;
			}
		}
		if(!result){
			PecaOrcamento pecaOrcamento = new PecaOrcamento(peca, 1);
			listaPecasOrcamento.add(pecaOrcamento);
		}
	}
	
	public void addListaServicos(Servico servico){
		boolean result = false;
		for (ServicoOrcamento servicoOrcamento : listaServicosOrcamento) {
			if(servicoOrcamento.getServico().equals(servico)){
				servicoOrcamento.incrementaQuantidade();
				result = true;
				break;
			}
		}
		if(!result){
			ServicoOrcamento servicoOrcamento = new ServicoOrcamento(servico, 1);
			listaServicosOrcamento.add(servicoOrcamento);
		}
	}
	
	public void removeListaServicos(Servico servico){
		boolean result = false;
		ServicoOrcamento removeServicoOrcamento = null;
		for (ServicoOrcamento servicoOrcamento : listaServicosOrcamento) {
			if(servicoOrcamento.getServico().equals(servico)){
				servicoOrcamento.reduzQuantidade();
				result = true;
				if(servicoOrcamento.getQuantidade()== 0){
					removeServicoOrcamento = servicoOrcamento;
				}
				break;
			}
			if(removeServicoOrcamento!=null){
				listaServicosOrcamento.remove(removeServicoOrcamento);
			}
		}
		if(!result){
			System.out.println("Servico não está na lista");
		}
	}
	

	public void removeListaPecas(Peca peca){
		boolean result = false;
		PecaOrcamento removePecaOrcamento = null;
		for (PecaOrcamento pecaOrcamento : listaPecasOrcamento) {
			if(pecaOrcamento.getPeca().equals(peca)){
				pecaOrcamento.reduzQuantidade();
				result = true;
				if(pecaOrcamento.getQuantidade()== 0){
					removePecaOrcamento = pecaOrcamento;
				}
				break;
			}
		}
		if(removePecaOrcamento!=null){
			listaPecasOrcamento.remove(removePecaOrcamento);
		}
		if(!result){
			System.out.println("Peça não está na lista");
		}
	}
	
	public List getListPecas(){
		return listaPecasOrcamento;
	}
	
	public List getListServicos(){
		return listaServicosOrcamento;
	}
	
}
