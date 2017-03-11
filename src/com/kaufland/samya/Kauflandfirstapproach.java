package com.kaufland.samya;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.*;



public class Kauflandfirstapproach 
{

	
final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static List<String> readTextFile(String aFileName) throws IOException 
	{
	    Path path = Paths.get(aFileName);
	    return Files.readAllLines(path, ENCODING);
	  }
	
	public static List<List<String>> getWords(String fileName) throws IOException 
	{
		Map<String, List<String>> tempListOfAnagrams = new HashMap<String, List<String>>();
		List<String> listOfWords = readTextFile(fileName);
		for(String s : listOfWords) 
		{
			char[] c = s.toUpperCase().toCharArray();
			Arrays.sort(c);
			List<String> l = tempListOfAnagrams.get(String.valueOf(c));
			if(l == null) {
				l = new ArrayList<String>();
			} 
			l.add(s);
			tempListOfAnagrams.put(String.valueOf(c), l);
		}
		List<List<String>> anagrams = new ArrayList<List<String>>();
		for(Map.Entry<String, List<String>> e : tempListOfAnagrams.entrySet()) {
			if(e.getValue().size() > 1) {
				anagrams.add(e.getValue());
			}
		}
		return anagrams;
	}
		
	public static void main(String[] args) {
		try {
			
			List<List<String>> anagramsLists = getWords("sample.txt");
			
			
			for(List<String> l : anagramsLists) 
			{
				for(String s : l) {
					System.out.print(s + " , ");
				}
				System.out.println();
			}
			System.out.println("\nTotal Sets of Anagrams Found from the sample.txt: " + anagramsLists.size());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
