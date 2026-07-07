package pratices.interfaces.exercise48;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface principal do jogo.
 * Gerencia o sistema de salvamento e carregamento de entidades do jogo
 * que implementam ISaveable (Player e Monster).
 * 
 * Demonstra o uso de polimorfismo através da interface ISaveable,
 * permitindo que diferentes tipos de objetos sejam salvos e carregados
 * de forma uniforme.
 *
 */
public class GameInterface {

    /**
     * Lista que armazena os dados salvos de entidades do jogo.
     */
    private static List<String> saveFile = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("========== SISTEMA DE JOGO ==========\n");

        // Criando um jogador
        Player player = new Player("Aragorn", 100, 15);
        System.out.println("Jogador criado: " + player);
        System.out.println();

        // Criando um monstro
        Monster monster = new Monster("Goblin", 50, 8);
        System.out.println("Monstro criado: " + monster);
        System.out.println();

        System.out.println("========== SALVANDO DADOS ==========\n");

        // Salvando jogador
        saveGame(player);

        // Salvando monstro
        saveGame(monster);

        System.out.println("========== CRIANDO NOVAS INSTÂNCIAS ==========\n");

        // Criando novas instâncias vazias
        Player playerLoaded = new Player("", 0, 0);
        Monster monsterLoaded = new Monster("", 0, 0);

        System.out.println("Nova instância do jogador (vazia): " + playerLoaded);
        System.out.println("Nova instância do monstro (vazia): " + monsterLoaded);
        System.out.println();

        System.out.println("========== CARREGANDO DADOS ==========\n");

        // Carregando dados no monstro (último salvo)
        loadGame(monsterLoaded);
        System.out.println("Monstro após carregamento: " + monsterLoaded);
        System.out.println();

        // Carregando dados no jogador (sobrescrevendo com dados do monstro)
        loadGame(playerLoaded);
        System.out.println("Jogador após carregamento: " + playerLoaded);
        System.out.println();

        System.out.println("========== SALVANDO NOVO ESTADO ==========\n");

        // Modificando e salvando novo estado do jogador
        playerLoaded = new Player("Legolas", 120, 18);
        System.out.println("Novo estado do jogador: " + playerLoaded);
        saveGame(playerLoaded);

        // Carregando o novo estado
        Player playerReloaded = new Player("", 0, 0);
        loadGame(playerReloaded);
        System.out.println("Jogador após recarregar: " + playerReloaded);
        System.out.println();

        System.out.println("========== FIM DO SISTEMA ==========");
    }

    /**
     * Salva os dados de uma entidade do jogo no arquivo de salvamento.
     * 
     * @param entity a entidade a ser salva (deve implementar ISaveable)
     */
    public static void saveGame(ISaveable entity) {
        System.out.println("Salvando: " + entity);
        saveFile = entity.write();
        System.out.println("✓ Dados salvos: " + saveFile);
        System.out.println();
    }

    /**
     * Carrega os dados salvos de um arquivo para uma entidade do jogo.
     * 
     * @param entity a entidade que receberá os dados salvos
     */
    public static void loadGame(ISaveable entity) {
        System.out.println("Carregando dados para: " + entity.getClass().getSimpleName());
        entity.read(saveFile);
        System.out.println("✓ Dados carregados com sucesso");
        System.out.println();
    }

    /**
     * Metodo principal que demonstra o sistema de salvamento e carregamento.
     * Cria instâncias de Player e Monster, salva e carrega seus dados.
     */

}
