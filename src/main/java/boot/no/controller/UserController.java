package boot.no.controller;

import boot.no.model.User;
import boot.no.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/users")
    public String toUser() {
        return "/users/index";
    }

    @RequestMapping("/reg")
    public String toReg(Model model) {
        //向 reg.html 页面添加一个 user 对象
        model.addAttribute(new User());
        return "/users/reg";
    }

    @RequestMapping("/login")
    public String toLogin(Model model) {
        model.addAttribute(new User());
        return "/users/login";
    }

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
            return "/users/login";
        }
    }
}
