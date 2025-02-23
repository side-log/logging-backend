package yeah.yeahlogging.domain.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
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
@Builder
@AllArgsConstructor
public class ImpressionLogDocument {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    @Field(type = FieldType.Keyword)
    private String uuid;
    @Field(type = FieldType.Keyword)
    private String deviceId;
    @Field(type = FieldType.Text)
    private String userAgent;
    @Field(type = FieldType.Keyword)
    private String referrer;
    @Field(type = FieldType.Text)
    private String os;
    @Field(type = FieldType.Text)
    private String locale;
    private Map<String, Object> params;
    @Field(type = FieldType.Date)
    private LocalDateTime createdDate;

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
