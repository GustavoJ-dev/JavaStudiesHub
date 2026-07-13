package praticas.minichallenge;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String challenge1 = "Hello, World!";
        boolean matching1 = challenge1.matches("Hello, World!");
        System.out.println(matching1);

        String challenge2 = "[A-Z].*\\.";

        for(String s : List.of("A bicicleta é azul.",
                "Eu sou um novo aluno.",
                "hello world.",
                "Como voc~e está?")){

            boolean matching2 = s.matches(challenge2);
            System.out.println(matching2 + ": " + s);
        }

        System.out.println("_".repeat(50));

        String challenge3 = "^[A-Z][\\p{all}]+[.?!]$";

        for(String s : List.of("A bicicleta é azul, e tem tiras pretas.",
                "Eu gosto de ser um aluno L.P.A!",
                "Olá, amigos e familía: bem-vindos!",
                "Como você está, Gustavo?")){

            boolean matching3 = s.matches(challenge3);
            System.out.println(matching3 + ": " + s);
        }
    }
}
