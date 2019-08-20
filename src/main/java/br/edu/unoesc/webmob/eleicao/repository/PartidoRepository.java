package br.edu.unoesc.webmob.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.webmob.eleicao.model.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {
	public List<Partido> findByNomeLike(String sigla);

	@Query("select p from Partido p where p.sigla = :sigla")
	List<Partido> porSigla(@Param("sigla") String sigla);
	
	//public Partido buscarPorCodigo(Integer codigo);

}
