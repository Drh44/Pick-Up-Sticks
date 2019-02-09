import java.util.*;
/* 
   This program is a game played with a pile of sicks and a computer. 
   Using the random number generator to go from 1-3.
   Who ever gets the last stick wins.
   The computer will then ask if you want to play again.
   
   Author: Dylan Hesser
   vers. 1.0 
*/

public class Sticks {

   private static Scanner keyboard;
   private static String player1;
   private static String player2;
   
   public static void main(String[] args) {

        keyboard = new Scanner(System.in);
        boolean answer = false;

        player1 = "GLaDOS";
        
        System.out.print("Hello, my name is GLaDOS. What is yours? ");
        player2 = keyboard.next();
        System.out.println();
        
        System.out.printf("Hello %s, let's play a game.%n", player2);

        System.out.println("We are going to imagine a pile of matches on a table between us.");
        
        do
        {
           playTheGame();
            
           System.out.print("Would you like to play again? (Y/N)");
           answer = answerToRepeatGameQuestion();
         
        }while (answer == true);
 

    }

    private static void playTheGame()
    {
        Random dice = new Random();
        int number = 0;
        
        do
        {
           System.out.printf("How many matches, between 10 and 50, would you like to have in the pile? ");
           number = readLineInt();
          
        } while((number < 10) || (number > 50));
        
  
        int matchPile = number;
        int turn = 1;
        
        System.out.printf("Excellent %s, we now have a pile with %d matches between us.%n",player2,matchPile);

        
        do {


            if (turn % 2 == 1) {

                do
                {
                   System.out.print("How many matches (between 1 and 3) would you like to remove from the pile? ");
                   number = keyboard.nextInt();
                }while(number < 1 || number > 3);
                
                matchPile = matchPile - number;

                System.out.println("\nThe match pile now has: " + matchPile + " matches.");
                if(matchPile > 0)
                   turn++;
                
            }

            if (turn % 2 == 0) {

                number = dice.nextInt(3) + 1;
                System.out.printf("%s will now remove %d matches from the pile.%n", player1,number);
                matchPile = matchPile - number;

                System.out.println("\nThe match pile now has: " + matchPile + " matches.");
                if(matchPile > 0)
                   turn++;
             }


        } while (matchPile > 0);

 
        System.out.println();

        if (turn % 2 == 0) {

            System.out.printf("%s took the last match from the pile, so the house wins! Better luck next time.%n", player1);

        } else if (turn % 2 == 1) {

            System.out.printf("%s, you took the last match from the pile, so you WIN!%n", player2);

        }
    
    
    }
    
    private static boolean answerToRepeatGameQuestion()
    {
        String inputString = null;
        String response = "";
        boolean done = false;
        boolean answer = false;

        while (! done)
        {
            try
            {
                inputString = keyboard.next();
                inputString = inputString.trim();
                done = inputString.equalsIgnoreCase("Y") || inputString.equalsIgnoreCase("N");
                
                if(done == false)
                  System.out.print("Invalid input. Please enter either Y or N.");
                
            }
            catch (Exception e)
            {
                System.out.print("Invalid input. Please enter either Y or N.");
            }
        }
        
        answer = inputString.equalsIgnoreCase("Y");

        return answer;
    }
    
    private static int readLineInt()
    {
        String inputString = null;
        int number = -9999;
        
        boolean done = false;

        while (! done)
        {
            try
            {
                inputString = keyboard.next();
                inputString = inputString.trim();
                number = Integer.parseInt(inputString);
                done = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(" The only answers allows are the ones stated in the instructions. Use the correct numbers and other answers ");
            }
        }

        return number;
    }


    
}