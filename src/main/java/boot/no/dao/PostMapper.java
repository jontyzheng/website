package boot.no.dao;

import boot.no.model.Post;

import java.util.List;

public interface PostMapper {

    void addPost(Post post);
    List<Post> listPost();
    List<Post> listByTag(String tag);
    //List<Post> findLatest();
    //Post findById(Long id);
//    Post edit(Post post);
//    void deleteById(Long id);
}
