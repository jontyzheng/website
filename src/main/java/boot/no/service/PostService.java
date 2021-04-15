package boot.no.service;

import boot.no.dao.PostMapper;
import boot.no.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostMapper postMapper;

    public boolean addPost(Post post) {
        int res = postMapper.addPost(post);
        return res > 0;
    }

    public List<Post> listPost() {
        return postMapper.listPost();
    }

    public List<Post> listByTag(String tag) {
        return postMapper.listByTag(tag);
    }

    public Post byTitle(String title){
        return postMapper.byTitle(title);
    }
//    List<Post> findAll() {
//        return postMapper.findAll();
//    }
//
//    void deleteById(Long id) {
//        postMapper.deleteById(id);
//    };
//
//    List<Post> findLatest() {
//        return postMapper.findLatest();
//    };
//
//    Post findById(Long id) {
//        return postMapper.findById(id);
//    }
}
