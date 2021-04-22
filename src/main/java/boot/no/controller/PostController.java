package boot.no.controller;

import boot.no.model.Post;
import boot.no.service.PostService;
import boot.no.util.FileUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/posts/post")
    public String addPost(Post post) {
        System.out.println(post.getDate());
        System.out.println(post.getTitle());
        boolean res = postService.addPost(post);
        if (res) {
            return "/posts/post-article";
        }
        else
            return "false";
    }
    //2021-04-06 404 Bad Request closed

    @RequestMapping("/posts/post/image/upload")
    @ResponseBody
    public JSONObject imageUpload(@RequestParam("editor-image-file")MultipartFile image) {
        JSONObject jsonObject = new JSONObject();
        if (image != null) {
            String path = FileUtils.uploadFile(image);
            System.out.println(path);
            jsonObject.put("url", path);
            jsonObject.put("success", 1);
            jsonObject.put("message", "upload success");
        }
        else {
            jsonObject.put("success", 0);
            jsonObject.put("message", "upload error!");

        }
        return jsonObject;
    }


    @GetMapping("/posts/tag/{tag}")
    public String byTag(@PathVariable String tag, Model model) {
        System.out.println("经过了这里");
        System.out.println(tag);
        List<Post> tagPosts = postService.byTag(tag);
        model.addAttribute("tagPosts", tagPosts);
        System.out.println("执行完 byTag 查询");
        return "/posts/tag-post";
    }

    @GetMapping("/posts/postId/{id}")
    public String byTitle(Post post, Model model) {
        String title = post.getTitle();
        Long postId = post.getId();
        System.out.println(postId);
        System.out.println(title);
        Post article  = postService.byPostId(postId);
        model.addAttribute("post", article);
        return "/post/post-article";
    }
}
