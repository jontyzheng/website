package boot.no.service;

import boot.no.dao.BlogMapper;
import boot.no.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogMapper blogMapper;

    public void addBlog(Blog blog) {
        blogMapper.addBlog(blog);
    }


    public List<Blog> listBlog() {
        return blogMapper.listBlog();
    }
}
