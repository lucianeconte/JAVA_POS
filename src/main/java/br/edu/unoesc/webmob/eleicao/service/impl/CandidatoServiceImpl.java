package br.edu.unoesc.webmob.eleicao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.webmob.eleicao.model.Candidato;
import br.edu.unoesc.webmob.eleicao.repository.CandidatoRepository;
import br.edu.unoesc.webmob.eleicao.service.CandidatoService;

@Service
public class CandidatoServiceImpl implements CandidatoService {
	@Autowired
	private CandidatoRepository candidatoRepository;

	@Override
	public void salvar(Candidato candidato) {
		candidatoRepository.save(candidato);
	}

	@Override
	public void excluir(Candidato candidato) {
		candidatoRepository.delete(candidato);
	}

	@Override
	public List<Candidato> listar() {
		return candidatoRepository.findAll();
	}

	@Override
	public List<Candidato> listarPorNome(String nome) {
		return candidatoRepository.findByNomeLike("%" + nome + "%");
	}

	@Override
	public List<Candidato> listarPorCPF(Long cpf) {
		return candidatoRepository.porCpf(cpf);
	}

	@Override
	public Candidato buscarPorCodigo(Integer codigo) {
		return candidatoRepository.findById(codigo).orElse(new Candidato());
	}

	@Override
	public List<Candidato> dadosGrid() {
		return candidatoRepository.dadosGrid();
	}

}
