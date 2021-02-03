For Developers
============

You can also see [Python](https://github.com/starlangsoftware/Dictionary-Py), [C++](https://github.com/starlangsoftware/Dictionary-CPP), [Swift](https://github.com/starlangsoftware/Dictionary-Swift), or [C#](https://github.com/starlangsoftware/Dictionary-CS) repository.

## Requirements

* [Java Development Kit 8 or higher](#java), Open JDK or Oracle JDK
* [Maven](#maven)
* [Git](#git)

### Java 

To check if you have a compatible version of Java installed, use the following command:

    java -version
    
If you don't have a compatible version, you can download either [Oracle JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or [OpenJDK](https://openjdk.java.net/install/)    

### Maven
To check if you have Maven installed, use the following command:

    mvn --version
    
To install Maven, you can follow the instructions [here](https://maven.apache.org/install.html).      

### Git

Install the [latest version of Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).

## Download Code

In order to work on code, create a fork from GitHub page. 
Use Git for cloning the code to your local or below line for Ubuntu:

	git clone <your-fork-git-link>

A directory called Dictionary will be created. Or you can use below link for exploring the code:

	git clone https://github.com/olcaytaner/Dictionary.git

## Open project with IntelliJ IDEA

Steps for opening the cloned project:

* Start IDE
* Select **File | Open** from main menu
* Choose `Dictionary/pom.xml` file
* Select open as project option
* Couple of seconds, dependencies with Maven will be downloaded. 


## Compile

**From IDE**

After being done with the downloading and Maven indexing, select **Build Project** option from **Build** menu. After compilation process, user can run Dictionary.

**From Console**

Go to `Dictionary` directory and compile with 

     mvn compile 

## Generating jar files

**From IDE**

Use `package` of 'Lifecycle' from maven window on the right and from `Dictionary` root module.

**From Console**

Use below line to generate jar file:

     mvn install

## Maven Usage

        <dependency>
            <groupId>io.github.starlangsoftware</groupId>
            <artifactId>Dictionary</artifactId>
            <version>1.0.18</version>
        </dependency>

Detailed Description
============

+ [TxtDictionary](#txtdictionary)
+ [TxtWord](#txtword)
+ [SyllableList](#syllablelist)

## TxtDictionary

Dictionary is used in order to load Turkish dictionary or a domain specific dictionary. In addition, misspelled words and the true forms of the misspelled words can also be loaded. 

To load the Turkish dictionary and the misspelled words dictionary,

	a = TxtDictionary()
	
To load the domain specific dictionary and the misspelled words dictionary,

	TxtDictionary(String fileName, WordComparator comparator, String misspelledFileName)

And to see if the dictionary involves a specific word, Word getWord is used.

	Word getWord(String name)

## TxtWord

The word features:
To see whether the TxtWord class of the dictionary is a noun or not,

	boolean isNominal()

To see whether it is an adjective,

	boolean isAdjective()

To see whether it is a portmanteau word,

	boolean isPortmanteau()

To see whether it obeys vowel harmony,

	notObeysVowelHarmonyDuringAgglutination

And, to see whether it softens when it get affixes, the following is used.

	boolean rootSoftenDuringSuffixation()

## SyllableList

To syllabify the word, SyllableList class is used.

	SyllableList(String word)
