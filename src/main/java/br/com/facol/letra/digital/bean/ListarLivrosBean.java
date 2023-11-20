package br.com.facol.letra.digital.bean;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.facol.letra.digital.controller.TipoAcao;
import br.com.facol.letra.digital.dao.DAO;
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

		List<Livro> livros = new DAO<Livro>(Livro.class).listaTodos();
		this.req.setAttribute("livros", livros);

		RequestDispatcher dispatcher = this.req.getRequestDispatcher("/listarLivros.jsp");
		dispatcher.forward(this.req, this.resp);

	}

}
