import java.util.Scanner;
import java.lang.Math; 
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.concurrent.*;

class Cal {
   public static void main(String[] args) {
	  
      DecimalFormat df = new DecimalFormat("#,###,##0.00");
      Scanner keyboard = new Scanner(System.in);
      String interest;
      String YN;
      double P;
      double r;
      double t;
      double n = 1;
      double interestNum = 0;
      double differnce = 0;
      double e = 2.7182818284;
      
	  
	  
      System.out.println("This is a simple program for calculating interest.");
	  System.out.println("Valid commands are: Compound, Simple, Continuosly");
      interest = keyboard.nextLine();
      
      System.out.println("What is the value of the principal?");
      P = keyboard.nextDouble();
      
      System.out.println("What is the annual interest rate (as a descimal)");
      r = keyboard.nextDouble();
      
      System.out.println("Time in years");
      t = keyboard.nextDouble();
      
      if (interest.equals("Compound")) {
         System.out.println("Number of times to compound per year");
         n = keyboard.nextDouble();
      }
      
      switch (interest) {
      
         case "Compound":
            interestNum = compound(P, r, t, n);
            differnce = interestNum - P;
            break;
            
         case "Simple":
            interestNum = simple(P, r, t);
            differnce = interestNum - P;
            break;
            
         case "Continuosly":
            interestNum = continuosly(P, r, t, e);
            differnce = interestNum - P;
            break;
            
         default:
            System.out.println("invalid input, Did you misspell something?");
            System.out.println("Here are the types of interest this program can caluclate: Compound, Simple, and Continuous. These commands are case sensitive!");
      }
      
      if (interestNum != 0) {
         System.out.println("Here is the interest calculated:");
         System.out.println("$" + df.format(interestNum));
         System.out.println("That's a differnce of" + " $" + df.format(differnce));
         
      }
      else {
         System.out.println("Something went wrong...");
         System.out.println("Did you input all the values correctly?");
      }
   }
   
   public static double compound(double P, double r, double t, double n) {
      double A;
      double B;
      B = Math.pow((1+(r/n)),(n*t));
      A = B*P;
      return A;
   }
   
   public static double simple(double P, double r, double t) {
      double A;
      A = P*(1+(r*t));
      return A;
   }
   
   public static double continuosly(double P, double r, double t, double e) {
      double A;
      double ea = Math.pow(e,(r*t));
      A = P*ea;
      return A;
   }
}