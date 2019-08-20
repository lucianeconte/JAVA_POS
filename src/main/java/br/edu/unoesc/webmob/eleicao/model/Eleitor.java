package br.edu.unoesc.webmob.eleicao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe que representa um Eleitor
 * 
 * @author Roberson Alves
 *
 */
@Entity
public class Eleitor implements Validador {
	@Id
	private Long numeroTitulo;
	@Column(length = 40, nullable = false)
	private String nome;
	@Column(length = 40, nullable = false)
	private String nomeMae;
	@Column(nullable = false)
	private Short zonaEleitoral;
	@Column(nullable = false)
	private Short secao;

	/**
	 * @return the numeroTitulo
	 */
	public Long getNumeroTitulo() {
		return numeroTitulo;
	}

	/**
	 * @param numeroTitulo the numeroTitulo to set
	 */
	public void setNumeroTitulo(Long numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
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
	 * @return the nomeMae
	 */
	public String getNomeMae() {
		return nomeMae;
	}

	/**
	 * @param nomeMae the nomeMae to set
	 */
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	/**
	 * @return the zonaEleitoral
	 */
	public Short getZonaEleitoral() {
		return zonaEleitoral;
	}

	/**
	 * @param zonaEleitoral the zonaEleitoral to set
	 */
	public void setZonaEleitoral(Short zonaEleitoral) {
		this.zonaEleitoral = zonaEleitoral;
	}

	/**
	 * @return the secao
	 */
	public Short getSecao() {
		return secao;
	}

	/**
	 * @param secao the secao to set
	 */
	public void setSecao(Short secao) {
		this.secao = secao;
	}

	@Override
	public boolean validarDocumento(Long numero) {
		return numero > 100;
	}
}
