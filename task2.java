import java.util.Scanner;
import java.io.FileWriter;

import java.io.PrintWriter;
import java.io.IOException;

/*
Task 2. Even and odd numbers

We read an array of integers from keyboard (maximum 20 numbers)

Program finds how many even numbers and how many odd numbers

Program prints:
-count of even numbers and all even numbers,
-count of odd numbers and all odd numbers.

Program also writes even numbers to one file
and odd numbers to another file
*/


public class task2 {

    public static void main(String[] args) throws IOException{

        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of elements (1..20): ");
        int n = in.nextInt();

        // simple check for wrong size
        if (n < 1 || n > 20){
            System.out.println("Incorrect size! Please enter number from 1 to 20.");
            in.close();
            return;
        }

        int[] a = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }

        int[] even = new int[n];
        int[] odd = new int[n];
        
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < n; i++){
            if (a[i] % 2 == 0) {
                even[evenCount] = a[i];
                evenCount++;
            } else {
                odd[oddCount] = a[i];
                oddCount++;
            }
        }

        System.out.println("Number of even integers: " + evenCount);
        System.out.println("Number of odd integers: " + oddCount);

        System.out.print("Even integers: ");
        for (int i = 0; i < evenCount; i++){
            System.out.print(even[i] + " ");
        }
        System.out.println();

        System.out.print("Odd integers: ");
        for (int i = 0; i < oddCount; i++){
            System.out.print(odd[i] + " ");
        }
        System.out.println();

        PrintWriter evenFile = new PrintWriter(new FileWriter("task2_even.out"));
        for (int i = 0; i < evenCount; i++){
            evenFile.println(even[i]);
        }
        evenFile.close();

        PrintWriter oddFile = new PrintWriter(new FileWriter("task2_odd.out"));
        for (int i = 0; i < oddCount; i++){
            oddFile.println(odd[i]);
        }
        oddFile.close();

        PrintWriter allFile = new PrintWriter(new FileWriter("task2.out"));
        allFile.println("Even integers:");
        for (int i = 0; i < evenCount; i++){
            allFile.print(even[i] + " ");
        }
        allFile.println();
        allFile.println("Odd integers:");
        for (int i = 0; i < oddCount; i++){
            allFile.print(odd[i] + " ");
        }
        allFile.println();
        allFile.close();

        in.close();
    }
}
