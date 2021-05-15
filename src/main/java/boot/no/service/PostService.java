package boot.no.service;

import boot.no.dao.PostDao;
import boot.no.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostDao postDao;

    public boolean addPost(Post post) {
        int res = postDao.addPost(post);
        return res > 0;
    }

    public List<Post> byTag(String tag) {
        return postDao.byTag(tag);
    }

    public List<Post> listPost() {
        return postDao.listPost();
    }

    public List<Post> lastest() {
        return postDao.lastest();
    }

    public Post byPostId(Long postId){
        return postDao.byPostId(postId);
    }

    public int deleteById(Long id) {
        return postDao.deleteById(id);
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
