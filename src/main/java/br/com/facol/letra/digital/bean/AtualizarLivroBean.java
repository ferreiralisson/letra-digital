package br.com.facol.letra.digital.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.facol.letra.digital.controller.TipoAcao;
import br.com.facol.letra.digital.dao.LivroDAO;
import br.com.facol.letra.digital.model.Livro;

public class AtualizarLivroBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public AtualizarLivroBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	public void execute() throws ServletException, IOException {
		String titulo = this.req.getParameter("titulo");
		String genero = this.req.getParameter("genero");
		String paramId = this.req.getParameter("id");

		Integer idLivro = Integer.valueOf(paramId);
		LivroDAO db = new LivroDAO();

		Livro livro;
		try {
			livro = db.buscarLivroPorId(idLivro);
			if (livro.getId() != null) {
				livro.setTitulo(titulo);
				livro.setGenero(genero);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// chamo o jsp
		this.resp.sendRedirect("livros?acao=listarLivros");

	}

}
