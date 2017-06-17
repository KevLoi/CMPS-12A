//Queens.java
//Kevin Loi
//kloi
//pa5
//Gives n-Queens solution

class Queens{

   public static void main(String[] args){
      int n;
      if(args.length==1 && Int(args[0]) != -1){
         solve(Int(args[0]));
      }else if(args.length==2 && args[0].equals("-v") && Int(args[1]) != -1){
         solveVerbose(Int(args[1]));
      } else {
         printUsage();
      }
   }

   static void nextPermutation(int[] A){
      int pivot = 0;
      int successor = 0;
      boolean foundPivot = false;
      for(int i = A.length - 2; i>=1; i--){
         if(A[i] < A[i+1]){
            pivot = i;
            foundPivot = true;
            break;
         }
      }
      if(!foundPivot){
         reverse(A, 1, A.length-1);
         return;
      }
      for(int i = A.length - 1; i>1; i--){
         if(A[i] > A[pivot]){
            successor = i;
            break;
         }
      }
      swap(A, pivot, successor);
      reverse(A, pivot+1, A.length-1);
   }

   static void reverse(int[] A, int i, int j){
      while(i<j){
         swap(A, i, j);
         i++;
         j--;
      }
   }

   static void swap(int[] A, int i, int j){
      int temp = A[i];
      A[i] = A[j];
      A[j] = temp;
   }

   static void printArray(int[] A){
      System.out.print("(");
      for(int i=1; i<A.length-1; i++){
         System.out.print(A[i] + ", ");
      }
      System.out.print(A[A.length-1] +")\n");
   }

   static boolean isSolution(int[] A){
      for(int i = 1; i < A.length; i++){
         for(int j = i+1; j<A.length; j++){
            if(Math.abs(j-i) == Math.abs(A[j] - A[i])){
               return false;
            }
         }
      }
      return true;
   }

   static int factorial(int n){
      int total = 1;
      for(int i = 2; i <= n; i++){
         total *= i;
      }
      return total;
   }

   static void printUsage(){
      System.out.println("Usage: Queens [-v] number");
      System.out.println("Option: -v verbose output, print all solutions");
   }

   static void solve(int x){
      int count = 0;
      int n = x;
      int[] A = new int[n+1];
      int perm = factorial(n);
  
      for(int i = 0; i<A.length; i++){
         A[i] = i;
      }
      
      for(int i = 0; i<perm; i++){
         if(isSolution(A)){
            count++;
         }
         nextPermutation(A);
      }
      System.out.println(n+"-Queens has " +count+ " solutions");
   }

   static void solveVerbose(int x){
      int count = 0;
      int n = x;
      int[] A = new int[n+1];
      int perm = factorial(n);
    
      for(int i = 0; i<A.length; i++){
         A[i] = i;
      }

      for(int i = 0; i<perm; i++){
         if(isSolution(A)){
            printArray(A);
            count++;
         }
         nextPermutation(A);
      }
      System.out.println(n+"-Queens has " +count+ " solutions");
   }

   static int Int(String s){
      try{
         int n = Integer.parseInt(s);
         if(n>0){
            return n;
         }
      } catch (Exception e){
         return -1;
      }
      return -1;
   }

}
