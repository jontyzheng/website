package boot.no.service;

import boot.no.dao.PostDao;
import boot.no.model.Post;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class PostService {

    @Autowired
    PostDao postDao;
    @Autowired
    RestHighLevelClient esClient;

    public boolean addPost(Post post) {
        int res = postDao.addPost(post);
        return res > 0;
    }

    public List<Post> byTag(String tag) {
        return postDao.byTag(tag);
    }

    public List<Post> allPost() {
        return postDao.allPost();
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

    public int updatePost(Post post) {
        return postDao.updatePost(post);
    }


    // 将 mysql 数据导入 es
    public Boolean parse() throws Exception {
        List<Post> articles = postDao.allPost();
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        for (int i = 0; i < articles.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("db_articles")
                    .source(JSON.toJSONString(articles.get(i)), XContentType.JSON)
            );
        }
        BulkResponse bulk = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulk.hasFailures();
    }

    // 从 es 索引中按关键词搜索
    public List<Map<String, Object>> search(String keyword) throws Exception {

        SearchRequest searchRequest = new SearchRequest("db_articles");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 搜索 body 中包含关键词
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("body", keyword);

        sourceBuilder.query(termQueryBuilder);

        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);

        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            list.add(hit.getSourceAsMap());
        }
        // 遍历解析
        return list;
    }
}
