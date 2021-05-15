package boot.no.service;


import boot.no.dao.UserDao;
import boot.no.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User findUser(String email, String pwd) {
        return userDao.findUser(email, pwd);
    }

    public User showAbout() {
        return userDao.showAbout();
    }

    public void updateAbout(User user) {
        userDao.updateAbout(user);
    }
}
