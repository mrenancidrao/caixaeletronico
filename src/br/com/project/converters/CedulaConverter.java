package br.com.project.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.framework.hibernate.session.HibernateUtil;
import br.com.project.model.classes.Cedula;

@FacesConverter(forClass = Cedula.class)
public class CedulaConverter implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		if (id != null && !id.isEmpty()) {
			return (Cedula) HibernateUtil.getCurrentSession().get(Cedula.class, new Integer(id));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		if (objeto != null) {
			Cedula c = (Cedula) objeto;
			return c.getId() != null && c.getId() > 0 ? c.getId().toString() : null;
		}
		return null;
	}

}
