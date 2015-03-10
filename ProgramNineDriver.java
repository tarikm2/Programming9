/** *************************************
    * ProgramNineDriver.java                       
    *                                  
    * TCSS 143 winter 2015               
    * Assignment #9                    
    **************************************/

import java.util.*;
import java.io.*;

/** **************************************
    * ProgramNineDriver acts as the main driver 
    * for organiing and sorting word objects
    * into AnagramFamilies and outputing 
    * the resulting output.
    *                   
    * @author Tarik Merzouk               
    * @version 3/10/15                    
    ***************************************/

public class ProgramNineDriver
{

   /**
   * main is the driver program to test
   * word and AnagramFamily objects 
   * from words.txt.
   *
   * @param theArgs[] (command line input)
   *
   **/
	
	public static void main(String theArgs[])
	{
		Scanner input = null;
      PrintStream output = null;
      String inFileName = "words.txt"; 
      String outFileName = "out9.txt";
      boolean fileOk = false;
      
      try
      {
         input = new Scanner(new File(inFileName));
         output = new PrintStream(new File(outFileName));
         fileOk = true;
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Cannot open file " + e);
      }
      
      //body of program if file is read
      if (fileOk)
      {
         LinkedList<Word> words = new LinkedList<Word>();
   		//iterator creates and adds word objects to words
         
         while (input.hasNext())
         {
            words.add(new Word(input.next()));
         }
       
         //sorts words alphabetically canotically
         Collections.sort(words);
          
         //this LinkedList stores the content of 
         //unique AnagramFamilies for construction
         LinkedList<Word> aFamily = 
         new LinkedList<Word>();
         
         // this LinkedList stores anagram families
         LinkedList<AnagramFamily> families =
         new LinkedList<AnagramFamily>();
   		
         //iterator for traversing words
         ListIterator<Word> iterator = words.listIterator();
         
   		//uses recursive calls to getFamily to get families	
   		 while(iterator.hasNext())
   		 {
   			Word test = iterator.next(); 
   			aFamily.add(test);
            
            //recursive end runs untill end of family 
   			if(iterator.hasNext())
   			{
   				getFamily(aFamily, iterator, test);
   			}
            
            //sort this family on original word 
            //ascending alphabetically 
   			Collections.sort(aFamily, new CompareByOriginal());
            
            //adds current AnagramFamily to our list
   			families.add(new AnagramFamily(aFamily));
            
            //primes aFamily for next family
   			aFamily.clear();
   		}
         
         //sorts our AnagramFamilys
         //based on family size descending 
   		Collections.sort(families, new CompareAnagramSize());	
         
         
         //the rest of main handles program output
         output.println("5 LARGEST FAMILIES");
         for (int i = 0; i < 5; i++)
         {
            output.println(families.get(i));
         }
         output.println();
         
         output.println("FAMILIES OF LENGTH 8");
         for (AnagramFamily f: families)
         {
            if (f.getMyCount() == 8)
            {
               output.println(f);
            }
         }
         
         input.close();
         output.close();
	   }
   }
	
   /**
   * getFamily is a recursive method which 
   * continues down a list of Word objects 
   * untill the next word object is not
   * the same as the current object
   * based on its canotical form
   * and adds all similar objects 
   * to a result LinkedList.
   *
   * @param theFamily (list of similar words)
   * @param theIterator (word list iterator)
   * @param thePrevious (last word in the list)
   *
   **/
   
   public static void getFamily
  (LinkedList<Word> theFamily,
   ListIterator<Word> theIterator,
   Word thePrevious)
   	{
         //sets the test to the next word
   		Word test = theIterator.next();
         
         //if test == previous, recall method with
         // test passed to thePrevious
   		if (thePrevious.compareTo(test) == 0)
   		{
   			theFamily.add(test);
            
   			if(theIterator.hasNext())
            {
   			   getFamily(theFamily, theIterator, test);
            }
   		}
         
         //BASE CASE: if the next item != previous
   		else
   		{
            //step back in iterator so next item
            //is the first new canotical form
   			theIterator.previous();
   		}
	}
}
   