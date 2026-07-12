package praticas.gameconsole.player.interfaces;

/**
 * Define o contrato básico para jogadores utilizados em um jogo.
 *
 * <p>Qualquer classe ou record que implemente esta interface deve
 * fornecer o nome que identifica o jogador durante a execução
 * do jogo.</p>
 *
 * <p>Esta interface também permite que diferentes tipos de jogadores
 * sejam utilizados de forma polimórfica pelas estruturas genéricas
 * do sistema.</p>
 */
public interface Player {

    /**
     * Retorna o nome do jogador.
     *
     * @return nome do jogador
     */
    String name();
}
