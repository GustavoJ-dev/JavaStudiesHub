package praticas.filewalker;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Percorre uma árvore de diretórios utilizando a API NIO
 * e exibe estatísticas de cada pasta, incluindo:
 * <ul>
 *     <li>Tamanho total dos arquivos.</li>
 *     <li>Quantidade de arquivos.</li>
 *     <li>Quantidade de subdiretórios.</li>
 * </ul>
 */
public class Challenge {

    /**
     * Ponto de entrada da aplicação.
     *
     */
    public static void main(String[] args) {

        Path startingPath = Path.of(".");
        FileVisitor<Path> statsVisitor = new StatsVisitor(Integer.MAX_VALUE);

        try {
            Files.walkFileTree(startingPath, statsVisitor);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Implementação de {@link FileVisitor} responsável por percorrer
     * os diretórios e acumular estatísticas de cada pasta visitada.
     */
    private static class StatsVisitor implements FileVisitor<Path> {

        /**
         * Diretório inicial da busca.
         */
        private Path initialPath = null;

        /**
         * Armazena as estatísticas de cada diretório.
         * A chave representa o caminho da pasta e o valor
         * contém um mapa com as métricas calculadas.
         */
        private final Map<Path, Map<String, Long>> folderSizes = new LinkedHashMap<>();

        /**
         * Quantidade de elementos do caminho inicial.
         * Utilizada para determinar o nível de profundidade.
         */
        private int initialCount;

        /**
         * Profundidade máxima que será exibida no console.
         */
        private int printLevel;

        /**
         * Chave utilizada para armazenar
         * a quantidade de subdiretórios.
         */
        private static final String DIR_COUNT = "DirCount";

        /**
         * Chave utilizada para armazenar
         * o tamanho acumulado dos arquivos.
         */
        private static final String FILE_SIZE = "FileSize";

        /**
         * Chave utilizada para armazenar
         * a quantidade de arquivos.
         */
        private static final String FILE_COUNT = "FileCount";

        /**
         * Cria um visitante responsável por coletar
         * estatísticas dos diretórios.
         *
         * @param printLevel profundidade máxima
         *                   a ser exibida no console.
         */
        public StatsVisitor(int printLevel) {
            this.printLevel = printLevel;
        }

        /**
         * Processa cada arquivo encontrado durante a caminhada.
         * Atualiza o tamanho total e a quantidade de arquivos
         * do diretório pai.
         *
         * @param file caminho do arquivo.
         * @param attrs atributos do arquivo.
         * @return {@link FileVisitResult#CONTINUE} para continuar a busca.
         * @throws IOException caso ocorra erro durante a leitura.
         */
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException {

            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);

            var parentMap = folderSizes.get(file.getParent());

            if (parentMap != null) {

                long fileSize = attrs.size();

                parentMap.merge(FILE_SIZE, fileSize, (o, n) -> o += n);
                parentMap.merge(FILE_COUNT, 1L, Math::addExact);
            }

            return FileVisitResult.CONTINUE;
        }

        /**
         * Trata falhas ao acessar um arquivo.
         *
         * @param file arquivo que causou a falha.
         * @param exc exceção lançada.
         * @return {@link FileVisitResult#CONTINUE} para ignorar o erro
         * e continuar a caminhada.
         * @throws IOException caso ocorra um erro adicional.
         */
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc)
                throws IOException {

            Objects.requireNonNull(file);

            if (exc != null) {
                System.out.println(exc.getClass().getSimpleName() + " " + file);
            }

            return FileVisitResult.CONTINUE;
        }

        /**
         * Executado antes de visitar um diretório.
         * Inicializa o diretório raiz e cria
         * um mapa para armazenar suas estatísticas.
         *
         * @param dir diretório que será visitado.
         * @param attrs atributos do diretório.
         * @return {@link FileVisitResult#CONTINUE}.
         * @throws IOException caso ocorra erro.
         */
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException {

            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);

            if (initialPath == null) {

                initialPath = dir;
                initialCount = dir.getNameCount();

            } else {

                int relativeLevel = dir.getNameCount() - initialCount;

                if (relativeLevel == 1) {
                    folderSizes.clear();
                }

                folderSizes.put(dir, new HashMap<>());
            }

            return FileVisitResult.CONTINUE;
        }

        /**
         * Executado após a visita de um diretório.
         * Consolida as estatísticas da pasta atual,
         * propagando seus valores para o diretório pai.
         * Quando um diretório de primeiro nível é finalizado,
         * suas estatísticas são exibidas no console.
         *
         * @param dir diretório finalizado.
         * @param exc exceção ocorrida durante a visita, se houver.
         * @return {@link FileVisitResult#CONTINUE} ou
         * {@link FileVisitResult#TERMINATE} ao finalizar o diretório raiz.
         * @throws IOException caso ocorra erro.
         */
        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                throws IOException {

            Objects.requireNonNull(dir);

            if (dir.equals(initialPath)) {
                return FileVisitResult.TERMINATE;
            }

            int relativeLevel = dir.getNameCount() - initialCount;

            if (relativeLevel == 1) {

                folderSizes.forEach((key, value) -> {

                    int level = key.getNameCount() - initialCount - 1;

                    if (level < printLevel) {

                        long size = value.getOrDefault(FILE_SIZE, 0L);

                        System.out.printf(
                                "%s[%s] - %,d bytes, %d files, %d folders%n",
                                "\t".repeat(level),
                                key.getFileName(),
                                size,
                                value.getOrDefault(FILE_COUNT, 0L),
                                value.getOrDefault(DIR_COUNT, 0L)
                        );
                    }
                });

            } else {

                var parentMap = folderSizes.get(dir.getParent());
                var childMap = folderSizes.get(dir);

                long folderCount = childMap.getOrDefault(DIR_COUNT, 0L);
                long fileSize = childMap.getOrDefault(FILE_SIZE, 0L);
                long fileCount = childMap.getOrDefault(FILE_COUNT, 0L);

                parentMap.merge(DIR_COUNT, folderCount + 1, (o, n) -> o += n);
                parentMap.merge(FILE_SIZE, fileSize, Math::addExact);
                parentMap.merge(FILE_COUNT, fileCount, Math::addExact);
            }

            return FileVisitResult.CONTINUE;
        }
    }
}
