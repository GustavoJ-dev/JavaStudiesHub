package praticas.acessfilechallenge;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

/**
 * Representa um funcionário da empresa.
 * <p>
 * Armazena as informações básicas de um funcionário,
 * incluindo seu identificador, nome, sobrenome e salário.
 * Por ser um {@code record}, seus dados são imutáveis após
 * a criação do objeto.
 * </p>
 *
 * @param employeeId identificador único do funcionário
 * @param firstName primeiro nome do funcionário
 * @param lastName sobrenome do funcionário
 * @param salary salário do funcionário
 *
 */
record Employee(int employeeId, String firstName, String lastName, double salary){}


public class Main {

    /**
     * Mapeia o identificador de cada funcionário para a posição
     * correspondente do registro no arquivo de dados.
     */
    private static final Map<Integer, Long> indexedIds = new HashMap<>();

    /**
     * Inicializa o índice de funcionários.
     * <p>
     * Durante o carregamento da classe, lê o arquivo
     * {@code employees.dat} e cria um índice em memória que associa
     * o ID de cada funcionário à posição do seu registro no arquivo.
     * Esse índice permite acesso rápido aos dados sem a necessidade
     * de percorrer todo o arquivo.
     * </p>
     */
    static {

        int recordsInFile = 0;

        Path path = Path.of(
                "module13-Java-POO-IOFiles", "src", "praticas", "acessfilechallenge", "employees.dat");

        try (RandomAccessFile ra =
                     new RandomAccessFile( path.toFile(), "r")) {

            recordsInFile = ra.readInt();
            System.out.println(recordsInFile + " registros encontrados no arquivo.");

            for (int i = 0; i < recordsInFile; i++) {
                indexedIds.put(ra.readInt(), ra.readLong());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ponto de entrada da aplicação.
     * <p>
     * Permite consultar funcionários pelo ID e atualizar
     * seus salários diretamente no arquivo de dados utilizando
     * acesso aleatório.
     * </p>
     *
     */
    public static void main(String[] args) {

        Path original = Path.of(
                "module13-Java-POO-IOFiles",
                "src",
                "praticas",
                "acessfilechallenge",
                "employees.dat");

        Path updated = Path.of(
                "module13-Java-POO-IOFiles",
                "src",
                "praticas",
                "acessfilechallenge",
                "employees_updated.dat");

        try {

            Files.copy(original, updated,
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (RandomAccessFile ra =
                     new RandomAccessFile(updated.toFile(), "rw")) {

            Scanner scanner = new Scanner(System.in);

            List<Integer> ids = new ArrayList<>(indexedIds.keySet());
            Collections.sort(ids);

            while (true) {

                System.out.println(ids);
                System.out.println("Informe o ID do funcionário ou 0 para sair:");

                if (!scanner.hasNext()) {

                    break;
                }

                int employeeId = Integer.parseInt(scanner.nextLine());

                if (employeeId < 1) {

                    break;
                }

                if (!ids.contains(employeeId)) {

                    System.out.println("Funcionário não encontrado.");

                    continue;
                }

                Employee employee = readRecord(ra, employeeId);

                System.out.println("Informe o novo salário (pressione Enter para manter o atual):");

                try {

                    double salary = Double.parseDouble(scanner.nextLine());

                    ra.seek(indexedIds.get(employeeId) + 4);

                    ra.writeDouble(salary);

                    System.out.println("\nSalário atualizado com sucesso!");

                    readRecord(ra, employeeId);

                } catch (NumberFormatException ignore) {
                    // Mantém o salário atual caso nenhum valor válido seja informado.
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Lê o registro de um funcionário diretamente do arquivo.
     *
     * @param ra arquivo de acesso aleatório
     * @param employeeId identificador do funcionário
     * @return funcionário correspondente ao ID informado
     * @throws IOException caso ocorra erro durante a leitura do arquivo
     */
    private static Employee readRecord(RandomAccessFile ra, int employeeId)
            throws IOException {

        ra.seek(indexedIds.get(employeeId));

        int id = ra.readInt();
        double salary = ra.readDouble();
        String first = ra.readUTF();
        String last = ra.readUTF();

        Employee employee = new Employee(id, first, last, salary);

        System.out.println(employee);

        return employee;
    }
}
