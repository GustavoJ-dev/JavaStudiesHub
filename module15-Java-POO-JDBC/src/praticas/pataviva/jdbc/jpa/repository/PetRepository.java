package praticas.pataviva.jdbc.jpa.repository;

import jakarta.persistence.EntityManager;
import praticas.pataviva.jdbc.jpa.JPAConnection;
import praticas.pataviva.jdbc.jpa.entity.Pet;

/**
 * Repositório responsável pelas operações de persistência
 * relacionadas à entidade {@link Pet}.
 */
public class PetRepository {

    /**
     * Persiste um pet no banco de dados.
     * <p>
     * O método inicia uma transação, persiste a entidade e realiza
     * o commit. Caso ocorra alguma exceção durante a operação,
     * a transação é revertida através de rollback.
     *
     * @param pet pet que será persistido
     * @return o pet persistido
     * @throws RuntimeException caso ocorra um erro durante a persistência
     */
    public static Pet save(Pet pet) {

        EntityManager entityManager = JPAConnection.getEntityManager();

        try {

            entityManager.getTransaction().begin();

            entityManager.persist(pet);

            entityManager.getTransaction().commit();

            return pet;

        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {

                entityManager.getTransaction().rollback();
            }

            throw new RuntimeException("Erro ao salvar pet: " + e.getMessage(), e);

        } finally {

            entityManager.close();
        }
    }
}
