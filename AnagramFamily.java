/** *************************************
    * AnagramFamily.java                       
    *                                  
    * TCSS 143 winter 2015               
    * Assignment #9                    
    **************************************/
    
import java.util.*;

/** **************************************
    * AnagramFamily is object class made 
    * up of a LinkList of words and those
    * words' common canotical form.
    *                   
    * @author Tarik Merzouk               
    * @version 3/10/15                    
    ***************************************/

public class AnagramFamily
{
	private LinkedList<Word> myWords;
	private int myCount;
	
	/**
	 * this constructor accepts a list 
	 * containing a sorted anagram 
	 * family, adds the elements of
    * that list to the myWords feild,
    * sorts myWords, and calculates
    * the number of words in the list
    *
    * @param theFamily (list of words)
    *
	**/
	public AnagramFamily(List<Word> theFamily)
	{
		myCount = 0;
		myWords = new LinkedList<Word>();

		//theFamily iterator
      ListIterator<Word> iterator = 
      theFamily.listIterator();
      
       while (iterator.hasNext())
       {
          myWords.add(iterator.next());
          myCount++;
       }

		// sort words by original form
      // decending alphabetically
      Collections.sort
      (myWords, new CompareByOriginal());
	}
	
   /** 
   * getMyCount() returns this
   * objects # of words.
   *
   * @return myCount (# of words)
   **/
   
	public int getMyCount()
	{
		return myCount;
	}	
   
   /**
   * toString returns the 
   * string representation of
   * a list with all of myWords
   * original word forms to
   * identify its containing 
   * word objects.
   *
   * @return myWords.toString()
   *
   **/
   
   public String toString()
   {
      return myWords.toString();
   }
}