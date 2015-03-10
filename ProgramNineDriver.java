import java.util.*;
import java.io.*;

public class ProgramNineDriver
{
	
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
	   }
   }
	
   
   
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
   