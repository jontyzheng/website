package boot.no.controller;

import boot.no.model.Comment;
import boot.no.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @PostMapping("/comment")
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

    @GetMapping("/admin/comment-manage")
    public String commentManage(Model model) {
        List<Comment> comments = commentService.listComment();
        System.out.println("评论数:" + comments.size());
        model.addAttribute("comments", comments);
        return "/admin/comment-manage";
    }

    @GetMapping("/comment/update")
    public String commentUpdate(@RequestParam("commentId") Integer commentId, Comment comment) {
        System.out.println("状态更新:" + commentId);
        int res = commentService.updateStatus(commentId);
        if (res != 0) {
            System.out.println("状态更新通过");
            return "/admin/done";
        }
        else {
            System.out.println("状态更新有误");
            return "/admin/false";
        }
    }

    @GetMapping("/comment/delete")
    public String commentDelete(@RequestParam("commentId") Integer commentId) {
        System.out.println("评论 id " + commentId);
        int res = commentService.deleteComment(commentId);
        if (res != 0) {
            System.out.println("评论删除成功");
            return "/admin/done";
        }
        else {
            System.out.println("评论删除有误");
            return "/admin/false";
        }
    }
}
