package yeah.yeahlogging.domain.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;
import yeah.yeahlogging.domain.log.ImpressionLog;

import java.time.LocalDateTime;
import java.util.Map;

@Document(indexName = "impression_logs", writeTypeHint = WriteTypeHint.FALSE)
@Getter
@SuperBuilder
public class ImpressionLogDocument extends BaseLogDocument {

    public ImpressionLogDocument(ImpressionLog impressionLog) {
        super(impressionLog.getUuid(),
                impressionLog.getDeviceId(),
                impressionLog.getUserAgent(),
                impressionLog.getReferrer(),
                impressionLog.getOs(),
                impressionLog.getLocale(),
                impressionLog.getParams());
    }

    public static ImpressionLogDocument from(ImpressionLog impressionLog) {
        return ImpressionLogDocument.builder()
                .uuid(impressionLog.getUuid())
                .deviceId(impressionLog.getDeviceId())
                .userAgent(impressionLog.getUserAgent())
                .referrer(impressionLog.getReferrer())
                .os(impressionLog.getOs())
                .locale(impressionLog.getLocale())
                .params(impressionLog.getParams())
                .createdDate(LocalDateTime.now())
                .build();
    }
}
