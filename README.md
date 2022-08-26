# Babbel(Cucumber - Selenium - Java)

## Conf & Instalation

* macOs Catalina(10.15.7)
* IntelliJ (version:2019.3.1)
* Languange: java (version:15 JDK)
* Maven project
* InteliJ plugins: Gherkin - Cucumber for java
* NodeJS (14)
* Local Chromedriver version: 100.0.4896.60

## Before the start

* Open IntelliJ and clone this project
* Get chromedriver that locates in this project to your local folder.
* Get the path of chromedriver from your computer
* Go to BaseConfig Java class in this project and edit this path
 according to yours: "/Users/nilaytugce/Downloads/chromedriver");"
* Open the terminal and run the script:

```

mvn clean install

```


## Start
* Begin with execution of the command "mvn clean install -DskipTests"
* Right-click on the "login.feature" file(src/test/resources) then choose run the "Feature:checkout" option OR
* Execute the command to run  test case " mvn test -Dcucumber.filter.tags="@case:checkoutAmazon01 and not @skip" " on the
 terminal


## CUCUMBER TEST REPORT
* After test execution, you can find the url to reach cucumber test report.

## Github Action integration
* Test cases are executable after commit on the github action(ci/cd integration)

## Warning!
* Sometimes Amazon wants to authentication confirmation, when it happen, test goes fail status. Please make sure process goes without authentication confirmation.

## Reasons behind the chosen framework and pattern(s)

* Maven helps to download dependencies in java projects, you do not have to download any jar file. Just add  the versions of the jar files in the pom.xml to execute your tests.
* Cucumber supports Behaviour-Driven Development (BDD) Approch, and in my opinion, it provides to read test steps easily for everyone such as product owner, business analyst.
* In my opinion, TestNG is a bit more complex to create the BaseConfig Class, and generally, cucumber use Junit framework.


## Next possible steps for improvements
* If the project apply to use TestNG as a framework instead of junit, parallel test execution can be applied
* Project can be dockerilized

