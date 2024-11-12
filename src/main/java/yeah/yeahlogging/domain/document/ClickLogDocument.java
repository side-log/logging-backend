package yeah.yeahlogging.domain.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import yeah.yeahlogging.domain.ClickLog;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "click_logs")
public class ClickLogDocument {
//    @Id
    private String uuid;
    private String deviceId;
    private String userAgent;
    private String referrer;
    private String os;
    private String locale;
    private Map<String, Object> params;
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


