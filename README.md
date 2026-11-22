# JSON Utilities / JSON 유틸리티

[ENG](#eng) | [KR](#kr)

## ENG

Uses the original JsonUtils methods for JSON serialization, pretty printing, JSONObject access, and JSON-to-Map conversion. The original null-on-error behavior is kept.

### Source and minimal changes

Only package names and formatting changed in JsonUtils. Added tests and local build settings. Removed the previously generated JsonCodec.

| Original source | Extracted file |
|---|---|
| `ProxyApplication.java` | [DemoApplication.java](src/main/java/io/github/parkwoong/demo/DemoApplication.java) |
| `spec/util/JsonUtils.java` | [spec/util/JsonUtils.java](src/main/java/io/github/parkwoong/demo/spec/util/JsonUtils.java) |

### Structure

```text
pom.xml
src/main/java/io/github/parkwoong/demo/DemoApplication.java
src/main/java/io/github/parkwoong/demo/spec/util/JsonUtils.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/demo/JsonUtilsTest.java
```

### How it works

Call JsonUtils.toJsonString(value, false), toPrettyJsonString(value), getJson(body), getValueFromJsonString(body, key), or getDataMapFromJsonString(body). JsonUtilsTest shows calls with sample data.

### Run and test

Use Java 17 and Maven 3.6.3+. Run from the repository root:

```sh
mvn clean verify
mvn spring-boot:run
```

The app starts without an HTTP server or an added console workflow. Use the tests under src/test for actual calls and results. Database modules initialize H2 at startup.

### Formatting

All Java files use google-java-format 1.24.0 with the AOSP style: four-space indentation, consistent line breaks, and organized imports.

### Original limits

JSON-to-XML is not included. getValueFromJsonString expects a String value. Invalid input may return null and log an error; callers must handle it.

The build keeps Spring Boot 2.6.6 and the original MyBatis/JJWT APIs for source fidelity. Lombok 1.18.36 supports the local Java 17 build. These are legacy dependencies; this extraction is for learning, not a production-ready upgrade. No production integration or load test is included.

## KR

원본 JsonUtils의 JSON 직렬화, pretty printing, JSONObject 조회, JSON→Map 변환 메서드를 추출했습니다. 오류 발생 시 null을 반환하는 원본 동작을 유지합니다.

### 원본과 최소 변경 사항

JsonUtils는 패키지 이름과 포맷만 변경했습니다. 테스트와 로컬 빌드 설정을 추가하고 이전에 새로 작성했던 JsonCodec은 제거했습니다.

| 원본 파일 | 추출 파일 |
|---|---|
| `ProxyApplication.java` | [DemoApplication.java](src/main/java/io/github/parkwoong/demo/DemoApplication.java) |
| `spec/util/JsonUtils.java` | [spec/util/JsonUtils.java](src/main/java/io/github/parkwoong/demo/spec/util/JsonUtils.java) |

### 프로젝트 구조

```text
pom.xml
src/main/java/io/github/parkwoong/demo/DemoApplication.java
src/main/java/io/github/parkwoong/demo/spec/util/JsonUtils.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/demo/JsonUtilsTest.java
```

### 코드 설명

JsonUtils.toJsonString(value, false), toPrettyJsonString(value), getJson(body), getValueFromJsonString(body, key), getDataMapFromJsonString(body)를 호출합니다. JsonUtilsTest에서 샘플 호출을 확인할 수 있습니다.

### 실행과 테스트

Java 17, Maven 3.6.3 이상을 사용합니다. 저장소 루트에서 실행하세요:

```sh
mvn clean verify
mvn spring-boot:run
```

앱은 HTTP 서버나 별도 콘솔 시나리오 없이 시작합니다. 실제 호출과 결과 확인은 src/test의 테스트를 이용하세요. DB 모듈은 시작 시 H2를 초기화합니다.

### 코드 포맷

전체 Java 파일에 google-java-format 1.24.0의 AOSP 스타일을 적용했습니다. 들여쓰기 4칸, 일관된 줄바꿈 및 import 정리를 사용합니다.

### 유지한 원본 동작과 제한

JSON→XML은 포함하지 않습니다. getValueFromJsonString은 문자열 값을 기대합니다. 잘못된 입력은 오류 로그와 null 반환으로 처리하므로 호출자가 확인해야 합니다.

원본 코드 보존을 위해 Spring Boot 2.6.6과 원본 MyBatis/JJWT API를 사용합니다. 로컬 Java 17 빌드를 위해 Lombok 1.18.36을 적용했습니다. 레거시 의존성을 사용하는 학습용 추출본이며 운영용 업그레이드가 아닙니다. 운영 연동 및 부하 테스트는 포함하지 않습니다.
