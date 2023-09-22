package br.com.facol.letra.digital.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.facol.letra.digital.controller.TipoAcao;

public class LogoutBean implements TipoAcao{
	
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public LogoutBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}

	@Override
	public void execute() throws ServletException, IOException {
		HttpSession session = this.req.getSession();
		session.invalidate();
		
		this.resp.sendRedirect("livros?acao=formLogin");
	}

}
