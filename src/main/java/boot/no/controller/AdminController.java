package boot.no.controller;

import boot.no.model.Post;
import boot.no.model.User;
import boot.no.service.PostService;
import boot.no.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class AdminController {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @GetMapping("/admin")
    public String toAdmin() {
        return "/admin/admin-login";
    }

    //管理
    @GetMapping("/admin/article-manage")
    public String manage(Model model) {
        List<Post> articles = postService.listPost();
        model.addAttribute("articles", articles);
        return "/admin/article-manage";
    }

    @GetMapping("/posts/delete")
    public String delete(@RequestParam("id") Long id, Post post, Model model) {

        System.out.println("id: " + id);
        int res = postService.deleteById(id);
        if (res != 0) {
            System.out.println("文章已删除");
            return "/admin/done";
        }
        else {
            System.out.println("文章删除有误");
            return "/admin/false";
        }
    }

    //访问更新
    @GetMapping("/posts/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Post article = postService.byPostId(id);
        model.addAttribute("article", article);
        System.out.println("更新前 id" + article.getId());
        return "/posts/post-update";
    }

    //提交更新
    @PostMapping("/posts/update")
    public String update(Post post, Model model) {
        System.out.println("更新文章: " + post.getId());
        int res = postService.updatePost(post);
        if (res != 0) {
            System.out.println("更新成功");
            return "/admin/done";
        }
        else {
            System.out.println("更新操作有误");
            return "/admin/false";
        }
    }

    //访问编辑
    @GetMapping("/admin/intro-edit")
    public String edit(Model model, HttpSession session) {
        User preUser = userService.showAbout();
        model.addAttribute("preUser", preUser);
        return "/admin/intro-edit";
    }

    //编辑更新
    @PostMapping("/admin/intro-edit")
    public String editAbout(User user) {
        System.out.println("email: " + user.getEmail());
        System.out.println("name: " + user.getName());
        int res = userService.updateAbout(user);
        if (res != 0) {
            return "/admin/done";
        }
        else
            return "/admin/false";
    }
}
