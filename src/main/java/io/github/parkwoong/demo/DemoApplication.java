package io.github.parkwoong.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import java.util.Map;
@SpringBootApplication
public class DemoApplication {
 public static void main(String[] args) { SpringApplication.run(DemoApplication.class, args); }
 @Bean CommandLineRunner demo() { return args -> System.out.println(new JsonCodec().encode(Map.of("name", "sample", "count", 3), true)); }
}
