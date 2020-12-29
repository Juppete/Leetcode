package trick;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class BackTracking {
	//Decision Tree
	//Path:				choosen choose
	//Choose List:		optional choose
	//Finish condition:	reach the bottom of tree

	/***************EXAMPLE 1: Permutations***********************/
	public LinkedList<LinkedList<Integer>> permute(int[] nums) {
		//Store final output
		LinkedList<LinkedList<Integer>> output = new LinkedList<LinkedList<Integer>>();
		//Create a path to use
		LinkedList<Integer> track = new LinkedList<Integer>();
		backTrack(nums, track, output);		
		return output;
	}
	
	//track: temporary path
	public void backTrack(int[] nums,LinkedList<Integer> track,LinkedList<LinkedList<Integer>> output) {
		//Finish condition: N+1th number makes a complete path
		if (track.size()==nums.length) {
//			output.add(track); //When modify track the output will change strange bug
								//why??????????????????????
			output.add(new LinkedList (track));//must new one
			return;
		}
		
		for (int i=0;i<nums.length;i++) {
			if (track.contains(nums[i])) {
				continue;
			}
			track.add(nums[i]);
			backTrack(nums, track, output);		
			track.removeLast();//Nth number deletes last one and clear path
		}
	}
	
	/***************EXAMPLE 2: N queen***********************/
	
	public Vector<String[][]> NQueen(int N) {
		Vector<String[][]> output = new Vector<String[][]>();
		String[][] board= new String[N][N];
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				board[i][j]=".";
			}
		}
		backTrack2(N, 0, board, output);
		return output;
	}
	
	public void backTrack2(int N ,int row,String[][] board ,Vector<String[][]> output) {
		//Finish condition: N+1th number makes a complete path
		if (board.length==row) {
//			output.add(board);//  为什么随着board改变传给output的board也改变？？？？
			return;
		}
		
		for (int col=0;col<N;col++) {
			if (!isValid(board,row,col)) {
				continue;
			}
			board[row][col]="Q";
			backTrack2(N,row+1,board, output);		
			board[row][col]=".";
		}
	}
	
	public boolean isValid(String[][] board,int row,int col) {
		int n=board.length;
		//Check same column
		for (int i=0;i<n;i++) {
			if (board[i][col]=="Q") {
				return false;
			}
		}
		//Check upLeft
		for (int i=row-1,j=col-1;i>=0 && j>=0;i--,j--) {
			if (board[i][j]=="Q") {
				return false;
			}
		}
		//Check upright
		for (int i=row-1,j=col+1;i>=0 && j<n;i--,j++) {
			if (board[i][j]=="Q") {
				return false;
			}
		}
		return true;
	}
	
	/*********************************************************/
	
	public static void main(String[] args) {
		BackTracking BT = new BackTracking();
		int[] nums= {1,2,3};
		/***************EXAMPLE 1: Permutations***********************/
//		System.out.println("Permutations ");
//		LinkedList<LinkedList<Integer>> output=BT.permute(nums);
//		
//		for (LinkedList<Integer> track:output) {
//			System.out.println(output.indexOf(track)+" th:"+track+" ");
//			for (Integer t:track) {
//				System.out.println(" \'"+track.indexOf(t)+"\':"+t+" ");
//			}
//		}
		
		/***************EXAMPLE 2: N queen***********************/
		System.out.println("N queen ");
		Vector<String[][]> output=BT.NQueen(5);
//		
//		for (LinkedList<Integer> track:output) {
//			System.out.println(output.indexOf(track)+" th:"+track+" ");
//			for (Integer t:track) {
//				System.out.println(" \'"+track.indexOf(t)+"\':"+t+" ");
//			}
//		}
		
//		Vector<String[][]> output = new Vector<String[][]>();
//		String[][] aStrings={{"a","a","a"},{"a","a","a"}};
//		output.add(aStrings);
	}
}
