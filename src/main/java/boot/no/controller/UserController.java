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

import javax.servlet.http.HttpSession;

/**
 * 功能: 用户控制器
 * /user/reg        跳转注册
 * /user/reg (post) 用户注册
 * */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    //访问注册
    @RequestMapping("/admin/register")
    public String toReg(Model model) {
        //向 register.html 页面添加一个 user 对象
        model.addAttribute(new User());
        return "/admin/register";
    }

    //访问登录
    @RequestMapping("/admin/login")
    public String toLogin(Model model) {
        model.addAttribute(new User());
        return "/admin/admin-login";
    }

    //注册操作
    @PostMapping("/admin/register")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "result";
    }

    //登录操作
    @PostMapping("/admin/login")
    public String login(User u, Model model, HttpSession session) {
        String email = u.getEmail();
        String pwd = u.getPwd();
        System.out.println("email: " + email);
        User user = userService.findUser(email, pwd);
        System.out.println("u: " + u);

        if (user != null) {
            //添加 session
            session.setAttribute("USER_SESSION", user);
            return "/admin/admin-index";
        }
        else {
            System.out.println("UserController: 登录失败");
            return "/admin/admin-login";
        }
    }

    //访问关于
    @GetMapping("/admin/about")
    public String profile(Model model) {
        User user = userService.showAbout();
        model.addAttribute(user);
        return "/admin/about";
    }


}

