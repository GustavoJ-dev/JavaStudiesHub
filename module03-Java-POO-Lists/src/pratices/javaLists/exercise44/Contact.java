package pratices.javaLists.exercise44;

/**
 * Representa um contato com nome e número de telefone.
 * Esta classe encapsula as informações de um único contato
 * em uma lista de contatos de um telefone móvel. Fornece métodos
 * para recuperar o nome e número de telefone do contato.
 */
public class Contact {
    /** O número de telefone do contato */
    private String phoneNumber;
    /** O nome do contato */
    private String name;

    /**
     * Constrói um contato com o número de telefone e nome especificados.
     *
     * @param phoneNumber o número de telefone do contato
     * @param name o nome do contato
     */
    public Contact(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    /**
     * Retorna o número de telefone deste contato.
     *
     * @return o número de telefone
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Retorna o nome deste contato.
     *
     * @return o nome
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo de fábrica que cria uma instância de Contact.
     *
     * @param name o nome do contato
     * @param phoneNumber o número de telefone do contato
     * @return um novo objeto Contact com o nome e número de telefone especificados
     */
    public static Contact createContact(String name, String phoneNumber){

        return new Contact(phoneNumber, name);
    }
}
