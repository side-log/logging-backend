package yeah.yeahlogging.domain.document;

import co.elastic.clients.elasticsearch.xpack.usage.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;
import yeah.yeahlogging.domain.log.ClickLog;

import java.time.LocalDateTime;
import java.util.Map;

@Document(indexName = "click_logs", writeTypeHint = WriteTypeHint.FALSE)
@Getter
@SuperBuilder
public class ClickLogDocument extends BaseLogDocument {

    public ClickLogDocument(ClickLog clickLog) {
        super(clickLog.getUuid(),
                clickLog.getDeviceId(),
                clickLog.getUserAgent(),
                clickLog.getReferrer(),
                clickLog.getOs(),
                clickLog.getLocale(),
                clickLog.getParams());
    }

    public static ClickLogDocument from(ClickLog clickLog) {
        return ClickLogDocument.builder()
                .uuid(clickLog.getUuid())
                .deviceId(clickLog.getDeviceId())
                .userAgent(clickLog.getUserAgent())
                .referrer(clickLog.getReferrer())
                .os(clickLog.getOs())
                .locale(clickLog.getLocale())
                .params(clickLog.getParams())
                .createdDate(LocalDateTime.now())
                .build();
    }
}


