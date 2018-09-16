package br.com.project.bean.view;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.UsuarioController;
import br.com.project.model.classes.Usuario;

@Controller
@Scope(value = "session")
@ManagedBean(name = "usuarioBeanView")
public class UsuarioBeanView extends BeanManagedViewAbstract{
	
	@Autowired
	private ContextoBean contextoBean;

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioController usuarioController;

	public String getUsuarioLogadoSecurity() {
		return contextoBean.getAuthentication().getName();
	}
	
	public Date getUltimoAcesso() throws Exception {
		return contextoBean.getUsuarioLogado().getUltimoAcesso();
	}


	@Override
	protected Class<Usuario> getClassImplement() {
		return Usuario.class;
	}

	@Override
	protected InterfaceCrud<Usuario> getController() {
		return usuarioController;
	}

}
