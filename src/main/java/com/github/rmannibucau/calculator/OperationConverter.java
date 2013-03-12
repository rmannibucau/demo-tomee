package com.github.rmannibucau.calculator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.HashMap;
import java.util.Map;

@FacesConverter(forClass = Operation.class)
public class OperationConverter implements Converter {
    private static final Map<String, Operation> REVERSE_MAP = new HashMap<String, Operation>();
    static {
        for (final Operation o : Operation.values()) {
            REVERSE_MAP.put(o.getSymbol(), o);
        }
    }

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String value)
            throws ConverterException {
        if (value == null) {
            return null;
        }
        return REVERSE_MAP.get(value);
    }

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object value)
            throws ConverterException {
        if (value == null) {
            return null;
        }
        return Operation.class.cast(value).getSymbol();
    }
}
