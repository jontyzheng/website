package boot.no.dao;

import boot.no.model.User;

public interface UserDao {

    void addUser(User user);

    User findUser(String email, String pwd);

    User showAbout();

    void updateAbout(User user);
}
