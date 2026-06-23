package br.com.alura.desafio.contador.model;

public class Servico {

    String nome;

    public Servico() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
