// Author: Aditi Chaurasia
// this is a number guessing game

/*
 * When the game starts, it should display a welcome message along with the rules of the game.

 * The computer should randomly select a number between 1 and 100.

 * User should select the difficulty level (easy, medium, hard) which will determine the number of chances they get to guess the number.

 * The user should be able to enter their guess.

 * If the user's guess is correct, the game should display a congratulatory message along with the number of attempts it took to guess the number.

 * If the user's guess is incorrect, the game should display a message indicating whether the number is greater or less than the user's guess.

 * The game should end when the user guesses the correct number or runs out of chances.
 */

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main 
{
	public static void main(String args[])
	{
		// creating some initial variables
		int chances;
		int key;
		//below is the algorithm to generate a random number between 1 to 100
		int number = 1 + (int)(Math.random() * ((100 - 1) + 1));
		
		// messages to the console
		System.out.println("Welcome to the number guessing game!");
		System.out.println("I'm thinking of a number... \nMeanwhile select the difficulty level\n");
		
		System.out.println("\n1. Easy (you get 20 chances)\n" + "2. Medium (you get 10 chances)\n" + "3. Difficult (you get 5 chances)");
		System.out.print("Your answer: ");
		// add exception handling
		try 
		{
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			
			// the following code blocks decide the difficulty
			if (input == 1)
			{
				System.out.println("\nYou have chosen the EASY level");
				key =20;
				chances = 20;
			}
			
			else if(input == 2)
			{
				System.out.println("\nYou have chosen the MEDIUM level");
				key = 10;
				chances = 10;
			}
			
			else if(input ==3) 
			{
				System.out.println("\nYou have chosen the HARD level");
				key = 5;
				chances = 5;
			}
			
			else
			{
				System.out.println("\nYou have entered something unexpected number the default difficulty is set to EASY");
				key = 20;
				chances = 20;
			}
			
			// This runs the game until the the user is out of chances
			while (chances !=0)
			{
				// reducing the chances
				chances--;
				System.out.print("Enter your guess: ");
				input = sc.nextInt();
				System.out.println("");

				// breaking the loop if the user gets it
				if (input == number)
				{
					System.out.println("You have guessed it!");
					System.out.println("You used "+ (key-chances) +" chances to guess it!");
					break;
				}
				
				// if the number is lower than the user guess
				else if(input > number)
				{
					System.out.println("Its lower than "+input);
				}
				
				// if the number is higher than the user guess
				else if(input < number)
				{
					System.out.println("Its higher than "+input);
				}
						
			}
			
			// only and only if the user acc runs out of chances will this message be print
			if (chances == 0)
			{
				System.out.println("You ran out of chances :(");
			}
			
			sc.close();
		}
		
		catch (InputMismatchException e)
		{
			System.out.println("\nWe're so sorry... We need to terminate the program. An unexpected input was entered.\nPlease run the program again!");
		}
	}
}
