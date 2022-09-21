import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Aula02Lists {
    public static void main(String[] args) {
/*
        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40); //Método que adiciona elemento à lista;
        numbers.add(50);
        numbers.add(60);
        numbers.add(70);

        System.out.println(numbers);

        numbers.add(2, 5);
        System.out.println(numbers.size());

        System.out.println("===============");
        for (Integer number : numbers) {
            System.out.println(number);
        }
        System.out.println("===============");

        numbers.remove(numbers.remove(Integer.valueOf(5)));
        System.out.println(numbers.size());
        System.out.println(numbers);
        */
        List<String> names = new ArrayList<>();
        names.add("Gabriel");
        names.add("Sabrina");
        names.add("Estela");
        names.add("João");
        names.add("Maria");

        System.out.println(names);
        names.add(2, "Fernando");
        System.out.println(names);

/*        names.remove("Sabrina");
        System.out.println(names);

        names.remove(0);
        System.out.println(names);*/
        names.add("Marcos");
        names.add(4, "Milton");
        System.out.println(names);

        //Removendo todos os nomes com a letra M da lista;

        names.removeIf(x-> x.charAt(0) == 'M');
        System.out.println(names);

        System.out.println("Indice do nome Estela: " + names.indexOf("Estela"));
        System.out.println("Indice do nome Pedro: " + names.indexOf("Pedro")); //Index = -1;

        names.add("Gustavo");
        names.add(2,"Guilherme");
        System.out.println(names);

// ============ Deixando na lista apenas os nomes que começam com a letra G ===============;

        /*
            1º -> Criar uma lista que vai receber apenas os itens filtrados da lista original;
            (nesse caso, nomes que iniciam com a letra G;

            2º -> A lista precisa ser convertida para o tipo stream para aceitar expressoes lambda;
            (x -> x.charAt(0) == 'G') Expressao que filtra, de fato, os nomes que começam com G;

            3º -> Depois, como o stream não é compativel com o tipo List, deve ser feita a conversão de volta;
            (collect(Collectors.toList());

            4º -> Quando a nova lista for impressa, apenas os nomes que seguem a condição desejada estarao lá;

         */
        List<String> namesStatsWithG = names.stream().filter(x -> x.charAt(0) == 'G').collect(Collectors.toList());
        System.out.println(namesStatsWithG);

        //Retornando a primeira ocorrencia de uma certa condição desejada.
        String name = names.stream().filter(x -> x.charAt(0) == 'G').findFirst().orElse(null);
        System.out.println(name);
    }
}
