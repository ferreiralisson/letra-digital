package br.com.facol.letra.digital.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.facol.letra.digital.model.Livro;

public class LivroDAO {

	public static List<Livro> livros = new ArrayList<>();

	static {
		Livro livro1 = new Livro(1, "Grande Sertão Veredas", "Drama", 560, "978-8535931983");
		Livro livro2 = new Livro(1, "Dom Casmurro", "Drama", 560, "978-8594318602");

		livros.add(livro1);
		livros.add(livro2);
	}

	public List<Livro> listarLivros() {
		return livros;
	}

	public void novoLivro(Livro livro) {

		Integer idLivro = 0;
		if (livros.size() > 0) {
			idLivro = livros.size() + 1;
		}
		livro.setId(idLivro);

		livros.add(livro);
	}

}
