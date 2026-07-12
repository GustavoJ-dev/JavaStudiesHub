package praticas.gameconsole.game;

import java.util.function.Predicate;
/**
 * Representa uma ação disponível durante a execução de um jogo.
 *
 * <p>Cada ação possui uma tecla de identificação, uma descrição
 * apresentada ao jogador e uma operação que define o comportamento
 * executado quando a ação é selecionada.</p>
 *
 * <p>A operação recebe o índice de um jogador e retorna um valor
 * booleano indicando o resultado da execução da ação.</p>
 *
 * @param key tecla utilizada para selecionar a ação
 * @param prompt descrição da ação apresentada ao jogador
 * @param action operação executada ao selecionar a ação
 */
public record GameAction(char key, String prompt, Predicate<Integer> action) {
}
