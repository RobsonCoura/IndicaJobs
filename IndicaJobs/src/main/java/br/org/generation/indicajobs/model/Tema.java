package br.org.generation.indicajobs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tema;

	@NotNull (message = "Campo título é obrigatório.")
	@Size (min = 5, max = 100, message = "O campo título deve conter no mínimo 5 e no máximo 100 caracteres.")
	private String titulo_tema;

	@NotNull (message = "Campo descrição é obrigatório.")
	@Size (min = 5, max = 1000, message = "O campo descrição deve conter no mínimo 5 e no máximo 1000 caracteres.")
	private String descricao_tema;

	private String palavra_chave;

	public void tema() {

	}

	public long getId_tema() {
		return id_tema;
	}

	public void setId_tema(long id_tema) {
		this.id_tema = id_tema;
	}

	public String getTitulo_tema() {
		return titulo_tema;
	}

	public void setTitulo_tema(String titulo_tema) {
		this.titulo_tema = titulo_tema;
	}

	public String getDescricao_tema() {
		return descricao_tema;
	}

	public void setDescricao_tema(String descricao_tema) {
		this.descricao_tema = descricao_tema;
	}

	public String getPalavra_chave() {
		return palavra_chave;
	}

	public void setPalavra_chave(String palavra_chave) {
		this.palavra_chave = palavra_chave;
	}
}
