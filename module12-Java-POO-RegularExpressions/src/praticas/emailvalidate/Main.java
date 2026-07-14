package praticas.emailvalidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Aplicação de console para extração e validação de endereços de e-mail.
 *
 * <p>Este exemplo demonstra o uso das classes {@link Pattern} e {@link Matcher},
 * expressões regulares, Streams e expressões lambda para localizar, extrair
 * e validar endereços de e-mail.</p>
 *
 * <p>A aplicação é dividida em duas etapas:</p>
 * <ul>
 *     <li>Extração de e-mails presentes em um bloco de texto;</li>
 *     <li>Validação individual de cada endereço de e-mail.</li>
 * </ul>
 *
 */
public class Main {

    /**
     * Ponto de entrada da aplicação.
     *
     */
    public static void main(String[] args) {

        /*
         * Conjunto de endereços de e-mail utilizados nos testes
         * de extração e validação.
         */
        String emailsText = """
                gustavo.jesus.silva.dev@gmail.com
                ana.card54@hotmail.com
                gj7678.silva@gmail.com
                joao123@yahoo.com
                maria_oliveira@outlook.com
                dev.backend2026@gmail.com
                carlos-santos@empresa.com.br
                julia.dev_java@proton.me
                teste.regex99@dominio.org
                user2026@sub.dominio.com""";

        /*
         * Expressão regular utilizada para localizar endereços
         * de e-mail dentro de um texto.
         *
         * O lookahead negativo impede a ocorrência de dois
         * pontos consecutivos.
         */
        Pattern partialPattern = Pattern.compile(
                "(?!.*\\.\\.)([\\w._-]+)@(([\\w.]+\\.)+[\\w-]{2,})"
        );

        System.out.println("EXTRAÇÃO DE ENDEREÇOS DE E-MAIL");
        System.out.println("-".repeat(100));

        Matcher emailMatcher = partialPattern.matcher(emailsText);

        emailMatcher.results()
                .forEach(matchResult ->
                        System.out.printf("[Usuário=%s, domínio=%s]%n",
                                matchResult.group(1),
                                matchResult.group(2)
                        )
                );

        System.out.println();
        System.out.println("=".repeat(100));
        System.out.println();

        /*
         * Expressão regular utilizada para validar individualmente
         * cada endereço de e-mail.
         */
        Pattern emailPattern = Pattern.compile(
                "(?!.*\\.\\.)([\\w._-]+)@(([\\w.]+\\.)+[\\w-]{2,})"
        );

        /*
         * Converte cada linha do bloco de texto em uma amostra
         * individual de e-mail.
         *
         * Espaços são removidos e linhas vazias são descartadas.
         */
        String[] emailSamples = emailsText.lines()
                .map(String::trim)
                .filter(email -> !email.isBlank())
                .toArray(String[]::new);

        System.out.println("VALIDAÇÃO DE ENDEREÇOS DE E-MAIL");
        System.out.println("-".repeat(100));

        for (String email : emailSamples) {

            Matcher eMatcher = emailPattern.matcher(email);
            boolean matched = eMatcher.matches();

            System.out.print(
                    email + " é " + (matched ? "VÁLIDO -> " : "INVÁLIDO -> ")
            );

            if (matched) {

                System.out.printf("[Usuário=%s, domínio=%s]%n",
                        eMatcher.group(1),
                        eMatcher.group(2)
                );

            } else {

                System.out.println();
            }
        }
    }
}
