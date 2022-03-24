Spring Initializr
-----------------
Project Settings:
Java
Gradle
Java 17
Jar

Dependencies:
Web -> Spring Web
Template Engines -> Thymeleaf

@SpringBootApplication performs a @ComponentScan so that any class annotated with @Component will automatically be "loaded" at runtime.

Add logging.level.web=debug to src/main/resources/application.properties

Add static index.html to src/main/resources/static

Run from JAR file:
  .\gradlew build
  java -jar build\libs\jarname.jar
  
BindingAwareModelMap to mock a Model in unit tests  
  Model model = new BindingAwareModelMap();
  
