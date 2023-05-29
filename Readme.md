# WIP
Example of modern test harness using:
- Spring Boot
- Cucumber (BDD testing)
- TestNG (parallel test execution)
- Rest Assured (API testing)
- Selenide (UI testing)
- Allure Reports
- Extent Reports

# Environment Switching

You can specify profile using maven:
```
mvn clean test -DactiveProfile=dev
```

You can also set default profile in pom.xml
```xml

<profiles>
    ...
    <profile>
        <id>dev</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            <activatedProperties>dev</activatedProperties>
        </properties>
    </profile>
    ...
</profiles>
```

# Allure Reports

You can find configuration for Allure Reports in allure.proprties

To generate allure reports use:

allure serve .\target\allure-results

Remember to install allure first.

# Extent Reports

You can find configuration for Extent Reports in extent.properties

# Configuration

The `HarnessAbstractTestDefinition` is the base class for step and hook classes, it marks them with `@SpringBootTest` and
its `@ContextConfiguration`

```java

@ContextConfiguration(classes = {HarnessContextConfiguration.class})
@SpringBootTest
public class HarnessAbstractTestDefinition {
}
```

The `HarnessContextConfiguration` class is responsible for specifying the Spring `@Configuration`, modules to scan,
properties to use etc

```java

@EnableRetry
@Configuration
@ComponentScan({
        "com.maras.springtestharness"
})
@PropertySource("classpath:/application.properties")
public class HarnessContextConfiguration {
}
```