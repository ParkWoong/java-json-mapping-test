# JSON Mapping / JSON 직렬화·역직렬화

[ENG](#eng) | [KR](#kr)

## ENG

A small Jackson example that converts Java values to JSON and reads a JSON object as a Map. It also shows how to format JSON for easy reading.

### Project structure

```text
pom.xml
src/
├── main/
│   └── java/io/github/parkwoong/demo/
│       ├── DemoApplication.java
│       └── JsonCodec.java
└── test/java/io/github/parkwoong/demo/
    └── JsonCodecTest.java
```

Java package: `io.github.parkwoong.demo`.

| File | Role |
|---|---|
| [DemoApplication.java](src/main/java/io/github/parkwoong/demo/DemoApplication.java) | Starts Spring Boot and runs the example. |
| [JsonCodec.java](src/main/java/io/github/parkwoong/demo/JsonCodec.java) | Reuses an ObjectMapper. encode() writes JSON; decode() reads a Map. |
| [pom.xml](pom.xml) | Dependencies and build settings. |

### How it works

DemoApplication creates a sample Map and calls JsonCodec.encode(value, true). The console shows formatted JSON with name=sample and count=3. decode() is used in the test to check the round trip.

### Run

Requirements: Java 17+ and Maven 3.6.3+. Run these commands from the repository root.

```sh
mvn clean verify
mvn spring-boot:run
```

This is a console example, not an HTTP server. JSON field order is not guaranteed.

### Tests

JsonCodecTest checks a Map → JSON → Map round trip, including Korean text, and rejects broken JSON.

[JsonCodecTest.java](src/test/java/io/github/parkwoong/demo/JsonCodecTest.java)

### Scope and limits

decode() expects a JSON object. This example does not convert JSON to XML. JSON errors are passed to the caller as JsonProcessingException.

This learning example uses Spring Boot 3.5.16. Before production use, move to a supported version; see the [3.5 OSS support notice](https://spring.io/blog/2026/06/25/spring-boot-3-5-16-available-now/). Production connections and load tests are not included.

Adapted from a Java proxy project using generic names and sample data. Original Git history, production settings, and business identifiers are not included.

## KR

Jackson으로 Java 값을 JSON으로 변환하고 JSON 객체를 Map으로 읽는 예제입니다. 읽기 좋은 JSON 출력 방법도 다룹니다.

### 프로젝트 구조

```text
pom.xml
src/
├── main/
│   └── java/io/github/parkwoong/demo/
│       ├── DemoApplication.java
│       └── JsonCodec.java
└── test/java/io/github/parkwoong/demo/
    └── JsonCodecTest.java
```

Java 패키지: `io.github.parkwoong.demo`.

| 파일 | 역할 |
|---|---|
| [DemoApplication.java](src/main/java/io/github/parkwoong/demo/DemoApplication.java) | Spring Boot를 시작하고 예제를 실행합니다. |
| [JsonCodec.java](src/main/java/io/github/parkwoong/demo/JsonCodec.java) | ObjectMapper를 재사용합니다. encode()는 JSON을 만들고 decode()는 Map을 읽습니다. |
| [pom.xml](pom.xml) | 의존성과 빌드 설정입니다. |

### 동작 방식

DemoApplication이 샘플 Map을 만들고 JsonCodec.encode(value, true)를 호출합니다. 콘솔에는 name=sample, count=3인 JSON이 출력됩니다. 테스트에서는 decode()로 다시 읽어 원래 값과 비교합니다.

### 실행 방법

Java 17 이상, Maven 3.6.3 이상이 필요합니다. 저장소 루트에서 실행하세요.

```sh
mvn clean verify
mvn spring-boot:run
```

HTTP 서버가 아닌 콘솔 예제입니다. JSON 필드 순서는 보장하지 않습니다.

### 테스트

JsonCodecTest는 한글을 포함한 Map → JSON → Map 변환과 잘못된 JSON 입력의 예외 발생을 확인합니다.

[JsonCodecTest.java](src/test/java/io/github/parkwoong/demo/JsonCodecTest.java)

### 범위와 제한

decode()는 JSON 객체를 입력받습니다. JSON→XML 변환은 포함하지 않습니다. JSON 처리 오류는 JsonProcessingException으로 호출자에게 전달됩니다.

Spring Boot 3.5.16 기반 학습용 예제입니다. 운영 도입 전 지원 버전으로 전환하세요. [3.5 OSS 지원 종료 안내](https://spring.io/blog/2026/06/25/spring-boot-3-5-16-available-now/)를 참고할 수 있습니다. 운영 시스템 연결 및 부하 테스트는 포함하지 않습니다.

기존 Java 프록시 프로젝트에서 기술을 추출해 범용 이름과 샘플 데이터로 재작성했습니다. 기존 Git 이력, 운영 설정 및 업무 식별자는 포함하지 않습니다.
