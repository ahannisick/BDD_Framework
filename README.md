# BDD Automated Testing Framework:
Setup Guide (Mac OS X)

Installation Overview:

JAVA JDK 9

	* Our Java Software Development Kit
	
APACHE MAVEN

    * Our Java Dependency Management Tool (pom.xml)
    
IntelliJ IDEA 

    * Our Java Integrated Dev Environment
	
Mac OS X Shortcuts

    * Enabling File/Folder Shortcuts

PhantomJS

    * Headless WebKit Scriptable for Running Tests Without Browser GUI
    * Rapid Script Execution / Performance Improvements

SELENIUM WEBDRIVER & Driver Installation

    * Browser Automation Library
    * Using Apache Maven pom.xml File to Install WebDriver as a Java Library
    
FIREFOX & PLUGINS (FIREBUG, FIREPATH)

    * To Help Us Work with the DOM
______________________________________________________________________________

Install Homebrew:

    * The Missing Package Manager for MacOS
    * /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

INSTALLING JAVA SDK:

    * brew cask install java
    * javac --version 

INSTALLING APACHE MAVEN:

    * brew install maven
    * mvn --version

INSTALLING IntelliJ IDE:

    * brew cask install intellij-idea-ce

Setup Mac OS X Shortcuts

    * Settings – Keyboard – Shortcuts – Services - Files and Folders
	* New Terminal Tab at Folder / New Terminal at Folder

CLONE THE FOLLOWING GITHUB REPO:

    * https://github.com/ahannisick/BDD_Framework.git
    * Open Finder – Locate Project Folder – Right Click – New Terminal at Folder
	* ls
	* Run Test from Terminal:
	* mvn test (same place as pom.xml file)
	* Automatically Downloads All Dependencies Needed to Run the Test
	* Runs Test:
	* “Build Success” means Java and Maven are installed properly
	* Run Test from IDE:
	* Open Project in Intellij IDEA
	* Import Maven Projects Automatically
	* Map SDK – Telling IntelliJ where our Java JDK lives
	* When IntelliJ starts, it refreshes indexes, goes and does stuff online, when it’s finished with its processes:
	* Right click test:  
	* Run “MyFirstTest”
	* “Build Success” means Java and Maven are installed properly and running within the IDE

INSTALLING PhantomJS:

    * brew install phantomjs
    * phantomjs --version

SELENIUM WEBDRIVER

    * First, download the Selenium Standalone Server:
	* https://www.seleniumhq.org/download/ 
	* brew install selenium-server-standalone
	* run selenium (terminal): selenium-server --port 4444
	* note the selenium version number
	* update version in pom.xml
________________________________________________________________________________________________________________________
    <dependency>
       <groupId>org.seleniumhq.selenium</groupId>
          	<artifactId>selenium-java</artifactId>
          	<version>3.141.59</version>
    </dependency>
________________________________________________________________________________________________________________________

BROWSER & DRIVER INSTALLATION

In order to get WebDriver running and communicating with the actual browsers, we need to install the drivers.


    * Install Mozilla Firefox & GeckoDriver
	* brew cask install firefox
	* brew install geckodriver
	
	* Install Google Chrome & ChromeDriver
	* brew cask install google-chrome
	* brew cask install chromedriver
	
	* Safari & Driver (Already Pre-Built into OS X)
    * Enable remote execution in safari browser
	* Allows webdriver to use safari driver to automate safari
	* Safari \ Preferences \ Advanced
	* [x] show develop menu in menu bar
	* Develop \ Allow Remote Automation

Test Driver Installation:

    * mvn test -Dtest=MyFirstChromeTest
