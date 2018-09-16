package br.com.project.bean.view;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.project.geral.controller.UsuarioController;
import br.com.project.geral.controller.SessionController;
import br.com.project.model.classes.Usuario;

@Scope(value = "session")
@Component(value = "contextoBean")
public class ContextoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String USER_LOGADO_SESSAO = "userLogadoSessao";
	
	@Autowired
	private UsuarioController usuarioController;
	
	@Autowired 
	private SessionController sessionController;

	/**
	 * Retorna todas as informa��es do usu�rio logado
	 * @return Authentication
	 */
	public Authentication getAuthentication(){
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public Usuario getUsuarioLogado() throws Exception{
		Usuario usuario = (Usuario) getExternalContext().getSessionMap().get(USER_LOGADO_SESSAO);
		
		if (usuario == null || (usuario != null &&
				!usuario.getLogin().equals(getUserPrincipal()))){
			
			if (getAuthentication().isAuthenticated()){
				usuarioController.updateUltimoAcessoUser(getAuthentication().getName());
				
				usuario = usuarioController.findUserLogado(getAuthentication().getName());
				getExternalContext().getSessionMap().put(USER_LOGADO_SESSAO, usuario);		
				
				sessionController.addSession(usuario.getLogin(),
						(HttpSession) getExternalContext().getSession(true));
			}
		}
		return usuario;
	}
	
	
	private String getUserPrincipal() {
		return getExternalContext().getUserPrincipal().getName();
	}

	public ExternalContext getExternalContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		return externalContext;
	}
}
