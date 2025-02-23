package yeah.yeahlogging.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ImpressionLog {
    private String uuid;
    private String deviceId;
    private String userAgent;
    private String referrer;
    private String os;
    private String locale;
    private Map<String, Object> params;
}
