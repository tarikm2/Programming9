Sudo code
-----------------------------------------------------------------------------------------------------------------


/************************ WORD OBJECT CLASS *******************************/
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
		(assign theWord to myWord)
		(call method to get canotical form of word)
	}

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
		return myCat();
	}

	/**
	* this method will find the canotical 
	* form of the passed . efficency will be
	* crucial as the database being processed 
	* is fairly large.
	**/
	
	private final void makeCat(theWord)
	{
		(convert string into a character array)

		(use merge sort recursive algorithm to sort letters)
		
		(combine array into string and assign to myCat)
	}
		
	private final merge(Char[] theLeft, Char[] theRight)
	{
		(this method controles the merging section
		of the merge sort algorithm)
	}	
	
	/**
	* this method returns positive int
	* value if myCat > theOther, 0 if 
	* myCat is == theOther, and negative
	* int if myCat < theOther.
	**/
	public int compareTo (Word theOther)
	{
		return myCat.compareTo(theOther.getMyCat());
	}
}

/********** WORD OBJECT COMPARATOR CopareByOriginal*************/

public class CompareByOriginal implements Comparator<Word>
{
   public int compare(Word theFirst, Word theSecond)
   {	
	return theSecond.getMyWord()
	.compareTo(theFirst.getMyWord());
   }
}


/************************ ANAGRAM FAMILY *******************************/

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
		myWords = new LinkedList<Word>;

		(create iterator for theFamily)
		(traverse theFamily, adding 
		 its contents to myWords and 
		 incrementing count)

		(sort myWords through a comparator)
		(alphabetically by original word)
	}
	
	public void getMyCount()
	{
		return myCount;
	}
	/**
	* compareTo compares AnagramFamilies
	* based on their size
	**/
		
	
}

/********************************AnagramFamily comparator *************/

public class CompareAnagramSize implements Comparator<Word>
{
	public int compare(AnagramFamily theThis AnagramFamily theOther)
	{
		return theOther.getMyCount() 
		- theThis.getMyCount();
	}
}

/************************ MAIN DRIVER *******************************/

public class 
{
	
	public static void main(String theArgs[])
	{
		(open input file)
		
		(use iterator over input to create
		 word objects and add these objects 
	 	 to LinkedList )

		(sort the list alphabetically 
		 by canotical form (Word class'
		 compareTo method)
		
		(create a new LinkedList<AnagramFamily> families)
		(creat a new LinkedList<Word> aFamily)
		
		(uses recursive calls to getFamily to get families)	
		 while(the iterator.hasNext())
		 {
			Word test = iterator.Next();
			aFamily.add(Test);
			if( iterator.hasNext())
			{
				getFamily(aFamily, iterator, test);
			}
			Collections.sort(aFamily, new CompareByOriginal());
			families.add(new AnagramFamily(aFamily));
			aFamily.clear();
		}
		Collections.sort(families, new CompareAnagramSize());
		
		
		
	}
	
	public static void getFamily(theFamily, theIterator, thePrevious)
	{
}		Word test = theIterator.next();
		if (thePrevious.compareTo(test) == 0)
		{
			theFamily.add(test);
			if(theIterator.hasNext();
			getFamily(theFamily, theIterator, test)
		}
		else
		{
			theIterator.previous();
		}
	}


Original Assignment
------------------------------------------------------------------------------------------------------------------

TCSS143
Fundamentals of Object-Oriented Programming-Theory and Application
Programming Assignment 9
The purpose of this programming project is to demonstrate a significant culmination of most constructs learned
thus far in the course. This includes Lists, Classes, accessors, mutators, constructors, implementation of 
Comparable, Comparator, use of Collections sort, iterators, properly accessing fields of complex objects, and 
fundamental File I/O.

BACKGROUND
Look over Programming Project #4 at the end of the Searching & Sorting Chapter (13), page 869. 
Programming Assignment 9 is similar with some added features as described below.
You will submit a single file Programming9.zip through the Programming Assignment 9 Submission link on 
Canvas. This zipped file will contain a minimum of 5 files which make up the solution to this assignment. DO 
NOT zip any folders.
The standard grading rules (documentation included) for all previous assignments applies here as well.

DETAILS
To better prepare you for assignments in more advanced courses, specific step-by-step, method headings, 
class names, and the like have been omitted. What remains is a general description (you may need to read 
this several times to fully understand the requirements):
You will create a LinkedList of Word objects using all the words found in the input file words.txt. A Word 
object contains 2 String fields; 1 to store a word in its normal form and the other to store a word in its canonical 
form. The canonical form stores a word with its letters in alphabetical order, e.g. bob would be bbo, cat would 
be act, program would be agmoprr, and so on. The class Word constructor has the responsibility of storing 
the normal form of the word in the normal form field and converting the normal form into the canonical form 
which is stored in the canonical form field (you should call a separate method for this conversion purpose).
Once all the words from the input file have been properly stored in a LinkedList of Word, you should use 
Collections to sort this list ascending alphabetically based on the canonical words by making the Word class 
Comparable.
Using an Iterator on the LinkedList of Word, create a 2nd list (new LinkedList) consisting of objects of a new 
class named AnagramFamily. AnagramFamily should contain at least 2 fields; 1 to hold a list of ÅgWordÅh words 
that are all anagrams of each other (these should all be grouped together in the original canonical sorted list), 
and the 2nd field to store an integer value of how many items are in the current list. (Keep in mind, because the 
original list contains both the normal and canonical forms, as the AnagramFamily List will also have, a family of 
anagrams will all have the same canonical form with different normal forms stored in the normalForm field of 
the Word class). Each AnagramFamily List of Word should be sorted Descending by normal form using a 
Comparator of Word (If you insert Word(s) into a family one at a time, this presents an issue on how to get this 
list sorted as each Word insertion will require a new sort to be performed to guarantee the list is always sorted. 
For this reason it is best to form a list, sort it, and then create an AnagramFamily by passing the sorted list to it.
Sort the AnagramFamily LinkedList in descending order based on family size by use of a Comparator to be 
passed to the Collections sort method.
Next, output the top five largest families and then, all families of length 8 to a file named Ågout9.txt.Åh Be sure to 
format the output to be very clear and meaningful.
Finally, the first 4 people to complete the assignment should post their output results to the Canvas discussion 
forum for the remaining students to see the correct answer.
Be sure to instantiate new objects whenever transferring data from one object to another to avoid a repeat ofthe issues involved with Programming Assignment 6. Also, be sure to include various methods for 
manipulation and access of fields as well as helper methods to reduce code in main, such as the input/output 
of file data (like all other assignments, you will be graded on decomposition, i.e. main should not contain too 
many lines of code).
Keep in mind such items as proper documentation (including javadoc), meaningful variable names, proper 
indentation, reduction of redundancy whenever possible, and so on.
Part of your grade will depend on time. If written correctly (use of iterators and care taken when creating the 
anagram families), the running time should be less than 3 seconds. Programs that take longer will lose points 
based on the time. As encouragement to consider all options for speed, programs taking 1 minute will receive 
a 40 point deduction. Any longer than 3 minutes will receive only minimal points (10) for effort.
Though the basic algorithms involved are straight forward enough, there is a great deal of complexity involved 
with various levels of access to specific data. As mentioned before and never so importantly as with this 
assignment, start early and set a goal for completion by this weekend. Trust me, this is sound advice.
As a reminder, you will create at least 5 files: the driver, Word class, AnagramFamily class, and 2 comparators: 
1 to compare Word objects for sorting descending based on the normal form of Word objects and 1 to compare 
AnagramFamily sizes for a descending sort.
You will submit a single file Programming9.zip through the Programming Assignment 9 Submission link on 
Canvas. This zipped file will contain a minimum of 5 files which make up the solution to this assignment. DO 
NOT zip any folders.