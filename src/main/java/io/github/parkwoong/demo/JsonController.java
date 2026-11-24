package io.github.parkwoong.demo;

import io.github.parkwoong.demo.spec.util.JsonUtils;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JsonController {
    @PostMapping(value = "/api/json/format", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> format(@RequestBody String body) {
        Map<String, Object> data = JsonUtils.getDataMapFromJsonString(body);
        if (data == null) return ResponseEntity.badRequest().body("Invalid JSON");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(JsonUtils.toPrettyJsonString(data));
    }
}
