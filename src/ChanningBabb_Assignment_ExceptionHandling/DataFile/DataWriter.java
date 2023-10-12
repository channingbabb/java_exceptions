package ChanningBabb_Assignment_ExceptionHandling.DataFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Author of the following class is Jonathan Baarsch.  Reusing his code from the example provided.
public interface DataWriter {


    public void writeData(Integer[][] data, String destination); //throws IOException;

}
