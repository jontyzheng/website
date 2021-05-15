package boot.no.service;

import boot.no.dao.CommentDao;
import boot.no.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentDao commentDao;

    public int addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

}
