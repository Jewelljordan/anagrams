hi
import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Anagrams 
{
	static String phrase="";
	static Set<String> dictionary= new TreeSet<String>();
	static int max=0;
	static ArrayList<String> toUse= new ArrayList<String>();
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void run()throws Exception
	{
		//read in dictionary
	Scanner file= new Scanner(new File("smalldict1.txt"));
	while(file.hasNext())
	{
		dictionary.add(file.next());
	}
		//keyboard input scanner
	Scanner kb = new Scanner(System.in);
	System.out.print("What word/phrase do you want to use? ");
	phrase = kb.nextLine();
	System.out.print("How many words do you want to lose?");
	max = kb.nextInt();
	System.out.println("Searching for anagrams...");
	//convert phrase into WordsToUse Tree Set
			toUse=new ArrayList<String>();
			String[] no_space_phrase= phrase.split(" ");
			for(int x=0; x<no_space_phrase.length; x++)
			{
				for(int y=0; y<no_space_phrase[x].length(); y++)
				{
					toUse.add((no_space_phrase[x].substring(y,y+1)).toLowerCase());
				}
			}
			Collections.sort(toUse);
	//System.out.println(findAnagrams(phrase,max,dictionary));
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static int findAnagrams(ArrayList<String> current, int m, ArrayList<ArrayList<String>> found)
	{
		//parameters: ArrayList that holds the current strings that work & an array list of array list to hold the ones we've already found
		//loop find words that fit into toUse
		//then recur to see all words that make the string
		
		for(int x=0; x<dictionary.size(); x++)
		{
			//see if the letters of this word can be found in toUse (how the heck... bc rn I have toUse as an ArayList ummmm)
			//if yes, recur to find the rest
			//add to count if all the letters used equal toUse
		}
		
		//snirjirwt 
		
		//return the count
		return 0;
	}
	
	
	public static void main(String[] args) throws Exception
	{
		Anagrams.run();
	}
	
}
