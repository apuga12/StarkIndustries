package mx.book.ajax.domain3;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEST_CAT")
public class TestCat implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "ID_TEMA")
    //@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTema;
	private String tema;
	private String comentarios;
	
	@Override
	public String toString() {
		return "TestCat [idTema=" + idTema + ", tema=" + tema
				+ ", comentarios=" + comentarios + "]";
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}
