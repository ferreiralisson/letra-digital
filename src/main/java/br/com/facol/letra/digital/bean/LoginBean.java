package br.com.facol.letra.digital.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.facol.letra.digital.controller.TipoAcao;
import br.com.facol.letra.digital.dao.LivroDAO;
import br.com.facol.letra.digital.model.Usuario;

public class LoginBean implements TipoAcao {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	public LoginBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {
		String login = this.req.getParameter("login");
		String senha = this.req.getParameter("senha");

		LivroDAO dao = new LivroDAO();
		Usuario usuario = dao.existeUsuario(login, senha);
		

		if (usuario != null) {
			HttpSession session = this.req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			this.resp.sendRedirect("livros?acao=inicio");
		} else {
			this.resp.sendRedirect("livros?acao=formLogin");
		}
		

	}

}
