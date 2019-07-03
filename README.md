# Craiglist-test-suite


This is simple UI test project for demonstrating BDD test approach.

### Tech

* [Groovy] - Object-oriented programming language for the Java platform
* [Cucumber] - BDD tool
* [Google Guice] - Lightweight dependency injection framework for Java
* [Allure] - Test execution reports framework
* [Gradle] - Build automation system


### Test execution from command line:

##### 1) Execute all tests and generate report:
```sh
$ cd craiglist-test-suite
$ ./gradlew clean test allureReport
```
##### 2) Open generated report:
```sh
$ ./gradlew allureServe
```

### Test execution from IDE:

#####First option:
 Open CukesRunner.groovy class and run it.
#####Second option:
1. Add "com.github.asergejs.steps" in 'Glue' field to cucumber run configuration
2. Execute tests from 'sorting.feature' file 
  


   [Cucumber]: <https://cucumber.io/>
   [Groovy]: <http://groovy-lang.org/>
   [Google Guice]: <https://github.com/google/guice/>
   [Allure]: <http://allure.qatools.ru/>
   [Gradle]: <https://gradle.org/>

  
