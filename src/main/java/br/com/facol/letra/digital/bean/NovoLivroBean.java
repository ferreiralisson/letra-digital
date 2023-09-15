package br.com.facol.letra.digital.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.facol.letra.digital.controller.TipoAcao;
import br.com.facol.letra.digital.dao.LivroDAO;
import br.com.facol.letra.digital.model.Livro;

public class NovoLivroBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public NovoLivroBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	public void execute() throws ServletException, IOException {
		String titulo = this.req.getParameter("titulo");
		String genero = this.req.getParameter("genero");

		Livro livro = new Livro(titulo, genero);
		LivroDAO db = new LivroDAO();
		db.novoLivro(livro);

		// chamo o jsp
		this.resp.sendRedirect("livros?acao=listarLivros");

	}

}
