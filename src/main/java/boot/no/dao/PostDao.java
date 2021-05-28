package boot.no.dao;

import boot.no.model.Post;

import java.util.List;

public interface PostDao {

    int addPost(Post post);
    List<Post> allPost();
    List<Post> byTag(String tag);
    //按照超链接点进去的实际上按照标题查找全文
    Post byPostId(Long postId);
    List<Post> lastest();
    int deleteById(Long id);
    int updatePost(Post post);
//    Post edit(Post post);

}
