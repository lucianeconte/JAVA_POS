package br.edu.unoesc.webmob.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.webmob.eleicao.model.Eleitor;

public interface EleitorRepository extends JpaRepository<Eleitor, Integer> {
	public List<Eleitor> findByNomeLike(String nome);

	@Query("select p from Eleitor p where p.numeroTitulo = :numeroTitulo")
	List<Eleitor> porNumeroTitulo(@Param("numeroTitulo") Long numeroTitulo);

}
