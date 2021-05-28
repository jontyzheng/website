package boot.no.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
//修改数据类型!
//index 对应数据库中的数据库，type对应数据库中的表
//@Document(indexName="blogdb", type="post")
public class Post implements Serializable {
    @Id
    private Long id;

    @Field(type= FieldType.Keyword)
    private String tag;

    @Field(type=FieldType.Keyword)
    private String title;

    @Field(type=FieldType.Keyword)
    private String profile;

    //String 对应 Keyword
    @Field(type=FieldType.Keyword)
    private String body;

    @Field(type=FieldType.Date)
    private Date date;              //对应 db 中 date 类型的字段 date

    private List<Comment> comments; //增加一个List<Commetn>表示文章下的多条评论

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
