package org.example;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
    private ParDeValores[] table;
    private DefaultToString toStringFn;
    private int capacidade;
    private int tamanho;

    public HashTable(int capacidade) {
        this.toStringFn = new DefaultToString();
        this.capacidade = capacidade;
        this.table = new ParDeValores[this.capacidade];
        this.tamanho = 0;
    }

    public int mapearChave(Object chave) {
        if (chave instanceof Number) {
            return (int) chave;
        }
        final String chaveTabela = (String) this.toStringFn.defaultToString(chave);
        int hash = 0;
        for (int i = 0; i < chaveTabela.length(); i++) {
            hash += String.valueOf(chaveTabela.charAt(i)).hashCode();
        }
        return hash % 37;
    }

    public int hashcode(Object chave) {
        return mapearChave(chave);
    }

    public boolean put(Object chave, Estudante estudante) {
        this.aumentarCapacidade();
        if (chave != null && estudante != null) {

            final int posicao = hashcode(chave);

            this.table[posicao] = new ParDeValores<>((String) toStringFn.defaultToString(chave), estudante);
            this.tamanho++;
            return true;
        }
        return false;
    }

    public void aumentarCapacidade() {
        if (this.tamanho == this.capacidade) {
            ParDeValores[] novaTabela = new ParDeValores[this.capacidade * 2];
            for (int i = 0; i < this.table.length; i++) {
                novaTabela[i] = this.table[i];
            }
            this.table = novaTabela;
        }
    }

    public Object get(Object chave) {
        ParDeValores parChaveValor = this.table[hashcode(chave)];
        System.out.println(hashcode(chave));
        return parChaveValor == null ? "undefined" : parChaveValor.valor;
    }

    public void getAll() {
        for (ParDeValores parDeValores : this.table) {
            if(parDeValores != null) {

            System.out.println(parDeValores.toString());
            }
        }
    }

    public boolean remove(Object chave) {
        int hash = hashcode(chave);
        ParDeValores parChaveValor = this.table[hash];
        if (parChaveValor != null) {
            this.table[hash] = null;
            this.tamanho--;
            return true;
        }
        return false;
    }

    public int size() {
        return this.tamanho;
    }


    @Override
    public String toString() {
        return "HashTable{" +
                "table=" + Arrays.toString(table) +
                ", toStringFn=" + toStringFn +
                ", tamanho=" + capacidade +
                '}';
    }
}
