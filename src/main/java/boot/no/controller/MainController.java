package boot.no.controller;

import boot.no.model.Post;
import boot.no.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 功能: 页面控制器
 * /        index
 * /index   index
 * /reg     reg
 * */
@Controller
public class MainController {

    @GetMapping("/index")
    public String toIndex() {
        return "index";
    }

    @GetMapping("/admin")
    public String toAdmin() {
        return "/admin/admin-login";
    }

}
