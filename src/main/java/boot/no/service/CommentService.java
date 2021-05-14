package boot.no.service;

import boot.no.dao.CommentMapper;
import boot.no.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

}
