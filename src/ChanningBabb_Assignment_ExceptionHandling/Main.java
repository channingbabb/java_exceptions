package ChanningBabb_Assignment_ExceptionHandling;

import ChanningBabb_Assignment_ExceptionHandling.DataFile.DataFileWriter;
import ChanningBabb_Assignment_ExceptionHandling.DataFile.DataMaker;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataFileWriter writer = new DataFileWriter();
        DataMaker source = new DataMaker();
        Scanner scanner = new Scanner(System.in);

        final int rows = 10;
        final int cols = 10;

        System.out.print("src/ChanningBabb_Assignment_ExceptionHandling/test.dat\n");
        System.out.print("Enter the name of the input file: ");
        String inputFileName = scanner.nextLine();
        String outputFileName = "squares.dat";
        System.out.println("Processing file...");

        Integer[][] data = source.createSquaredData(inputFileName, outputFileName, rows, cols);
        writer.writeData(data, outputFileName);
        System.out.println("Done.");
        scanner.close();

    }
}
