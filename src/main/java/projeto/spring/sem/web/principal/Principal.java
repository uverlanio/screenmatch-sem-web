package projeto.spring.sem.web.principal;

import com.fasterxml.jackson.core.JsonProcessingException;
import projeto.spring.sem.web.model.DadosEpisodios;
import projeto.spring.sem.web.model.DadosSerie;
import projeto.spring.sem.web.model.DadosTemporada;
import projeto.spring.sem.web.service.ConsumoApi;
import projeto.spring.sem.web.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_AKEY = "&apikey=6585022c";
    private ConsumoApi consumoApi = new ConsumoApi();
    ConverteDados conversor = new ConverteDados();

    public void exibeMenu() throws JsonProcessingException {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ","+") + API_AKEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ","+") + "&season=" + i + API_AKEY);
			DadosTemporada temporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(temporada);
		}
		temporadas.forEach(System.out::println);

        temporadas.forEach(t -> t.episodios()
                .forEach(e -> System.out.println(e.titulo())));
    }
}
