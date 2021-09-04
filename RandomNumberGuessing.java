/*
Name: Ahmed Helow
SID: 950719096
02/12/20
This program try multiple times to guess a number I thought of.
 */

import java.util.*;
public class RandomNumberGuessing {
    static Scanner console= new Scanner(System.in);
    static Random rand= new Random();
    static int lowerBound, upperBound;

    public static void main(String[] args) {

        playGame();
    }

    public static void playGame(){
        int count;
        boolean correct = false;
        boolean condition = false;
        count=1; //to know how many times the computer had to guess the number.

        while (correct==false){
            while (condition == false) { //this while loop to make sure the two numbers achieve the condition.
                System.out.print("enter lower number: ");
                lowerBound = console.nextInt();
                System.out.print("enter upper number: ");
                upperBound = console.nextInt();
                if (upperBound - lowerBound < 20 || lowerBound <= 0) {
                    System.out.println("Upper bound – lower bound must be >= 20.");
                    condition = false;
                }
                else condition= true;
            }
            int guess= rand.nextInt(upperBound - lowerBound +1) + lowerBound;
            System.out.println("I guess, the answer is "+ guess);


            System.out.print("Your answer is (h= Is your number higher than my guess?, l= Is your number lower than my guess?, c=correct): ");
            String userAnswer= console.next();
            userAnswer= userAnswer.toUpperCase();

            if (userAnswer.equals("C")){
                System.out.println("It took " +count+ " times to guess your number.");
                System.out.println("I am a genius computer!");

                while(true){
                    System.out.print("Do you want to play again?");
                    String useranswer2= console.next();
                    useranswer2=useranswer2.toUpperCase();
                    if (useranswer2.equals("Y")){
                        playGame(); // this line to begin the program again.
                    }
                    else if (useranswer2.equals("N")){
                        System.out.println("Thanks for playing! ");
                        System.exit(0); // this line to end the program.
                    }
                }

            }
            else if (userAnswer.equals("L")){
                upperBound = guess-1; // the minus 1 for not guess the same number again.
                correct= false;
                count++; // to count the number of times the computer guess.
            }
            else if (userAnswer.equals("H")){
                lowerBound =guess+1; //the plus 1 for not guess the same number again.
                correct=false;
                count++;
            }

        }
    }

}
