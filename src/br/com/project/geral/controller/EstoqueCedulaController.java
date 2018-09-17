package br.com.project.geral.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.EstoqueCedula;
import br.com.repository.interfaces.RepositoryEstoqueCedula;
import br.com.srv.implementacao.SrvEstoqueCedulaImpl;

@Controller
public class EstoqueCedulaController extends ImplementacaoCrud<EstoqueCedula> implements InterfaceCrud<EstoqueCedula> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SrvEstoqueCedulaImpl srvEstoqueCedula;
	
	@Autowired
	private RepositoryEstoqueCedula repositoryEstoqueCedula;

	public List<EstoqueCedula> getCedulasDisponiveis() throws Exception  {
		
		List<EstoqueCedula> estoqueCedula = super.findListByQueryDinamica(" from EstoqueCedula where estoque > 0");
		
		return estoqueCedula;
	}
}
