package br.com.facol.letra.digital.model;

public class Livro {

	private Integer id;
	private String titulo;
	private String genero;
	private Integer quantidadePaginas;
	private String isbn;

	public Livro(Integer id, String titulo, String genero, Integer quantidadePaginas, String isbn) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.quantidadePaginas = quantidadePaginas;
		this.isbn = isbn;
	}

	public Livro(String titulo, String genero) {
		super();
		this.titulo = titulo;
		this.genero = genero;
	}

	public Livro() {
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getGenero() {
		return genero;
	}

	public Integer getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
