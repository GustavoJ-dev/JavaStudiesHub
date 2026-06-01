package exercises.Section04_flow_control.challenge13;

/**
 * Classe que contém uma atividade prática sobre flow control.
 * Focada na conversão de um dígito numérico para sua representação textual
 * em português, utilizando a estrutura `switch expression`.
 */
public class WrittenDigi {

    /**
     * Método principal para testar a funcionalidade de conversão de dígito para texto.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Dígito 1: " + longDigit(1));   // Um
        System.out.println("Dígito 5: " + longDigit(5));   // Cinco
        System.out.println("Dígito 9: " + longDigit(9));   // Nove
        System.out.println("Dígito 0: " + longDigit(0));   // Inválido
        System.out.println("Dígito 10: " + longDigit(10)); // Inválido
    }

    /**
     * Converte um dígito inteiro (de 1 a 9) para sua representação textual em português.
     * Utiliza uma `switch expression` para mapear o número ao seu nome.
     *
     * @param number O dígito a ser convertido (espera-se um valor entre 1 e 9).
     * @return A representação textual do dígito (ex: "Um", "Dois"), ou "Inválido"
     *         se o número não estiver na faixa de 1 a 9.
     */
    public static String longDigit(int number){
        return switch (number){
            case 1 -> "Um";
            case 2 -> "Dois";
            case 3 -> "Três";
            case 4 -> "Quatro";
            case 5 -> "Cinco";
            case 6 -> "Seis";
            case 7 -> "Sete";
            case 8 -> "Oito";
            case 9 -> "Nove";
            default -> "Inválido";
        };
    }
}
