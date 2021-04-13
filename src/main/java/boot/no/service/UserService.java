package boot.no.service;


import boot.no.dao.UserMapper;
import boot.no.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    public String checkUser(String pwd) {
        return userMapper.checkUser(pwd);
    }

    public User showAbout() {
        return userMapper.showAbout();
    }

    public void updateAbout(User user) {
        userMapper.updateAbout(user);
    }
}
