package projeto.spring.sem.web.desafio.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DesafioLambdaMain {

    public static void main(String[] args) {

        // Desafio 1 - multiplicar dois números inteiros
        MultiplicarLambda multiplicao = (a, b) -> a * b;
        //System.out.println(multiplicao.multiplicacao(3, 1));

        // Desafio 2 - verificar se um número é primo
        NumeroPrimoLambda eNumeroPrimo = (e) -> {
            if (e <= 1) {
                return false;
            }

            if (e == 2) {
                return true;
            }

            if (e % 2 == 0) {
                return false;
            }

            for (int i = 3; i * i <= e; i += 2) {
                if (e % i == 0) {
                    return false;
                }
            }
            return true;
        };

        //System.out.println(eNumeroPrimo.eNumeroPrimo(8));

        // Desafio 3 - converter string para maiuscula
        ConverterStringMaiuscula stringMaiuscula = (s) -> s.toUpperCase();
        //System.out.println(stringMaiuscula.converterParaMaiuscula("Uver"));

        // Desafio 4 - verificar se string é um palíndromo
        VerificarPalindromo texto = (s) -> {
            StringBuilder sb = new StringBuilder(s.toUpperCase()).reverse();
            return sb.toString().equals(s.toUpperCase());
        };

        //System.out.println(texto.eUmPalindromo("Arara"));

        // Desafio 5 - retornar lista com os números multiplicados por 3
        List<Integer> ls =List.of(1, 2, 3, 4);
        RetornarListaCadaDigitoVezesTres digitoVezesTres = (d) -> {
            List<Integer> novaLista = new ArrayList<>();
            ls.forEach(n -> novaLista.add(n * 3));

            return novaLista;
        };
        //System.out.println(digitoVezesTres.lista(ls));

        // Desafio 6
        List<String> lista = new ArrayList<>(List.of("Uverlanio", "Jesus"));
        OrdemAlfabetica ordemAlfabetica = (o) -> {
            o.sort(Comparator.naturalOrder());
        };

        ordemAlfabetica.ordernarEmOrdemAlfabetica(lista);

        //System.out.println(lista);

        DividirPrimeiroPorSegundo primeiroPorSegundo = (p, s) -> {

            Double r = p / s;

            if(r == 0){
                throw new ArithmeticException();
            }
            return r;
        };

        System.out.println(primeiroPorSegundo.dividirPrimeiroPeloSegundo(0, 10));
    }


}

