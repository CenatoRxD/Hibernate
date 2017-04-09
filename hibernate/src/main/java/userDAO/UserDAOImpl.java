package userDAO;

import Session.HibernateUtils;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Sviatoslav on 09.04.2017.
 */
public class UserDAOImpl implements IUserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Users create(String name, String lastName, int age, String address) {
        Users user;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        user = new Users(name, lastName, age, address);
        session.save(user);
        session.getTransaction().commit();
        session.close();

        return user;
    }

    @Override
    public Users read(int index) {
        Users user;
        Session session = sessionFactory.openSession();
        user = session.get(Users.class, index);
        session.close();
        return user;
    }

    @Override
    public Users update(int index, String name, String lastName, int age, String address) {
        Users user;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        user = session.get(Users.class, index);
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        user.setAddress(address);
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public Users delete(int index) {
        Users user;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        user = session.get(Users.class, index);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<Users> readAll() {
        List<Users> users;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Users.class);
        Root<Users> root = cq.from(Users.class);
        Query query = session.createQuery(cq.select(root));
        users = query.getResultList();
        session.close();
        return users;
    }
}
