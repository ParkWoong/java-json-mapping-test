package io.github.parkwoong.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
public class JsonCodec {
 private final ObjectMapper mapper = new ObjectMapper();
 public String encode(Object value, boolean pretty) throws JsonProcessingException {
  return (pretty ? mapper.writerWithDefaultPrettyPrinter() : mapper.writer()).writeValueAsString(value);
 }
 public Map<String, Object> decode(String json) throws JsonProcessingException {
  return mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
 }
}
