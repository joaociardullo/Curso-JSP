package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection; // chamando a conexao

	public DaoUsuario() {
		connection = SingleConnection.getConnection();

	}

	// Inserindo usuario BD
	public void salvar(BeanCursoJsp usuario) {

		try {

			String sql = "insert into usuario(login, senha, nome) values (?, ?, ?)"; // inserindo ?passando os valores
			PreparedStatement insert = connection.prepareStatement(sql);// preparando a conexao
			insert.setString(1, usuario.getLogin());// as variaveis
			insert.setString(2, usuario.getSenha());// variaveis
			insert.setString(3, usuario.getNome());
			insert.execute();// execute o comando
			connection.commit();
			/**
			 * tray Catch deve compor em todo bloco para sim poder saber o erro
			 */
		} catch (Exception e) {
			e.printStackTrace(); // tendo o printStacktrace
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	// listar os usuarios

	public List<BeanCursoJsp> listar() throws Exception {
		List<BeanCursoJsp> listar = new ArrayList<BeanCursoJsp>();
		String sql = "select * from usuario"; // puxando do sql

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();// executando a query do BD
		while (resultSet.next()) {

			BeanCursoJsp beanCursoJsp = new BeanCursoJsp(); // Estaciando um Obejto "New"
			beanCursoJsp.setId(resultSet.getLong("id"));
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			beanCursoJsp.setNome(resultSet.getString("nome"));

			listar.add(beanCursoJsp);// listando

		}
		return listar; // retornando a list do metodo listar()
	}

	//delete
	public void delete(String id) {

		try {
			String sql = "delete  from usuario where id='" + id + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {

			}
		}
	}

	public BeanCursoJsp consultar(String id) throws Exception {
		String sql = "select * from usuario where id='" + id + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setId(resultSet.getLong("id"));
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			beanCursoJsp.setNome(resultSet.getString("nome"));

			return beanCursoJsp;

		}
		return null;
	}
	
	
	
	public boolean validarLogin(String login) throws Exception {
		String sql = "select count(1) as qtd from usuario where login='" + login + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			

			return resultSet.getInt("qtd") <=0 ; //é menor igual a zero retorna true=0

		}
		return false;
	}

	public void atualizar(BeanCursoJsp usuario) {

		try {
			String sql = "update usuario set login =?, senha = ?, nome = ? where id =" + usuario.getId();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}
}
