# Pac-Man 
- Team ID: B1

### Introduction

Pac-Man, a single-player arcade desktop game where a yellow, circular character navigates a maze, eating fruits, avoiding ghosts and occasionally eating them. 

### How To Start The Game

In order to run the program, you can either open the project in `NetBeans` and run it as a java application or you can click and run the `Pacman.jar` located in the main project folder.

### How To Play The Game

At the start of the game, users are allowed to choose one size of board among the `small`, `medium`, `large` ones by pressing `'s'`, `'m'` or `'l'`.

Once the board is chosen, user starts from `level 1` which is increasing depending on the score collected by eating the `dots` or `some fruits`. In order to change level, user should reach a certain point according to the size of the board. As the level changes, the difficulty of getting more scores increases proportionally by changing the movement of ghosts. 

If the Pac-Man is eaten by a ghost, it loses a life and goes back to the left-top corner of the maze. Once there is no life remaining, user loses the game. 

There are four different kinds of fruits that have different impacts on the game: 

-	`Cherry` is for stopping the ghosts for few seconds.
-	`Banana` is for making the Pac-Man immortal and ghosts can be eaten in a limited time.
-	`Number 5` adds 5 points to the total score.
-	`Question Mark` is a combo fruit that contains two set of effects taken randomly from the fruits mentioned above. 

During the game, users can control the circular character by keyboard or mouse:

- Keys like: `'w'`, `'a'`, `'s'` and `'d'` are for moving the character to up, left, down and right respectively. In addition, arrow keys can be used for the same purpose.
- Mouse events like: `left-click`, `right-click`, `wheel-up` and `wheel-down` are for moving the character to left, right, up and down respectively.
