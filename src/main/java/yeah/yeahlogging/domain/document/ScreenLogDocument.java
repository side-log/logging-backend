package yeah.yeahlogging.domain.document;

import co.elastic.clients.util.DateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import yeah.yeahlogging.domain.ScreenLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Document(indexName = "screen_logs")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreenLogDocument {
    @Id
    private String uuid;
    private String deviceId;
    private String userAgent;
    private String referrer;
    private String os;
    private String locale;
    private Map<String, Object> params;
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
