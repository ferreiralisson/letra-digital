package br.com.facol.letra.digital.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.facol.letra.digital.controller.TipoAcao;

public class PaginaInicialBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public PaginaInicialBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	public void execute() throws ServletException, IOException {
		String action = this.req.getParameter("button");

		if (action.equals("Biblioteca")) {
			this.resp.sendRedirect("livros?acao=ListarLivros");
		} else if (action.equals("Novo livro")) {
			RequestDispatcher rd = this.req.getRequestDispatcher("formNovoLivro.jsp");
			rd.forward(this.req, this.resp);
		}

	}

}
