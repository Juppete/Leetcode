package trick;

import java.util.HashMap;

public class SlidingWindow {
	//suit for substring or subarray
	/***************EXAMPLE 1: Minimum Window Substring***********************/
	public String minWindow(String s,String t) {
		//Record substring
		HashMap<Character, Integer> need = new HashMap<Character, Integer>();
		//Record Window
		HashMap<Character, Integer> window = new HashMap<Character, Integer>();
		//Record the char of substring
		for (int i=0;i<t.length();i++) {
			need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0)+1);//value++
		}
		int left=0; 	//Left index
		int right=0;	//Right index
		int valid=0;	//Each char is enough?
		
		int start=0;	//Start index of final result
		int len=100;	//The length of substring
		
		//Right move
		while (right<s.length()) {
			char c=s.charAt(right);
			right++;
			
			if (need.containsKey(c)) {						//If contain c
				window.put(c, window.getOrDefault(c, 0)+1);	//Put in window
				if (window.get(c)==need.get(c)) {			//Whether enough c
					valid++;
				}
				if (valid==need.size()) {					//Enough char
					break;
				}
			}
		}
		
		//Left shrink
		while (valid==need.size()) {
			//Renew first, judge later avoid incorrect answer
			//Update minimum substring
			if (right-left<len) {
				start=left;
				len=right-left;
			}
			//To be removed char
			char deleteChar=s.charAt(left);
			left++;
			if (need.containsKey(deleteChar)) {
				window.put(deleteChar, window.getOrDefault(deleteChar, 0)-1);//window[c] value--
				if (window.get(deleteChar)<need.get(deleteChar)) {
					valid--;
				}
			}
		}
		
		return len==100?"":s.substring(start, right);
	}
	
	/***************EXAMPLE 2: Permutation in String***********************/
	public boolean checkInclusion(String s,String t) {
		HashMap<Character, Integer> need = new HashMap<Character, Integer>();
		HashMap<Character, Integer> window = new HashMap<Character, Integer>();
		for (int i=0;i<t.length();i++) {
			need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0)+1);
		}
		int left=0;	int right=0;int valid=0;			
		int start=0;int len=100;	
		
		//Right move
		while (right<s.length()) {
			char c=s.charAt(right);
			right++;
			
			if (need.containsKey(c)) {						
				window.put(c, window.getOrDefault(c, 0)+1);	
				if (window.get(c)==need.get(c)) {			
					valid++;
				}
				if (valid==need.size()) {
					break;
				}
			}
		}
		
		//Left shrink
		while (right-left>=t.length()) {	
			if (right-left==t.length() & valid==need.size()) {//same string size
				return true;
			}
			char deleteChar=s.charAt(left);
			left++;
			if (need.containsKey(deleteChar)) {
				window.put(deleteChar, window.getOrDefault(deleteChar, 0)-1);
				if (window.get(deleteChar)<need.get(deleteChar)) {
					valid--;
				}
			}
		}		
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindow SW = new SlidingWindow();
		/***************EXAMPLE 1: Minimum Window Substring***********************/
		//  0 1 2 3 4 5 6 7 8 9 10 11 12
		//	A D O B E C O D E B A  N  C	
		String S="ADOBECODEBANCMOP";
		String T="ABC";
		System.out.println(SW.minWindow(S, T));
		/***************EXAMPLE 2: Permutation in String***********************/
		//0 1 2 3 4 5 6 7
		//e i d b a o o o
		String s1="ba";
		String s2="eidbaooo";
		System.out.println(SW.checkInclusion(s2, s1));
	}

}
