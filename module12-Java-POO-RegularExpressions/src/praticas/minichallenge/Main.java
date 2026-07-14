package praticas.minichallenge;

import java.util.List;

/**
 * Classe principal responsável por demonstrar diferentes desafios
 * envolvendo expressões regulares em Java.
 *
 * <p>Os exemplos utilizam o método {@link String#matches(String)}
 * para verificar se textos correspondem aos padrões definidos.</p>
 *
 */
public class Main {

    /**
     * Ponto de entrada da aplicação.
     *
     * <p>Executa desafios de correspondência exata e validação
     * de estruturas textuais utilizando expressões regulares.</p>
     */
    public static void main(String[] args) {

        /*
         * Desafio 1:
         * Verifica se o texto corresponde exatamente
         * à expressão regular informada.
         */
        String challenge1 = "Hello, World!";
        boolean matching1 = challenge1.matches("Hello, World!");

        System.out.println(matching1);

        /*
         * Desafio 2:
         * Define um padrão para textos iniciados por uma letra
         * maiúscula entre A e Z e finalizados com ponto.
         */
        String challenge2 = "[A-Z].*\\.";

        for (String s : List.of(
                "A bicicleta é azul.",
                "Eu sou um novo aluno.",
                "hello world.",
                "Como voc~e está?")) {

            boolean matching2 = s.matches(challenge2);
            System.out.println(matching2 + ": " + s);
        }

        System.out.println("_".repeat(50));

        /*
         * Desafio 3:
         * Valida frases iniciadas por uma letra maiúscula
         * e finalizadas com ponto, interrogação ou exclamação.
         *
         * As âncoras ^ e $ determinam, respectivamente,
         * o início e o fim da String.
         */
        String challenge3 = "^[A-Z]\\p{all}+[.?!]$";

        for (String s : List.of(
                "A bicicleta é azul, e tem tiras pretas.",
                "Eu gosto de ser um aluno L.P.A!",
                "Olá, amigos e familía: bem-vindos!",
                "Como você está, Gustavo?")) {

            boolean matching3 = s.matches(challenge3);
            System.out.println(matching3 + ": " + s);
        }
    }
}
