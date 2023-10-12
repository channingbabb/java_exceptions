package ChanningBabb_Assignment_ExceptionHandling;



//Create a program that reads a file of shorts (the data type) arranged in a matrix.
//The program should ask the user to input the name of the input file.
//The output file should be called "squares.dat"
//Your program should evaluate square each number and then write the squares to a new file in the same position
// they were in in the old file.
//It should also track the number of errors it catches as it processes the file and print that number with a
// completion message after the file has been processed.
//As it processes the file, your program should catch a few exceptions:
//FileNotFoundException (if the file name is not valid)
//In this case, the program should ask for a new file name.
//NumberFormatException (if the number in the input file cannot be parsed.)
//In this case, the program should write the string "err" in place of the number, and increment the errorCount.
//SquareOutOfBounds (if the square of the number is too large to fit as a short:  i.e. -32768 to 32767)  This
// should be a custom Exception you create.
//In this case, the program should just write the maximum short value where the square would normally be written
// and increment the errorCount.


import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int errorCount = 0;
        Scanner input = new Scanner(System.in);

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter outFile = null;


        // ask user for input
        System.out.println("What is the name of the input file? ");
        String fileName = input.nextLine();
            // read file
        try {
            String file = "squares.dat";
            Scanner fileScan = new Scanner(new File(fileName));
            fw = new FileWriter (file);
            bw = new BufferedWriter (fw);
            outFile = new PrintWriter (bw);
            // read and process each line of the file
            while (fileScan.hasNext()) {
                String line = fileScan.nextLine();
                System.out.println("Line: " + line);
                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(" ");
                // print each part of the line
                while (lineScan.hasNext()) {
                    String num = lineScan.next();
                    System.out.println("Number: " + num);
                    try {
                        int square = Integer.parseInt(num) * Integer.parseInt(num);
                        System.out.println("Square: " + square);
                        // write to squares.dat here later


                    } catch (NumberFormatException e) {
                        System.out.println("Error: " + e.getMessage());
                        errorCount++;
                    }

                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please enter a valid file name: ");
            errorCount++;
            fileName = input.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
            errorCount++;
        }
    }
}
