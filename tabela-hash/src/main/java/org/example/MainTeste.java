package org.example;

import java.util.Scanner;

public class MainTeste {
    public static void main(String[] args) {

        HashTableComColisoesTratados hashTable = new HashTableComColisoesTratados(100);
        Estudante estudante = new Estudante("Lucas", "Masculino");
        Estudante estudante2 = new Estudante("sacuL", "Masculino");
        hashTable.remove(estudante.nome);
        hashTable.put(estudante2.nome, estudante2);
        hashTable.put(estudante.nome, estudante);
        hashTable.remove(estudante2.nome);
        hashTable.getAll();
    }
}
