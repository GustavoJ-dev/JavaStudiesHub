package praticas.pataviva.jdbc.jpa.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import praticas.pataviva.jdbc.jpa.JPAConnection;
import praticas.pataviva.jdbc.jpa.entity.Consulta;
import praticas.pataviva.jdbc.jpa.entity.Pet;
import praticas.pataviva.jdbc.jpa.entity.Tutor;

import java.util.List;


/**
 * Fornece consultas para busca de registros de {@link Consulta}
 * utilizando a API Criteria do JPA.
 */
public class ConsultCriteria {

    /**
     * Busca todas as consultas associadas a um determinado tutor.
     * <p>
     * A busca é realizada através dos relacionamentos entre
     * {@link Consulta}, {@link Pet} e {@link Tutor}.
     *
     * @param tutorId identificador do tutor utilizado como filtro
     * @return lista de consultas pertencentes ao tutor informado
     */
    public static List<Consulta> findByTutorId(int tutorId) {

        EntityManager entityManager = JPAConnection.getEntityManager();

        try {

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();

            CriteriaQuery<Consulta> query = builder.createQuery(Consulta.class);

            Root<Consulta> consulta = query.from(Consulta.class);

            Join<Consulta, Pet> pet = consulta.join("pet");

            Join<Pet, Tutor> tutor = pet.join("tutor");

            query.select(consulta).where(builder.equal(tutor.get("id"), tutorId));

            return entityManager.createQuery(query)
                    .getResultList();

        } finally {

            entityManager.close();
        }
    }
}
