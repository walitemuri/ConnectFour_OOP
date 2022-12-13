# Project Title

Connect Four Game Using OO Design

## Description

This Project is a simple Connect4 game designed to be played by 2 players using the same device and interface. The main purpose for this project was to further my understanding of OO Design, 
The program consists of files: 

* Board.java 
* Player.java
* TextUI.java
* FileIO.java
* ConnectFour.Java

The main objects used to design the gameplay was Board, Player,ConnectFour. TextUI.java dealt with input and output streams, dealing with user interaction. FileIO.java dealt with saving/lodaing to files
These are the following attributes of each object:

Board:
* 6*7 integer matrix representing the slots of a Connect4 Board

Player:
* String, playerSymbol "X" and "O" are used for my example
*Integer, currentMove for storing players intended move

ConnectFour:
* Composition:
* Board
* 2 Player
* FileIO
* turn Integer to keep track of turns

TextUI:
* Scanner for user Input

FileIO:
* No instance variables

```
            |---|---|---|---|---|---|---|
            | - | - | - | - | - | - | - |
            |---|---|---|---|---|---|---|
            | - | - | - | - | - | - | - |
            |---|---|---|---|---|---|---|
            | - | - | - | - | - | - | - |
            |---|---|---|---|---|---|---|
            | - | - | - | - | - | - | - | 
            |---|---|---|---|---|---|---|
            | O | O | - | - | - | - | - |
            |---|---|---|---|---|---|---|
            | X | X | - | - | - | - | - |
            |---|---|---|---|---|---|---|

```

## Getting Started

### Dependencies

* Windows 7, 8, 10, 13
* MacOsX Monetery
* util.Scanner Library was imported
* JDK
* Terminal

### Executing program

* First you must use gradle to build files
```
gradle build
```
* This will output the following:
```
BUILD SUCCESSFUL in 698ms
```
* Next you must run gradle run command
```
gradle run
```
* The output should be the following:
```
To run the program:
java -cp build/classes/java/main connectfour.TextUI
```
* Finally you must copy and paste the outputed cmnd into your cmnd line
```
java -cp build/classes/java/main connectfour.TextUI
```


## Limitations

The Game lacks a single player option against a computer, random move generation or AI computation could be implemented in the future.
Rerunning of the command is requried in order to start a new game, functionality is restricted in that regard. Exceptions are thrown over incorrect file naming, entering inappropriate column numbers,
FileIO exception handling does not allow for reprompt of user input, program is automatically exited.

## Author Information

Name: Wali Temuri - 1183379
Contact: wtemuri@uoguelph.ca

## Development History

* 0.1.0
    * Initial Inception 
