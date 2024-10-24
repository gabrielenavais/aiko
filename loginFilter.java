package br.com.aiko.util;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aiko.bean.LoginBean;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServerException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String url = request.getRequestURI().toString();

		if (url.contains("/usuarioaluno") && LoginBean.getUsuario().equals("aluno")) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else if (url.contains("/usuarioprofessor")
				&& LoginBean.getUsuario().equals("professor")) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else if (url.contains("/usuarioadm")
				&& LoginBean.getUsuario().equals("adm")) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			response.sendRedirect(request.getServletContext().getContextPath()
					+ "/home.xhtml");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
