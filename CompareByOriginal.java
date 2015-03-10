
import java.util.Comparator;

/**
* used to compare words decending 
* alphabetically
**/

public class CompareByOriginal implements Comparator<Word>
{
   public int compare(Word theFirst, Word theSecond)
   {	
	return theSecond.getMyWord()
	.compareTo(theFirst.getMyWord());
   }
}
