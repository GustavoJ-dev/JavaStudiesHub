package praticas.pataviva.jdbc.jpa.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa uma consulta veterinária realizada para um pet.
 * <p>
 * A entidade {@code Consulta} é persistida na tabela {@code consulta}
 * do banco de dados e possui relacionamentos com {@link Pet} e
 * {@link Veterinario}.
 */
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "veterinario_id", nullable = false)
    private Veterinario veterinario;

    /**
     * Construtor padrão exigido pelo JPA.
     */
    public Consulta() {
    }

    /**
     * Cria uma nova consulta veterinária.
     *
     * @param dataHora data e hora em que a consulta será realizada
     * @param pet pet associado à consulta
     * @param veterinario veterinário responsável pela consulta
     */
    public Consulta(LocalDateTime dataHora, Pet pet, Veterinario veterinario) {
        this.dataHora = dataHora;
        this.pet = pet;
        this.veterinario = veterinario;
    }

    /**
     * Retorna o identificador da consulta.
     *
     * @return id da consulta
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna a data e hora da consulta.
     *
     * @return data e hora da consulta
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e hora da consulta.
     *
     * @param dataHora nova data e hora da consulta
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Retorna o pet associado à consulta.
     *
     * @return pet da consulta
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Define o pet associado à consulta.
     *
     * @param pet pet que será associado à consulta
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * Retorna o veterinário responsável pela consulta.
     *
     * @return veterinário da consulta
     */
    public Veterinario getVeterinario() {
        return veterinario;
    }

    /**
     * Define o veterinário responsável pela consulta.
     *
     * @param veterinario veterinário que será associado à consulta
     */
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}
