package boot.no.controller;

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

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/reg")
    public String toReg(Model model) {
        //向 reg.html 页面添加一个 user 对象
        model.addAttribute(new User());
        return "reg";
    }
}
