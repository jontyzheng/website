package boot.no.controller;

import boot.no.model.Post;
import boot.no.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 功能: 页面控制器
 * /        index
 * /index   index
 * /reg     reg
 * */
@Controller
public class MainController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String defaultIndex(Model model) {
        //显示最新的十条
        System.out.println("xx");
        List<Post> lastest = postService.lastest();
        model.addAttribute("lastest", lastest);
        System.out.println(lastest);
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
