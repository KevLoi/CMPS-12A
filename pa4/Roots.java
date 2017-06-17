//Roots.java
//Kevin Loi
//kloi
//pa4
//Find roots using bisection method

import java.util.Scanner;

class Roots{

   public static void main( String[] args ){
      Scanner sc = new Scanner(System.in);
      double resolution = 0.01, threshold = 0.001, tolerance = 0.0000001, z;
      int n = 0;
      int[] ep = new int[2];
   
      //Degrees
      System.out.print("Enter the degree: ");
      n = sc.nextInt();
      double[] w = new double[n+1];
     
      double[] D = diff(w);

      //Enter coefficients 
      System.out.print("Enter "+ (n+1) +" coefficients: ");
      for(int i=0; i<(n+1); i++){
         D[i] = sc.nextDouble();
      }
  
      //Endpoints
      System.out.print("Enter left and right endpoints: ");
      for(int p=0; p<2; p++){
         ep[p] = sc.nextInt();
      }
      System.out.println("");

      for(double i=e[0]; i<e[1]; i+=resolution){
         if( poly(w,i)>0 && (poly(w,i+=resolution))<0 ){
            double x = findRoot(w, i, i+resolution, tolerance);
            System.out.printf("Root found at %.5f%n", x);

         }else if( poly(w,i)<0 && poly(w,i+resolution)>0 ){
            double x = findRoot(w, i, i+resolution, tolerance);
            System.out.printf("Root found at %.5f%n", x);
         
         }else if( poly(D,i)>0 && poly(D,i+resolution)<0 ){
            double x = findRoot(D, i, i+resolution, tolerance);
            System.out.printf("Root found at %.5f%n", x);
     
         }else if( poly(D,i)<0 && poly(D,i+resolution)>0){
            double x = findRoot(D, i, i+resolution, tolerance);
            System.out.printf("Root found at %.5f%n", x);
         
         }
      }

         if( (poly(D,ep[0]) >= 0) && (poly(D,ep[1]) >= 0) || (poly(D,ep[0]) < 0) && (poly(D,ep[1]) < 0) ){
         System.out.println("No roots were found in the specified range.");
         System.exit(0);
      }
   }

      //Return the value at x of the polynomial with coefficient array C
      static double poly(double[] C, double x){
         double y = 0;
         double[] temp = new double[C.length];
         for(int i=0; i<C.length; i++){
            temp[i] = C[i]*Math.pow(x,i);
            y += temp[i];
         }
         return y;
      }

      //Return reference to newly allocated array 
      static double[] diff(double[] C){
         double[] temp = new double[C.length];
         for(int i=1; i<=C.length-1; i++){
            temp[i-1] = C[i]*i;
         }
         temp[temp.length-1] = 0;
         return(temp);
      }

      //Return approximation to root in interval whose error is no more than tolerance
      static double findRoot(double[] C, double a, double b, double tolerance){
         double mid=0.0, k=(b-a);
         while( Math.abs(k) > tolerance) {
            mid = (a+b)/2.0;
            if( (poly(C,a))*(poly(C,mid)) <= 0){
               b = mid;
               k = b-a;
            }else if( (poly(C,b))*(poly(C,mid)) <= 0 ){
               a = mid; 
               k = b-a;
            }
         }
         return mid;
      }

}      
