package praticas.heritance.exercise31; // Corrigido o nome do pacote para minúsculas

/**
 * Classe principal para demonstrar o uso da classe {@link Person}.
 * Este é o ponto de entrada para o Exercício 31 do Módulo 05,
 * que cria e exibe informações de pessoas.
 */
public class Main {
    /**
     * Metodo principal que inicia a demonstração da criação e manipulação de objetos
     * {@link Person}.
     * Chama o metodo {@code printPerson} com diferentes dados para exibir
     * o nome completo e se a pessoa é adolescente.
     */
    public static void main(String[] args) {
        printPerson("Gustavo", "Jesus", 22);
        printPerson("Alex", "Silva", 18);
        printPerson("Ana", "Angel", 10);
        printPerson("João", "Silva", 13); // Exemplo de adolescente
        printPerson("Maria", "Souza", 19); // Exemplo de adolescente
    }

    /**
     * Cria uma instância de {@link Person}, define seus atributos (nome, sobrenome, idade)
     * e imprime o nome completo da pessoa e se ela é adolescente.
     *
     * @param name O primeiro nome da pessoa.
     * @param lastName O sobrenome da pessoa.
     * @param age A idade da pessoa.
     */
    public static void printPerson(String name, String lastName, int age){
        Person person = new Person();
        person.setName(name);
        person.setLastName(lastName);
        person.setAge(age);

        System.out.println(person.getFullName() + " is " + (person.isTeen() ? "a teenager." : "not a teenager."));
    }
}
