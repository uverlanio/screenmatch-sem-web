package projeto.spring.sem.web.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException;
}
