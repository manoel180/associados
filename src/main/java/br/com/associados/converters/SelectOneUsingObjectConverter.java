package br.com.associados.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.associados.model.AbstractBean;

/**
 * @author manoel
 */

@FacesConverter("selectOneUsingObjectConverter")
public class SelectOneUsingObjectConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	try {
	    if (value != null && !value.isEmpty()) {
	            return (AbstractBean) uiComponent.getAttributes().get(value);
	        }    
	} catch (Exception e) {
	    e.printStackTrace();
	    return value;
	}
	return null;
       
       
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof AbstractBean) {
            AbstractBean entity= (AbstractBean) value;
            if (entity != null && entity instanceof AbstractBean && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }

}
