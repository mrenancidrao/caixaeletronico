package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Cedula;
import br.com.repository.interfaces.RepositoryCedula;

@Repository
public class DaoCedula extends ImplementacaoCrud<Cedula> implements RepositoryCedula {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	
}
