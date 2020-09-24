package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;

@WebFilter(filterName = "SecurityFilterCliente", urlPatterns = { "/faces/pagescliente/*" })
public class SecurityFilterCliente implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest servletRequest = (HttpServletRequest) request;
		// imprime o endereco da pagina
		String endereco = servletRequest.getRequestURI();
		System.out.println(servletRequest.getRequestURL());
		System.out.println(endereco);

// 	 	Para desabilitar o filter, descomente as duas proximas linhas e comente o restante		
		chain.doFilter(request, response);
		return;

		// filtrando o nome da pagina
//		if (endereco != null) {
//			int inicio = endereco.lastIndexOf("/faces/") + 7;
//			int fim = endereco.length();
//			endereco = endereco.substring(inicio, fim);
//		}
//		System.out.println(endereco);
//
//		// caso seja a pagina de login .. nao sera feita nenhuma restricao
//		// deixo o fluxo seguir
//		if (endereco.equals("logincliente.xhtml") || servletRequest.getRequestURI().matches(".*(css|jpg|png|gif|js)")) {
//			chain.doFilter(request, response);
//			return;
//		}
//
//		// retorna a sessao corrente (false - para nao criar uma nova sessao)
//		HttpSession session = servletRequest.getSession(false);
//
//		Cliente usuario = null;
//		if (session != null)
//			usuario = (Cliente) session.getAttribute("clienteLogado");
//
//		if (usuario == null) {
//			((HttpServletResponse) response).sendRedirect("/Biblioteca/faces/logincliente.xhtml");
//		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SecurityFilter Iniciado.");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}