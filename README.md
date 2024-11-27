# CSC207 - Mahjong Score Trainer

A simple Mahjong Score Trainer that includes a score calculator, a puzzle rush mode, and a leaderboard.

## Group Members

| Name           | Github Username | Git Usernames (if different) |
|----------------|-----------------|------------------------------|
| Christopher Li | ChristopherLi05 | a, Christopher Li            |
| Fuma Kano      | fumak208        |                              |
| David Won      | david-703       |                              |
| Hiro Yano      | Hiro2974        |                              |
| Max Chen       | MaxChen102      |                              |

## User Stories

#### Group User Story
- As a user, I want to be able to practice scoring hands under time pressure, so I can calculate hand value faster.

#### Christopher User Story
- As a user, I want to be able to see the maximum number of hands that were scored during the Puzzle Rush mode, so I can set a goal for myself to achieve

#### Fuma User Story
- As a user, I want to be able to create an account to keep track of my progress, so I can keep track of my progress

#### David User Story
- As a user, I want to be able to click on tiles to add to the calculator

#### Hiro User Story
- As a user, I want to be able to calculate how much my mahjong hand is worth, so I can receive a correct amount of points

#### Max User Story
- As a user, I want to be able to login to my account, so I can keep track of my progress

## Overview

There are 3 main views this program will have: a **Point Calculator**, a **Puzzle Rush**, and the **Leaderboard**. In the Point Calculator mode, users are given a UI in which they will input a Mahjong Hand and the program will output the score that the hand is worth. In the Puzzle Rush mode, users are given a time limit and are tasked with inputting as many scores as they can. Once done, the number of hands they scored are tallied and they will be shown a leaderboard on how they compare to other users.

This project was created for beginners to learn how to calculator points for a Mahjong hand using the Calculator, and for experienced players to train themselves using the Puzzle Rush mode

## Table of Contents

* [Installation](#installation)

* [License](#license)

* [Features and Usages](#features-and-usage)

* [Feedback](#feedback)

* [Contributions](#contributions)


## Installation
- Build the project with the provided `pox.xml` file
- [Java Development Kit 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) is recommended, however anything 11+ will be sufficient.

## License
See the MIT License attached.

## Features and Usage

### Signing Up
![image of signup screen](images/signup.png)

To sign up, you must choose a username that does not already exist. Next enter your password twice and click the "Sign up" button to create your account!

### Logging In
![image of login](images/login.png)

Once your account is created, you will be taken to the login screen. Simply re-enter your username and password and click the "Log in" button to login. 
You are also able to go back to the signup screen to create another account.
Guest login is also possible but your scores will not be stored.

### Mahjong Point Calculator
![gif of calculator](gifs/calculator.gif)

Upon logging in, you will be taken to the calculator.
Here you are able to input any hand by clicking on the tiles, and click the "calculate" button to get your score. 
If the hand is invalid or the score is 0, it will return "Invalid Hand".
There is also a tab switcher on top to take you to other modes, puzzle rush and the leaderboard.

### Puzzle Rush
![gif of puzzlerush](gifs/puzzlerush.gif)

After clicking "start" in the puzzle rush mode, a timer goes off.
You are asked to input the correct amount of points of the Mahjong hand presented to you, if your answer is correct, you will be given another hand.

### Leaderboard
![image of leaderboard](images/leaderboard.png)

In the leaderboard, you are able to see the top scores and the username of the players who achieved those scores.

## Feedback
Any feedback is welcomed! Please fill out [this Google Form](https://forms.gle/2dxpigfPianYNCdE8) to submit your feedback.

## Contributions
Any contribution is welcomed too! To contribute, please make a fork of this repository and make your edits there. Next, create a merge request with clear comments on what changes were made.



