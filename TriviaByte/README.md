# TriviaTech: A Java-Based Computing Engineering Trivia Game

## Introduction

TriviaTech is a console-based trivia game designed to test and improve your knowledge in various computing engineering topics. The game includes categories such as Programming, Hardware, Software, Networks, Algorithms, and more.

## Features

- Multiple categories of questions.
- Randomized questions from each category.
- Tracks player scores.
- Console-based user interface.

## Installation

To set up and run TriviaTech on your local machine, follow these steps:

1. Clone the repository:
git clone https://github.com/yourusername/triviatech.git
cd triviatech

2. Compile the Java files:
javac -d bin src/trelo_Git/*.java

3. Run the game:
java -cp bin trelo_Git.Main

## Usage

1. Start the game by running the main class.
2. Follow the on-screen prompts to play.
3. Each player takes turns to answer questions from different categories.
4. Enter the number corresponding to your chosen answer.
5. The game will keep track of the scores and display them at the end.

## Example Session

Welcome to TriviaTech!

It's Alice's turn.
Category: Programming
What is the time complexity of quicksort in the average case?
1: O(n)
2: O(n log n)
3: O(n^2)
4: O(log n)
Your answer: 2
Correct!

It's Bob's turn.
Category: Hardware
What does CPU stand for?
1: Central Processing Unit
2: Central Performance Unit
3: Central Power Unit
4: Central Parallel Unit
Your answer: 1
Correct!

Game Over! Here are the scores:
Alice: 1
Bob: 1

vbnet
Copiar código

## Game Rules

1. Each player takes turns to answer questions.
2. A random question from a random category is presented to the player.
3. The player selects an answer by entering the corresponding number.
4. Points are awarded for correct answers.
5. The game continues until a predefined number of questions have been asked or a predefined score is reached.
6. The player with the highest score at the end of the game wins.

## Contributions

Feel free to contribute to TriviaTech by adding new features, fixing bugs, or improving the documentation.

## Contact

For any questions or suggestions, please contact [your email].


Annotations, we had a problem with the final project, since we could not connect it with a data base, that makes the classes of the password etc not able to compare it with anything, therefore not knowing if the password is correct if the user is logged in.

That makes the project useless if we execute all in once, but if we execute the classes separately, it should be working.
