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
        return "/posts/post-all";
    }

    @RequestMapping("/posts/post")
    public String toEdit(Model model) {
        model.addAttribute(new Post());
        return "posts/post-add";
    }

    //发布文章
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
        System.out.println(tag);
        //输出 null 区间锁定参数未获取
        //添加@PathVariable 输出 Python, Python 正是首页触发的标签
        model.addAttribute("tag",tag);
        List<Post> tagPosts = postService.byTag(tag);
        model.addAttribute("tagPosts", tagPosts);
        //输出 true 区间锁定到 sql 语句执行部分
        //sql调试, 无误
        //输出 false sql 执行完毕, 区间锁定到显示部分
        //System.out.println(tagPosts.get(0).getTitle());
        //输出 Java, 而是 Java 正是第一篇文章的标题
        return "/posts/tag-post";
    }

    //访问文章
    @GetMapping("/posts/postId")
    public String byTitle(@RequestParam("id") Long id, Post post, Model model) {
        Long postId = post.getId();
        System.out.println("postId: " + postId);
        Post article  = postService.byPostId(postId);
        System.out.println("评论: " + article.getComments());
        model.addAttribute("post", article);
        return "/posts/post-article";
    }
}
