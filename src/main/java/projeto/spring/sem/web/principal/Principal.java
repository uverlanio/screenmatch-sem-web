package projeto.spring.sem.web.principal;

import com.fasterxml.jackson.core.JsonProcessingException;
import projeto.spring.sem.web.model.DadosEpisodios;
import projeto.spring.sem.web.model.DadosSerie;
import projeto.spring.sem.web.model.DadosTemporada;
import projeto.spring.sem.web.model.Episodio;
import projeto.spring.sem.web.service.ConsumoApi;
import projeto.spring.sem.web.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_AKEY = "&apikey=6585022c";
    private ConsumoApi consumoApi = new ConsumoApi();
    ConverteDados conversor = new ConverteDados();

    public void exibeMenu() throws JsonProcessingException {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_AKEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_AKEY);
            DadosTemporada temporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(temporada);
        }
        temporadas.forEach(System.out::println);

        temporadas.forEach(t -> t.episodios()
                .forEach(e -> System.out.println(e.titulo())));

        List<DadosEpisodios> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        dadosEpisodios.stream()
                .filter(d -> !d.avaliacao().contains("N/A"))
                .limit(5)
                .sorted(Comparator.comparing(DadosEpisodios::avaliacao).reversed())
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("A partir de que ano você deseja ver os episódios?");
        var ano = leitura.nextInt();
        leitura.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
        episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> System.out.println(
                        "Temporada: " + e.getTemporada() +
                                " Episódio: " + e.getTitulo() +
                                " Data de Lançamento: " + e.getDataLancamento().format(formatter))
                );
    }
}
