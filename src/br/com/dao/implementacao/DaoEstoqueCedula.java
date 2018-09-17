package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.EstoqueCedula;
import br.com.repository.interfaces.RepositoryEstoqueCedula;

@Repository
public class DaoEstoqueCedula extends ImplementacaoCrud<EstoqueCedula> implements RepositoryEstoqueCedula {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	
}
