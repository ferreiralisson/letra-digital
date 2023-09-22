package br.com.facol.letra.digital.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.facol.letra.digital.controller.TipoAcao;

public class FormLoginBean implements TipoAcao{
	
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public FormLoginBean(HttpServletRequest req, HttpServletResponse resp) {
		super();
		this.req = req;
		this.resp = resp;
	}


	@Override
	public void execute() throws ServletException, IOException {
		RequestDispatcher rd = this.req.getRequestDispatcher("formLogin.jsp");
		rd.forward(this.req, this.resp);
		
	}

}
