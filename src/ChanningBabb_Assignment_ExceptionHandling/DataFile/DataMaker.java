package ChanningBabb_Assignment_ExceptionHandling.DataFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ChanningBabb_Assignment_ExceptionHandling.SquareOutOfBounds;

// Author of the following class is Jonathan Baarsch.  Reusing his code from the example provided.
public class DataMaker {

    public Integer[][] createData(int rows, int columns) {
        Integer[][] data = new Integer[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                data[row][column] = (int) (Math.random() * 100 + 1);
            }
        }
        return data;
    }

    /**
     * Creates a new array of the same size as the input array, but the data is
     * prespecified.
     * 
     * @param data
     * @param rows
     * @param columns
     * @return
     */
    public Integer[][] createSquaredData(String inputFileName, String outputFileName, int rows, int cols) {
        DataFileWriter writer = new DataFileWriter();
        int errors = 0;
        Integer[][] data = new Integer[10][10];
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split("\\s+|\\r?\\n");
                int currentElement = 0;

                for (int col = 0; col < cols; col++) {
                    try {
                        if (numbers[currentElement].equals("x")) {
                            throw new SquareOutOfBounds("Value " + numbers[currentElement] + " is out of bounds.");
                        }

                        int n = Integer.parseInt(numbers[currentElement]);
                        data[row][col] = n * n;
                        System.out.print(n * n + " ");
                    } catch (NumberFormatException e) {
                        errors++;
                        System.out.print("Number format exception: " + e.getMessage() + " ");
                    } catch (SquareOutOfBounds e) {
                        errors++;
                        System.out.println("Error: " + e.getMessage());
                    }
                    currentElement++;
                }
                row++;
                System.out.println();
            }
        } catch (IOException e) {
            errors++;
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("File processed successfully with " + errors + " errors.");
        }
        return data;
    }

}
