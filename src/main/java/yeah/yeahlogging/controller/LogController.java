package yeah.yeahlogging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yeah.yeahlogging.dto.SaveLogRequest;
import yeah.yeahlogging.service.LogService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/log")
public class LogController {

    private final LogService logService;

    @CrossOrigin(origins = {"https://sonbal.vercel.app", "http://localhost:3000"})
    @PostMapping("/v1/log/{uuid}")
    public ResponseEntity<String> saveLog(
            @PathVariable String uuid,
            @RequestBody SaveLogRequest saveLogRequest
    ) {
        log.info("[LogController.saveLog] UUID: {}", uuid);

        logService.saveLog(uuid, saveLogRequest);
        String logType = saveLogRequest.getLog_type();

        return ResponseEntity.ok(logType + " log saved");
    }
}
