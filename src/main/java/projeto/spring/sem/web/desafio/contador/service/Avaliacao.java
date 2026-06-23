package br.com.alura.desafio.contador.service;

public class Avaliacao<T> {

    T avaliacao;
    Integer nota;
    String comentario;

    public Avaliacao() {
    }

    public T getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(T avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "avaliacao=" + avaliacao +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
