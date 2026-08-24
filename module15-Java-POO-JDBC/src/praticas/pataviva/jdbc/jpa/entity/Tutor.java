package praticas.pataviva.jdbc.jpa.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa um tutor cadastrado no sistema.
 * <p>
 * A entidade {@code Tutor} é persistida na tabela {@code tutor}
 * do banco de dados e possui um relacionamento com os pets
 * pertencentes ao tutor.
 */
@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(length = 20)
    private String telefone;

    @OneToMany(mappedBy = "tutor")
    private List<Pet> pets;

    /**
     * Construtor padrão exigido pelo JPA.
     */
    public Tutor() {
    }

    /**
     * Cria um novo tutor.
     *
     * @param nome nome do tutor
     * @param telefone telefone de contato do tutor
     */
    public Tutor(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    /**
     * Retorna o identificador do tutor.
     *
     * @return id do tutor
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do tutor.
     *
     * @return nome do tutor
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do tutor.
     *
     * @param nome novo nome do tutor
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o telefone do tutor.
     *
     * @return telefone do tutor
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do tutor.
     *
     * @param telefone novo telefone do tutor
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
