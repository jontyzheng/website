package boot.no.controller;

import boot.no.model.Post;
import boot.no.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public String post(Model model) {
        //向 posts/index 页中添加一个 post 列表对象
        List<Post> posts = postService.listPost();
        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @RequestMapping("/posts/post")
    public String toEdit(Model model) {
        model.addAttribute(new Post());
        return "posts/post-add";
    }

    @PostMapping("/post")
    public String addPost(Post post) {
        System.out.println("经过了这里");
        System.out.println(post.getDate());
        postService.addPost(post);
        return "posts/post-success";
    }
    //2021-04-06 404 Bad Request closed

    //
    @GetMapping("/posts/{tag}")
    public String listByTag(@PathVariable String tag, Model model) {
        System.out.println("经过了这里");
        System.out.println(tag);
        //return "result";
        List<Post> tagPosts = postService.listByTag(tag);
        model.addAttribute("tagPosts", tagPosts);
        return "/posts/tag-post";
    }
}
