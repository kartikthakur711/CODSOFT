package com.company;
import java.util.Scanner;
import java.util.Random;
public class number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalScore = 0;

        while (true) {
            System.out.println("Welcome to Guess the Number game!");
            rounds++;

            int numberToGuess = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int score = 0;

            while (true) {
                System.out.println("Round " + rounds);
                System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
                int userGuess = scanner.nextInt();
                score++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess +
                            " correctly in " + score + " attempts.");
                    totalScore += score;
                    break;
                }

                if (score >= maxAttempts) {
                    System.out.println("Oops! You've reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your total score across " + rounds + " round(s) is " + totalScore + ".");
                break;
            }
        }
    }
}
