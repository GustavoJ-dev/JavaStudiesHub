package praticas.pataviva.jdbc.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Gerencia a criação e escrita de arquivos no diretório de saída da aplicação.
 */
public class FileManager {

    private static final String OUTPUT = "module15-Java-POO-JDBC/src/praticas/pataviva/jdbc/output";

    /**
     * Escreve o conteúdo informado em um arquivo dentro de uma pasta específica.
     * <p>
     * Caso a pasta não exista, ela será criada automaticamente.
     *
     * @param folder  nome da pasta onde o arquivo será armazenado
     * @param fileName nome do arquivo que será criado ou sobrescrito
     * @param content conteúdo que será escrito no arquivo
     * @throws RuntimeException caso ocorra um erro durante a criação ou escrita do arquivo
     */
    public static void write(String folder, String fileName, String content) {

        try {

            File directory = new File(OUTPUT + File.separator + folder);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                    directory + File.separator + fileName))) {

                writer.write(content);
            }

        } catch (IOException e) {

            throw new RuntimeException("Erro ao escrever no arquivo: " + e.getMessage(), e);
        }
    }
}
