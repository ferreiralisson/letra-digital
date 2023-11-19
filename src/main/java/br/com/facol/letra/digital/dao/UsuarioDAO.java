package br.com.facol.letra.digital.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.facol.letra.digital.model.Usuario;

public class UsuarioDAO {

	private static List<Usuario> usuarios = new ArrayList<>();

	static {
		Usuario user1 = new Usuario("Alisson", "123");
		Usuario user2 = new Usuario("Ferreira", "321");

		usuarios.add(user1);
		usuarios.add(user2);
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
