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

- `@RequestBody`、`@ResponseBody` 與 `@RestController` Annotations

- `RequestEntity` 與 `ResponseEntity`

- `@RequestMapping` 與 `@<METHOD>Mapping`

### Service

內容待補

- DTO

- Mapping

### Repository

內容待補

- EntityManager

- JPQL

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

### Spring Boot

- [30天帶你潮玩Spring Boot Zone 系列](https://ithelp.ithome.com.tw/users/20119569/ironman/2159)
- [Guide to Spring @Autowired](https://www.baeldung.com/spring-autowire)
- [Using Spring ResponseEntity to Manipulate the HTTP Response](https://www.baeldung.com/spring-response-entity)
- [Spring’s RequestBody and ResponseBody Annotations](https://www.baeldung.com/spring-request-response-body)
- [What is the difference between ResponseEntity<T> and @ResponseBody?](https://stackoverflow.com/a/22725259)
- [albert-hg/learning-from-jhipster - Learning From JHipster - GitHub](https://github.com/albert-hg/learning-from-jhipster)
- [Open PowerShell terminal in Eclipse](https://stackoverflow.com/a/72845794)
- [How to start up spring-boot application via command line?](https://stackoverflow.com/a/55200392)
- [[Spring Boot] 請求與回應](https://hackmd.io/@winnienotes/BJ0R84fUj)

### JPA

- [springframeworkguru/spring-boot-mariadb-example - GitHub](https://github.com/springframeworkguru/spring-boot-mariadb-example)
- [Qualified bean must be of 'EntityManagerFactory' type in Spring Boot 3. Works with Spring Boot 2](https://stackoverflow.com/a/74861220)
- [Unable to resolve name [org.hibernate.dialect.MySQL5InnoDBDialect] as strategy [org.hibernate.dialect.Dialect]](https://stackoverflow.com/a/74580109)
- [What is the MariaDB dialect class name for Hibernate?](https://stackoverflow.com/a/51734560)
- [Introduction to Project Lombok](https://www.baeldung.com/intro-to-project-lombok)
- [How can I make an auto-incremental id in springBoot](https://stackoverflow.com/a/74616094)
