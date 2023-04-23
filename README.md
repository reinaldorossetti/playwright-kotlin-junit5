# Microsoft Playwright - Koltin Project Automation Test

Microsoft has a new open source web automation tool, Playwright. It recently released support for Java\Kotlin. Here are example tests that demonstrate how to use Playwright, including creating Page Objects, Junit 5 e Allure Report.  


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

>> playwright inspect mode:  
npx playwright codegen https://automationbookstore.dev

Now, we can start Postgres with just one simple command:
````shell
docker-compose up
````
or run Postgres in the background with this command, adding -d Detached mode

$ docker-compose up -d
And stop the Postgres service running

$ docker-compose down
In this case, we mapped our local port 5438 to the port 5432 (Postgres default port) inside the container., also we will persist the data in our machine, preventing data loss when deleting the containers, for this, we add the volume using the folder postgres-data as the place where Postgres data are stored.
References:  
https://github.com/microsoft/playwright-java  
https://playwright.dev  
https://applitools.com/blog/playwright-java/  
