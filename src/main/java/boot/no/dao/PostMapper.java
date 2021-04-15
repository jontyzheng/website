package boot.no.dao;

import boot.no.model.Post;

import java.util.List;

public interface PostMapper {

    int addPost(Post post);
    List<Post> listPost();
    List<Post> listByTag(String tag);
    //按照超链接点进去的实际上按照标题查找全文
    Post byTitle(String title);
    //List<Post> findLatest();
    //Post findById(Long id);
//    Post edit(Post post);
//    void deleteById(Long id);
}
