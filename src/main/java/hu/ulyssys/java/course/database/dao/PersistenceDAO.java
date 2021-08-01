package hu.ulyssys.java.course.database.dao;

import hu.ulyssys.java.course.database.entity.Author;
import hu.ulyssys.java.course.database.entity.BlogPost;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersistenceDAO<T> {
    private final Class<T> typeParameterClass;

    public PersistenceDAO(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    private static final String PERSISTENCE_UNIT = "TestPersistence";

    private EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public void save(T entity) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<T> findAll() {
        TypedQuery<T> query = createEntityManager().createQuery("select n from "
                + typeParameterClass.getSimpleName() + " n" ,typeParameterClass);
        return query.getResultList();
    }

}
