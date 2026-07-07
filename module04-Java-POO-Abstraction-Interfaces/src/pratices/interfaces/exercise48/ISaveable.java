package pratices.interfaces.exercise48;

import java.util.List;

/**
 * Interface que define o contrato para objetos que podem ser salvos e carregados.
 * Implementadores desta interface devem fornecer métodos para serializar
 * (write) e desserializar (read) seu estado.
 * 
 * <p>Utilizada pelo sistema de jogo para permitir salvamento e carregamento
 * de diferentes tipos de entidades (Player, Monster, etc.).
 * 
 * @author Sistema de Jogo
 * @version 1.0
 */
public interface ISaveable {

    /**
     * Serializa o estado do objeto para uma lista de strings.
     * Cada implementação define a ordem e conteúdo dos dados.
     * 
     * @return lista de strings representando o estado do objeto
     */
    List<String> write();

    /**
     * Desserializa o estado do objeto a partir de uma lista de strings.
     * A ordem dos valores deve corresponder à ordem definida em write().
     * 
     * @param savedValues lista de strings contendo os dados a serem carregados
     */
    void read(List<String> savedValues);
}
