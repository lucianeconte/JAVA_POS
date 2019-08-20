package br.edu.unoesc.webmob.eleicao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa um partido
 * 
 * @author Roberson Alves
 *
 */
@Entity
public class Partido {
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	@Column(length = 30, nullable = false)
	private String nome;
	@Column(length = 10, nullable = false)
	private String sigla;

	// construtor
	public Partido(Integer codigo, String nome, String sigla) {
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
	}

	//Teste para arrumar erro "No default constructor for entity"
	public Partido() {  
	}  
	
	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
