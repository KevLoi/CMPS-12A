//Lawn.java
//Kevin Loi
//kloi
//Lawn
//The amount of time it will take to mow the Lawn

import java.util.Scanner;

class Lawn{
   
   public static void main( String[] args){
       
       double LLength, LWidth, HLength, HWidth, Area, MowingRate, MowingTime;
       Scanner sc = new Scanner(System.in);
       
       //Lot
       System.out.print("Enter the length and width of the lot, in feet: ");
       LLength = sc.nextDouble();
       LWidth = sc.nextDouble();
      
       //House
       System.out.print("Enter the length and width of the house, in feet: ");
       HLength = sc.nextDouble();
       HWidth = sc.nextDouble();
      
       //Area of Lawn
       Area = (LLength*LWidth)-(HLength*HWidth);
       System.out.print("The lawn area is: ");
       System.out.println(Area + " square feet " );
      
       //Rate of Lawn Mowing
       System.out.print("Enter the mowing rate, in square feet per second: ");
       MowingRate = sc.nextDouble();
      
       //Time of Lawn Mowing
       MowingTime = (Area/MowingRate);
       int s = (int) Math.round(MowingTime);
       int m = s/60;
       s = (s)%60;  
       int h = m/60;
       m = (m)%60;
       String a = ( h==1? "hour" : "hours");
       String b = ( m==1? "minute" : "minutes");
       String c = ( s==1? "second" : "seconds");
       System.out.println( "The mowing time is "+h+" "+a+" "+m+" "+b+" "+s+" "+c+".");

     }
}
								
