# Microsoft Playwright - Java API

Microsoft has a new open source web automation tool, Playwright. It recently released support for Java. Here are example tests that demonstrate how to use Playwright, including creating Page Objects  


### Executes all tests in SomeTestClass
```
gradle clean test --tests SearchTests
```
### Executes a single specified test in SomeTestClass
```
gradle test --tests SearchTests.searchForPartialTitle
gradle test --tests SearchTests.*PartialTitle*
```
###Requirements:  
>> Install Java JDK >= 11  
```  
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}
```  
https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html  

>> download allure command line:  
npm install -g allure-commandline

>> download dependencies:  
mvn package  

>> run tests:  
mvn clean test  
allure serve target/allure-results  

>> playwright inspect mode:  
npx playwright codegen https://automationbookstore.dev


References:  
https://github.com/microsoft/playwright-java  
https://playwright.dev  
https://applitools.com/blog/playwright-java/  
