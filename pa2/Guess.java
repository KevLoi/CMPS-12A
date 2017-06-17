//Guess.java
//Kevin Loi
//kloi
//Three guesses from 1 to 10

import java.util.Scanner;

class Guess{

   public static void main( String[] args ){
       int n1, n2, n3;
       Scanner sc = new Scanner(System.in);
      // Random r = new Random();
      int rR = (int)(Math.random()*10+1);

       System.out.println(" ");
       System.out.println("I'm thinking of an integer in the range 1 to 10. You have three guesses.");
      
       System.out.println(" ");
       System.out.print("Enter your first guess: ");
       n1 = sc.nextInt();
       if( n1 == rR ) {
           System.out.println("You win!");
           System.out.println(" ");
         } else if( n1 > rR ) {
           System.out.println("Your guess is too high.");
            	
             System.out.println(" ");        
             System.out.print("Enter your second guess: ");
             n2 = sc.nextInt();
            
             if( n2 == rR ) {
             System.out.println("You win!");
             System.out.println(" ");
           } else if( n2 > rR ) {
             System.out.println("Your guess is too high.");
           
               System.out.println(" ");
               System.out.print("Enter your third guess: ");
               n3 = sc.nextInt();
               if( n3 == rR ) {
               System.out.println("You win!");
               System.out.println(" ");
             } else {
               System.out.println("You lose. The number was "+rR+".");
               System.out.println(" ");
           }
           } else if( n2 < rR ) {
             System.out.println("Your guess is too low.");
            
               System.out.println(" ");
               System.out.println("Enter your third guess: ");
               n3 = sc.nextInt();
               if( n3 == rR ) {
               System.out.println("You win!");
               System.out.println(" ");
             } else { 
               System.out.println("You lose. The number was "+rR+".");
               System.out.println(" ");
           }
         }
         } else if( n1 < rR ) {
           System.out.println("Your guess is too low.");
          
             System.out.println(" ");
             System.out.print("Enter your second guess: ");
             n2 = sc.nextInt();

             if( n2 == rR ) {
             System.out.println("You win!");
             System.out.println(" ");
           } else if( n2 > rR ) {
             System.out.println("Your guess is too high.");

               System.out.println(" ");
               System.out.print("Enter your third guess: ");
               n3 = sc.nextInt();
               if( n3 == rR ) {
               System.out.println("You win!");
               System.out.println(" ");
             } else { 
               System.out.println("You lose. The number was "+rR+".");
               System.out.println(" ");
           }
           }  else if( n2 < rR ) {
              System.out.println("Your guess is too low.");
              
                System.out.println(" ");
                System.out.println("Enter your third guess: ");
                n3 = sc.nextInt();
                if( n3 == rR ) {
                System.out.println("You win!");
                System.out.println(" ");
              } else {
                 System.out.println("You lose. The number was "+rR+".");
                 System.out.println(" ");
              }
           }
        }
     }
  }













