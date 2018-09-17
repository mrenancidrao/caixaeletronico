package br.com.srv.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.repository.interfaces.RepositoryEstoqueCedula;
import br.com.srv.interfaces.SrvEstoqueCedula;

@Service
public class SrvEstoqueCedulaImpl implements SrvEstoqueCedula {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RepositoryEstoqueCedula repositoryEstoqueCedula;
	
	
}
