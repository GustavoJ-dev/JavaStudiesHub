package praticas.pataviva.jdbc.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

/**
 * Gerencia a conexão com o banco de dados através do JPA.
 * <p>
 * Mantém uma instância única de {@link EntityManagerFactory} e
 * fornece novos {@link EntityManager} para realizar operações
 * de persistência e consulta.
 */
public class JPAConnection {

    private static final EntityManagerFactory FACTORY;

    static {

        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (user == null || password == null) {
            throw new IllegalStateException(
                    "As variáveis de ambiente DB_USER e DB_PASSWORD não foram configuradas."
            );
        }

        Map<String, Object> properties = new HashMap<>();

        properties.put("jakarta.persistence.jdbc.user", user);
        properties.put("jakarta.persistence.jdbc.password", password);

        FACTORY = Persistence.createEntityManagerFactory("pataviva", properties);
    }

    /**
     * Cria e retorna um novo {@link EntityManager}.
     *
     * @return novo EntityManager para operações com o banco de dados
     */
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
