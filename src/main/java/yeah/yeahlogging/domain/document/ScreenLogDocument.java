package yeah.yeahlogging.domain.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;
import yeah.yeahlogging.domain.ScreenLog;

import java.time.LocalDateTime;
import java.util.Map;

@Document(indexName = "screen_logs", writeTypeHint = WriteTypeHint.FALSE)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreenLogDocument {
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

    public static ScreenLogDocument from(ScreenLog screenLog) {
        return ScreenLogDocument.builder()
                .uuid(screenLog.getUuid())
                .deviceId(screenLog.getDeviceId())
                .userAgent(screenLog.getUserAgent())
                .referrer(screenLog.getReferrer())
                .os(screenLog.getOs())
                .locale(screenLog.getLocale())
                .params(screenLog.getParams())
                .createdDate(LocalDateTime.now())
                .build();
    }
}
