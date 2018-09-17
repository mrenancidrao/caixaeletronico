package br.com.dao.implementacao;

import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Usuario;
import br.com.repository.interfaces.RepositoryUsuario;

@Repository
public class DaoUsuario extends ImplementacaoCrud<Usuario> implements
		RepositoryUsuario {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void updateUltimoAcessoUser(String login) {
		String sql = "update usuario set ultimo_acesso = current_timestamp where ativo is true and login = ? ";
		super.getSimpleJdbcTemplate().update(sql, login);
	}

	@Override
	public boolean existeUsuario(String login) {
		StringBuilder builder = new StringBuilder();
		builder.append(" select count(1) >=1 from usuario where login = '").append(login).append("' ");
		return super.getJdbcTemplate().queryForObject(builder.toString(), Boolean.class);
	}	

	@Override
	public Date getUltimoAcessoUsuarioLogado(String name) {

		SqlRowSet rowSet = super
				.getJdbcTemplate()
				.queryForRowSet(
						"select ultimo_acesso from usuario where ativo is true and login = ?",
						new Object[] { name });

		return rowSet.next() ? rowSet.getDate("ultimo_acesso") : null;
	}

	

}
