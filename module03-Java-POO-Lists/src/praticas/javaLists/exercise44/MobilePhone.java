package praticas.javaLists.exercise44;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um telefone móvel com uma lista de contatos.
 * Esta classe gerencia uma coleção de contatos para um telefone móvel.
 * Fornece funcionalidade para adicionar, atualizar, remover e consultar
 * contatos da lista de contatos do telefone.
 */
public class MobilePhone {

    /** O número de telefone deste telefone móvel */
    private String myNumber;
    /** A lista de contatos armazenados neste telefone móvel */
    private List<Contact> myContacts;

    /**
     * Constrói um MobilePhone com o número de telefone especificado.
     * A lista de contatos é inicializada vazia.
     *
     * @param myNumber o número de telefone deste telefone móvel
     */
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }


    /**
     * Adiciona um novo contato ao telefone móvel.
     *
     * @param contact o Contact a ser adicionado
     * @return verdadeiro se o contato foi adicionado com sucesso,
     *         falso se um contato com o mesmo nome já existe
     */
    public boolean addNewContact(Contact contact){

        if (findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }

        myContacts.add(contact);
        return true;

    }

    /**
     * Atualiza um contato existente no telefone móvel.
     *
     * @param oldContact o Contact a ser substituído
     * @param newContact o novo Contact com informações atualizadas
     * @return verdadeiro se o contato foi atualizado com sucesso,
     *         falso se o contato antigo não for encontrado ou
     *         um contato com o novo nome já existe
     */
    public boolean updateContact(Contact oldContact, Contact newContact){

        int foundPosition = findContact(oldContact);
        if (foundPosition < 0){
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1 ){
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not successful.");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;

    }

    /**
     * Remove um contato do telefone móvel.
     *
     * @param contact o Contact a ser removido
     * @return verdadeiro se o contato foi removido com sucesso,
     *         falso se o contato não for encontrado
     */
    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if (foundPosition < 0){
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    /**
     * Encontra a posição do índice de um contato na lista de contatos.
     *
     * @param contact o Contact a procurar
     * @return o índice do contato, ou -1 se não encontrado
     */
    private int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    /**
     * Encontra a posição do índice de um contato pelo nome.
     *
     * @param contactName o nome do contato a procurar
     * @return o índice do contato, ou -1 se não encontrado
     */
    private int findContact(String contactName){
        for (int i = 0; i < myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Consulta um contato pelo nome.
     *
     * @param name o nome do contato a consultar
     * @return o Contact se encontrado, nulo caso contrário
     */
    public Contact queryContact(String name){

        int position = findContact(name);
        if (position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }

    /**
     * Imprime todos os contatos da lista de contatos no console.
     * Cada contato é exibido com seu número de índice, nome e número de telefone.
     */
    public void printContacts(){
        System.out.println("Contact List:");{
            for (int i = 0; i < this.myContacts.size(); i++){
                System.out.println((i+1) + ". " + this.myContacts.get(i).getName() + " -> "
                        + this.myContacts.get(i).getPhoneNumber());
            }
        }
    }
}
