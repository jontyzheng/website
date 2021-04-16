package boot.no.controller;

import boot.no.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 功能: 页面控制器
 * /        index
 * /index   index
 * /reg     reg
 * */
@Controller
public class MainController {

    @GetMapping("/")
    public String defaultIndex() {
        return "index";
    }

    @GetMapping("/index")
    public String toIndex() {
        return "index";
    }

    @GetMapping("/admin/admin")
    public String toAdmin() {
        return "/admin/admin";
    }
}
