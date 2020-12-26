package trick;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PrimitiveIterator.OfDouble;

public class DynamicProgramming {
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
	
	public static void main(String[] args) {
		DynamicProgramming DP = new DynamicProgramming();
		System.out.println("output Of fibonacci sequence "+DP.easyFibonacci(10));
		System.out.println("output Of fibonacci sequence with note "+DP.FibonacciWithNote(10));
		System.out.println("output Of fibonacci sequence with DP "+DP.FibonacciWithDP(10));
		System.out.println("output Of fibonacci sequence with DP2 "+DP.FibonacciWithDP2(10));
	}
}
