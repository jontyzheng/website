package boot.no.pojo;

import java.sql.Timestamp;
/**
 * 博客
 * */
public class Blog {

    private long id;
    private String title;
    private String profile;
    private String content;
    //private Timestamp createDate;
    //private int readSize;
    //private int voteSize;
    private String tags;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public Timestamp getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Timestamp createDate) {
//        this.createDate = createDate;
//    }

//    public int getReadSize() {
//        return readSize;
//    }
//
//    public void setReadSize(int readSize) {
//        this.readSize = readSize;
//    }

//    public int getVoteSize() {
//        return voteSize;
//    }
//
//    public void setVoteSize(int voteSize) {
//        this.voteSize = voteSize;
//    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
