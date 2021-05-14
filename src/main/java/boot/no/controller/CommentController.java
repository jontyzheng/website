package boot.no.controller;

import boot.no.model.Comment;
import boot.no.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @PostMapping("comment")
    public String comment(Comment comment) {
//        System.out.println(comment.getAuthor());
//        System.out.println(comment.toString());
        int res = commentService.addComment(comment);
//        System.out.println("res:"+res);
        if (res != 0)
            System.out.println("评论添加成功");
        else
            System.out.println("添加有误");
        return "插入成功";
    }
}
