package br.com.associados.converters;

import java.lang.reflect.Field;
import java.util.Collection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * @author manoel
 */
@FacesConverter("selectOneUsingObjectConverter")
public class SelectOneUsingObjectConverter implements Converter {

        @Override
        @SuppressWarnings("rawtypes")
        public final Object getAsObject(final FacesContext context,
                        final UIComponent component, final String value) {
                if (value == null || value.equals("")) {
                        return null;
                }

                try {
                        Long id = Long.valueOf(value);
                        Collection items = (Collection) component
                                        .getAttributes().get("items");
                        return findById(items, id);
                } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new ConverterException(
                                        "Não foi possível aplicar conversão de item com valor ["
                                                        + value
                                                        + "] no componente ["
                                                        + component.getId()
                                                        + "]", ex);
                }
        }

        @Override
        public final String getAsString(final FacesContext context,
                        final UIComponent component, final Object value) {
                if (value == null) {
                        return "";
                }

                try {

                        return getIdByReflection(value).toString();

                } catch (Exception e) {
                        return "";
                }
        }

        /**
         * @param collection
         * @param idToFind
         * @return
         */
        private Object findById(final Collection<?> collection,
                        final Long idToFind) {
                for (Object obj : collection) {
                        Long id = getIdByReflection(obj);
                        if (id.toString().equals(idToFind.toString())) {
                                return obj;
                        }
                }

                return null;
        }

        private Long getIdByReflection(final Object bean) {
                try {
                        Field idField = bean.getClass().getDeclaredField("id");
                        idField.setAccessible(true);
                        return (Long) idField.get(bean);
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
                return null;
        }
}
