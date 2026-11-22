# JSON Utilities / JSON 유틸리티

[ENG](#eng) | [KR](#kr)

## ENG

### Project structure

```text
pom.xml
src/main/java/io/github/parkwoong/demo/DemoApplication.java
src/main/java/io/github/parkwoong/demo/spec/util/JsonUtils.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/demo/JsonUtilsTest.java
```

### Code explanation

`JsonUtils` converts Java values to JSON, formats JSON, reads a `JSONObject`, and converts a JSON object to a `Map`. `toJsonString(value, false)` produces compact JSON; `toPrettyJsonString(value)` formats it. `getValueFromJsonString` reads a String field. Invalid input may return `null`, so callers must check the result.

### Run and test

Use JDK 8 and Maven 3.6.3+. Set JAVA_HOME to your JDK 8 directory, then run from the repository root:

```sh
java -version
mvn -version
mvn clean verify
mvn spring-boot:run
```

`JsonUtilsTest` checks JSON/Map round trips, String field lookup, and invalid input.

The app starts without an HTTP server and exits. The test class shows the actual method calls and results. Database examples use H2 and need no external server.

## KR

### 프로젝트 구조

```text
pom.xml
src/main/java/io/github/parkwoong/demo/DemoApplication.java
src/main/java/io/github/parkwoong/demo/spec/util/JsonUtils.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/demo/JsonUtilsTest.java
```

### 코드 설명

`JsonUtils`는 Java 값의 JSON 직렬화, JSON 포맷 출력, `JSONObject` 조회 및 JSON 객체의 `Map` 변환을 제공합니다. `toJsonString(value, false)`는 압축 JSON, `toPrettyJsonString(value)`는 정렬된 JSON을 만듭니다. `getValueFromJsonString`은 문자열 필드를 읽습니다. 잘못된 입력은 `null`을 반환할 수 있으므로 호출자가 확인해야 합니다.

### 실행과 테스트

JDK 8과 Maven 3.6.3 이상을 사용합니다. JAVA_HOME을 JDK 8 경로로 설정하고 저장소 루트에서 실행하세요:

```sh
java -version
mvn -version
mvn clean verify
mvn spring-boot:run
```

`JsonUtilsTest`는 JSON/Map 왕복 변환, 문자열 필드 조회 및 잘못된 입력을 확인합니다.

앱은 HTTP 서버 없이 시작 후 종료합니다. 실제 메서드 호출과 결과는 테스트 클래스에서 확인합니다. DB 예제는 H2를 사용하며 외부 서버는 필요하지 않습니다.
