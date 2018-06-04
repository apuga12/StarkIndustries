package mx.book.ajax.domain3;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEST_LIBS")
public class TestLibs implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "ISBN")
    //@GeneratedValue(strategy = GenerationType.AUTO)
	private String isbn;
	@Column(name = "ID_TEMA")
	private Integer idTema;
	private String titulo;
	private String autor;
	private Double precio;
	@Override
	public String toString() {
		return "TestLibs [isbn=" + isbn + ", idTema=" + idTema + ", titulo="
				+ titulo + ", autor=" + autor + ", precio=" + precio + "]";
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getIdTema() {
		return idTema;
	}
	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	

}
