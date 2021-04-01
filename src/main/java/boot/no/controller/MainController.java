package boot.no.controller;

import boot.no.pojo.Blog;
import boot.no.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 功能: 页面控制器
 * /        index
 * /index   index
 * /reg     reg
 * */
@Controller
public class MainController {

    @RequestMapping("/reg")
    public String toReg(Model model) {
        //向 reg.html 页面添加一个 user 对象
        model.addAttribute(new User());
        return "reg";
    }

    @RequestMapping("/login")
    public String toLogin(Model model) {
        model.addAttribute(new User());
        return "login";
    }

    @RequestMapping("/blogadd")
    public String toEdit(Model model) {
        model.addAttribute(new Blog());
        return "blog-add";
    }

}
