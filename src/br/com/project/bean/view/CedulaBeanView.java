package br.com.project.bean.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.CedulaController;

@Controller
@Scope(value = "session")
@ManagedBean(name = "cedulaBeanView")
public class CedulaBeanView extends BeanManagedViewAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CedulaController cedulaController;
	
	public List<SelectItem> getCedulas() throws Exception {
		return cedulaController.getListCedula();
	}

	@Override
	protected Class<?> getClassImplement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected InterfaceCrud<?> getController() {
		// TODO Auto-generated method stub
		return null;
	}


}
