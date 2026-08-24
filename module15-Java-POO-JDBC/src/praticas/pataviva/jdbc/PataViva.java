package praticas.pataviva.jdbc;

import jakarta.persistence.EntityManager;
import praticas.pataviva.jdbc.io.FileManager;
import praticas.pataviva.jdbc.jpa.JPAConnection;
import praticas.pataviva.jdbc.jpa.criteria.ConsultCriteria;
import praticas.pataviva.jdbc.jpa.entity.Consulta;
import praticas.pataviva.jdbc.jpa.entity.Pet;
import praticas.pataviva.jdbc.jpa.entity.Tutor;
import praticas.pataviva.jdbc.jpa.entity.Veterinario;
import praticas.pataviva.jdbc.jpa.repository.ConsultRepository;
import praticas.pataviva.jdbc.jpa.repository.PetRepository;
import praticas.pataviva.jdbc.jpa.repository.TutorRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal da aplicação PataViva.
 * <p>
 * Responsável por inicializar a aplicação, gerenciar o menu principal
 * e executar operações relacionadas ao cadastro de tutores, pets,
 * consultas veterinárias e visualização da agenda.
 */
public class PataViva {

    public static final String URL = "jdbc:mysql://localhost:3306/pataviva";
    public static final String USER = System.getenv("DB_USER");
    public static final String PASSWORD = System.getenv("DB_PASSWORD");

    // Para testar diretamente com String:
    //
    // private static final String USER = "Seu_root";
    // private static final String PASSWORD = "sua_senha";'

    /**
     * Exibe e gerencia o menu principal da aplicação.
     * <p>
     * Permite ao usuário realizar operações de cadastro,
     * consulta, atualização, exclusão e visualização da agenda.
     */
    public static void ptViva(){

        Scanner scanner = new Scanner(System.in);

        int option;

        String menu = """
                    ================================
                               PATAVIVA
                    ================================
                    1 - Cadastrar tutor
                    2 - Cadastrar pet
                    3 - Marcar consulta
                    4 - Visualizar consultas
                    5 - Atualizar
                    6 - Deletar
                    7 - Agenda
                    0 - Sair
                    ================================
                    """;

        do {
            System.out.print(menu);
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    cadastrarTutor(scanner);
                    break;

                case 2:
                    cadastrarPet(scanner);
                    break;

                case 3:
                    marcarConsulta(scanner);
                    break;

                case 4:
                    visualizarConsultas(scanner);
                    break;

                case 5:
                    System.out.println(atualizarNomePet(scanner));
                    break;

                case 6:
                    deletarPet(scanner);
                    break;

                case 7:
                    visualizarAgenda();
                    break;

                case 0:
                    System.out.println("Encerrando PataViva...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (option != 0);

        scanner.close();
    }

    /**
     * Cadastra um novo tutor no sistema.
     * <p>
     * Solicita ao usuário o nome e telefone, persiste o tutor
     * no banco de dados e gera um arquivo contendo seus dados.
     *
     * @param scanner objeto utilizado para receber os dados informados pelo usuário
     */
    private static void cadastrarTutor(Scanner scanner) {

        System.out.print("Nome do tutor: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone do tutor: ");
        String telefone = scanner.nextLine();

        Tutor tutor = new Tutor(nome, telefone);

        Tutor salvo = TutorRepository.save(tutor);

        System.out.println();
        System.out.println("Tutor cadastrado com sucesso!");
        System.out.println("ID: " + salvo.getId());

        String content = """
            ========== TUTOR ==========

            ID: %d
            Nome: %s
            Telefone: %s

            ===========================
            """.formatted(salvo.getId(), salvo.getNome(), salvo.getTelefone());

        FileManager.write("tutores", "tutor_" + salvo.getId() + ".txt", content);
    }

    /**
     * Cadastra um novo pet associado a um tutor.
     * <p>
     * Localiza o tutor informado, cria o pet, persiste os dados
     * no banco e gera um arquivo contendo as informações do pet.
     *
     * @param scanner objeto utilizado para receber os dados informados pelo usuário
     */
    private static void cadastrarPet(Scanner scanner) {

        System.out.print("ID do tutor: ");
        int tutorId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do pet: ");
        String nome = scanner.nextLine();

        System.out.print("Espécie: ");
        String especie = scanner.nextLine();

        EntityManager entityManager = JPAConnection.getEntityManager();

        Tutor tutor = entityManager.find(Tutor.class, tutorId);

        entityManager.close();

        if (tutor == null) {

            System.out.println("Tutor não encontrado!");
            return;
        }

        Pet pet = new Pet(tutor, nome, especie);

        Pet salvo = PetRepository.save(pet);

        System.out.println();
        System.out.println("Pet cadastrado com sucesso!");
        System.out.println("ID: " + salvo.getId());

        String content = """
            ========== PET ==========

            ID: %d
            Nome: %s
            Espécie: %s
            Tutor ID: %d

            =========================
            """.formatted(salvo.getId(), salvo.getNome(), salvo.getEspecie(), tutor.getId());

        FileManager.write("pets", "pet_" + salvo.getId() + ".txt", content);
    }

    /**
     * Marca uma nova consulta veterinária.
     * <p>
     * Localiza o pet e o veterinário informados, cria a consulta,
     * persiste os dados no banco e gera um arquivo com as informações
     * da consulta.
     *
     * @param scanner objeto utilizado para receber os dados informados pelo usuário
     */
    private static void marcarConsulta(Scanner scanner) {

        System.out.print("ID do pet: ");
        int petId = scanner.nextInt();

        System.out.print("ID do veterinário: ");
        int veterinarioId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Data e hora da consulta (yyyy-MM-dd HH:mm): ");
        String dataHoraInput = scanner.nextLine();

        LocalDateTime dataHora = LocalDateTime.parse(dataHoraInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        EntityManager entityManager = JPAConnection.getEntityManager();

        Pet pet = entityManager.find(Pet.class, petId);

        Veterinario veterinario = entityManager.find(
                Veterinario.class,
                veterinarioId
        );

        entityManager.close();

        if (pet == null) {

            System.out.println("Pet não encontrado!");
            return;
        }

        if (veterinario == null) {

            System.out.println("Veterinário não encontrado!");
            return;
        }

        Consulta consulta = new Consulta(dataHora, pet, veterinario);

        Consulta salva = ConsultRepository.save(consulta);

        System.out.println();
        System.out.println("Consulta marcada com sucesso!");
        System.out.println("ID: " + salva.getId());

        String content = """
            ========== CONSULTA ==========

            ID: %d
            Tutor: %s
            Pet: %s
            Veterinário: %s
            Data/Hora: %s

            ==============================
            """.formatted(salva.getId(), pet.getTutor().getNome(), pet.getNome(), veterinario.getNome(),
                salva.getDataHora());

        FileManager.write("consultas", "consulta_" + salva.getId() + ".txt", content);
    }

    /**
     * Exibe as consultas associadas a um determinado tutor.
     *
     * @param scanner objeto utilizado para receber o ID do tutor
     */
    private static void visualizarConsultas(Scanner scanner) {

        System.out.print("Digite o ID do tutor: ");

        int tutorId = scanner.nextInt();

        scanner.nextLine();

        List<Consulta> consultas = ConsultCriteria.findByTutorId(tutorId);

        if (consultas.isEmpty()) {

            System.out.println("Nenhuma consulta encontrada para este tutor.");
            return;
        }

        System.out.println();
        System.out.println("========== SUAS CONSULTAS ==========");

        for (Consulta consulta : consultas) {

            System.out.println("Consulta ID: " + consulta.getId());

            System.out.println("Pet: " + consulta.getPet().getNome());

            System.out.println("Veterinário: " + consulta.getVeterinario().getNome());

            System.out.println("Data/Hora: " + consulta.getDataHora());

            System.out.println("------------------------------------");
        }
    }

    /**
     * Atualiza o nome de um pet utilizando uma procedure armazenada
     * no banco de dados.
     * <p>
     * A procedure recebe o ID do pet e o novo nome e retorna uma
     * mensagem através de um parâmetro de saída.
     *
     * @param scanner objeto utilizado para receber o ID do pet e o novo nome
     * @return mensagem retornada pela procedure ou {@code null} caso ocorra um erro
     */
    public static String atualizarNomePet(Scanner scanner) {

        System.out.print("Digite o ID do pet: ");

        int petId = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Digite o novo nome do pet: ");
        String novoNome = scanner.nextLine();

        String sql = "{CALL atualizar_nome_pet(?, ?, ?)}";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement statement = connection.prepareCall(sql)) {

            statement.setInt(1, petId);

            statement.setString(2, novoNome);

            statement.registerOutParameter(3, Types.VARCHAR);

            statement.execute();

            return statement.getString(3);

        } catch (SQLException e) {

            System.out.println("Erro ao executar PROCEDURE: " + e.getMessage());

            return null;
        }
    }

    /**
     * Exclui um pet utilizando uma procedure armazenada
     * no banco de dados.
     * <p>
     * A procedure recebe o ID do pet, o ID do tutor e a quantidade
     * de pets, retornando um valor através de um parâmetro de saída.
     *
     * @param scanner objeto utilizado para receber os dados da exclusão
     * @return valor retornado pela procedure ou {@code -1} caso ocorra um erro
     */
    public static int deletarPet(Scanner scanner) {

        System.out.print("Digite o ID do pet: ");

        int petId = scanner.nextInt();

        System.out.print("Digite o ID do tutor: ");

        int tutorId = scanner.nextInt();

        System.out.print("Digite a quantidade de pets: ");

        int quantidade = scanner.nextInt();

        scanner.nextLine();

        String sql = "{CALL deletar_pet(?, ?, ?)}";

        try (Connection connection = DriverManager.getConnection(
                URL, USER, PASSWORD);
             CallableStatement statement = connection.prepareCall(sql)) {

            statement.setInt(1, petId);

            statement.setInt(2, tutorId);

            statement.setInt(3, quantidade);

            statement.registerOutParameter(3, Types.INTEGER);

            statement.execute();

            return statement.getInt(3);

        } catch (SQLException e) {

            System.out.println("Erro ao executar PROCEDURE: " + e.getMessage());

            return -1;
        }
    }

    /**
     * Consulta e exibe a agenda de consultas do sistema.
     * <p>
     * Os dados são obtidos através da view {@code vw_agenda_pataviva}
     * e apresentados em ordem crescente de data e hora.
     */
    private static void visualizarAgenda() {

        String sql = """
            SELECT
                tutor_id,
                tutor,
                quantidade_pets,
                pet,
                especie,
                veterinario,
                crmv,
                data_hora
            FROM vw_agenda_pataviva
            ORDER BY data_hora
            """;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            boolean encontrou = false;

            System.out.println();

            System.out.println("========== AGENDA PATAVIVA ==========");

            while (resultSet.next()) {

                encontrou = true;

                System.out.println("""
                    
                    Tutor: %s
                    Quantidade de pets: %d
                    Pet: %s
                    Espécie: %s
                    Veterinário: %s
                    CRMV: %s
                    Data/Hora: %s
                    
                    ------------------------------------
                    """.formatted(resultSet.getString("tutor"),
                        resultSet.getInt("quantidade_pets"),
                        resultSet.getString("pet"),
                        resultSet.getString("especie"),
                        resultSet.getString("veterinario"),
                        resultSet.getString("crmv"),
                        resultSet.getTimestamp("data_hora")));
            }

            if (!encontrou) {

                System.out.println("Nenhuma consulta encontrada.");
            }

        } catch (SQLException e) {

            System.out.println("Erro ao consultar a agenda: " + e.getMessage());
        }
    }
}
