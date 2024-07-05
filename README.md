<!-- markdownlint-disable MD028 -->
<!-- markdownlint-disable MD033 -->

# 從零開始建置 Spring Boot 專案

這個專案搭配網路上的教學，用於練習 Spring Boot 的專案建立、撰寫與啟動

> 此專案為學習 Spring Boot 過程中紀錄給自己看的筆記，因此有些內容可能不正確

## Table of Contents

內容待補

## 事前準備

開發 Spring Boot 前，需先準備以下工具，下面將會一步一步說明如何安裝與設定

### JDK 安裝

開發 Java 必須安裝 JDK，本專案使用的 JDK 版本為 17，可以透過以下方式進行安裝

> 此專案使用 Eclipse Temurin OpenJDK，不一定要選擇此 JDK，只要經過 Jakarta 官方驗證的發行版都可以安裝使用

- 先到[官方網站](https://www.eclipse.org/downloads/)下載安裝檔
- 依據安裝檔指示完成安裝
- 完成

### Eclipse IDE

Eclipse IDE 是開發 Java 非常常見的開源 IDE，可以透過以下方式進行安裝

> 新版的 Eclipse IDE 安裝檔已無提供壓縮檔，皆須經過安裝檔才可安裝

- 先到[官方網站](https://www.eclipse.org/downloads/)下載安裝檔
- 選擇含有 Jakarta EE 的設定檔進行安裝
- 安裝完後啟動 Eclipse
  > 初次啟動會要求指定 Eclipse 設定檔存放位置，可以依據需求選擇希望的位置儲存，Eclipse 支援多個設定檔
- 打開 Help > Eclipse Marketplace...
- 左上角搜尋框輸入「Spring Tools 4」，找到相應的套件進行安裝
- 以下幾個套件也可以一起安裝，但非必要
  - EGit
- 安裝完成後，關閉 Eclipse IDE
- 到 [Lombok 官方網站](https://projectlombok.org/)下載 JAR 檔
- 打開下載的 JAR 檔，在下面的路徑中選擇 Eclipse IDE 的完整路徑
- 按下安裝，待安裝完成後啟動 Eclipse IDE，即完成安裝

> 若覺得預設的 Intellisense 不好用，或是希望輸入任意文字都會跳出 Intellisense 供選擇，可以依據以下步驟調整設定:
>
> - 打開 Window > Preferneces
> - 左側選單選擇 Java > Editor > Content Assist
> - 右側找到 `Auto activation triggers for Java` 欄位，修改其值為 `.(abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`
> - 按下 Apply and Close 完成設定

下面是在 Eclipse IDE 中新增 Powershell 的步驟

- 打開 Eclipse IDE，點選 Window > Preferences
- 左邊選單切換到 Terminal > Local Terminal
- 右側點選 Add...，並依據以下說明填寫
  - Name: 輸入這個終端機要顯示的名稱
  - Path: 選擇 Powershell 所在位置，沒有特別修改什麼設定，預設路徑會在 `C:\Windows\System32\WindowsPowerShell\v<VERSION>\powershell.exe`
    > `<VERSION>` 視使用者有沒有安裝新版，否則預設皆為 1.0
- 按下 Add 後即完成新增

## IDE 常用快捷鍵

以下是使用 Eclipse IDE 開發 Java 專案常用的快捷鍵

- `Ctrl + Shift + O`: 引用必要的 Package 並清理未使用的引用

## 從零開始建立專案

建立 Spring Boot 專案有兩種方式，但不論如何，其都是透過線上產生專案檔後再進行匯入，以下會針對其進行說明

### 透過 Spring Initializr 建立

- 打開 [Spring Initializr](https://start.spring.io/) 網頁
- Project 選擇 Maven
- Language 選擇 Java
- Spring Boot 版本選擇不含 SNAPSHOT 字樣的版本
- Project Metadata 依據以下說明進行輸入
  - Group: 依據自己的團隊進行輸入，例如: 本專案使用 `net.smkz`
  - Artifact: 輸入此專案的 Package 名稱，例如: 本專案使用 `springbootpractice`
  - Name: 輸入此專案的名稱
  - Description: 輸入此專案的描述
  - Package name: 會由網頁自動產生，不需自行填寫
  - Packaging: 選擇 War
  - Java: 選擇 JDK 版本，本專案使用 17 版
- 按下 Generate，網頁會自動產生一個壓縮檔，下載後自行選定一資料夾進行解壓縮
- 打開 Eclipse IDE，選擇 File > Import...
- 選擇 Maven > Existing Maven Projects 後按下 Next 鈕
- Root Directory 選擇剛剛解壓縮出來的壓縮檔，並按下 Select All
  > 或者可以選擇包含有 `pom.xml` 檔案的資料夾也可以
- 按下 Finish 即完成專案建立

### 透過 Eclipse IDE 建立

- 打開 Eclipse IDE，選擇 New > Project...
- 選擇 Spring Boot > Spring Starter Project 後按下 Next
- 針對以下欄位進行填寫
  - Name: 輸入此專案的名稱
  - Use default location: 若希望自行選擇專案儲存位置，可以將此勾選去除，並指定專案的儲存位置
  - Type: 選擇 Maven
  - Packaging: 選擇 War
  - Java Version: 選擇 JDK 版本，此專案選擇 17
  - Language: 選擇 Java
  - Group: 依據自己的團隊進行輸入，例如: 本專案使用 `net.smkz`
  - Artifact: 輸入此專案的 Package 名稱，例如: 本專案使用 `springbootpractice`
  - Version: 輸入此專案的版本號碼
  - Description: 輸入此專案的描述
  - Package: 輸入專案的 Package 名稱，此名稱應由 Group 與 Artifact 名稱透過 `.` 串成，例: 本專案的 Package 名稱為 `net.smkz.springbootpractice`
- 點選 Next
- 填寫以下欄位
  - Spring Boot Version 選擇不含 SNAPSHOT 字樣的版本
  - 下面可以選擇此專案希望安裝的相依套件，這些套件也可以日後從 `pom.xml` 中修改
- 按下 Finish 即完成專案建立

### 安裝必要的相依套件

本專案會針對需要的相依套件進行安裝說明，其中以下的宣告字串皆應放置於 `pom.xml` 的 `<dependencies>` 區塊中

- 安裝 Lombok

  ```xml
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <scope>provided</scope>
  </dependency>
  ```

- 安裝 JPA，以 MariaDB 為例

  - 修改 `pom.xml`，加入 JPA 與 JDBC 相關套件

    ```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
    ```

  - 再加入第三方廠商的 JDBC 套件，以 MariaDB 為例

    ```xml
    <dependency>
      <groupId>org.mariadb.jdbc</groupId>
      <artifactId>mariadb-java-client</artifactId>
    </dependency>
    ```

  - 修改專案底下的 `src/main/resources/application.properties` 設定，以 MariaDB 為例

    > `DATABASE_HOST` 請修改為資料庫的域名或 IP \
    > `DATABASE_PORT` 請修改為資料庫的連接埠號碼 \
    > `DATABASE_NAME` 請修改為資料庫名稱 \
    > `DATABASE_USERNAME` 請修改為資料庫使用者名稱 \
    > `DATABASE_PASSWORD` 請修改為資料庫密碼

    > `spring.jpa.properties.hibernate.dialect` 若非使用 MariaDB，請自行查詢應使用何種 Dialect

    ```properties
    # Database connection url
    spring.datasource.url=jdbc:mariadb://DATABASE_HOST:DATABASE_PORT/DATABASE_NAME?serverTimezone=UTC&useSSL=false
    spring.datasource.username=DATABASE_USERNAME
    spring.datasource.password=DATABASE_PASSWORD
    spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
    # Show or not log for each sql query
    spring.jpa.show-sql=true
    # Hibernate ddl auto (create, create-drop, update): with "create-drop" the database
    # schema will be automatically created afresh for every start of application
    # spring.jpa.hibernate.ddl-auto=create
    # Allows Hibernate to generate SQL optimized for a particular DBMS
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
    ```

完成後回到 Eclipse IDE 中執行以下操作步驟:

- 對專案點選滑鼠右鍵 > Run as > Maven clean
- 再對專案點選一次滑鼠右鍵 > Run as > Maven install
- 若 Console 中沒有回報錯誤，則完成安裝

或是透過以下方式在終端機中套用變更:

- 針對專案點選滑鼠右鍵 > Show in Local Terminal > Powershell
    > 或是選擇任一習慣的終端機也行
- 在終端機中輸入以下指令:
  - Powershell

    ```Powershell
    .\mvnw.cmd clean; .\mvnw.cmd install
    ```

  - cmd

    ```cmd
    mvnw.cmd clean && mvnw.cmd install
    ```

  - 其它 Bash-Like 終端機

    ```command
    mvnw clean; mvnw install
    ```

## 功能實作方式說明

針對一般的 Spring Boot 專案，預設都是以 MVC 方式進行 RESTful API 的實作，但對於純後端的專案來說，其實不需要 View 層，而 Controller 層可以進一步將商業邏輯與資料持久層分離出來，實作目前 Controller-Service-Repository 三層架構，讓每個功能的邏輯可以更簡單易懂，更易於維護。

以下除了會針對三層架構的撰寫做說明外，會針對專案中其它套件實作與設定實作進行說明

### Lombok

在 Java 世界中，所有的類別其成員都會存在 Getter 與 Setter，一旦成員數量變多，撰寫 Getter 與 Setter 就會造成開發人員的負擔，為了避免開發人員撰寫這類重複性高的方法，可以透過安裝 Lombok 到專案中，其提供一套 Annotations 供開發人員使用，只要針對成員加上 `@Getter` 與 `@Setter` 的 Annotation，專案編譯時就會自動針對這些成員加上相應的 Getter 與 Setter，除此之外，建構式等也可透過這類方式實作，下面是一個簡易範例：

```java
@NoArgConstructor
public class Human {
    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public Integer age;

    @Getter
    @Setter
    public Integer height;

    @Getter
    @Setter
    public Integer weight;
}
```

上面這個範例等效於：

```java
public class Human {
    public Human() {}

    public String name;
    public Integer age;
    public Integer height;
    public Integer weight;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return this.weight;
    }
}
```

由上面的範例可已得知透過 Lombok 套件的協助，可以減少許多重複性高的撰寫工作，提高開發人員的生產力，因此非常建議在專案中加入此套件協助開發。

更多 Annotations 可以參考[官方文件](https://projectlombok.org/features/)說明

### Configuration 與 Profile

內容待補

### Controller

在 MVC 中，Controller 通常是負責從請求接收、商業邏輯處理到回應請求的整個流程，但對於純後端的專案來說，這樣的 Controller 過於肥大，因此會將商業邏輯拆分到 Service 中，而資料持久化等處理則是拆分到 Repository 中，在這樣的架構下，Controller 負責的範圍將只會剩下接收請求、驗證請求資料、處理回應資料與送出回應，讓 Controller 不再這麼肥大。

下面是針對 Spring Boot 專案中 Controller 常用的 Annotations 進行說明:

- `@Autowired`

    以往 Java EE (現名 Jakarta EE) 在注入類別時，需要先宣告成員後，再透過建構式將該類別注入，但在 Spring Boot 中，只要宣告成員時加上此 Annotation，專案啟動後 Spring Boot 就會自動將這些類別注入到類別成員中，因此除了 Controller 外，也常看到 Service 與 Repository 類別使用此 Annotation 注入其它類別。

    下面是一個簡易的範例，先假設我們有一個 `DemoService` 的類別如下：

    ```java
    @Component
    public class DemoService implements IDemoService {

        public List<String> getDemoStringList() {
            List<String> demoStringList = new LinkedList<>();
            demoStringList.add("Hello");
            demoStringList.add("World");

            return demoStringList;
        }
    }
    ```

    在 Controller 中注入此 Service 並呼叫 `getDemoStringList()` 方法可以透過以下方式撰寫：

    ```java
    package net.smkz.springbootpractice.controller;

    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    import net.smkz.springbootpractice.service.IDemoService;

    @RestController
    public class DemoController {

        // 注入 IDemoService
        @Autowired
        private IDemoService demoService;

        @GetMapping("/demo/strings")
        public List<String> getDemoStringList() {
            return this.demoService.getDemoStringList();
        }
    }
    ```

- `@Controller` 與 `@RestController`

  兩個 Annotations 都可套用於 Controller 類別上，其主要差異在於 `@Controller` 需在每個方法上宣告 `@ResponseBody` Annotation 才能讓回應的資料格式變成 JSON，而 `@RestController` 則不需要，如下範例：

  ```java
  @Controller
  public class DemoController {

    @GetMapping("/demo")
    @ResponseBody
    public String demo() {
      return "Hello demo.";
    }
  }
  ```

  ```java
  @RestController
  public class DemoController {

    @GetMapping("/demo")
    public String demo() {
      return "Hello demo.";
    }
  }
  ```

- `@RequestBody` 與 `@ResponseBody`

  `@RequestBody` 是取得請求酬載資料時使用，而 `@ResponseBody` 則是將物件轉換成 Json 回應資料，如下範例：

  ```java
  // HumanDTO.java
  @Data
  public class HumanDTO {
    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;
  }

  // SearchHumanDTO.java
  @Data
  public class SearchHumanDTO {
    private String name;
  }

  // DemoController.java
  @Controller
  public class DemoController {

    @GetMapping("/human")
    @ResponseBody
    public HumanDTO getHumanInfo(@RequestBody SearchHumanDTO searchParam) {
      HumanDTO human = new HumanDTO();
      human.name = searchParam.name;
      human.age = 16;
      human.height = 165;
      human.weight = 45;

      return human;
    }
  }
  ```

- `RequestEntity` 與 `ResponseEntity`

  `RequestEntity` 主要功能為當需要於專案內透過 HTTP 協定呼叫 API 時，可以透過此物件建立請求的內容，包含標頭、方法、URI 與請求酬載等，如下範例：

  ```java
  @GetMapping("/resources/{id}")
  public Resource getResource(@PathVariable("id") String id) {
    RequestEntity<void> request = RequestEntity
      .get(URI.create("http://localhost:8081/resources/" + id))
      .accept(MediaType.APPLICATION_JSON)
      .build();

    ResponseEntity<Resource> response = restTemplate.exchange(request, Resource.class);
    return response.getBody();
  }
  ```

  而 `ResponseEntity` 則是用於建立回應的物件，其區分為 new 物件的方式與 Builder 方式，如下範例：

  - new 物件方式

    ```java
    @GetMapping("/human")
    public ResponseEntity<HumanDTO> getHumanInfo() {
      HumanDTO human = new HumanDTO();
      human.name = "Steven";
      human.age = 16;
      human.height = 165;
      human.weight = 45;

      return new ResponseEntity<HumanDTO>(
        human,
        HttpStatus.OK
      );
    }
    ```

  - Builder 方式

    ```java
    @GetMapping("/human")
    public ResponseEntity<HumanDTO> getHumanInfo() {
      HumanDTO human = new HumanDTO();
      human.name = "Steven";
      human.age = 16;
      human.height = 165;
      human.weight = 45;

      return ResponseEntity.ok(human);
    }
    ```

- `@RequestMapping` 與 `@GetMapping`

  `@RequestMapping` 的用途是在指定各 Controller 方法所對應的網址，或是指定該 Controller 網址的前綴，如下兩個範例其 API 的路徑皆為 `/demo/example`：

  - 指定 Controller 網址前綴

    ```java
    @RestController
    @RequestMapping("/demo")
    public class DemoController {

      @RequestMapping(value = "/example", method = RequestMethod.GET)
      public String getDemoString() {
        return "Hello demo!";
      }
    }
    ```

  - 指定各方法路徑

    ```java
    @RestController
    public class DemoController {

      @RequestMapping(value = "/demo/example", method = RequestMethod.GET)
      public String getDemoString() {
        return "Hello demo!";
      }
    }
    ```

  而 `@GetMapping` 為 Spring 4.3 中出現的，其等效於 `@RequestMapping(method = RequestMethod.GET)`，與 `@RequestMapping` 最大的差異在於 `@GetMapping` 僅可宣告於類別的方法上，不可宣告於類別上，如下範例，其 API 路徑為 `/demo/example`：

  ```java
  @RestController
  @RequestMapping("/demo")
  public class DemoController {

    @GetMapping("/example")
    public String getDemoString() {
      return "Hello demo!";
    }
  }
  ```

### Plain Old Java Object (POJO)

POJO 是 Java 中僅有屬性，沒有方法的物件種類之一。

在開發過程中，當 Controller 接受到請求，或從 Repository 收到查詢結果，都應透過相對應的 POJO 進行型別轉換，避免將不必要的資料暴露給客戶端或從客戶端收到不必要的資料，以下是幾個常在 Java 中見到的 POJO 物件：

- Value Object (VO):

  此物件用途為單純儲存資料用，因此其所有的屬性值僅可在建構式中初始化，後續每個屬性皆沒有 Setter 方法可以變更其值。常用於從其它 Web Service 中收到回應。

- Data Transfer Object (DTO):

  此物件非常常在 Java 中見到，其用途為過濾客戶端請求的資料、在應用程式各層間傳輸資料。

- Persistent Object (PO):

  此物件常用於資料庫寫入，另一常用名稱為 Entity。

- Business Object (BO):

  此物件常用於業務邏輯層，其與 PO、VO 最大差異在於其包含有複雜的業務邏輯，Service 物件是其一種應用。

- Data Access Object (DAO):

  常用於儲存查詢資料庫的邏輯，Repository 是其一種應用。

應依其使用情境決定要使用哪個 POJO，而 POJO 間的轉換最常見也最穩定的方式就是透過重新建立一個新的 POJO 後，將原本的屬性儲存到新的 POJO 中。但若屬性數量比較多，可以使用 ObjectMapper 套件協助轉換，但若會在 POJO 上使用 `@JsonProperty` 設定 JSON 格式欄位名稱的話，ObjectMapper 就不適合使用於 POJO 的轉換。

### Service

在撰寫過程中，會習慣將業務與商業邏輯放到 Service 層中處理，避免 Controller 過於肥大，而每個 Service 的方法所處理的邏輯不應太過複雜，應符合「單一職責原則」進行開發，每個 Service 也應透過其負責的領域進行拆分。

### Repository

Repository 實際用途在於處理資料庫資料的寫入、查詢、刪除，在 Spring Boot 中可以透過建立一個介面，並繼承 `JpaRepository`，就可以達到其目的，也可以透過 `EntityManager` 宣告需要的方法進行資料的處理，以下

- EntityManager

  EntityManager 的實作方式與其它語言的框架較相近，先建立一個

- JPQL

  - `@Query` 與 `@NamedQuery`

- 效能優化說明

### Entity

內容待補

### Javadoc

內容待補

## 啟動專案

啟動 Spring Boot 專案可以透過 Run As 選單與透過指令兩種方式啟動

專案啟動後可以透過瀏覽器存取 `http://localhost:8080/` 檢視成果

### 透過 Run As 選單

針對專案點選滑鼠右鍵 > Run As > Spring Boot App 即可在本機中啟動 Spring Boot 專案

> 也可透過快速鍵 `Alt + Shift + X` 後再按下 `B` 啟動 Spring Boot 專案

### 透過指令

- 針對專案點選滑鼠右鍵 > Show in Local Terminal > 點選常用的終端機
- 依據終端機不同執行相對應的指令：
  - Powershell

    ```Powershell
    .\mvnw.cmd clean; .\mvnw.cmd install; .\mvnw.cmd spring-boot:run
    ```

  - cmd

    ```cmd
    mvnw.cmd clean && mvnw.cmd install && mvnw.cmd spring-boot:run
    ```

  - 其它 Bash-Like 終端機

    ```shell
    mvnw clean; mvnw install; mvnw spring-boot:run
    ```

## 容器化

內容待補

## 參考資料

### IDE

- [Eclipse Intellisense?](https://stackoverflow.com/a/4225995)
- [How to change back the perspective after terminating the debugged process in Eclipse?](https://stackoverflow.com/a/522958)
- [How to run Spring Boot web application in Eclipse itself?](https://stackoverflow.com/a/28349142)

### Java

- [一次搞懂POJO、PO、DTO、VO、BO](https://hackmd.io/@MonsterLee/HJyAdgRBB#)
- [DTO、VO、BO、DAO、POJO 各種 Object](https://hackmd.io/@OceanChiu/HJBvCZcQ8)

### Spring Boot Common

- [深入理解 Spring Boot 架構](https://www.51cto.com/article/757069.html)
- [30天帶你潮玩Spring Boot Zone 系列](https://ithelp.ithome.com.tw/users/20119569/ironman/2159)
- [Learning From JHipster](https://github.com/albert-hg/learning-from-jhipster)
- [Guide to Spring @Autowired](https://www.baeldung.com/spring-autowire)
- [Using Spring ResponseEntity to Manipulate the HTTP Response](https://www.baeldung.com/spring-response-entity)
- [Spring’s RequestBody and ResponseBody Annotations](https://www.baeldung.com/spring-request-response-body)
- [What is the difference between ResponseEntity<T> and @ResponseBody?](https://stackoverflow.com/a/22725259)
- [albert-hg/learning-from-jhipster - Learning From JHipster - GitHub](https://github.com/albert-hg/learning-from-jhipster)
- [Open PowerShell terminal in Eclipse](https://stackoverflow.com/a/72845794)
- [How to start up spring-boot application via command line?](https://stackoverflow.com/a/55200392)
- [[Spring Boot] 請求與回應](https://hackmd.io/@winnienotes/BJ0R84fUj)
- [Spring Boot: RequestEntity vs ResponseEntity | RequestBody vs ResponseBody](https://medium.com/@daryl-goh/spring-boot-requestentity-vs-responseentity-requestbody-vs-responsebody-dc808fb0d86c)
- [Spring ResponseEntity](https://hackmd.io/@JohnnyTsai/SJ-AwULBP)
- [Spring RequestMapping](https://www.baeldung.com/spring-requestmapping)
- [Java Spring: automatic EntityToDTO mapping using a method instead of an attribute](https://stackoverflow.com/a/67065874)
- [(17) Spring Boot 導入 Liquibase](https://medium.com/learning-from-jhipster/17-spring-boot-%E5%B0%8E%E5%85%A5-liquibase-c00bc6c481db)
- [Spring Boot Docker](https://spring.io/guides/topicals/spring-boot-docker)
- [Spring boot autowiring an interface with multiple implementations](https://stackoverflow.com/questions/51766013/spring-boot-autowiring-an-interface-with-multiple-implementations)
- [Singleton Design Pattern vs Singleton Beans in Spring Boot](https://www.baeldung.com/spring-boot-singleton-vs-beans)
- [How to Set a Header on a Response with Spring 6](https://www.baeldung.com/spring-response-header)
- [@Component vs @Repository and @Service in Spring](https://www.baeldung.com/spring-component-repository-service)
- [Generate list of dtos to the list of entities using Java 8](https://stackoverflow.com/a/67688827)
- [Swagger Like a Pro with Spring Boot 3 and Java 17](https://medium.com/@berktorun.dev/swagger-like-a-pro-with-spring-boot-3-and-java-17-49eed0ce1d2f)

### Spring Boot Validation

- [Validation in Spring Boot](https://www.baeldung.com/spring-boot-bean-validation)
- [How do I customize default error message from spring @Valid validation?](https://stackoverflow.com/a/33664636)
- [Spring Boot REST API Validate Path Variables Examples](https://www.codejava.net/frameworks/spring-boot/rest-api-validate-path-variables-examples)
- [Validating RequestParams and PathVariables in Spring](https://www.baeldung.com/spring-validate-requestparam-pathvariable)
- [Validations in Spring Boot](https://medium.com/@himani.prasad016/validations-in-spring-boot-e9948aa6286b)
- [Spring Boot Validation not working with Generics](https://stackoverflow.com/a/73910373)
- [Java generic type validation](https://stackoverflow.com/a/73583412)
- [Include variable value in validation message](https://stackoverflow.com/a/74736185)
- [Regex date format validation on Java](https://stackoverflow.com/a/2149692)
- [https://stackoverflow.com/a/4528094](How to sanity check a date in Java)
- [Get Missing Fields When HttpMessageNotReadableException occurs](https://stackoverflow.com/a/71210685)
- [How to handle jackson deserialization error for all kinds of data mismatch in spring boot](https://stackoverflow.com/a/52196438)
- [Spring @JsonFormat exception handler](https://stackoverflow.com/a/76511648)
- [Validation with Spring Boot - the Complete Guide](https://reflectoring.io/bean-validation-with-spring-boot/)
- [How to validate date in the format "MM/dd/yyyy" in Spring Boot?](https://stackoverflow.com/a/53540029)

### Exception Handler

- [Java Spring Boot: Exception Handling](https://stackoverflow.com/a/74525772)
- [Error Handling for REST with Spring](https://www.baeldung.com/exception-handling-for-rest-with-spring)
- [Exception Handling in Spring MVC](https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc)
- [Spring Boot ExceptionHandler for MethodArgumentNotValidException in RestController never gets invoked](https://stackoverflow.com/a/66373975)
- [How we can get different @ExceptionHandler for different controllers in java spring boot?](https://stackoverflow.com/a/73150426)
- [ExceptionHandler shared by multiple controllers](https://stackoverflow.com/a/7557241)
- [How to have two ControllerAdvice in the same SpringMvc application](https://stackoverflow.com/a/34878952)
- [different response for a same exception using @controlleradvice and @exceptionhandler if exception is generating from different controller](https://stackoverflow.com/a/60356230)

### Web Client

- [Spring Boot – WebClient with Example](https://www.geeksforgeeks.org/spring-boot-webclient-with-example/)
- [Spring 5 WebClient](https://www.baeldung.com/spring-5-webclient)
- [retrieve()](https://docs.spring.io/spring-framework/reference/web/webflux-webclient/client-retrieve.html)
- [Get list of objects as response Web client Java](https://stackoverflow.com/a/76690118)

### JPA

- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [springframeworkguru/spring-boot-mariadb-example - GitHub](https://github.com/springframeworkguru/spring-boot-mariadb-example)
- [Qualified bean must be of 'EntityManagerFactory' type in Spring Boot 3. Works with Spring Boot 2](https://stackoverflow.com/a/74861220)
- [Unable to resolve name [org.hibernate.dialect.MySQL5InnoDBDialect] as strategy [org.hibernate.dialect.Dialect]](https://stackoverflow.com/a/74580109)
- [What is the MariaDB dialect class name for Hibernate?](https://stackoverflow.com/a/51734560)
- [Introduction to Project Lombok](https://www.baeldung.com/intro-to-project-lombok)
- [How can I make an auto-incremental id in springBoot](https://stackoverflow.com/a/74616094)
- [(19) 導入Spring-Data-JPA，將資料庫與物件進行綁定與 Sequence 的設定](https://medium.com/learning-from-jhipster/19-%E5%B0%8E%E5%85%A5spring-data-jpa-%E5%B0%87%E8%B3%87%E6%96%99%E5%BA%AB%E8%88%87%E7%89%A9%E4%BB%B6%E9%80%B2%E8%A1%8C%E7%B6%81%E5%AE%9A%E8%88%87-sequence-%E7%9A%84%E8%A8%AD%E5%AE%9A-d96724c03458)
- [(20) Controller、Service、Repository的建立 - 1 _ JpaRepository 的使用](https://medium.com/learning-from-jhipster/20-controller-service-repository%E7%9A%84%E5%BB%BA%E7%AB%8B-1-jparepository-%E7%9A%84%E4%BD%BF%E7%94%A8-6606de7c9d41)
- [Defining Query Methods](https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html)
- [How to store @Query sql in external file for CrudRepository?](https://stackoverflow.com/a/50409558)
- [How to write multiple line property value using PropertiesConfiguration?](https://stackoverflow.com/a/8978515)
- [How to Use Spring Data JPA Named Queries](https://attacomsian.com/blog/spring-data-jpa-named-queries)
- [How can I log SQL statements in Spring Boot?](https://stackoverflow.com/a/31249985)
- [Show Hibernate/JPA SQL Statements from Spring Boot](https://www.baeldung.com/sql-logging-spring-boot)
- [Spring-data JPA 搭配 Optional 的使用](https://jerry80409.github.io/2018/12/24/spring-data-jpa-and-optional/)
- [java.util.NoSuchElementException: No value present Spring JPA](https://stackoverflow.com/a/65466956)
- [How to Access EntityManager with Spring Data](https://www.baeldung.com/spring-data-entitymanager)

## WebFlux

### Reactive Programming

- [Spring Framework - WebFlux Overview](https://docs.spring.io/spring-framework/reference/web/webflux/new-framework.html)
- [Guide to Spring 5 WebFlux](https://www.baeldung.com/spring-webflux)
- [How to get request body from ServerRequest object in Spring WebFlux reactive?](https://stackoverflow.com/a/64396389)
- [RestController with Spring WebFlux :Required parameter is not present](https://stackoverflow.com/a/50209402)
- [a-mountain/realworld-spring-webflux](https://github.com/a-mountain/realworld-spring-webflux)
- [Introduction to Reactive Programming with Spring Webflux](https://gokhana.dev/reactive-programming-with-spring-webflux/)
- [What is the recommended project structure for spring boot rest projects? [closed]](https://stackoverflow.com/a/55590796)
- [Learn reactive programming with Spring WebFlux](https://medium.com/@aashigangrade06/learn-reactive-programming-with-spring-webflux-6b53cfd0c038)

### Reactive Repository

- [Spring Data JPA 非阻塞](https://hackmd.io/@bloxmithp/BkCzRafG3)
- [Reactive Programming with Java Spring, R2DBC and MariaDB](https://dev.to/probablyrealrob/reactive-programming-with-java-spring-r2dbc-and-mariadb-3327)
- [Spring WebFlux Tutorial with CRUD Example](https://howtodoinjava.com/spring-webflux/spring-webflux-tutorial/)
- [Reactive programming with Spring Data R2DBC](https://medium.com/pictet-technologies-blog/reactive-programming-with-spring-data-r2dbc-ee9f1c24848b)
- [R2DBC vs Spring Jdbc Vs Spring Data JDBC?](https://stackoverflow.com/a/68918139)
- [Asynchronous RDBMS access with Spring Data R2DBC](https://lankydan.dev/2019/02/16/asynchronous-rdbms-access-with-spring-data-r2dbc)
- [R2DBC – Reactive Relational Database Connectivity](https://www.baeldung.com/r2dbc)

## Swagger

- [springdoc-openapi v2.5.0 - Get Started](https://springdoc.org/#getting-started)
- [spring boot 專案使用Swagger 標示API](https://medium.com/@openthedidi2004/spring-boot-%E5%B0%88%E6%A1%88%E4%BD%BF%E7%94%A8swagger-%E6%A8%99%E7%A4%BAapi-36ae720e8905)
- [why Swagger UI is not working in Spring Boot 3.0 version?](https://stackoverflow.com/a/75926275)
- [Documenting Spring Boot REST API with SpringDoc + OpenAPI 3](https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-springdoc-openapi-3/)
- [Spring boot : Migrating from Springfox Swagger 2 to Springdoc OpenAPI 3](https://deepak-shinde.medium.com/migrating-from-springfox-swagger-2-to-springdoc-openapi-3-79a79757b8d1)
- [How to add swagger or spring doc annotation to pojos columns？](https://github.com/jOOQ/jOOQ/issues/14779#issuecomment-1465654439)
- [springdoc-openapi how to display an list of object class as a response?](https://stackoverflow.com/a/74410256)
- [SwaggerUI Response Examples do not work with mediaType JSON](https://stackoverflow.com/a/63710058)
- [Swagger - Setting Default media-type or Accept Header for responses](https://stackoverflow.com/a/74274711)
- [spring boot 3 使用swagger](https://hackmd.io/@_XeDPt_GRpu82pxm_rKHrQ/rysozEsCo)

### Logging

- [Logging in Spring Boot](https://www.baeldung.com/spring-boot-logging)

### 日期與時間處理

- [Java：日期時間格式化輸出入處理：Date、Calendar、SimpleDateFormat](https://www.ewdna.com/2009/01/javadatecalendardateformatsimpledatefor.html)
- [How to get the current date/time in Java [duplicate]](https://stackoverflow.com/a/5175900)
- [Android 使用LocalDate、LocalTime、LocalDateTime等Java8的日期時間](https://medium.com/evan-android-note/android-%E4%BD%BF%E7%94%A8localdate-localtime-localdatetime%E7%AD%89java8%E7%9A%84%E6%97%A5%E6%9C%9F%E6%99%82%E9%96%93-a78a41becee7)
- [Convert java.util.Date to String](https://stackoverflow.com/a/5683761)
- [Jackson Date](https://www.baeldung.com/jackson-serialize-dates)
- [Deserialize JSON date format to ZonedDateTime using objectMapper](https://stackoverflow.com/a/57183634)
- [How do I force a Spring Boot JVM into UTC time zone?](https://stackoverflow.com/a/54321163)
- [String to java.sql.Date](https://stackoverflow.com/a/18439059)

### Object Mapper

- [Intro to the Jackson ObjectMapper](https://www.baeldung.com/jackson-object-mapper-tutorial#bd-3-handling-date-formats)
- [ObjectMapper.convertValue() 遇到的一些問題](https://blog.csdn.net/weixin_39778417/article/details/103304940)
- [Jacksonで、オブジェクトをシリアライズする際にnullのプロパティを出力しないようにする](https://kazuhira-r.hatenablog.com/entry/2023/01/15/210749)

### Test

- [Testing the Web Layer](https://spring.io/guides/gs/testing-web)
- [Is Java's assertEquals method reliable?](https://stackoverflow.com/a/1201944)
- [Assert an Exception Is Thrown in JUnit 4 and 5](https://www.baeldung.com/junit-assert-exception)
- [在 Spring boot 上撰寫 API 與 Service 的單元測試 JUnit、Mockito](https://bingdoal.github.io/backend/2021/12/api-and-service-unit-test-on-spring-boot-junit-mockito/)
- [Testing in Spring Boot](https://www.baeldung.com/spring-boot-testing)
- [Spring Boot - Rest Controller Unit Test](https://www.tutorialspoint.com/spring_boot/spring_boot_rest_controller_unit_test.htm)
- [Best Practices for How to Test Spring Boot Applications](https://spring.academy/guides/spring-spring-boot-testing)
- [Testing with Spring Boot and @SpringBootTest](https://reflectoring.io/spring-boot-test/)
- [How to populate test data programmatically for integration tests in Spring?](https://stackoverflow.com/a/35065462)
- [Quick Guide on Loading Initial Data with Spring Boot](https://www.baeldung.com/spring-boot-data-sql-and-schema-sql)
- [Testing Exceptions with Spring MockMvc](https://www.baeldung.com/spring-mvc-test-exceptions)
- [Spring mock MVC unit test with controller advice](https://stackoverflow.com/a/48380572)
- [How to test exceptions handling in @ControllerAdvice](https://stackoverflow.com/a/76341135)
- [Spring MVC Controllers Unit Test not calling @ControllerAdvice](https://stackoverflow.com/a/28727831)
- [Support default character encoding for response in MockMvc](https://github.com/spring-projects/spring-framework/issues/27230#issuecomment-1816150215)
- [AssertContains on strings in jUnit](https://stackoverflow.com/a/13777283)
- [Join String list elements with a delimiter in one step [duplicate]](https://stackoverflow.com/a/22949211)

## Deployments

- [Native Images with Spring Boot and GraalVM](https://www.baeldung.com/spring-native-intro)
