package praticas.sets.taskmanangement;

import praticas.sets.taskmanangement.task.Task;
import praticas.sets.taskmanangement.task.TaskData;

import java.util.*;

/**
 * Classe responsável por demonstrar operações com coleções do tipo {@link Set}
 * aplicadas ao gerenciamento de tarefas.
 *
 * A aplicação realiza operações de união, interseção e diferença entre conjuntos
 * de tarefas atribuídas a diferentes usuários, além de exibir os resultados
 * ordenados por diferentes critérios.
 *
 */
public class Main {

    /**
     * Ponto de entrada da aplicação.
     *
     * Executa diferentes operações sobre conjuntos de tarefas, incluindo:
     *
     * Listagem de todas as tarefas.
     * Listagem das tarefas atribuídas a cada usuário.
     * União dos conjuntos de tarefas.
     * Diferença entre conjuntos.
     * Interseção entre conjuntos.
     * Ordenação e exibição dos resultados.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("todas");
        sortAndPrint("Todas Tarefas", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);

        Set<Task> gustavosTasks = TaskData.getTasks("gustavo");
        sortAndPrint("Tarefas do Gustavo", gustavosTasks, sortByPriority);

        Set<Task> joaoTasks = TaskData.getTasks("joao");
        Set<Task> carolsTasks = TaskData.getTasks("Carol");

        List<Set<Task>> sets = List.of(
                gustavosTasks,
                joaoTasks,
                carolsTasks
        );

        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("Tarefas atribuídas", assignedTasks);

        Set<Task> everyTask = getUnion(List.of(tasks, assignedTasks));
        sortAndPrint("Todas as tarefas", everyTask);

        Set<Task> missingTasks = getDifference(everyTask, tasks);
        sortAndPrint("Tarefas ausentes", missingTasks);

        Set<Task> unassignedTasks = getDifference(tasks, assignedTasks);
        sortAndPrint("Tarefas não atribuídas", unassignedTasks, sortByPriority);

        Set<Task> overlap = getUnion(List.of(
                getIntersect(gustavosTasks, joaoTasks),
                getIntersect(carolsTasks, joaoTasks),
                getIntersect(gustavosTasks, carolsTasks)
        ));

        sortAndPrint("Atribuídas a todos", overlap, sortByPriority);

        List<Task> overlapping = new ArrayList<>();

        for (Set<Task> set : sets) {
            Set<Task> dupes = getIntersect(set, overlap);
            overlapping.addAll(dupes);
        }

        Comparator<Task> priorityNatural =
                sortByPriority.thenComparing(Comparator.naturalOrder());

        sortAndPrint("Sobrepostas", overlapping, priorityNatural);
    }

    /**
     * Ordena e imprime uma coleção utilizando a ordenação natural dos elementos.
     *
     * @param header título exibido antes da listagem
     * @param collection coleção de tarefas a ser exibida
     */
    private static void sortAndPrint(String header, Collection<Task> collection) {

        sortAndPrint(header, collection, null);
    }

    /**
     * Ordena e imprime uma coleção de tarefas utilizando um comparador opcional.
     *
     * @param header título exibido antes da listagem
     * @param collection coleção de tarefas a ser exibida
     * @param sorter comparador utilizado na ordenação; caso seja
     *               {@code null}, será utilizada a ordenação natural da lista
     */
    private static void sortAndPrint(String header,
                                     Collection<Task> collection,
                                     Comparator<Task> sorter) {

        String lineSeparator = "_".repeat(90);

        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);

        list.forEach(System.out::println);
    }

    /**
     * Retorna a união de vários conjuntos de tarefas.
     * O conjunto resultante contém todos os elementos presentes em
     * qualquer um dos conjuntos informados.
     *
     * @param sets lista de conjuntos de tarefas
     * @return conjunto contendo a união dos elementos
     */
    private static Set<Task> getUnion(List<Set<Task>> sets) {

        Set<Task> union = new HashSet<>();

        for (Set<Task> taskSet : sets) {
            union.addAll(taskSet);
        }

        return union;
    }

    /**
     * Retorna a interseção entre dois conjuntos de tarefas.
     * Apenas os elementos presentes em ambos os conjuntos serão mantidos.
     *
     * @param a primeiro conjunto
     * @param b segundo conjunto
     * @return conjunto contendo apenas os elementos em comum
     */
    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {

        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);

        return intersect;
    }

    /**
     * Retorna a diferença entre dois conjuntos.
     * O conjunto resultante contém apenas os elementos presentes no primeiro
     * conjunto que não pertencem ao segundo.
     *
     * @param a conjunto de origem
     * @param b conjunto cujos elementos serão removidos
     * @return conjunto contendo a diferença entre os dois conjuntos
     */
    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {

        Set<Task> result = new HashSet<>(a);
        result.removeAll(b);

        return result;
    }
}
