package br.com.project.bean.view;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.EstoqueCedulaController;
import br.com.project.model.classes.Cedula;
import br.com.project.model.classes.EstoqueCedula;

@Controller
@Scope(value = "request")
@ManagedBean(name = "saqueCedulaBeanView")
public class SaqueCedulaBeanView extends BeanManagedViewAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer valorSaque;
	
	private List<EstoqueCedula> listEstoqueCedula = new ArrayList<EstoqueCedula>();
	
	private List<Cedula> cedulasDisponiveis = new ArrayList<Cedula>();
	
	private List<List<Object[]>> opcoesDisponiveis = new ArrayList<List<Object[]>>();  
	
	private HashMap<Integer, Cedula> opcoesDisponiveisMap = new HashMap<Integer, Cedula>(); 
	
	List<OpcaoSaqueView> listOpcaoSaqueView = new ArrayList<OpcaoSaqueView>();
	
	List<Object[]> opcao = new ArrayList<>();
	
	@Autowired
	private EstoqueCedulaController estoqueCedulaController;

	public Integer getValorSaque() {
		return valorSaque;
	}

	public void setValorSaque(Integer valorSaque) {
		this.valorSaque = valorSaque;
	}
	
	

	public List<Object[]> getOpcao() {
		return opcao;
	}

	public void setOpcao(List<Object[]> opcao) {
		this.opcao = opcao;
	}

	
	public void saque() throws Exception {
		this.listOpcaoSaqueView = new ArrayList<OpcaoSaqueView>();
		
		this.buscaOpcoesSaque(valorSaque, buscarCedulasDisponiveis());
		
		this.montarOpcoesParaView();
		
	}
	
	@Override
	public String save() throws Exception {
		
		System.out.println(this.opcao);
		
		return "";
	}
	
	public List<EstoqueCedula> buscarCedulasDisponiveis() throws Exception {
		listEstoqueCedula = estoqueCedulaController.getCedulasDisponiveis();
		
		return listEstoqueCedula;
	}
 
	private void buscaOpcoesSaque(Integer valorSaque, List<EstoqueCedula> listEstoqueCedula) {
		
		for (int c = 0; c < listEstoqueCedula.size(); c++) {
			
			for (int i = (valorSaque/listEstoqueCedula.get(c).getCedula().getValor()); i >= 0; i--) {
				List<Object[]> bloco = new ArrayList<Object[]>();
				Object[] qCedula = new Object[2];
				
				qCedula[0] = (Integer) i;
				qCedula[1] = (Cedula) listEstoqueCedula.get(c).getCedula();
				

				int tmp = i * listEstoqueCedula.get(c).getCedula().getValor();
				if (tmp == valorSaque) {	
					
					bloco.add(qCedula);
					
					opcoesDisponiveis.add(bloco);
					opcoesDisponiveisMap.put((Integer) qCedula[0], (Cedula) qCedula[1]);
					
					bloco = new ArrayList<Object[]>();
				}
				
				else {
					if (tmp < valorSaque && tmp != 0) {						
						
						if (c+1 < listEstoqueCedula.size()) {
							for (int j = (valorSaque/listEstoqueCedula.get(c+1).getCedula().getValor()); j >= 0; j--) {
								
								int tmp2 = j * listEstoqueCedula.get(c+1).getCedula().getValor();

								Object[] qCedula2 = new Object[2];
								qCedula2[0] = (Integer) j;
								qCedula2[1] = (Cedula) listEstoqueCedula.get(c+1).getCedula();
								
								if (tmp + tmp2 == valorSaque) {
									
									if ((Integer) qCedula[0] > 0)
										bloco.add(qCedula);
									if ((Integer) qCedula2[0] > 0)
										bloco.add(qCedula2);
									
									opcoesDisponiveis.add(bloco);
									
									opcoesDisponiveisMap.put((Integer) qCedula[0], (Cedula) qCedula[1]);
									opcoesDisponiveisMap.put((Integer) qCedula2[0], (Cedula) qCedula2[1]);
									
									bloco = new ArrayList<Object[]>();
								}
								
								else {
									if (tmp + tmp2 < valorSaque) {
										
										if (c+2 < listEstoqueCedula.size()) {
											for (int k = (valorSaque/listEstoqueCedula.get(c+2).getCedula().getValor()); k >= 0; k--) {
												int tmp3 = k * listEstoqueCedula.get(c+2).getCedula().getValor();

												Object[] qCedula3 = new Object[2];
												qCedula3[0] = (Integer) k;
												qCedula3[1] = (Cedula) listEstoqueCedula.get(c+2).getCedula();
												
												if (tmp + tmp2 + tmp3 == valorSaque) {
													
													if ((Integer) qCedula[0] > 0)
														bloco.add(qCedula);
													if ((Integer) qCedula2[0] > 0)
														bloco.add(qCedula2);
													if ((Integer)qCedula3[0] > 0 && (Integer) qCedula3[0] < 51)
														bloco.add(qCedula3);
													
													opcoesDisponiveis.add(bloco);
													
													opcoesDisponiveisMap.put((Integer) qCedula[0], (Cedula) qCedula[1]);
													opcoesDisponiveisMap.put((Integer) qCedula2[0], (Cedula) qCedula2[1]);
													opcoesDisponiveisMap.put((Integer) qCedula3[0], (Cedula) qCedula3[1]);
													
													bloco = new ArrayList<Object[]>();
												}
												
												
												else {
													if (tmp + tmp2 + tmp3 < valorSaque) {
														
														if (c+3 < listEstoqueCedula.size()) {
															for (int l = (valorSaque/listEstoqueCedula.get(c+3).getCedula().getValor()); l >= 0; l--) {
																int tmp4 = l * listEstoqueCedula.get(c+3).getCedula().getValor();

																Object[] qCedula4 = new Integer[2];
																qCedula4[0] = (Integer) l;
																qCedula4[1] = (Cedula) listEstoqueCedula.get(c+3).getCedula();
																
																if (tmp + tmp2 + tmp3 + tmp4 == valorSaque) {
																	
																	if ((Integer) qCedula[0] > 0)
																		bloco.add(qCedula);
																	if ((Integer) qCedula2[0] > 0)
																		bloco.add(qCedula2);
																	if ((Integer) qCedula3[0] > 0 && (Integer) qCedula3[0] < 51)
																		bloco.add(qCedula3);
																	if ((Integer) qCedula4[0] > 0 && (Integer) qCedula4[0] < 51)
																		bloco.add(qCedula4);
																	
																	if (bloco.size() <= 3) {
																		opcoesDisponiveis.add(bloco);

																		opcoesDisponiveisMap.put((Integer) qCedula[0], (Cedula) qCedula[1]);
																		opcoesDisponiveisMap.put((Integer) qCedula2[0], (Cedula) qCedula2[1]);
																		opcoesDisponiveisMap.put((Integer) qCedula3[0], (Cedula) qCedula3[1]);
																		opcoesDisponiveisMap.put((Integer) qCedula4[0], (Cedula) qCedula4[1]);
																	}
																	
																	bloco = new ArrayList<Object[]>();
																}
															}
														}
													}
												}
												
											}
										}
									}
								}
							}
						}
						
					}
				}
	
			}
			
		}
	}
	
	
	private void montarOpcoesParaView() {
		
		listOpcaoSaqueView.clear();
		
		for (List<Object[]> opcoes : opcoesDisponiveis) {
			
			OpcaoSaqueView opcaoSaqueAux = new OpcaoSaqueView();
			
			String titulo = "";
			for (Object[] opcao : opcoes) {
				Cedula cedulaAux = (Cedula) opcao[1];
				titulo += opcao[0] + "x R$" + cedulaAux.getDescricao() + " ";
			}
			
			opcaoSaqueAux.setTitulo(titulo);
			opcaoSaqueAux.setCombinacaoCedula(opcoes);
			
			listOpcaoSaqueView.add(opcaoSaqueAux);
			
		}
		
	}
	
	
	public List<SelectItem> getListOpcoesSaqueView() throws Exception  {
		
		montarOpcoesParaView();
		
		List<SelectItem> list = new ArrayList<SelectItem>();
		
		list.clear();
		
		for (OpcaoSaqueView opcao : listOpcaoSaqueView) {
			list.add(new SelectItem(opcao.combinacaoCedula, opcao.titulo));
		}
		return list;
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

	
	
	class OpcaoSaqueView {
		
		private String titulo;
		
		private List<Object[]> combinacaoCedula = new ArrayList<Object[]>();

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public List<Object[]> getCombinacaoCedula() {
			return combinacaoCedula;
		}

		public void setCombinacaoCedula(List<Object[]> combinacaoCedula) {
			this.combinacaoCedula = combinacaoCedula;
		}
		
		
	}
	
}
