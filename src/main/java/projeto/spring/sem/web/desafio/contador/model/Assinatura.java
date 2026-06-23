package br.com.alura.desafio.contador.model;

public class Assinatura {

    String nome;

    public Assinatura() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Assinatura{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
