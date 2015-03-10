
import java.util.*;

public class Word implements Comparable<Word>
{
	
	private String myWord;
	private String myCat;
	
	/**
	* this constructor assigns myWord
	* and calls       to create myCan
	**/
	public Word(String theWord)
	{
		myWord = theWord;
      char[] wordChars = theWord.toCharArray();
		makeCat(wordChars);
      myCat = new String(wordChars);
      
	}

	/**
	* this method will find the canotical 
	* form of the passed. Efficency will be
	* crucial as the database being processed 
	* is fairly large.
	**/
	
	private final void makeCat(char[] chars)
	{
		//BASE CASE: if length =< 1
      if (chars.length > 1)
      {
         char[] left = Arrays.copyOfRange
         (chars, 0, chars.length / 2);
         
         char[] right = Arrays.copyOfRange
         (chars, chars.length / 2, chars.length);
         
         //recursively call makeCat
         makeCat(left);
         makeCat(right);
         
         //merge the two halves together
         merge(chars, left, right);
      }
	}
		
   /**
   * this method handles merging the two halves 
   * of the char array into  sorted order
   **/
   
	private final void merge(char[] result, 
   char[] theLeft, char[] theRight)
	{
		int i1 = 0; //left array index
      int i2 = 0; // right array index
      
      for (int i = 0; i < result.length; i++)
      {
         if (i2 >= theRight.length 
         || (i1 < theLeft.length 
         && theLeft[i1] <= theRight[i2]))
         {
            result[i] = theLeft[i1]; //take from left
            i1++;
         }
         else
         {
            result[i] = theRight[i2];
            i2++;
         }
      }
   }
		
	
	/**
	* this method returns positive int
	* value if myCat > theOther, 0 if 
	* myCat is == theOther, and negative
	* int if myCat < theOther.
	**/
   
   /** this accessor method retrieves
	  * myWord
	**/
   
	public String getMyWord()
	{
		return myWord;
	}

	/** 
	* retrieves canatical form
	**/
   
	public String getMyCat()
	{
		return myCat;
	}

   /**
   * compareTo method compares
   * this objects canotical form
   * to the others canotical form
   * ascending alphabetically
   **/
   
	public int compareTo (Word theOther)
	{
		return myCat.compareTo(theOther.getMyCat());
	}
}
