package boot.no.dao;

import boot.no.model.Comment;

import java.util.List;

public interface CommentDao {
    int addComment(Comment comment);
    List<Comment> listComment();
    int updateStatus(Integer commentId);
    int deleteComment(Integer commentId);
}
