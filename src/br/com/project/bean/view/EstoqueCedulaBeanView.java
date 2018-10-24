package br.com.project.bean.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.EstoqueCedulaController;
import br.com.project.model.classes.EstoqueCedula;

@Controller
@Scope(value = "view")
@ManagedBean(name = "estoqueCedulaBeanView")

public class EstoqueCedulaBeanView extends BeanManagedViewAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EstoqueCedula estoqueCedula = new EstoqueCedula();

	private EstoqueCedula estoqueAtualizado = new EstoqueCedula();

	@Autowired
	private EstoqueCedulaController estoqueCedulaController;

	private List<EstoqueCedula> list = new ArrayList<>();

	public EstoqueCedula getEstoqueCedula() {
		return estoqueCedula;
	}

	public void setEstoqueCedula(EstoqueCedula estoqueCedula) {
		this.estoqueCedula = estoqueCedula;
	}

	public EstoqueCedula getEstoqueAtualizado() {
		return estoqueAtualizado;
	}

	public void setEstoqueAtualizado(EstoqueCedula estoqueAtualizado) {
		this.estoqueAtualizado = estoqueAtualizado;
	}

	public List<EstoqueCedula> getList() throws Exception {
		list = estoqueCedulaController.findList(EstoqueCedula.class);
		return list;
	}

	public void reabastecer() throws Exception {
		estoqueAtualizado = estoqueCedulaController.findUniqueByProperty(EstoqueCedula.class,
				estoqueCedula.getCedula().getId(), "cedula.id", "");

		estoqueAtualizado.setEstoque(estoqueCedula.getEstoque() + estoqueAtualizado.getEstoque());

	}

	public String zerarEstoque() throws Exception {
		estoqueAtualizado.setEstoque(0);

		estoqueCedulaController.save(estoqueAtualizado);

		return "";
	}

	@Override
	public String save() throws Exception {
		reabastecer();

		estoqueCedulaController.save(estoqueAtualizado);

		estoqueCedula = new EstoqueCedula();

		return "";
	}

	@Autowired
	private EstoqueCedulaController estoqueEstoqueCedulaController;

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
