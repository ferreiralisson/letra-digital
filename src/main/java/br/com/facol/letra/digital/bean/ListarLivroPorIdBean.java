package br.com.facol.letra.digital.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.facol.letra.digital.controller.TipoAcao;
import br.com.facol.letra.digital.dao.LivroDAO;
import br.com.facol.letra.digital.model.Livro;

public class ListarLivroPorIdBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public ListarLivroPorIdBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	public void execute() throws ServletException, IOException {
		String idParam = this.req.getParameter("id");
		Integer idLivro = Integer.valueOf(idParam);

		LivroDAO dao = new LivroDAO();
		try {
			Livro livro = dao.buscarLivroPorId(idLivro);
			if (livro != null) {
				this.req.setAttribute("livro", livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = this.req.getRequestDispatcher("formAtualizarLivro.jsp");
		rd.forward(this.req, this.resp);

	}
}
