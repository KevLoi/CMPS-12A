//Complex.java
//Kevin Loi
//kloi
//pa6
//Represents complex numbers as as pair of doubles

class Complex{
   
   //---------------------------------------------
   // Private Data Fields
   //---------------------------------------------
   private double re;
   private double im;

   //---------------------------------------------
   // Public Constant Fields
   //---------------------------------------------
   public static final Complex ONE = Complex.valueOf(1,0);
   public static final Complex ZERO = Complex.valueOf(0,0);
   public static final Complex I = Complex.valueOf(0,1);
   
   //---------------------------------------------
   // Constructors
   // --------------------------------------------
   Complex(double a, double b){
      this.re = a;
      this.im = b;
   }

   Complex(double a){
      this.re = a;
      this.im = 0;
   }
  
   Complex(String s){
      //Fill in this constructor.
      //It should accept expressions like "-2+3i", "2-3i", "3", etc.
      //Throw a NumberFormatException if s cannot be parsed as Complex
      double[] C = parseComplex(s);
      this.re = C[0];
      this.im = C[1];
   }

   //---------------------------------------------
   // Public methods
   //---------------------------------------------

   // Complex arithmetic -------------------------

   //copy()
   //Return a new Complex equal to this Complex
   Complex copy(){
      return new Complex(this.re, this.im);
   }

   //add()
   //Return a new Complex representing this plus z.
   Complex add(Complex z){
      return new Complex(this.re+z.re, this.im+z.im);
   }

   //negate()
   //Return a new Complex representing the negative of this. 
   Complex negate(){
      return new Complex(-this.re, -this.im);
   }

   //sub()
   //Return a new Complex representing the difference this minus z.
   Complex sub(Complex z){
      return new Complex(this.re-z.re, this.im-z.im);
   }
 
   //mult()
   //Return a new Complex representing the product this times z.
   Complex mult(Complex z){
      double a = this.re;
      double b = this.im;
      double c = z.re;
      double d = z.im;
      double i = (a*c-d*b);
      double j = (a*d+b*c);
      return new Complex(i, j);
   }

   //recip()
   //Return a new Complex representing the reciprocal of this.
   //Throw an Arithmetic Exception with appropriate message if
   //this.equals(Complex.ZERO).
   Complex recip(){
      double a = this.re;
      double b = this.im;
      if(!this.equals(Complex.ZERO)){
         return new Complex( a/((a*a)+(b*b)), -b/((a*a)+(b*b)) );
      } else {
         throw new ArithmeticException();
      }
   }

   //div()
   //Return a new Complex representing the quotient of this by z.
   //Throw an ArithmeticException with appropriate message if
   //z.equals(Complex.ZERO).
   Complex div(Complex z){
      if(z.equals(Complex.ZERO)){
         throw new NumberFormatException("Cannot divide by zero.");
      }
      double a = this.re;
      double b = this.im;
      double c = z.re;
      double d = z.im;
      double i = ((a*c)+(b*d))/((c*c)+(d*d));
      double j = ((b*c)-(a*d))/((c*c)+(d*d));
      return new Complex(i, j);
   }

   //conj()
   //Return a new Complex representing the conjugate of this Complex.
   Complex conj(){
      return new Complex(this.re, -this.im);
   }

   //Re()
   //Return the real part of this.
   double Re(){
      return re;
   }

   //Im()
   //Return the imaginary part of this.
   double Im(){
      return im;
   }

   //abs()
   //Return the modulus of this Complex, i.e. the distance between
   //points (0, 0) and (re, im).
   double abs(){
      return Math.sqrt(Math.pow(this.re,2) + Math.pow(this.im,2));
   }

   //arg()
   //Return the argument of this Complex, i.e. the angle this Complex
   //makes with positive real axis.
   double arg(){
      return Math.atan2(im, re);
   }

   //Other functions -------------------------------------------------

   //toString()
   //Return a String representation of this complex.
   //The String returned will be readable by the constructor Complex(String s)
   public String toString(){
      if( this.im>0 && this.re>0 ){
         return re+"+"+im+"i";
      }else if( this.im==0 && this.re>0 ){
         return re+" ";
      }else if( this.im<0 && this.re>0 ){
         return +re+"-"+(-im)+"i";
      }else if( this.im>0 && this.re<0 ){
         return re+"+"+im+"i";
      }else if( this.im==0 && this.re<0 ){
         return re+" ";
      }else if( this.im<0 && this.re<0 ){
         return +re+"-"+(-im)+"i";
      }
      return +im+"i";
   }

   //equals()
   //Return true if this and obj have the same real and imaginary parts.
   public boolean equals(Object obj){
      if(obj instanceof Complex){
         Complex c = (Complex) obj;
         if(this.re==c.re && this.im==c.im){
            return true;
         }
      }
      return false;
   }

   //valueOf()
   //Return a new Complex with real part a and imaginary part b.
   static Complex valueOf(double a, double b){
      return new Complex(a,b);
   }
  
   //valueOf()
   //Return new Complex with a real part a and imaginary part 0.
   static Complex valueOf(double a){
      return new Complex(a);
   }
   
   //valueOf()
   //Return a new Complex constructed from s.
   static Complex valueOf(String s){
      return new Complex(s);
   }

   //parseComplex()
   //Returns a double of length 2 containing (real, imaginary) parts 
   //of a complex number represented by string argument str. Throws a
   //NumberFormatException if str cannot be parsed as a complex number.
   static double[] parseComplex(String str){
      double[] part = new double[2];
      String s = str.trim();
      String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
      String SGN = "[+-]?";
      String OP = "\\s*[+-]\\s*";
      String I = "i";
      String OR = "|";
      String REAL = SGN+NUM;
      String IMAG = SGN+NUM+"?"+I;
      String COMP = REAL+OR+
                    IMAG+OR+
                    REAL+OP+NUM+"?"+I;

      if( !s.matches(COMP) ){
         throw new NumberFormatException(
            "Cannot parse input string\""+s+"\" as Complex");
      }
      s = s.replaceAll("\\s","");
      if( s.matches(REAL) ){
         part[0] = Double.parseDouble(s);
         part[1] = 0;
      }else if( s.matches(SGN+I) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
      }else if( s.matches(IMAG) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I, "" ) );
      }else if( s.matches(REAL+OP+I) ){
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{ // s.matches(REAL+OP+NUM+I)
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }
      return part;
   }
}

