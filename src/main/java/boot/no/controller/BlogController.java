package boot.no.controller;

import boot.no.pojo.Blog;
import boot.no.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blogadd")
    public String addBlog(@ModelAttribute Blog blog) {
        if (blog != null) {
            System.out.println(blog.getTitle());
            blogService.addBlog(blog);
            return "result";
        }
        else
            return "blog-add";
    }

    @GetMapping("/index")
    public String listBlog(Model model) {
        List<Blog> blogs = blogService.listBlog();
        model.addAttribute("blogs", blogs);
        return "index";
    }
}
