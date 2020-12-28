package trick;

import java.util.Iterator;
import java.util.LinkedList;

public class BackTracking {

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
			output.add(track);
		}
		
		for (int i=0;i<nums.length;i++) {
			//
			if (track.contains(nums[i])) {
				continue;
			}
			track.add(nums[i]);
			backTrack(nums, track, output);		
			track.removeLast();//Nth number deletes last one and make clear path
		}
	}
	
	public static void main(String[] args) {
		BackTracking BT = new BackTracking();
		int[] nums= {1,2,3};
		/***************EXAMPLE 1: Permutations***********************/
		System.out.println("Permutations ");
		LinkedList<LinkedList<Integer>> output=BT.permute(nums);
		
		for (LinkedList<Integer> track:output) {
			System.out.println("\'"+output.indexOf(track)+"\':"+track+" ");
			for (Integer t:track) {
				System.out.println(" \'"+track.indexOf(t)+"\':"+t+" ");
			}
		}
		
		/***************EXAMPLE 2: coins***********************/
	}
}
