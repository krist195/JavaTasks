import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/*
Task 1. Money conversion

Simple console program

First line in console: "Money conversion"

Then user chooses:
1-convert from USA dollars to British pounds
2-convert from British pounds to USA dollars

User enters number from keyboard (int, float or double)

Program prints result as double with format 10.3

Program also writes every operation to file:
type of operation,
start amount and start currency,
final amount and final currency
*/



public class task1{

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);

        double rateUsdToGbp = 0.79;
        double rateGbpToUsd = 1.0 / rateUsdToGbp;

        System.out.println("Money conversion");
        System.out.println("1 -Convert from USA$ to British Pound");
        System.out.println("2 -Convert from British Pound to USA$");
        System.out.print("Choose operation 1 or 2: ");

        int choice = in.nextInt();

        System.out.print("Enter amount: ");
        double amount = in.nextDouble();

        double result;
        String fromCurrency;
        String toCurrency;

        if (choice == 1){
            fromCurrency = "USD";
            toCurrency = "GBP";

            result = amount * rateUsdToGbp;

        } else{
            fromCurrency = "GBP";
            toCurrency = "USD";

            result = amount * rateGbpToUsd;
        }

        System.out.printf("%10.3f%n", result);

        PrintWriter pw = new PrintWriter(new FileWriter("task1.out", true));
        pw.println(fromCurrency + " " + amount + " -> "
                   + toCurrency + " " + result);
        pw.close();

        in.close();
    }

}


