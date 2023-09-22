package br.com.facol.letra.digital.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.facol.letra.digital.model.Livro;
import br.com.facol.letra.digital.model.Usuario;

public class LivroDAO {

	public static List<Livro> livros = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();

	static {
		Livro livro1 = new Livro(1, "Grande Sertão Veredas", "Drama", 560, "978-8535931983");
		Livro livro2 = new Livro(2, "Dom Casmurro", "Drama", 560, "978-8594318602");

		Usuario user1 = new Usuario("Alisson", "123");
		Usuario user2 = new Usuario("Ferreira", "321");

		usuarios.add(user1);
		usuarios.add(user2);

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

	public Livro buscarLivroPorId(Integer id) throws Exception {
		return livros.stream().filter(livro -> livro.getId().compareTo(id) == 0).findFirst()
				.orElseThrow(() -> new Exception("livro não encontrado"));
	}

	public void removerLivro(Integer id) {
		Iterator<Livro> it = livros.iterator();

		while (it.hasNext()) {
			Livro livro = it.next();

			if (livro.getId().compareTo(id) == 0) {
				it.remove();
			}
		}
	}

	public Usuario existeUsuario(String login, String senha) {

		for (Usuario usuario : usuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}

		return null;
	}

}
