package org.example;

public class Estudante {
    String nome;
    String sexo;
    String numeroMatricula;

    public Estudante(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "Nome:'" + nome + '\'' +
                ", Sexo='" + sexo + '\'' +
                ", Número de matrícula='" + numeroMatricula + '\'' +
                '}';
    }
}
