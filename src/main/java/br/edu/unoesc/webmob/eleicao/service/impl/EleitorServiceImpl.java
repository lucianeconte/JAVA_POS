package br.edu.unoesc.webmob.eleicao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.webmob.eleicao.model.Eleitor;
import br.edu.unoesc.webmob.eleicao.repository.EleitorRepository;
import br.edu.unoesc.webmob.eleicao.service.EleitorService;


@Service
public class EleitorServiceImpl implements EleitorService {
	@Autowired
	private EleitorRepository eleitorRepository;

	@Override
	public void salvar(Eleitor eleitor) { 
		eleitorRepository.save(eleitor);
	}
	
	@Override
	public void excluir(Eleitor eleitor) {
		eleitorRepository.delete(eleitor);
	}

	@Override
	public List<Eleitor> listar() {
		return eleitorRepository.findAll();
	}

	@Override
	public List<Eleitor> listarPorNome(String nome) {
		return eleitorRepository.findByNomeLike("%" + nome + "%");
	}

	@Override
	public List<Eleitor> listarPorNumeroTitulo(Long numeroTitulo) {
		return eleitorRepository.porNumeroTitulo(numeroTitulo);
	}


}