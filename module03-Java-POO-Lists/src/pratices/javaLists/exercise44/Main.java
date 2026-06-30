package pratices.javaLists.exercise44;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal da Aplicação de Gerenciamento de Contatos de Telefone Móvel.
 *
 * Esta aplicação fornece um menu interativo para gerenciar contatos em um telefone móvel.
 * Os usuários podem adicionar, atualizar, remover e consultar contatos da lista de contatos do telefone.
 *
 */
public class Main {
    /** Scanner para ler entrada do usuário do console */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Ponto de entrada principal da aplicação.
     */
    public static void main(String[] args) {
        cell();
    }

    /**
     * Inicializa o telefone móvel com contatos de exemplo e inicia o menu interativo.
     */
    public static void cell() {

        MobilePhone mobilePhone = new MobilePhone("999999999");

        List<Contact> contacts = List.of(
                Contact.createContact("John Doe", "1234567890"),
                Contact.createContact("Jane Smith", "9876543210"),
                Contact.createContact("Alice Johnson", "5551234567"),
                Contact.createContact("Bob Brown", "1112223333")
        );

        cell(contacts, mobilePhone);
    }

    /**
     * Executa o menu interativo de gerenciamento de contatos.
     * Adiciona contatos iniciais ao telefone e exibe um menu com opções para:
     * adicionar, atualizar, remover e consultar contatos.
     *
     * @param contacts a lista inicial de contatos para adicionar ao telefone
     * @param mobilePhone o objeto MobilePhone a gerenciar
     */
    public static void cell(List<Contact> contacts, MobilePhone mobilePhone) {

        // adiciona os contatos iniciais ao telefone
        for (Contact contact : contacts) {
            mobilePhone.addNewContact(contact);
        }

        System.out.println("Welcome to the Mobile Phone App!");

        boolean quit = false;

        while (!quit) {

            System.out.println("""
                Please choose an option:
                1. Add a new contact
                2. Update an existing contact
                3. Remove a contact
                4. Query if a contact exists
                5. Print all contacts
                6. Quit
                """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();

                    mobilePhone.addNewContact(Contact.createContact(name, phone));
                }

                case 2 -> {

                    System.out.print("Current contact name: ");
                    String oldName = scanner.nextLine();
                    Contact oldContact = mobilePhone.queryContact(oldName);

                    if (oldContact == null) {
                        System.out.println("Contact not found.");
                        break;
                    }

                    System.out.println("Enter new name and phone separated by comma:");
                    String[] newCtt = scanner.nextLine().split(",");

                    if (newCtt.length != 2) {
                        System.out.println("Invalid format.");
                        break;
                    }

                    mobilePhone.updateContact(oldContact, Contact.createContact(
                                    newCtt[0].trim(),
                                    newCtt[1].trim()));
                }

                case 3 -> {

                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    Contact contact = mobilePhone.queryContact(name);

                    if (contact != null) {
                        mobilePhone.removeContact(contact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                }

                case 4 -> {

                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    Contact contact = mobilePhone.queryContact(name);

                    if (contact != null) {
                        System.out.println(contact.getName()
                                + " exists in the contact list.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                }

                case 5 -> mobilePhone.printContacts();

                case 6 -> quit = true;

                default -> System.out.println("Invalid option.");
            }
        }
    }



}
