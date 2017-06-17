//GCD.java
//Kevin Loi
//kloi
//pa3
//Find GCD of two numbers

import java.util.Scanner;

class GCD{

   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int a,b,r,q;

      //Enter first integer
      System.out.print("Enter a positive integer: ");
      while(true){
         while(!sc.hasNextInt()){
            sc.next();
            System.out.print("Please enter a positive integer: "); 
         }
         a = sc.nextInt();
         if(a>0){
            break;
         } else {
            System.out.print("Please enter a positive integer: ");
         }
       }
      
      //Enter second integer
      System.out.print("Enter another positive integer: ");
      while(true){
         while(!sc.hasNextInt()){
            sc.next();
            System.out.print("Please enter a positive integer: ");
         }
         b = sc.nextInt();
         if(b>0){
            break;
         } else {
            System.out.print("Please enter a positive integer: ");
         }
       }
      
      //Print GCD
      System.out.print("The GCD of "+a+" and "+b+" is ");
      gCD(a,b);
    }
   
    static void gCD(int x, int y){
      int r,q;
      r=x%y;

      while(r>0){
          x = y;
          y = r;
          r = x%y;
          q = x/y;
          x = y*q + r;
        }
        System.out.println(y);
    }
}
 




