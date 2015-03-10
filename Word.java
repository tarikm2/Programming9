/** *************************************
    * Word.java                       
    *                                  
    * TCSS 143 winter 2015               
    * Assignment #9                    
    **************************************/
    
import java.util.*;

/** **************************************
    * Word is object class which defines
    * a word by its original form and 
    * its canotical form. words are inherintly
    * ordered by their canotical form
    * ascending alphabetically 
    *                   
    * @author Tarik Merzouk               
    * @version 3/10/15                    
    ***************************************/

public class Word implements Comparable<Word>
{
	//Original word field 
	private String myWord;
   
   //feild for myWord's canotical form
	private String myCat;
	
	/**
	* this constructor assigns myWord
	* and calls makeCat to create myCat
   *
   * @param theWord (original word)
   *
	**/
   
	public Word(String theWord)
	{
		myWord = theWord;
      
      //charlist of word for sorting
      char[] wordChars = theWord.toCharArray();
      
		makeCat(wordChars);
      
      //assign myCat to new sorted char string
      myCat = new String(wordChars);
      
	}

	/**
	* this method will find the canotical 
	* form of the passed arraylist of 
   * char. It operates using the mergesort
   * algorithm by recursively splitting the
   * array in half then sorting those halfs
   * into a resulting array.
   *
   * @param chars (char list of word characters)
   *
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
   * of the char array  from makeCat
   * into  sorted order.
   *
   * @param result (final char array)
   * @param theLeft (first half of array)
   * @param theRight (second half of array)
   *
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
   * this accessor method retrieves
	* myWord.
   *
   * @return myWord (word objects word feild)
   *
	**/
   
	public String getMyWord()
	{
		return myWord;
	}

	/** 
	* getMyCat retrieves canatical form.
   *
   * @return myCat (canotical form feild)
   *
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
   *
   *  @param theOther (word to compare to
   *  @return myCat.compareTo(theOther.getMyCat())
   *
   **/
   
	public int compareTo (Word theOther)
	{
		return myCat.compareTo(theOther.getMyCat());
	}
   
   /**
   * toString simply returns
   * the word objects original
   * word feild.
   *
   * @return myWord (the word feild)
   *
   **/
   
   public String toString()
   {
      return myWord;
   }
}
