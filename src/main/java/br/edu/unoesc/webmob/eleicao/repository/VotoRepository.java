package br.edu.unoesc.webmob.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.webmob.eleicao.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
	@Query("select p from Voto p where p.urna = :urna")
	List<Voto> porUrna(@Param("urna") Long urna);
	
	@Query("select p from Voto p where p.urna = :codigoRegistro")
	List<Voto> porCodigoRegistro(@Param("codigoRegistro") Integer codigoRegistro);

	@Query("select v from Voto v inner join fetch v.eleitor")
	List<Voto> dadosGrid();

}
