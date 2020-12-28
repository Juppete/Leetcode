package trick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {
	//Feature:	find the max or min
	//			exhaustive search
	//			optimal sub problem
	
	//Note:	store repetitive problem's answer
	
	//Process: confirm status -->define DP method --> confirm choose --> 
	// 		   confirm base case(margin status)
	
	/***************EXAMPLE 1: Fibonacci Sequence***********************/
	//NUMBER: 0  1  2  3  4  5  6  7   8   9   10  11  12   13
	//OUTPUT: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233
	
	/*--------------Fibonacci Sequence with violent recursion----------*/
	public static int easyFibonacci(int N) {
		int output=0;	
		if(N==1 | N==2) {
			return 1;
		}
		output=easyFibonacci(N-1)+easyFibonacci(N-2);
		return output;
	}
	
	/*----------------------Fibonacci Sequence with note----------------*/
	//with note to store array
	public int note(ArrayList<Integer> noteArrayList,int N) {
		if(N==1 | N==2) {
			return 1;
		}
		if (noteArrayList.get(N)!=0) {
			return noteArrayList.get(N);
		}
		noteArrayList.add(N,note(noteArrayList, N-1)+note(noteArrayList, N-2));
		return noteArrayList.get(N);
	}
	
	public int FibonacciWithNote(int N) {
		//Whether N is correct
		if (N<1) {
			return 0;
		}
		//Don't store number at index of 0
		ArrayList<Integer> noteArrayList=new ArrayList<>(N+1);
		for (int i=0;i<N+1;i++) {
			noteArrayList.add(i, 0);
		}
		return note(noteArrayList,N);
	}
	
	/*-------------------Fibonacci Sequence with DP----------------------*/
	
	public int FibonacciWithDP(int N) {
		if (N<1) {
			return 0;
		}

		ArrayList<Integer> DPArrayList=new ArrayList<>(N+1);
		for (int i=0;i<N+1;i++) {
			DPArrayList.add(i, 0);
		}
		//Init list
		DPArrayList.add(1, 1);
		DPArrayList.add(2, 1);
		//Bottom-up
		for (int i=3;i<N+1;i++) {
			DPArrayList.add(i,DPArrayList.get(i-1)+DPArrayList.get(i-2));
		}
		return DPArrayList.get(N);
	}
	/*---------Fibonacci Sequence with perfect DP----------------------*/
	public int FibonacciWithDP2(int N) {
		if (N<1) {
			return 0;
		}
		//only store 2 numbers
		int prev2=1;//N-2
		int prev1=1;//N-1
		int now=0;
		for (int i=3;i<N+1;i++) {
			now=prev2+prev1;
			prev2=prev1;
			prev1=now;
		}
		return now;
	}
	/*******************************************************************/
	
	
	
	/***************EXAMPLE 2: coins***********************/
	
	public int coinChange(int[] coins, int amount) {
		return coinDP(coins,amount);
	}
	
	public int coinDP(int[] coins,int expectedMount) {
		if (expectedMount==0) {
			return 0;
		}
		if (expectedMount<0) {
			return -1;
		}
		int numberOfCoins=500; //Enough big
		for (int coin:coins) {
			int subProblem=coinDP(coins,expectedMount-coin);
			if (subProblem==-1) {
				continue;
			}
			numberOfCoins=Math.min(numberOfCoins, 1+subProblem);//add a coin
		}	
		return numberOfCoins;
	}
	
	/*----------------------coins with note----------------*/
	public int coinChange2(int[] coins, int amount) {
		//Note store the relationship between amount and the number of coins
		Map<Integer, Integer> note = new HashMap();
		return coinDPWithNote(note,coins,amount);
	}
	
	public int coinDPWithNote(Map<Integer, Integer> note,int[] coins,int expectedMount) {
		//If note has expected amount
		for (Integer key : note.keySet()) {
			if (key==expectedMount) {
				return note.get(key);
			}
		}
		
		if (expectedMount==0) {
			return 0;
		}
		if (expectedMount<0) {
			return -1;
		}
		int numberOfCoins=500; //Enough big
		for (int coin:coins) {
			//get subproblem's answer
			int subProblem=coinDP(coins,expectedMount-coin);
			if (subProblem==-1) {
				continue;
			}
			//from small to big
			//not skip means have answer then add a coin
			numberOfCoins=Math.min(numberOfCoins, 1+subProblem);
		}	
		note.put(expectedMount, numberOfCoins);
		return numberOfCoins;
	}
	
	public static void main(String[] args) {
		DynamicProgramming DP = new DynamicProgramming();
		/***************EXAMPLE 1: fibonacci sequence***********************/
//		System.out.println("output Of fibonacci sequence "+DP.easyFibonacci(10));
//		System.out.println("output Of fibonacci sequence with note "+DP.FibonacciWithNote(10));
//		System.out.println("output Of fibonacci sequence with DP "+DP.FibonacciWithDP(10));
//		System.out.println("output Of fibonacci sequence with DP2 "+DP.FibonacciWithDP2(10));
		
		/***************EXAMPLE 2: coins***********************/
		int[] coins= {1,2,5};
		int amount=11;
//		System.out.println("output Of coins "+DP.coinChange(coins, amount));
		System.out.println("output Of coins with note "+DP.coinChange2(coins, amount));
	}
}
