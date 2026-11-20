package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashTableComColisoesTratados<T> {
    private LinkedList<ParDeValores> table[];
    private DefaultToString toStringFn;
    private int capacidade;
    private int tamanho;

    public HashTableComColisoesTratados(int capacidade) {
        this.toStringFn = new DefaultToString();
        this.capacidade = capacidade;
        this.table = new LinkedList[this.capacidade];
        this.tamanho = 0;
    }

    public int mapearChave(Object chave) {
        if (chave instanceof Number) {
            return (int) chave%37;
        }
        final String chaveTabela = (String) this.toStringFn.defaultToString(chave);
        int hash = 0;
        for (int i = 0; i < chaveTabela.length(); i++) {
            hash += String.valueOf(chaveTabela.charAt(i)).hashCode();
        }
        if (hash % 37 >= this.table.length) {
            return (hash % 37) % 37;
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
            if (this.table[posicao] == null) {
                this.table[posicao] = new LinkedList<>();
            }
            this.table[posicao].add(new ParDeValores(chave.toString(), estudante));
            this.tamanho++;
            return true;
        }
        return false;
    }

    public void aumentarCapacidade() {
        if (this.tamanho == this.capacidade) {
            LinkedList[] novaTabela = new LinkedList[this.capacidade * 2];
            for (int i = 0; i < this.capacidade; i++) {
                novaTabela[i] = new LinkedList<>();
                novaTabela[i] = this.table[i];
            }
            this.table = novaTabela;
        }
    }


    public Object get(Object chave) {
        final int posicao = this.hashcode(chave);
        final LinkedList<ParDeValores> linkedList = this.table[posicao];
        if (linkedList != null && !linkedList.isEmpty()) {
            for (ParDeValores parDeValores : linkedList) {
                if (parDeValores.chave == chave) {
                    return parDeValores.valor;
                }
            }
        }
        return null;
    }

    public void getAll() {
        for (LinkedList<ParDeValores> linkedList : this.table) {
            if (linkedList != null && !linkedList.isEmpty()) {

                for (ParDeValores parDeValores : linkedList) {
                    System.out.println(parDeValores.toString());
                }
            }
        }
    }

    public boolean remove(Object chave) {
        final int posicao = this.hashcode(chave);
        LinkedList<ParDeValores> linkedList = this.table[posicao];
        if (linkedList != null && !linkedList.isEmpty()) {
            for (ParDeValores parDeValores : linkedList) {
                if (parDeValores.chave == chave) {
                    linkedList.remove(parDeValores);
                    if (linkedList.isEmpty()) {
                        this.table[posicao] = null;
                        this.tamanho--;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void removeAll() {
        Arrays.fill(this.table, null);
    }

    public int size() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                this.table.toString() +
                '}';
    }
}
