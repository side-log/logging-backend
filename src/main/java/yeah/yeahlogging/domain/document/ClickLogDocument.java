package yeah.yeahlogging.domain.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;
import yeah.yeahlogging.domain.ClickLog;

import java.time.LocalDateTime;
import java.util.Map;

@Document(indexName = "click_logs", writeTypeHint = WriteTypeHint.FALSE)
@Getter
@Builder
@AllArgsConstructor
public class ClickLogDocument {
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


