package com.gustavo.mainapp.cineticket;

import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositório responsável pelo armazenamento e gerenciamento das sessões
 * de cinema da aplicação CineTicket.
 *
 * <p>Utiliza o padrão Singleton para garantir que exista apenas uma
 * instância do repositório durante a execução da aplicação. As sessões
 * são armazenadas em uma lista e podem ser carregadas ou gravadas em
 * arquivo de texto.</p>
 */
public class SessaoRepositorio {

    /**
     * Instância única do repositório.
     */
    private static SessaoRepositorio instancia = new SessaoRepositorio();

    /**
     * Nome do arquivo utilizado para armazenar as sessões.
     */
    private static final String FICHEIRO = "sessoes.txt";

    /**
     * Lista contendo as sessões cadastradas.
     */
    private List<Sessao> sessoes;

    /**
     * Formato utilizado para converter datas e horários para texto
     * e vice-versa.
     */
    private DateTimeFormatter formato;

    /**
     * Construtor privado do repositório.
     *
     * <p>Inicializa o formato de data e horário e cria a lista
     * responsável por armazenar as sessões.</p>
     */
    private SessaoRepositorio() {
        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        sessoes = new ArrayList<>();
    }

    /**
     * Retorna a instância única do repositório.
     *
     * @return instância do {@code SessaoRepositorio}
     */
    public static SessaoRepositorio getInstance() {
        return instancia;
    }

    /**
     * Retorna a lista de sessões cadastradas.
     *
     * @return lista de sessões
     */
    public List<Sessao> getSessoes() {
        return sessoes;
    }

    /**
     * Carrega as sessões armazenadas no arquivo de texto.
     *
     * <p>Cada linha do arquivo representa uma sessão, contendo o nome
     * do filme, a sala e o horário separados por tabulação.</p>
     *
     * @throws IOException caso ocorra um erro durante a leitura do arquivo
     */
    public void carregarSessoes() throws IOException {

        List<Sessao> list = new ArrayList<>();
        Path caminho = Paths.get(FICHEIRO);

        try (BufferedReader br = Files.newBufferedReader(caminho)) {

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split("\t");
                LocalDateTime horario =
                        LocalDateTime.parse(partes[2], formato);

                list.add(new Sessao(partes[0], partes[1], horario));
            }
        }

        sessoes = list;
    }

    /**
     * Grava as sessões cadastradas em um arquivo de texto.
     *
     * <p>Cada sessão é armazenada em uma linha contendo o filme,
     * a sala e o horário, separados por tabulação.</p>
     *
     * @throws IOException caso ocorra um erro durante a gravação do arquivo
     */
    public void gravarSessoes() throws IOException {

        Path caminho = Paths.get(
                "src/main/java/com/gustavo/mainapp/cineticket/reservas/"
                        + FICHEIRO);

        try (BufferedWriter bw = Files.newBufferedWriter(caminho)) {

            for (Sessao s : sessoes) {

                bw.write(String.format("%s\t%s\t%s",
                        s.getFilme(), s.getSala(), s.getHorario().format(formato)));

                bw.newLine();
            }
        }
    }
}