/**
 * 
 */
package com.ss.jb.two;
import java.util.Scanner;
import java.util.Random;

/**
 * @author Cesar Camarena
 *
 */
public class Assignment2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int random_number = 1 + rand.nextInt(100);	//random number from 1-100
		int guesses = 5;							//guesses the user has
		
		//Introduction menu
		System.out.println("A number has been randomly selected from 1 to 100.\n");
		System.out.println("Guess the randomly selected number.\n");
		System.out.println("You are allowed to be off by 10 from the random number.\n");
		System.out.println("You have " + guesses + " guesses remaining.\n");
		
		for (int i = 1; i <= guesses; i++)
		{			
			System.out.print("Guess a number from 1-100: ");
			
			//Input Handling
			while (!sc.hasNextInt())
			{
				System.out.print("\nGuess a number from 1-100: ");
				sc.next();
			}
			
			//Obtains guess
			int guess = sc.nextInt();
			
			//Checks to see if it's above or below the answer by 10
			if (guess >= (random_number - 10) && guess <= (random_number + 10))
			{
				System.out.println("\nThe answer was " + random_number);
				System.out.println("You win!");
				return;
			}
			
			//Quits if the user reaches 5 guesses
			if (i == 5)
			{
				System.out.println("\nSorry, you have used up all your guesses.");
				System.out.println("The answer was " + random_number);
			}
			
			//User tries again
			else
			{
				System.out.println("\nTry again! You have " + (guesses - i) + " guesses remaining.");
			}
			
		}
		
	}
}
