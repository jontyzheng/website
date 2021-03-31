package boot.no.controller;

import boot.no.pojo.Blog;
import boot.no.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
