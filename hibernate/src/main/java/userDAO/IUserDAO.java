package userDAO;

import entity.Users;

import java.util.List;

/**
 * Created by Sviatoslav on 09.04.2017.
 */
public interface IUserDAO {

    Users create();

    Users read(int index);

    Users update(int index);

    Users delete(int index);

    List<Users> readAll();
}
