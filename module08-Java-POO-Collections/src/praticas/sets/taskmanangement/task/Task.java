package praticas.sets.taskmanangement.task;

import praticas.sets.taskmanangement.enums.Priority;
import praticas.sets.taskmanangement.enums.Status;

/**
 * Representa uma tarefa pertencente a um projeto.
 *
 * Cada tarefa possui um projeto, uma descrição, um responsável,
 * um nível de prioridade e um status. A classe implementa
 * {@link Comparable} para permitir a ordenação natural das tarefas
 * pelo projeto e, em caso de empate, pela descrição.
 *
 *
 */
public class Task implements Comparable<Task> {

    /** Nome do projeto ao qual a tarefa pertence. */
    private String project;

    /** Descrição da tarefa. */
    private String description;

    /** Responsável pela execução da tarefa. */
    private String assignee;

    /** Nível de prioridade da tarefa. */
    private Priority priority;

    /** Status atual da tarefa. */
    private Status status;

    /**
     * Cria uma tarefa com todas as informações especificadas.
     *
     * @param project nome do projeto
     * @param description descrição da tarefa
     * @param assignee responsável pela tarefa
     * @param priority prioridade da tarefa
     * @param status status inicial da tarefa
     */
    public Task(String project, String description, String assignee,
                Priority priority, Status status) {

        this.project = project;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Cria uma tarefa atribuindo automaticamente o status.
     *
     * Caso exista um responsável, o status será
     * {@link Status#ATRIBUÍDA}; caso contrário,
     * será {@link Status#NA_FILA}.
     *
     *
     * @param project nome do projeto
     * @param description descrição da tarefa
     * @param assignee responsável pela tarefa
     * @param priority prioridade da tarefa
     */
    public Task(String project, String description,
                String assignee, Priority priority) {

        this(project, description, assignee, priority,
                assignee == null ? Status.NA_FILA : Status.ATRIBUÍDA);
    }

    /**
     * Cria uma tarefa ainda não atribuída a um responsável.
     *
     * @param project nome do projeto
     * @param description descrição da tarefa
     * @param priority prioridade da tarefa
     */
    public Task(String project, String description, Priority priority) {

        this(project, description, null, priority);
    }

    /**
     * Retorna o nome do projeto.
     *
     * @return nome do projeto
     */
    public String getProject() {
        return project;
    }

    /**
     * Define o nome do projeto.
     *
     * @param project novo nome do projeto
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * Retorna a descrição da tarefa.
     *
     * @return descrição da tarefa
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição da tarefa.
     *
     * @param description nova descrição
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o responsável pela tarefa.
     *
     * @return responsável pela tarefa ou {@code null}
     * caso não exista um responsável atribuído
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * Define o responsável pela tarefa.
     *
     * @param assignee novo responsável
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    /**
     * Retorna a prioridade da tarefa.
     *
     * @return prioridade da tarefa
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Define a prioridade da tarefa.
     *
     * @param priority nova prioridade
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Retorna o status atual da tarefa.
     *
     * @return status da tarefa
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Define o status da tarefa.
     *
     * @param status novo status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Retorna uma representação textual da tarefa,
     * contendo projeto, descrição, prioridade,
     * responsável e status.
     *
     * @return representação formatada da tarefa
     */
    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(
                project,
                description,
                priority,
                assignee,
                status);
    }

    /**
     * Verifica se esta tarefa é igual a outro objeto.
     *
     * Duas tarefas são consideradas iguais quando possuem
     * o mesmo projeto e a mesma descrição.
     *
     *
     * @param o objeto a ser comparado
     * @return {@code true} se as tarefas forem iguais;
     * caso contrário, {@code false}
     */
    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (!getProject().equals(task.getProject())) return false;
        return getDescription().equals(task.getDescription());
    }

    /**
     * Retorna o código hash da tarefa.
     *
     * O cálculo é baseado no projeto e na descrição,
     * mantendo consistência com o metodo {@link #equals(Object)}.
     *
     *
     * @return código hash da tarefa
     */
    @Override
    public int hashCode() {
        int result = getProject().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    /**
     * Compara esta tarefa com outra utilizando
     * a ordenação natural.
     *
     * A comparação é realizada primeiro pelo nome do projeto
     * e, caso sejam iguais, pela descrição da tarefa.
     *
     * @param o tarefa a ser comparada
     * @return valor negativo, zero ou positivo conforme esta
     * tarefa seja menor, igual ou maior que a tarefa informada
     */
    @Override
    public int compareTo(Task o) {

        int result = this.project.compareTo(o.project);

        if (result == 0) {
            result = this.description.compareTo(o.description);
        }

        return result;
    }
}
