package br.edu.unoesc.webmob.eleicao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe que representa um candidato
 * 
 * @author Roberson Alves
 *
 */
@Entity
public class Candidato implements Validador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigoRegistro;
	@Column(length = 40, nullable = false)
	private String nome;
	@Column(nullable = false)
	private Long cpf;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo")
	private Partido partido;
	@Column
	private Cargo cargo;

	/**
	 * @return the codigoRegistro
	 */
	public Integer getCodigoRegistro() {
		return codigoRegistro;
	}

	/**
	 * @param codigoRegistro the codigoRegistro to set
	 */
	public void setCodigoRegistro(Integer codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cpf
	 */
	public Long getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the partido
	 */
	public Partido getPartido() {
		return partido;
	}

	/**
	 * @param partido the partido to set
	 */
	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	/**
	 * @return the cargo
	 */
	public Cargo getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public boolean validarDocumento(Long numero) {
		return numero > 10; // número maior que 10
	}

}
