package userDAO;

import Session.HibernateUtils;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sviatoslav on 09.04.2017.
 */
public class UserDAOImplTest {
    private SessionFactory sessionFactory;
    private UserDAOImpl dao;
    private List<Users> list;

    @Before
    public void setUp() throws Exception {
        sessionFactory = HibernateUtils.getSessionFactory();
        dao = new UserDAOImpl();
        list = new ArrayList<>();
    }

    @Test
    public void create() throws Exception {
        assertNotNull(dao.create("lol", "olo", 25, "lolo"));
    }

    @Test
    public void read() throws Exception {
        /*Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final Users EXPECTED_RESULT = session.get(Users.class, 1);
        session.getTransaction().commit();
        final Users RESULT = dao.read(1);
        assertEquals(EXPECTED_RESULT, RESULT);*/
    }

    @Test
    public void update() throws Exception {
        /*Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final Users EXPECTED_RESULT = session.get(Users.class, 1);
        final Users RESULT = dao.update(1, "lol", "olo", 25, "lolo");
        assertNotEquals(EXPECTED_RESULT, RESULT);*/
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void readAll() throws Exception {

    }

}