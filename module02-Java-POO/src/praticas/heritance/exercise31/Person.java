package praticas.heritance.exercise31; // Corrigido o nome do pacote para minúsculas

/**
 * Representa uma pessoa com nome, sobrenome e idade.
 * Esta classe faz parte do Exercício 31 do Módulo 05,
 * demonstrando encapsulamento e métodos de acesso (getters e setters).
 */
public class Person {
    /**
     * O primeiro nome da pessoa.
     */
    private String name;
    /**
     * O sobrenome da pessoa.
     */
    private String lastName;
    /**
     * A idade da pessoa.
     */
    private int age;

    /**
     * Retorna a idade da pessoa.
     * @return A idade da pessoa.
     */
    public int getAge() {
        return age;
    }

    /**
     * Define a idade da pessoa.
     * A idade é validada para estar entre 0 e 100 (inclusive).
     * Se a idade fornecida for inválida, a idade será definida como 0.
     * @param age A nova idade da pessoa.
     */
    public void setAge(int age) {
        if (age < 0 || age > 100) {
            this.age = 0; // Define como 0 se a idade for inválida
        } else {
            this.age = age;
        }
    }

    /**
     * Retorna o sobrenome da pessoa.
     * @return O sobrenome da pessoa.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Define o sobrenome da pessoa.
     * @param lastName O novo sobrenome da pessoa.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retorna o primeiro nome da pessoa.
     * @return O primeiro nome da pessoa.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o primeiro nome da pessoa.
     * @param name O novo primeiro nome da pessoa.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Verifica se a pessoa é adolescente.
     * Uma pessoa é considerada adolescente se sua idade estiver entre 13 e 19 (inclusive).
     * @return {@code true} se a pessoa for adolescente, {@code false} caso contrário.
     */
    public boolean isTeen(){
        return age >= 13 && age <= 19;
    }

    /**
     * Retorna o nome completo da pessoa.
     * Se ambos os nomes (primeiro e último) estiverem vazios, retorna uma string vazia.
     * Se apenas um estiver vazio, retorna o nome não vazio.
     * Caso contrário, retorna o primeiro nome seguido de um espaço e o sobrenome.
     * @return O nome completo da pessoa.
     */
    public String getFullName(){
        if (name == null || name.isEmpty()) { // Verifica se o nome é nulo ou vazio
            if (lastName == null || lastName.isEmpty()) { // Verifica se o sobrenome é nulo ou vazio
                return "";
            } else {
                return lastName;
            }
        } else if (lastName == null || lastName.isEmpty()) { // Se o nome não é vazio, mas o sobrenome é
            return name;
        } else {
            return name + " " + lastName;
        }
    }
}
