/* GCD.c
 * Kevin Loi
 * kloi
 * lab8
 * Finds GCD of two doubles
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

int main(){
   int i, n;
   int x[2];
   char str[100]; /*discard bad input*/
      
   for(i=0; i<2; i++){
      if(i == 0){ printf("Enter a positive Integer: ");}
      if(i == 1){ printf("Enter another positive Integer: ");}
      n = scanf(" %s", str); /* read one token from stdin */
     
      while(1){ /* seemingly infinite loop */
     
         while( !isInt(str) ){ /* if not double */
            printf("Please enter a positive integer: ");
            n = scanf(" %s", str); /* get another string */
         }

         sscanf(str, "%d", &x[i]); /*convert str to int & store in array x[] */
         if( x[i]>0 ){   
            break;
         }
         printf("Please enter a positive integer: ");
         n = scanf(" %s", str);
      }
   }
   printf("The GCD of %d and %d is %d\n", x[0], x[1], GCD(x[0], x[1]));

   return 0;
}

/* isInt() 
 * Returns 1 (true) is string s[] can be interpreted as an Integer, and 
 * returns 0 (false) otherwise.
 */
int isInt(char s[]){
   int i, n;
  
   if( s==NULL )
      return 0;
   n = strlen(s);
   if( n==0 )
      return 0;
   if( s[0]!='-' && s[0]!='+' && !isdigit(s[0]) )
      return 0;
   for(i=1; i<n; i++){
      if( !isdigit(s[i]) )
         return 0;
   }
   return 1;
}

/* GCD 
 * Returns GCD of two ints
 */
int GCD(int x, int y){
   int q,r;
   r = x%y;

   while(r>0){
      x = y;
      y = r;
      r = x%y;
      q = x/y;
      x = y*q + r;
   }
   return y;
}
