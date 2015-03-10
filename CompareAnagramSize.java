
import java.util.Comparator;

public class CompareAnagramSize implements Comparator<AnagramFamily>
{
	public int compare(AnagramFamily theThis, AnagramFamily theOther)
	{
		return theOther.getMyCount() 
		- theThis.getMyCount();
	}
}