package trick;

public class Dichotomy {
	//Three situation: target in nums ; traget bigger than nums;traget smaller than nums
	/***************EXAMPLE 1: Find a number(basic)***********************/
	//nums:		2 4 6 7 8 9
	//index:	0 1 2 3 4 5	
	//target:	six
		
	public int binarySearch(int[] nums,int target) {
		int left=0;						//[L,
		int right=nums.length-1;		//	 R]
		while (left<=right) {			//Stop condition:left>right --> left==right+1
//		while (left<right) {			//Stop condition:left==right --> [L,L] miss L
			int mid=left+(right-left)/2;//Avoid upflow ; Notice: round down 2.5->2
			if (nums[mid]==target) {
				return mid;
			}else if (nums[mid]<target) {
				left=mid+1;				//skip nums[mid] because it's not answer
			}else if (nums[mid]>target) {
				right=mid-1;
			}
		}
		return -1;
//		return nums[left]==target?left:-1;//Check [L,L]
	}
	
	
	/***************EXAMPLE 2: Find left margin of traget***********************/
	//nums:		0 1 2 2 2 3 3 4 5	
	//index:	0 1 2 3 4 5 6 7 8
	//target:	leftmost two
	//meaning:	index means the number of elements smaller than target
	//process:	(0+8)/2=4 -->(0+4)/2=2-->(0+1)/2=0 X 
	//			If the right(left) cannot find answer than right(left)=mid¡À1
	public int leftBound(int[] nums,int target) {
		if(nums.length==0) return -1;
		int left=0;						//[L,
		int right=nums.length;			//	  R)
		
		while (left<right) {			//Stop condition:left==right --> [L,L) is empty
			int mid=left+(right-left)/2;
			if (nums[mid]==target) {
				right=mid;				//shrink the uppper boundary
			}else if (nums[mid]<target) {
				left=mid+1;				
			}else if (nums[mid]>target) {
				right=mid;				//[left,mid) mid is skipped
			}
		}
		if(right==nums.length) return -1;
		return nums[left]==target?(left):-1;//left==right they are same 
	}
	/***************EXAMPLE 2: Find right margin of traget***********************/
	public int rightBound(int[] nums,int target) {
		if(nums.length==0) return -1;
		int left=0;						//[L,
		int right=nums.length;			//	  R)
		
		while (left<right) {			//Stop condition:left==right --> [L,L) is empty
			int mid=left+(right-left)/2;
			if (nums[mid]==target) {
				left=mid+1;				//shrink the lower boundary
			}else if (nums[mid]<target) {
				left=mid+1;				
			}else if (nums[mid]>target) {
				right=mid;				//[left,mid) mid is skipped
			}
		}
		if(left==0) return -1;
		//when stop loop the nums[left](left==right) is not in range
		return nums[left-1]==target?(left-1):-1;					
	}
	
	
	public static void main(String[] args) {
		Dichotomy D = new Dichotomy();
		//index:	 0 1 2 3 4 5
		int[] nums= {1,2,3,4,5,6};
		//index:	  0 1 2 3 4 5 6 7 8 9 10 11 12
		int[] nums2= {1,1,1,2,2,2,3,3,4,4, 4, 5, 5};
		int target=3; //try -1 3 10
		int index=D.binarySearch(nums, target);
		int leftIndex=D.leftBound(nums2, target);
		int rightIndex=D.rightBound(nums2, target);
		System.out.println(index);
		System.out.println(leftIndex);
		System.out.println(rightIndex);
	}
}
