package boot.no.dao;

import boot.no.pojo.Blog;

import java.util.List;

public interface BlogMapper {

    void addBlog(Blog blog);

    List<Blog> listBlog();
}
