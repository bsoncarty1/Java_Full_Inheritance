//Brandon Soncarty

/**
 * This class was given
 */

package lab9.cscd211utils;

import java.io.*;
import java.util.Scanner;

/**
 * The FileUtils class. This class is used for reading and writing from and to input and output files
 */
public class FileUtils
{

	public FileUtils() {}
	
	/**
	 * This openInputFile takes the array of command line arguments known as args
	 * This method presumes that the filename will be in args[0]
	 * This method will attempt to create a new File of args[0]. If args[0] does not 
	 * exist as a filename then an IllegalArgumentException is thrown
	 */
   public static File openInputFile(final String [] args)
   {
      if(args == null || args.length < 1)
         throw new IllegalArgumentException("bad arguments in openInputFile(final String [] args)");
       
      File inf = new File(args[0]);
      if(!inf .exists())
         throw new IllegalArgumentException("bad filename in openInputFile"); 
      
      return inf;
   }// end openInputFile
   
   /**
    * The countRecords counts the number of lines in the file.  Once the number of
    * lines is determined then that value is checked for 0 or that number mod linesPerRecord
    * does not equal zero. If all checks are passed then count divided by linesPerRecord 
    * is returned.
    */
   public static int countRecords(final Scanner fin, final int linesPerRecord)
   {
      if(fin == null || linesPerRecord < 1)
         throw new IllegalArgumentException("bad arguments in countRecords");
         
      int count = 0;
      while(fin.hasNext())
      {
         fin.nextLine();
         count ++;
      
      }// end while
      
      if(count == 0 || count % linesPerRecord != 0)
         throw new RuntimeException("bad count in countRecords");
         
      return count / linesPerRecord;
      
   }// end countRecords
   
   /**
    * This displayFile method reads from the input file for the number of records and
    * the number of lines per record.  This information is written back to the screen.
    */
   public static void displayFile(int num, Scanner fin, final int linesPerRecord)
   {
      if(num < 1 || fin == null || linesPerRecord < 1)
         throw new IllegalArgumentException("bad params in displayFile(int num, Scanner fin, final int linesPerRecord)");

      String str = "";
      for(int x = 0; x < num; x++)
      {
         for(int y = 0; y < linesPerRecord; y++)
         {
            str = fin.nextLine();
            System.out.println(str);
         }// end for y
      }// end for x
   
   }// end displayFile
   
   /**
    * This openInputFile method receives a Scanner object.  It prompts the user to enter the name of an input
    * file.  Next the method tries to open the that filename as a file.  If the filename does not exist then the
    * method re-prompts the user until a valid filename is received.
    */
   public static File openInputFile(final Scanner kb)
   {
       if(kb == null)
         throw new IllegalArgumentException("bad arguments in openInputFile(final Scanner kb)");
         
       String str = "";  
       File inf = null;
       do
       {
         System.out.print("Please enter the name of the input file ");
         str = kb.nextLine();
         
         inf = new File(str);       
       
       }while(!inf.exists());
       
      return inf;
   }// end openInputFile

   
   /**
    * This readFileName method prompts the user to enter a file name for the given type.
    * The filename is read in and returned. The input buffer will be cleaned by the end of 
    * the function
    */
   public static String readFileName(final Scanner kb, final String type)
   {
      if(kb == null || type == null || type.isEmpty())
         throw new IllegalArgumentException("bad arguments in readFileName");
         
      System.out.printf("Please enter the name of the %s file ", type);
      String fn = kb.nextLine();      
      
      return fn;
   }// end readFileName
   
   /**
    * This openInputFile method is passed a String.  The method attempts to create a new File based
    * on the filename that is passed in.  If the File exists it is returned.  If the file does not exist then an
    * IllegalArgumentException is thrown
    */
   public static File openInputFile(final String fn)
   {
      if(fn == null || fn.isEmpty())
         throw new IllegalArgumentException("bad arguments in openInputFile(final String fn)");
         
      File inf = new File(fn);
      if(!inf.exists())
         throw new IllegalArgumentException("bad filename in openInputFile"); 
      
      return inf;
   }// end openInputFile
   
   /**
    * This displayFile method receives a Scanner object. The method reads from the 
    * file until the file no longer has tokens, and writes that output to the screen.
    */
   public static void displayFile(final Scanner fin)
   {
      if(fin == null)
         throw new IllegalArgumentException("bad params in displayFile(Scanner fin)");

      String str = "";
      while(fin.hasNext())
      {
         str = fin.nextLine();
         System.out.println(str);      
      }// end while
   }// end displayFile
   
   /**
    * This openOutputFile method receives a String representing the filename. The method
    * creates a new File and returns that new File.
    */
   public static File openOutputFile(final String fn)
   {
      if(fn  == null || fn.isEmpty())
         throw new IllegalArgumentException("bad params in openOutputFile(final String fn)");
         
      File outf = new File(fn);
      return outf;
      
   }// end openOutputFile
   
   
   /**
    * This displayFile method receives a Scanner object and a PrintStream object.
    * This methods simple reads from the Scanner object (until there are no longer tokens)
    *  and writes the results to the PrintStream object
    */
   public static void displayFile(final Scanner fin, final PrintStream fout)
   {
      if(fin  == null || fout == null)
         throw new IllegalArgumentException("bad params in displayFile(final Scanner fin, final PrintStream fout)");
         
      while(fin.hasNext())
      {
         fout.println(fin.nextLine());
      }// end while   
   }// end displayFile
   
   /**
    * This openOutputFile receives a File object. This method creates a new PrintStream object from the
    * passed in File object.  This method must have throws Exception on the method header to quiet the compiler
    * because of a potential FileNotFoundException.
    */
   public static PrintStream openOutputFile(final File outf)throws Exception
   {
      if(outf  == null)
         throw new IllegalArgumentException("bad params in openOutputFile(final File outf)");
         
      PrintStream fout = new PrintStream(outf);         
      return fout;
      
   }// end openOutputFile
   
}// end class