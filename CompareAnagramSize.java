/** *************************************
    * CompareAnagramSize.java                       
    *                                  
    * TCSS 143 winter 2015               
    * Assignment #9                    
    **************************************/
    
import java.util.Comparator;

/** **************************************
    * CompareAnagramSize is a comparator 
    * for AnagramFamily objects which
    * sorts based on the number of words
    * in a given AnagramFamily, largest 
    * first.
    *                   
    * @author Tarik Merzouk               
    * @version 3/10/15                    
    ***************************************/

public class CompareAnagramSize implements Comparator<AnagramFamily>
{

   /**
   * this comparator compares two 
   * anagram families, families with
   * more objects considered ahead.
   *
   * @param theThis (original family)
   * @param theOther (family being considered)
   * @return theOther.getMyCount()
             - theThis.getMyCount()
   *
   **/
   
	public int compare(AnagramFamily theThis, AnagramFamily theOther)
	{
		return theOther.getMyCount() 
		- theThis.getMyCount();
	}
}