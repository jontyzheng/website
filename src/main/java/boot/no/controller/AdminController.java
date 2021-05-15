package boot.no.controller;

import boot.no.model.Post;
import boot.no.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class AdminController {

    @Autowired
    PostService postService;

    @GetMapping("/admin")
    public String toAdmin() {
        return "/admin/admin-login";
    }

    //管理
    @GetMapping("/admin/manage")
    public String manage(Model model) {
        List<Post> articles = postService.listPost();
        model.addAttribute("articles", articles);
        return "/admin/post-manage";
    }
}
