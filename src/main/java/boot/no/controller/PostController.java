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
import java.util.Map;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/")
    public String defaultIndex(Model model) throws Exception {
        //显示最新的十条
        System.out.println("xx");
        List<Post> lastest = postService.lastest();
        model.addAttribute("lastest", lastest);
        System.out.println(lastest);
        return "/index";
    }

    @GetMapping("/posts")
    public String post(Model model) throws Exception {
        //向 posts/index 页中添加一个 post 列表对象
        List<Post> posts = postService.allPost();
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
            return "/admin/false";
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

    // 解析 parse 以写到默认主页映射
    @GetMapping("/search/{keyword}")
    @ResponseBody   //数据最后通过 vue 模板引擎显示
    public List<Map<String, Object>> search(@PathVariable("keyword") String keyword) throws Exception {
        return postService.search(keyword);
    }


    //为防止重复数据，此 url 只访问一次
    @GetMapping("/import")
    @ResponseBody
    public String importToES() throws Exception {
        // updated: 访问时解析所有内容到 es 索引，以便后面进行全文搜索
        boolean hasImport = postService.parse();
        if (hasImport)
            System.out.println("PostController: 数据库文章导入 es 索引成功");
        else
            System.out.println("PostController: 数据库文章导入 es 索引错误");
        return "数据导入成功，现在可以正常搜索了 此url在项目运行期间执行一次即可，否则会导致搜索结果重复";
    }

    @GetMapping("/search")
    public String search() {
        return "/posts/search-page";
    }
}
