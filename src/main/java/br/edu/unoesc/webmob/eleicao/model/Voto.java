package br.edu.unoesc.webmob.eleicao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que representa os votos
 * 
 * @author Roberson Alves
 *
 */
@Entity
public class Voto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	@Column
	@Temporal(TemporalType.DATE)
	private Date data;
	@Column(nullable = false)
	private Long urna;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoRegistro")
	private Candidato candidato;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "numeroTitulo")
	private Eleitor eleitor;

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the urna
	 */
	public Long getUrna() {
		return urna;
	}

	/**
	 * @param urna the urna to set
	 */
	public void setUrna(Long urna) {
		this.urna = urna;
	}

	/**
	 * @return the candidato
	 */
	public Candidato getCandidato() {
		return candidato;
	}

	/**
	 * @param candidato the candidato to set
	 */
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	/**
	 * @return the eleitor
	 */
	public Eleitor getEleitor() {
		return eleitor;
	}

	/**
	 * @param eleitor the eleitor to set
	 */
	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

}
