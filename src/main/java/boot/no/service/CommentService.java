package boot.no.service;

import boot.no.dao.CommentDao;
import boot.no.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentDao commentDao;

    public int addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    public List<Comment> listComment() {
        return commentDao.listComment();
    }

    public int updateStatus(Integer commemtId) {
        return commentDao.updateStatus(commemtId);
    }

    public int deleteComment(Integer commentId) {
        return commentDao.deleteComment(commentId);
    }
}
