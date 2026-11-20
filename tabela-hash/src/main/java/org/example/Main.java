package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Estudante estudante=new Estudante("Lucas","Masculino");
        Estudante estudante2=new Estudante("sacuL","Masculino");


        HashTable hashTable = new HashTable(100);
        hashTable.put(estudante2.nome, estudante2);
        hashTable.put(estudante.nome, estudante);

        hashTable.getAll();

    }
}