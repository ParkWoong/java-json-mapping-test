package io.github.parkwoong.demo;

import static org.junit.jupiter.api.Assertions.*;

import io.github.parkwoong.demo.spec.util.JsonUtils;

import org.junit.jupiter.api.Test;

import java.util.Map;

class JsonUtilsTest {
    @Test
    void originalConversionsAndFailureContract() {
        Map<String, Object> value = Map.of("name", "sample", "count", 3);
        assertEquals(
                value, JsonUtils.getDataMapFromJsonString(JsonUtils.toPrettyJsonString(value)));
        assertEquals(
                "sample",
                JsonUtils.getValueFromJsonString(JsonUtils.toJsonString(value, false), "name"));
        assertNull(JsonUtils.getJson("broken"));
    }
}
