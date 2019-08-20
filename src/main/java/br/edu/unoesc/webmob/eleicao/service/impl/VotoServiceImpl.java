package br.edu.unoesc.webmob.eleicao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.webmob.eleicao.model.Voto;
import br.edu.unoesc.webmob.eleicao.repository.VotoRepository;
import br.edu.unoesc.webmob.eleicao.service.VotoService;

@Service
public class VotoServiceImpl implements VotoService {
	@Autowired
	private VotoRepository votoRepository;

	@Override
	public void salvar(Voto voto) {
		votoRepository.save(voto);
	}

	@Override
	public void excluir(Voto voto) {
		votoRepository.delete(voto);
	}

	@Override
	public List<Voto> listarPorUrna(Long urna) {
		return votoRepository.porUrna(urna);
	}

	@Override
	public List<Voto> listarPorCandidato(Integer codigoRegistro) {
		return votoRepository.porCodigoRegistro(codigoRegistro);
	}
	
	@Override
	public List<Voto> dadosGrid() {
		return votoRepository.dadosGrid();
	}

}