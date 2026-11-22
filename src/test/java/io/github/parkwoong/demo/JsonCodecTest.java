package io.github.parkwoong.demo;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
class JsonCodecTest {
 @Test void roundTripAndInvalidInput() throws Exception {
  var codec = new JsonCodec();
  var input = Map.of("name", "예제", "count", 3);
  assertEquals(input, codec.decode(codec.encode(input, true)));
  assertThrows(com.fasterxml.jackson.core.JsonProcessingException.class, () -> codec.decode("{broken"));
 }
}
