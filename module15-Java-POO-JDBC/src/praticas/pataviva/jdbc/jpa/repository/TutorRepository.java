package praticas.pataviva.jdbc.jpa.repository;

import jakarta.persistence.EntityManager;
import praticas.pataviva.jdbc.jpa.JPAConnection;
import praticas.pataviva.jdbc.jpa.entity.Tutor;


/**
 * Repositório responsável pelas operações de persistência
 * relacionadas à entidade {@link Tutor}.
 */
public class TutorRepository {

    /**
     * Persiste um tutor no banco de dados.
     * <p>
     * O método inicia uma transação, persiste a entidade e realiza
     * o commit. Caso ocorra alguma exceção durante a operação,
     * a transação é revertida através de rollback.
     *
     * @param tutor tutor que será persistido
     * @return o tutor persistido
     * @throws RuntimeException caso ocorra um erro durante a persistência
     */
    public static Tutor save(Tutor tutor) {

        EntityManager entityManager = JPAConnection.getEntityManager();

        try {

            entityManager.getTransaction().begin();

            entityManager.persist(tutor);

            entityManager.getTransaction().commit();

            return tutor;

        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().rollback();
            }

            throw new RuntimeException("Erro ao salvar tutor: " + e.getMessage(), e);

        } finally {

            entityManager.close();
        }
    }
}