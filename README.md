# JSON Utilities / JSON 유틸리티

[ENG](#eng) | [KR](#kr)

## ENG

### Project structure

```text
pom.xml
src/main/java/io/github/parkwoong/demo/DemoApplication.java
src/main/java/io/github/parkwoong/demo/JsonController.java
src/main/java/io/github/parkwoong/demo/spec/util/JsonUtils.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/demo/JsonUtilsTest.java
```

### Code explanation

`JsonUtils` converts Java values to JSON, formats JSON, reads a `JSONObject`, and converts a
JSON object to a `Map`. `toJsonString(value, false)` produces compact JSON;
`toPrettyJsonString(value)` formats it. `getValueFromJsonString` reads a String field. Invalid
input may return `null`, so callers must check the result.

JsonController exposes JSON parsing and formatting through one HTTP request.

### Run and test

Use JDK 8 and Maven 3.6.3+. Set JAVA_HOME to your JDK 8 directory, then run from the repository
root:

```sh
java -version
mvn -version
mvn clean verify
mvn spring-boot:run
```

`JsonUtilsTest` checks JSON/Map round trips, String field lookup, and invalid input.

The app listens on localhost:8080. Unit tests cover the helper methods.

#### Postman API

##### Format JSON

**Request**

- Method: POST
- URL: http://localhost:8080/api/json/format
- Content-Type: application/json

~~~json
{
  "name": "sample",
  "count": 2
}
~~~

**Response**

- Status: 200 OK

~~~json
{
  "name": "sample",
  "count": 2
}
~~~

**Note:** Invalid JSON: 400 Bad Request.

## KR

### 프로젝트 구조

```text
pom.xml
src/main/java/io/github/parkwoong/demo/DemoApplication.java
src/main/java/io/github/parkwoong/demo/JsonController.java
src/main/java/io/github/parkwoong/demo/spec/util/JsonUtils.java
src/main/resources/application.properties
src/test/java/io/github/parkwoong/demo/JsonUtilsTest.java
```

### 코드 설명

`JsonUtils`는 Java 값의 JSON 직렬화, JSON 포맷 출력, `JSONObject` 조회 및 JSON
객체의 `Map` 변환을 제공한다. `toJsonString(value, false)`는 압축 JSON,
`toPrettyJsonString(value)`는 읽기 편한 JSON을 만든다.
`getValueFromJsonString`은 문자열 필드를 읽는다. 잘못된 입력은 `null`을 반환할 수 있으므로
호출자가 확인해야 한다.

JsonController는 HTTP 요청 한 번으로 JSON 읽기와 형식 정리를 확인한다.

### 실행과 테스트

JDK 8, Maven 3.6.3 이상 사용. 저장소 루트에서 실행.

```sh
java -version
mvn -version
mvn clean verify
mvn spring-boot:run
```

`JsonUtilsTest`는 JSON/Map 왕복 변환, 문자열 필드 조회 및 잘못된 입력을 확인한다.

앱은 localhost:8080에서 실행된다. 단위 테스트는 내부 메서드를 확인한다.

#### Postman API

##### JSON 형식 정리

**요청**

- 메서드: POST
- URL: http://localhost:8080/api/json/format
- Content-Type: application/json

~~~json
{
  "name": "sample",
  "count": 2
}
~~~

**응답**

- 상태: 200 OK

~~~json
{
  "name": "sample",
  "count": 2
}
~~~

**참고:** 잘못된 JSON: 400 Bad Request.
