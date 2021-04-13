package boot.no.dao;

import boot.no.model.User;

public interface UserMapper {

    void addUser(User user);

    String checkUser(String pwd);

    User showAbout();

    void updateAbout(User user);
}
