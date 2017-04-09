package userDAO;

import entity.Users;

import java.util.List;

/**
 * Created by Sviatoslav on 09.04.2017.
 */
public interface IUserDAO {

    Users create(String name, String lastName, int age, String address);

    Users read(int index);

    Users update(int index, String name, String lastName, int age, String address);

    Users delete(int index);

    List<Users> readAll();
}
