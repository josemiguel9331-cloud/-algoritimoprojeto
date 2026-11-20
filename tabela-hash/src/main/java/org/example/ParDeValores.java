package org.example;

public class ParDeValores<T> {
    String chave;
    T valor;

    public ParDeValores(String chave, T valor) {
        this.chave = chave;
        this.valor = valor;

    }

    @Override
    public String toString() {
        return "ParChaveValor{chave=" + chave + ", valor=" + valor+

                "}";
    }
}
