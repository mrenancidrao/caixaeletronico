package br.com.project.geral.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Cedula;
import br.com.repository.interfaces.RepositoryCedula;
import br.com.srv.implementacao.SrvCedulaImpl;

@Controller
public class CedulaController extends ImplementacaoCrud<Cedula> implements InterfaceCrud<Cedula> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<SelectItem> getListCedula() throws Exception  {
		List<SelectItem> list = new ArrayList<SelectItem>();
		
		List<Cedula> cedulas = super.findListByQueryDinamica(" from Cedula");
		
		for (Cedula cedula : cedulas) {
			list.add(new SelectItem(cedula, cedula.getDescricao()));
		}
		return list;
	}
	

	public List<Cedula> getCedulasDisponiveis() throws Exception  {
		
		List<Cedula> cedulas = super.findListByQueryDinamica(" from Cedula c where exists (select 1 from EstoqueCedula ec where ec.cedula = c.id and ec.estoque > 0)");
		
		return cedulas;
	}
	
	
	

	@Autowired
	private SrvCedulaImpl srvCedula;
	
	@Autowired
	private RepositoryCedula repositoryCedula;
	
	

	
}
