package yeah.yeahlogging.domain.document;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@SuperBuilder
public abstract class BaseLogDocument {
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

    @Field(type = FieldType.Date)g
    private LocalDateTime createdDate;

    protected BaseLogDocument(String uuid, String deviceId, String userAgent, String referrer, String os, String locale, Map<String, Object> params) {
        this.uuid = uuid;
        this.deviceId = deviceId;
        this.userAgent = userAgent;
        this.referrer = referrer;
        this.os = os;
        this.locale = locale;
        this.params = params;
        this.createdDate = LocalDateTime.now();
    }
}
