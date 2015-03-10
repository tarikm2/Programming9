/** *************************************
    * CompareByOriginal.java                       
    *                                  
    * TCSS 143 winter 2015               
    * Assignment #9                    
    **************************************/

import java.util.Comparator;

/** **************************************
    * CompareByOriginal is a comparator 
    * for Word objects which
    * sorts based on the words original form
    * decending alphabetically
    *                   
    * @author Tarik Merzouk               
    * @version 3/10/15                    
    ***************************************/

public class CompareByOriginal implements Comparator<Word>
{
   /**
   * compare is a comparator which compares 
   * word objects alphabetically descending
   *
   * @param theFirst (word being compared to)
   * @param theSecond (word being compared)
   * @return theSecond.getMyWord().compareTo(
             theFirst.getMyWord())
   *
   */
   public int compare(Word theFirst, Word theSecond)
   {	
	return theSecond.getMyWord()
	.compareTo(theFirst.getMyWord());
   }
}
