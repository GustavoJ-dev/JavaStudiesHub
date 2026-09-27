package com.gustavo.mainapp.cineticket;

import java.time.LocalDateTime;


/**
 * Representa uma sessão de cinema disponível para reserva.
 *
 * <p>Uma sessão é composta pelo filme em exibição, pela sala onde ocorre
 * a sessão e pelo horário de início.</p>
 */
public class Sessao {

    /**
     * Nome do filme da sessão.
     */
    private String filme;

    /**
     * Sala onde a sessão será realizada.
     */
    private String sala;

    /**
     * Data e horário de início da sessão.
     */
    private LocalDateTime horario;

    /**
     * Cria uma nova sessão de cinema.
     *
     * @param filme nome do filme em exibição
     * @param sala sala onde a sessão será realizada
     * @param horario data e horário da sessão
     */
    public Sessao(String filme, String sala, LocalDateTime horario) {
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
    }

    /**
     * Retorna o nome do filme da sessão.
     *
     * @return nome do filme
     */
    public String getFilme() {
        return filme;
    }

    /**
     * Retorna a sala onde a sessão será realizada.
     *
     * @return nome ou identificação da sala
     */
    public String getSala() {
        return sala;
    }

    /**
     * Retorna a data e o horário da sessão.
     *
     * @return data e horário da sessão
     */
    public LocalDateTime getHorario() {
        return horario;
    }

    /**
     * Retorna uma representação textual da sessão.
     *
     * <p>Neste caso, utiliza o nome do filme como representação,
     * facilitando sua exibição em componentes como {@code ListView}.</p>
     *
     * @return nome do filme
     */
    @Override
    public String toString() {
        return filme;
    }
}