# Project Title

Automated requirements as mentioned in the Assignment

## Getting Started

Tools used: Intellij as IDE
Browser: Chrome
Language: JAVA
framework : TestNG
Build tool: Maven
OS: MAC

### Prerequisites

Java 1.8+ version installed
Maven installed

## Running the tests

1. Import the pom.XML
2. Use commands: mvn clean followed by mvn install to install the dependencies
3. Invoke the testNG.xml from IDE or
  via terminal: mvn clean install test -DsuiteXmlFile="testng.xml" -Dbrowser="firefox"

xml includes:
class: ZoloStays
Methods: testTheSearchResult
DataProvider: SearchParametersDataProvider

### Scenarios and exceptions handled

1.Browser to be triggered/used for execution based on the parameter -Dbrowser.

2.Have avoided advertisements and have handled selecting valid links alone.

3.Better try-catch mechanism to handle exceptions.

4.Proper asserts and reporting used to provide a detailed context, can be witnessed in testNG Report - have checked in the same.

5.Screenshots captured at requested Scenarios.

6.proper parameterisation and data provider used to dynamically serve data.

## Authors

Vinayak kaladhar

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
