package yeah.yeahlogging.domain;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScreenLog {
    private String uuid;
    private String deviceId;
    private String userAgent;
    private String referrer;
    private String os;
    private String locale;
    private Map<String, Object> params;
}
