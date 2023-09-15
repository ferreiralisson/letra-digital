package br.com.facol.letra.digital.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.facol.letra.digital.controller.TipoAcao;
import br.com.facol.letra.digital.dao.LivroDAO;

public class DeletarLivroServiceBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public DeletarLivroServiceBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	public void execute() throws ServletException, IOException {

		String idParam = this.req.getParameter("id");
		Integer idLivro = Integer.valueOf(idParam);

		LivroDAO db = new LivroDAO();
		db.removerLivro(idLivro);

		// chamo o jsp
		this.resp.sendRedirect("livros?acao=listarLivros");

	}

}
