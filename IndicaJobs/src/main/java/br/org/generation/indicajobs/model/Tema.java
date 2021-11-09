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
	private long idTema;

	@NotNull (message = "Campo título é obrigatório!")
	@Size (min = 5, max = 100, message = "O campo título deve conter no mínimo 5 e no máximo 100 caracteres.")
	private String tituloTema;

	@NotNull (message = "Campo descrição é obrigatório!")
	@Size (min = 5, max = 1000, message = "O campo descrição deve conter no mínimo 5 e no máximo 1000 caracteres.")
	private String descricaoTema;

	private String palavraChave;

	public void tema() {

	}

	public long getIdTema() {
		return idTema;
	}

	public void setIdTema(long idTema) {
		this.idTema = idTema;
	}

	public String getTitulotema() {
		return tituloTema;
	}

	public void setTituloTema(String tituloTema) {
		this.tituloTema = tituloTema;
	}

	public String getDescricaoTema() {
		return descricaoTema;
	}

	public void setDescricaoTema(String descricaoTema) {
		this.descricaoTema = descricaoTema;
	}

	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}
}
