package com.euchreleague.persistence;


import com.euchreleague.entity.UserRoles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type User roles dao.
 */
public class UserRolesDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public UserRoles getById(int id) {
        Session session = sessionFactory.openSession();
        UserRoles userRoles = session.get( UserRoles.class, id );
        session.close();
        return userRoles;
    }

    /**
     * Save or update.
     *
     * @param userRoles the user roles
     */
    public void saveOrUpdate(UserRoles userRoles) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(userRoles);
        transaction.commit();
        session.close();
    }

    /**
     * Insert int.
     *
     * @param userRoles the user roles
     * @return the int
     */
    public int insert(UserRoles userRoles) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(userRoles);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete.
     *
     * @param userRoles the user roles
     */
    public void delete(UserRoles userRoles) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userRoles);
        transaction.commit();
        session.close();
    }


    /**
     * Gets all.
     *
     * @return the all
     */
    public List<UserRoles> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserRoles> query = builder.createQuery( UserRoles.class );
        Root<UserRoles> root = query.from( UserRoles.class );
        List<UserRoles> userRoles = session.createQuery( query ).getResultList();

        logger.debug("The list of Users " + userRoles);
        session.close();

        return userRoles;
    }

}


