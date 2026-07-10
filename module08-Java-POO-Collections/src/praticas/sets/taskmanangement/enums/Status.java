package praticas.sets.taskmanangement.enums;

/**
 * Representa os possíveis estados de uma tarefa durante seu ciclo de vida.
 *
 * O status indica o estágio atual da tarefa, desde sua criação até o
 * momento em que está sendo executada.
 *
 *
 */
public enum Status {

    /** A tarefa está aguardando para ser atribuída a um responsável. */
    NA_FILA,

    /** A tarefa foi atribuída a um responsável, mas ainda não foi iniciada. */
    ATRIBUÍDA,

    /** A tarefa está em execução. */
    EM_ANDAMENTO
}
