package yeah.yeahlogging.dto;

import lombok.Data;

import java.util.Map;

@Data
public class SaveLogRequest {
    private String device_id;
    private String user_agent;
    private String log_type; // screen, impression, click
    private String referrer;
    private String os;
    private String locale;
    private Map<String, Object> params;
}
