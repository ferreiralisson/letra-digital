package br.com.facol.letra.digital.controller;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/livros")
public class LivrosController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("acao");

		HttpSession session = req.getSession();
		boolean isLogado = session.getAttribute("usuarioLogado") == null;
		boolean isProtected = !(action.equalsIgnoreCase("Login") || action.equalsIgnoreCase("formLogin"));

		if (isLogado && isProtected) {
			resp.sendRedirect("livros?acao=formLogin");
			return;
		}

		String fqn = "br.com.facol.letra.digital.bean." + Character.toUpperCase(action.charAt(0)) + action.substring(1)
				+ "Bean";

		System.out.println(fqn);

		try {
			Class<?> classe = Class.forName(fqn);
			Constructor<?> construtor = classe.getDeclaredConstructor(HttpServletRequest.class,
					HttpServletResponse.class);

			TipoAcao tipoAcao = (TipoAcao) construtor.newInstance(req, resp);
			tipoAcao.execute();
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ServletException(e);
		}

	}

}
