package br.com.project.bean.geral;

import org.springframework.stereotype.Component;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.util.all.BeanViewAbstract;

@Component
public abstract class BeanManagedViewAbstract extends BeanViewAbstract {

	private static final long serialVersionUID = 1L;
	
	protected abstract Class<?> getClassImplement();
	
	protected abstract InterfaceCrud<?> getController();
}
