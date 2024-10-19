package yeah.yeahlogging.respository;

import org.springframework.data.repository.CrudRepository;
import yeah.yeahlogging.domain.ScreenLog;
import yeah.yeahlogging.domain.document.ScreenLogDocument;

public interface ScreenLogRepository extends CrudRepository<ScreenLogDocument, String> {
}
