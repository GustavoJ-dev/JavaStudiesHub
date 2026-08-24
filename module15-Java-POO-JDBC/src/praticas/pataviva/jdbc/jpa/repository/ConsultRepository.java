package praticas.pataviva.jdbc.jpa.repository;

import jakarta.persistence.EntityManager;
import praticas.pataviva.jdbc.jpa.JPAConnection;
import praticas.pataviva.jdbc.jpa.entity.Consulta;
import java.util.List;

/**
 * Repositório responsável pelas operações de persistência
 * e consulta relacionadas à entidade {@link Consulta}.
 */
public class ConsultRepository {

    /**
     * Persiste uma consulta no banco de dados.
     * <p>
     * O método inicia uma transação, persiste a entidade e realiza
     * o commit. Caso ocorra alguma exceção durante a operação,
     * a transação é revertida através de rollback.
     *
     * @param consulta consulta que será persistida
     * @return a consulta persistida
     * @throws RuntimeException caso ocorra um erro durante a persistência
     */
    public static Consulta save(Consulta consulta) {

        EntityManager entityManager = JPAConnection.getEntityManager();

        try {

            entityManager.getTransaction().begin();

            entityManager.persist(consulta);

            entityManager.getTransaction().commit();

            return consulta;

        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().rollback();
            }

            throw new RuntimeException(
                    "Erro ao salvar consulta: "
                            + e.getMessage(), e
            );

        } finally {

            entityManager.close();
        }
    }

    /**
     * Busca todas as consultas cadastradas no banco de dados.
     * <p>
     * As informações relacionadas ao pet, tutor e veterinário
     * também são carregadas através de {@code JOIN FETCH}.
     *
     * @return lista contendo todas as consultas cadastradas
     */
    public static List<Consulta> findAll() {

        EntityManager entityManager = JPAConnection.getEntityManager();

        try {

            String jpql = """
                SELECT c
                FROM Consulta c
                JOIN FETCH c.pet p
                JOIN FETCH p.tutor t
                JOIN FETCH c.veterinario v
                """;

            return entityManager.createQuery(jpql, Consulta.class).getResultList();

        } finally {

            entityManager.close();
        }
    }
}