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

    @GetMapping("/me")
    public String toUser() {
        return "/me/profile";
    }

    @RequestMapping("/me/register")
    public String toReg(Model model) {
        //向 register.html 页面添加一个 user 对象
        model.addAttribute(new User());
        return "/me/register";
    }

    @RequestMapping("/me/login")
    public String toLogin(Model model) {
        model.addAttribute(new User());
        return "/me/login";
    }

    @PostMapping("/me/register")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "result";
    }

    @PostMapping("/me/login")
    public String checkUser(@ModelAttribute User user) {
        String account = user.getName();
        String pwd = user.getPwd();
        String realPwd = userService.checkUser(account);
        System.out.println(realPwd);
        if (pwd.equals(realPwd))
            return "redirect:index";
        else {
            return "/me/login";
        }
    }

    @GetMapping("/me/about")
    public String profile(Model model) {
        User user = userService.showAbout();
        model.addAttribute(user);
        return "/me/about";
    }

    @GetMapping("/me/edit")
    public String edit() {
        return "/me/edit";
    }

    @PostMapping("/me/edit")
    public String editAbout(User user) {
        userService.updateAbout(user);
        return "/me/about";
    }
}

