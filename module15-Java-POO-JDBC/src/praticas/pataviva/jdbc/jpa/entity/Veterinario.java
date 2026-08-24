package praticas.pataviva.jdbc.jpa.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um veterinário cadastrado no sistema.
 * <p>
 * A entidade {@code Veterinario} é persistida na tabela
 * {@code veterinario} do banco de dados e possui um relacionamento
 * com as consultas realizadas pelo veterinário.
 */
@Entity
@Table(name = "veterinario")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 20)
    private String crmv;

    @OneToMany(mappedBy = "veterinario")
    private List<Consulta> consultas = new ArrayList<>();

    /**
     * Construtor padrão exigido pelo JPA.
     */
    public Veterinario() {
    }

    /**
     * Cria um novo veterinário.
     *
     * @param nome nome do veterinário
     * @param crmv registro do veterinário no Conselho Regional de Medicina Veterinária
     */
    public Veterinario(String nome, String crmv) {
        this.nome = nome;
        this.crmv = crmv;
    }

    /**
     * Retorna o identificador do veterinário.
     *
     * @return id do veterinário
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do veterinário.
     *
     * @return nome do veterinário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do veterinário.
     *
     * @param nome novo nome do veterinário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o número de registro no CRMV.
     *
     * @return número do CRMV
     */
    public String getCrmv() {
        return crmv;
    }

    /**
     * Define o número de registro no CRMV.
     *
     * @param crmv novo número de registro
     */
    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    /**
     * Retorna a lista de consultas do veterinário.
     *
     * @return lista de consultas associadas ao veterinário
     */
    public List<Consulta> getConsultas() {
        return consultas;
    }
}