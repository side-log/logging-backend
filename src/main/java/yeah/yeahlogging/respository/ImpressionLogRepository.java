package yeah.yeahlogging.respository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import yeah.yeahlogging.domain.ImpressionLog;
import yeah.yeahlogging.domain.document.ImpressionLogDocument;

public interface ImpressionLogRepository extends ElasticsearchRepository<ImpressionLogDocument, String> {
}