package boot.no.controller;

import boot.no.pojo.User;
import boot.no.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能: 用户控制器
 * /user/reg        跳转注册
 * /user/reg (post) 用户注册
 * */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/reg")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        System.out.println(user.getUsername());
        System.out.println(user.getUserpwd());
        return "result";
    }

    @PostMapping("/login")
    public String checkUser(@ModelAttribute User user) {
        String account = user.getUsername();
        String pwd = user.getUserpwd();
        String realPwd = userService.checkUser(account);
        System.out.println(realPwd);
        if (pwd.equals(realPwd))
            return "redirect:index";
        else {
            return "login";
        }
    }
}
