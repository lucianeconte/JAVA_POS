package br.edu.unoesc.webmob.eleicao.service;

import java.util.List;

import br.edu.unoesc.webmob.eleicao.model.Partido;

public interface PartidoService {
	public void salvar(Partido partido);
	public void excluir(Partido partido);
	public List<Partido> listar();
	public List<Partido> listarPorSigla(String siglas);

}
