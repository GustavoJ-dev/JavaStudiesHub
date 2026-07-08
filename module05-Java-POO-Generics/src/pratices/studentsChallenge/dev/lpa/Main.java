package pratices.studentsChallenge.dev.lpa;

import pratices.studentsChallenge.dev.lpa.model.LPAStudent;
import pratices.studentsChallenge.dev.lpa.model.LPAStudentComparator;
import pratices.studentsChallenge.dev.lpa.util.QueryList;

import java.util.Comparator;
import java.util.List;

/**
 * Classe principal para demonstração do sistema de consulta de estudantes (Students Challenge).
 * Realiza operações de criação, filtragem e ordenação utilizando Generics e Fluent API.
 */
public class Main {

    public static void main(String[] args) {
        // Inicialização da lista com dados aleatórios
        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 25; i++) {
            queryList.add(new LPAStudent());
        }

        // 1. Exibição da lista ordenada por ID (Ordem Natural)
        printHeader("1. Lista Original (Ordenada por ID)");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        // 2. Filtragem de estudantes usando busca dinâmica (METODO DE INSTÂNCIA - Fluent API)
        printHeader("2. Filtragem via Método de Instância (Fluent API)");
        var matches = queryList
                .getMatches("PercentComplete", "50")
                .getMatches("Course", "Java");

        matches.sort(new LPAStudentComparator());
        printList(matches);

        // 3. Demonstração do uso do METODO ESTÁTICO
        // Útil para quando você tem uma List comum e não quer instanciar uma QueryList
        printHeader("3. Filtragem via Método Estático (QueryList.getMatches)");
        List<LPAStudent> staticMatches = QueryList.getMatches(queryList, "Course", "Python");
        printList(staticMatches);
    }

    /**
     * Imprime um cabeçalho estilizado no console para facilitar a leitura.
     * @param title O título da seção a ser exibido.
     */
    private static void printHeader(String title) {
        String separator = "=".repeat(50);
        System.out.println("\n" + separator);
        System.out.println(title.toUpperCase());
        System.out.println(separator);
    }

    /**
     * Imprime os elementos de uma lista no console, um por linha.
     * @param list A lista de objetos a ser impressa.
     */
    public static void printList(List<?> list) {
        if (list.isEmpty()) {
            System.out.println("[Nenhum registro encontrado]");
        } else {
            list.forEach(System.out::println);
        }
    }
}
