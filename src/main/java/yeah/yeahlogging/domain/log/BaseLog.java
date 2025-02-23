package yeah.yeahlogging.domain.log;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseLog {
    private String uuid;
    private String deviceId;
    private String userAgent;
    private String referrer;
    private String os;
    private String locale;
    private Map<String, Object> params;
}
