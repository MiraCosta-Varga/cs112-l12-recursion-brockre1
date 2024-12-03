import java.util.Scanner; //to grab and print info to and from the console

class Main {
  public static void main(String[] args) {

    /*Main menu will prompt user for principal, rate, and years for calculation. */
    double amount, rate;
    int years;
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter the initial deposit amount: ");
    amount = keyboard.nextDouble();
    keyboard.nextLine();
    System.out.println("Enter the rate (in decimal form):");
    rate = keyboard.nextDouble();
    keyboard.nextLine();
    System.out.println("Enter the amount of years until withdrawal:");
    years = keyboard.nextInt();
    keyboard.nextLine();

    /*Output of interestCalc methods*/
    System.out.println("\nIterative Output");
    System.out.println("-----------------");
    System.out.printf("Your investment will be $%.2f after %d year(s) at a rate of %.1f%%", iterativeInterestCalc(amount, rate, years), years, rate*100);

    // Recursive Output
    System.out.println("\n\nRecursive Output");
    System.out.println("-----------------");
    System.out.printf("Your investment will be $%.2f after %d year(s) at a rate of %.1f%%", recursiveInterestCalc(amount, rate, years), years, rate*100);
  }

  /*iterativeInterestCalc method uses a for loop to calculate the new balance in your investment account.*/
  public static double iterativeInterestCalc(double amount, double rate, int years) {
    for (int i = 0; i < years; i++) {
      amount += amount * rate;
    }
    return amount;
  }

  /*recursiveInterestCalc method uses recursion to calculate the new balance in your investment account*/
  public static double recursiveInterestCalc(double amount, double rate, int years) {
    // Base case: if years is 0, return the amount
    if (years == 0) {
      return amount;
    }
    // Recursive case: calculate new balance and make a recursive call
    double newBalance = amount + (amount * rate);
    return recursiveInterestCalc(newBalance, rate, years - 1);
  }
}