package org.example;

import java.util.Objects;

public class DefaultToString<T> {
    public DefaultToString() {}
    public  T defaultToString(Object elemento) {
        if(elemento == null) {
            return null;
        }
        else if(elemento instanceof String) {
            return (T) Objects.toString((String)elemento);
        }

        return (T) elemento.toString();
    }
}
