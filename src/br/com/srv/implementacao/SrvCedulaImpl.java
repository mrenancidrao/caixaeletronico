package br.com.srv.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.repository.interfaces.RepositoryCedula;
import br.com.srv.interfaces.SrvCedula;

@Service
public class SrvCedulaImpl implements SrvCedula {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RepositoryCedula repositoryCedula;
	
	
}
