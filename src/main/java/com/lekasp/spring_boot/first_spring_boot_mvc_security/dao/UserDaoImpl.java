package com.lekasp.spring_boot.first_spring_boot_mvc_security.dao;

import com.lekasp.spring_boot.first_spring_boot_mvc_security.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
//        Session session = entityManager.unwrap(Session.class);
//        return session.createQuery("select u from User u", User.class).getResultList();

        Query query = entityManager.createQuery("select u from User u");
        return query.getResultList();
    }

    @Override
    public Optional<User> findById(Long id) {
//        Session session = entityManager.unwrap(Session.class);
//        TypedQuery<User> query = session.createQuery(
//                "select u from User u where u.id = :id", User.class);
//        if (id != null) {
//            query.setParameter("id", id);
//            return Optional.ofNullable(query.getSingleResult());
//        }
//        throw new NoResultException("No User by: " + id + " present");

        Query query = entityManager.createQuery(
                "select u from User u where u.id = :id");
        if (query != null) {
            query.setParameter("id", id);
            return Optional.ofNullable((User) query.getSingleResult());
        }
        throw new NoResultException("No User by: " + id + " present");
    }

    @Override
    public void saveUser(User user) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(user);

        User newUser = entityManager.merge(user);
        user.setId(newUser.getId());
    }

//    @Override
//    public void updateUser(User user) {
//        Session session = entityManager.unwrap(Session.class);
//        session.merge(user);
//    }

    @Override
    public void deleteById(Long id) {
//        Session session = entityManager.unwrap(Session.class);
//        TypedQuery<User> query = session.createQuery(
//                "select u from User u where u.id = :id", User.class);
//        query.setParameter("id", id);
//        User user = query.getResultList().stream().findAny().orElse(null);
//        session.remove(user);

        Query query = entityManager.createQuery(
                "select u from User u where u.id = :id");
        query.setParameter("id", id);
        entityManager.remove(query.getSingleResult());
    }

    @Override
    public Optional<User> getUserByName(String name) {
        Session session = entityManager.unwrap(Session.class);
        TypedQuery<User> query = session.createQuery(
                "select u from User u JOIN FETCH u.roles where u.name = :name", User.class);
        if (name != null) {
            query.setParameter("name", name);
            return Optional.ofNullable(query.getSingleResult());
        }
        throw new NoResultException("No User by: " + name + " present");
    }
}