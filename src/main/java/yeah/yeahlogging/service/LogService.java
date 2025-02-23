package yeah.yeahlogging.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;
import yeah.yeahlogging.domain.log.ClickLog;
import yeah.yeahlogging.domain.log.ImpressionLog;
import yeah.yeahlogging.domain.log.ScreenLog;
import yeah.yeahlogging.domain.document.ClickLogDocument;
import yeah.yeahlogging.domain.document.ImpressionLogDocument;
import yeah.yeahlogging.domain.document.ScreenLogDocument;
import yeah.yeahlogging.dto.SaveLogRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogService {

    private final ElasticsearchOperations elasticsearchOperations;

    public void saveLog(String uuid, SaveLogRequest request) {
        log.info("[LogService.saveLog]");

        switch (request.getLog_type()) {
            case "screen":
                saveScreenLog(uuid, request);
                break;
            case "impression":
                saveImpressionLog(uuid, request);
                break;
            case "click":
                saveClickLog(uuid, request);
                break;
            default:
                throw new IllegalArgumentException("Invalid log type: " + request.getLog_type());
        }
    }

    private void saveScreenLog(String uuid, SaveLogRequest request) {
        ScreenLog screenLog = new ScreenLog();
        screenLog.setUuid(uuid);
        screenLog.setDeviceId(request.getDevice_id());
        screenLog.setUserAgent(request.getUser_agent());
        screenLog.setReferrer(request.getReferrer());
        screenLog.setOs(request.getOs());
        screenLog.setLocale(request.getLocale());
        screenLog.setParams(request.getParams());

        screenLog.setParams(request.getParams());

        elasticsearchOperations.save(ScreenLogDocument.from(screenLog));

        log.info("[LogService.saveScreenLog] Screen log saved for UUID: {}", uuid);
    }

    private void saveImpressionLog(String uuid, SaveLogRequest request) {
        ImpressionLog impressionLog = new ImpressionLog();
        impressionLog.setUuid(uuid);
        impressionLog.setDeviceId(request.getDevice_id());
        impressionLog.setUserAgent(request.getUser_agent());
        impressionLog.setReferrer(request.getReferrer());
        impressionLog.setOs(request.getOs());
        impressionLog.setLocale(request.getLocale());
        impressionLog.setParams(request.getParams());

        elasticsearchOperations.save(ImpressionLogDocument.from(impressionLog));

        log.info("[LogService.saveImpressionLog] Impression log saved for UUID: {}", uuid);
    }

    private void saveClickLog(String uuid, SaveLogRequest request) {
        ClickLog clickLog = new ClickLog();
        clickLog.setUuid(uuid);
        clickLog.setDeviceId(request.getDevice_id());
        clickLog.setUserAgent(request.getUser_agent());
        clickLog.setReferrer(request.getReferrer());
        clickLog.setOs(request.getOs());
        clickLog.setLocale(request.getLocale());
        clickLog.setParams(request.getParams()); // params 그대로 저장

        elasticsearchOperations.save(ClickLogDocument.from(clickLog));

        log.info("[LogService.saveClickLog] Click log saved for UUID: {}", uuid);
    }
}
