package praticas.pataviva.jdbc.jpa.repository;

import jakarta.persistence.EntityManager;
import praticas.pataviva.jdbc.jpa.JPAConnection;
import praticas.pataviva.jdbc.jpa.entity.Veterinario;

/**
 * Repositório responsável pelas operações de persistência
 * relacionadas à entidade {@link Veterinario}.
 */
public class VetRepository {

    /**
     * Persiste um veterinário no banco de dados.
     * <p>
     * O método inicia uma transação, persiste a entidade e realiza
     * o commit. Caso ocorra alguma exceção durante a operação,
     * a transação é revertida através de rollback.
     *
     * @param veterinario veterinário que será persistido
     * @return o veterinário persistido
     * @throws RuntimeException caso ocorra um erro durante a persistência
     */
    public static Veterinario save(Veterinario veterinario) {

        EntityManager entityManager = JPAConnection.getEntityManager();

        try {

            entityManager.getTransaction().begin();

            entityManager.persist(veterinario);

            entityManager.getTransaction().commit();

            return veterinario;

        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().rollback();
            }

            throw new RuntimeException("Erro ao salvar veterinário: " + e.getMessage(), e);

        } finally {

            entityManager.close();
        }
    }
}
