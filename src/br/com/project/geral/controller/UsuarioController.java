package br.com.project.geral.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Usuario;
import br.com.srv.interfaces.SrvUsuario;

@Controller
public class UsuarioController extends ImplementacaoCrud<Usuario> implements
		InterfaceCrud<Usuario> {
	
	@Autowired
	private SrvUsuario srvUsuario;

	private static final long serialVersionUID = 1L;
	
	
	public Usuario findUserLogado(String userLogado) throws Exception {
		return super.findUniqueByProperty(Usuario.class, 
				userLogado, "login", " and entity.ativo is true");
	}
	
	public Date getUltimoAcessoUsuarioLogada(String login) {
		return srvUsuario.getUltimoAcessoUsuarioLogado(login);
	}

	public void updateUltimoAcessoUser(String name) {
		srvUsuario.updateUltimoAcessoUser(name);
	}

}
