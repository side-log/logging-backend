package yeah.yeahlogging.respository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import yeah.yeahlogging.domain.ClickLog;
import yeah.yeahlogging.domain.document.ClickLogDocument;

public interface ClickLogRepository extends ElasticsearchRepository<ClickLogDocument, String> {
}