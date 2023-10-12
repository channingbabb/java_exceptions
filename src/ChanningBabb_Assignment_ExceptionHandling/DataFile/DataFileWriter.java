package ChanningBabb_Assignment_ExceptionHandling.DataFile;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Author of the following class is Jonathan Baarsch.  Reusing his code from the example provided.
public class DataFileWriter implements DataWriter {


    public void writeData(Integer[][] data, String fileName) //throws IOException
    {

        String file = fileName;

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter outFile = null;

        try
        {

            fw = new FileWriter (file);
            bw = new BufferedWriter (fw);
            outFile = new PrintWriter (bw);

            for (Integer[] line : data)
            {
                for (Integer num: line)
                {
                    outFile.print (num + "\t");
                }
                outFile.println ();
            }
        }
        catch (IOException e) {
            System.err.print("File Error: Writing to " + file );  //Use whatever logging tool you have in place.
        }
        finally
        {
            outFile.close();
        }
    }



}
