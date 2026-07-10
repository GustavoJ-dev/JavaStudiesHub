package praticas.sets.taskmanangement.task;

import praticas.sets.taskmanangement.enums.Priority;
import praticas.sets.taskmanangement.enums.Status;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe utilitária responsável por fornecer conjuntos de tarefas
 * utilizados pela aplicação.
 *
 * Os dados são armazenados como texto e convertidos em objetos
 * {@link Task} conforme o usuário solicitado.
 *
 *
 */
public class TaskData {

    /** Lista contendo todas as tarefas disponíveis. */
    private static String tasks = """
            Infraestrutura, Registro de Logs, Alta
            Infraestrutura, Acesso ao Banco de Dados, Média
            Infraestrutura, Segurança, Alta
            Infraestrutura, Política de Senhas, Média
            Design de Dados, Tabela de Tarefas, Média
            Design de Dados, Tabela de Funcionários, Média
            Design de Dados, Tabelas de Referência Cruzada, Alta
            Design de Dados, Política de Criptografia, Alta
            Acesso a Dados, Gravação de Views, Baixa
            Acesso a Dados, Configuração de Usuários, Baixa
            Acesso a Dados, Configuração de Política de Acesso, Baixa
            """;

    /** Lista de tarefas atribuídas ao usuário João. */
    private static String joaoTasks = """
            Infraestrutura, Segurança, Alta, Em Andamento
            Infraestrutura, Política de Senhas, Média, Em Andamento
            Pesquisa, Soluções em Nuvem, Média, Em Andamento
            Design de Dados, Política de Criptografia, Alta
            Design de Dados, Tabela de Projetos, Média
            Acesso a Dados, Visualizações de Gravação, Baixa, Em Andamento
            """;

    /** Lista de tarefas atribuídas ao usuário Gustavo. */
    private static String gustavosTasks = """
            Infraestrutura, Segurança, Alta, Em Andamento
            Infraestrutura, Política de Senhas, Média
            Design de Dados, Política de Criptografia, Alta
            Acesso a Dados, Visualizações de Gravação, Baixa, Em Andamento
            """;

    /** Lista de tarefas atribuídas à usuária Carol. */
    private static String carolsTasks = """
            Infraestrutura, Registro de logs, Alta, Em andamento
            Infraestrutura, Acesso ao banco de dados, Média
            Infraestrutura, Política de senhas, Média
            Design de dados, Tabela de tarefas, Alta
            Acesso a dados, Gravação de visualizações, Baixa
            """;


    /**
     * Impede a instanciação desta classe utilitária.
     */
    private TaskData() {}


    /**
     * Retorna um conjunto de tarefas de acordo com o usuário informado.
     *
     * Caso o parâmetro corresponda a um usuário conhecido
     * ("joao", "gustavo" ou "carol"), serão retornadas apenas
     * as tarefas atribuídas a esse usuário. Caso contrário,
     * será retornada a lista contendo todas as tarefas.
     *
     *
     * @param owner nome do usuário cujas tarefas serão recuperadas
     * @return conjunto de tarefas correspondente ao usuário informado
     */
    public static Set<Task> getTasks(String owner) {

        Set<Task> taskList = new HashSet<>();

        String user = ("joao,gustavo,carol".contains(
                owner.toLowerCase())) ? owner : null;

        String selectedList = switch (owner.toLowerCase()) {

            case "joao" -> joaoTasks;
            case "gustavo" -> gustavosTasks;
            case "carol" -> carolsTasks;
            default -> tasks;
        };

        for (String taskData : selectedList.split("\n")) {

            String[] data = taskData.split(",");
            Arrays.asList(data).replaceAll(String::trim);

            Status status = (data.length <= 3)
                    ? Status.NA_FILA
                    : Status.valueOf(
                    data[3].toUpperCase().replace(' ', '_'));

            Priority priority =
                    Priority.valueOf(data[2].toUpperCase());

            taskList.add(new Task(
                    data[0],
                    data[1],
                    user,
                    priority,
                    status));
        }

        return taskList;
    }
}
