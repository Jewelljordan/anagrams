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
	static String phrase=""; //input (ex:Barbara Bush)
	static ArrayList<String> dictionary= new ArrayList<String>(); //the dictionary we pass in
	static int max=0; //the max words we can use for anagram
	static ArrayList<String> toUse= new ArrayList<String>(); //phrase, but in alpha order and in an array list
	static ArrayList<String> copyToUse= new ArrayList<String>(); //a copy of toUse that's found in isAnagram
	static ArrayList<ArrayList<String>> combos= new ArrayList<ArrayList<String>>(); //this holds all the array lists of possible anagrams split by their words
	static ArrayList<String> ctoUse=new ArrayList<String>(); //make a copy of toUse for findAnagrams
			
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
	System.out.print("How many words do you want to use?");
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
			System.out.println(toUse);
			ctoUse= toUse;
			copyToUse=toUse;
	System.out.println(isAnagram(toUse,"abashz"));
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean isAnagram(ArrayList<String> tu, String d) 
	{
		//parameters: ArrayList of letters toUse (barbara bush in alpha order) & a string of the dictionary word we're on (String d)
		toUse=tu;
		//sort d (the string from dictionary) into alpha order
		ArrayList<String> z= new ArrayList<String>();
		for(int x=0; x<d.length(); x++)
		{
			z.add((d.substring(x,x+1)).toLowerCase());
		}
		Collections.sort(z);
		//convert the alphabetized array list of d (string from dictionary) back to a string
		StringBuffer sb = new StringBuffer();
	      for (String s : z) {
	         sb.append(s);
	      }
	      String dict = sb.toString();
		
		//loop through dict to see if it can be found in toUse
	    for(int x=dict.length()-1; x>=0; x--)
		{
	    	if(!copyToUse.contains(dict.substring(x,x+1)))
				return false;
			if(copyToUse.contains(dict.substring(x,x+1)))
			{
				copyToUse.remove(dict.substring(x,x+1));
				dict=dict.substring(0,x);
			}
		}
		 
		
		//return true or false
		return true;
	}
	public int findAnagrams(ArrayList<String> possible, int count)
	{
		for(int x=0; x<dictionary.size(); x++)
		{
			if(ctoUse.isEmpty()) //
			{
				combos.add(possible);
				ctoUse=toUse;
				x=0;
			}
			if(Anagrams.isAnagram(toUse, dictionary.get(x))) // and check if combos doesn't contain possible
			{
				possible.add(dictionary.get(x));
				findAnagrams(possible,count);
			}
		}
			
		return 0;
	}
	
	public static void main(String[] args) throws Exception
	{
		Anagrams.run();
	}
	
}
