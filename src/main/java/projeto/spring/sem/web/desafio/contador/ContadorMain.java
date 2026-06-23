package projeto.spring.sem.web.desafio.contador;

import br.com.alura.desafio.contador.model.Assinatura;
import br.com.alura.desafio.contador.model.Produto;
import br.com.alura.desafio.contador.model.Servico;
import br.com.alura.desafio.contador.model.Tarefa;
import br.com.alura.desafio.contador.service.Avaliacao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class ContadorMain implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContadorMain.class, args);
	}

	//Ex 1
	@Override
	public void run(String... args) throws Exception {
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("Digite um valor: ");
		Integer valor = scanner.nextInt();

		for (int i = 1; i <= valor; i++) {
			System.out.println(i + " ");
		}*/
		// Ex 2
		// Acessar o https://mvnrepository.com/ e pegar a dependência com.google.code.gson

		//Ex 3
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Desafio contador");
		tarefa.setPessoaResponsavel("Uverlanio Silva");
		tarefa.setConcluida(true);

		File file = new File("src/main/resources/jsonFiles/tarefa.json");

		if(!file.exists()) {
			file.createNewFile();
		}

		ObjectMapper mapper = new ObjectMapper();

		try {
			mapper.writeValue(file, tarefa);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Tarefa exibirTarefa = mapper.readValue(file, Tarefa.class);
		//System.out.println(exibirTarefa);

		// Ex 6
		Produto produto = new Produto();
		produto.setNome("prod01");

		Servico servico = new Servico();
		servico.setNome("serv01");

		Assinatura assinatura = new Assinatura();
		assinatura.setNome("001");

		Avaliacao avaliacao = new Avaliacao();

		avaliacao.setAvaliacao(produto);
		avaliacao.setNota(10);
		avaliacao.setComentario("Comentario prod01");
		System.out.println(avaliacao);

		avaliacao.setAvaliacao(servico);
		avaliacao.setNota(10);
		avaliacao.setComentario("Comentario serv01");
		System.out.println(avaliacao);

		avaliacao.setAvaliacao(assinatura);
		avaliacao.setNota(10);
		avaliacao.setComentario("Comentario ass01");
		System.out.println(avaliacao);




	}
}
