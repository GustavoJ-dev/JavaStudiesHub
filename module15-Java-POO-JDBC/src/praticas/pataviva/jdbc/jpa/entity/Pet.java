package praticas.pataviva.jdbc.jpa.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um animal cadastrado no sistema.
 * <p>
 * A entidade {@code Pet} é persistida na tabela {@code pet} do banco de dados
 * e possui um relacionamento com um {@link Tutor} e com suas respectivas
 * {@link Consulta consultas}.
 */
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(length = 40)
    private String especie;

    @OneToMany(mappedBy = "pet")
    private List<Consulta> consultas = new ArrayList<>();

    /**
     * Construtor padrão exigido pelo JPA.
     */
    public Pet() {
    }

    /**
     * Cria um novo pet associado a um tutor.
     *
     * @param tutor tutor responsável pelo pet
     * @param nome nome do pet
     * @param especie espécie do pet
     */
    public Pet(Tutor tutor, String nome, String especie) {
        this.tutor = tutor;
        this.nome = nome;
        this.especie = especie;
    }

    /**
     * Retorna o identificador do pet.
     *
     * @return id do pet
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o tutor responsável pelo pet.
     *
     * @return tutor associado ao pet
     */
    public Tutor getTutor() {
        return tutor;
    }

    /**
     * Define o tutor responsável pelo pet.
     *
     * @param tutor tutor que será associado ao pet
     */
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    /**
     * Retorna a lista de consultas do pet.
     *
     * @return lista de consultas associadas ao pet
     */
    public List<Consulta> getConsultas() {
        return consultas;
    }

    /**
     * Retorna o nome do pet.
     *
     * @return nome do pet
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do pet.
     *
     * @param nome novo nome do pet
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a espécie do pet.
     *
     * @return espécie do pet
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Define a espécie do pet.
     *
     * @param especie nova espécie do pet
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
