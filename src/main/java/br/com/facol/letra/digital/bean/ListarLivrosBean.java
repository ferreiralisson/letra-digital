package br.com.facol.letra.digital.bean;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.facol.letra.digital.controller.TipoAcao;
import br.com.facol.letra.digital.dao.LivroDAO;
import br.com.facol.letra.digital.model.Livro;

public class ListarLivrosBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public ListarLivrosBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	public void execute() throws ServletException, IOException {
		LivroDAO db = new LivroDAO();
		List<Livro> livros = db.listarLivros();
		this.req.setAttribute("livros", livros);

		RequestDispatcher dispatcher = this.req.getRequestDispatcher("/listarLivros.jsp");
		dispatcher.forward(this.req, this.resp);

	}

}
