package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import connection.SingleConnection;

@WebFilter(urlPatterns = { "/*" }) // toda req vai ser intercepitada
public class Filter implements javax.servlet.Filter { // digita filter = javax.servlet

	private static Connection connection = SingleConnection.getConnection();

	//@Override
	public void destroy() {
		// chamado quando a aplicação web é finalizada.
	}

	//@Override
	/*
	 * public void doFilter(ServletRequest request, ServletResponse response,
	 * FilterChain chain) throws IOException, ServletException {
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		try {
			arg2.doFilter(arg0, arg1);
			// chain.doFilter(request, response);
			connection.commit();
		} catch (Exception e) {
			try {
				e.printStackTrace();
				connection.rollback(); // rollback -> deve conter mas um try cath isso é obrigado
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	//@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		connection = SingleConnection.getConnection();

	}

}
