package br.edu.unoesc.webmob.eleicao.service;

import java.util.List;

import br.edu.unoesc.webmob.eleicao.model.Eleitor;

public interface EleitorService {
	public void salvar(Eleitor eleitor);
	public void excluir(Eleitor eleitor);
	public List<Eleitor> listar();
	public List<Eleitor> listarPorNome(String nome);
	public List<Eleitor> listarPorNumeroTitulo(Long numeroTitulo);

}
