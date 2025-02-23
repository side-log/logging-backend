package yeah.yeahlogging.domain.document;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;
import yeah.yeahlogging.domain.log.ScreenLog;

import java.time.LocalDateTime;

@Document(indexName = "screen_logs", writeTypeHint = WriteTypeHint.FALSE)
@Getter
@SuperBuilder
public class ScreenLogDocument extends BaseLogDocument {

    public ScreenLogDocument(ScreenLog screenLog) {
        super(screenLog.getUuid(),
                screenLog.getDeviceId(),
                screenLog.getUserAgent(),
                screenLog.getReferrer(),
                screenLog.getOs(),
                screenLog.getLocale(),
                screenLog.getParams());
    }

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
