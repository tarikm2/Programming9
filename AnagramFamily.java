
import java.util.*;

public class AnagramFamily
{
	private LinkedList<Word> myWords;
	private int myCount;
	
	/**
	 * this constructor accepts a list 
	 * containing a sorted anagram 
	 * family
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
	
	public int getMyCount()
	{
		return myCount;
	}	
}