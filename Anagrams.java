import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class anagrams2 
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
	
	//System.out.println(isAnagram(toUse,"abashz"));
	System.out.println(1);
	anagrams2.findAnagrams(new ArrayList<String>(),max,toUse,0);
	System.out.println(2);
	
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static boolean isAnagram(ArrayList<String> tu, String d) 
	{
		//parameters: ArrayList of letters toUse (barbara bush in alpha order) & a string of the dictionary word we're on (String d)
		copyToUse=tu; //changed to copy of to use
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
		return true;
	}
	public static int findAnagrams(ArrayList<String> possible, int count, ArrayList<String> letters, int forx)
	{
		ArrayList<String> possible2 = new ArrayList<String>(); //gets new sets of data instead of the reference pasted into the method
		for(String x:possible) {
			possible2.add(x);
		}
		ArrayList<String> letters2 = new ArrayList<String>();
		for(String x:letters) {
			letters2.add(x);
		}
		
		for(int x=0; x<dictionary.size(); x++)
		{
			if(letters2.isEmpty()) //
			{
				System.out.println(3);
				System.out.println(possible2); //is printing why too much, why ugh
				return 0; //stop recursion
			}
			//System.out.println(letters);
			//System.out.println(letters2);
			//System.out.println(toUse);
			if(anagrams2.isAnagram(letters2, dictionary.get(x))) // and check if combos doesn't contain possible
			{
				//System.out.println(letters);
				//System.out.println(letters2);
				//System.out.println(toUse);
				//System.out.println(3);
				//System.out.println(4);
				anagrams2.findAnagrams(possible2,count,letters2,x+1);//branch one - doesn't add, (reason for forx) skips over to get different combo
				possible.add(dictionary.get(x));
				//System.out.println(5);
				anagrams2.findAnagrams(possible2,count,letters2,0); //branch two - adds it
				//System.out.println(6);
			}
			else {
				letters2 = new ArrayList<String>();
				for(String y:letters) {
					letters2.add(y);
				}
			}
			
		}
		//branching point, one branch add item another branch dont
		return 0;
	}
	
	public static void main(String[] args) throws Exception
	{
		anagrams2.run();
	}
	
}
