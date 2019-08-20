package br.edu.unoesc.webmob.eleicao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.webmob.eleicao.model.Partido;
import br.edu.unoesc.webmob.eleicao.repository.PartidoRepository;
import br.edu.unoesc.webmob.eleicao.service.PartidoService;

@Service
public class PartidoServiceImpl implements PartidoService {
	@Autowired
	private PartidoRepository partidoRepository;

	@Override
	public void salvar(Partido partido) {
		partidoRepository.save(partido);
	}

	@Override
	public void excluir(Partido partido) {
		partidoRepository.delete(partido);
	}

	@Override
	public List<Partido> listar() {
		return partidoRepository.findAll();
	}

	@Override
	public List<Partido> listarPorSigla(String sigla) {
		return partidoRepository.findByNomeLike("%" + sigla + "%");
	}

}