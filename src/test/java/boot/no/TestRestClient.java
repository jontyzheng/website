package boot.no;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRestClient {

    @Autowired
    //@Qualifier("restHighLevelClient")
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void test() {

    }
}
