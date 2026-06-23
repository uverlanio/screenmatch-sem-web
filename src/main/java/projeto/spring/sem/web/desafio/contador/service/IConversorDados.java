package br.com.alura.desafio.contador.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConversorDados {

    <T> T converterDados(String json, Class<T> classe) throws JsonProcessingException;
}
