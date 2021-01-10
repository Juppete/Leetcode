package trick;

import java.util.LinkedList;

import selfBuild.ListNode;
import selfBuild.MyLinkedList;

public class TwoPointers {
	/**********************Fast and slow pointers**********************/
	//Solve linked list
	/***************EXAMPLE 1: Whether linked list has a ring***********************/
	public boolean hasCycle(ListNode head) {
		ListNode fast,slow;
		fast=slow=head;
		while(fast!=null & fast.next()!=null) {
			fast=fast.next().next();
			slow=slow.next();
			//Meet at a point
			if (fast==slow) {
				return true;
			}
		}
		return false;
		
	}

	/***************EXAMPLE 2: Find start point of linked list***********************/
	//Assume a steps to start point of ring and k steps in ring
	//Fast and slow pointers encounters at place m steps from starting point
	//A circle is k
	//-----a=(k-m)----*---m----*   Meeting point
	//                |        |
	//                |        |   
	//                *--k-m---*	
	//Slow:a+m  Fast:2(a+m)=(a+m)+k -->a+m=k -->a=k-m
	public ListNode detectCycle(ListNode head) {
		ListNode fast,slow;
		fast=slow=head;
		while(fast!=null & fast.next()!=null) {
			fast=fast.next().next();
			slow=slow.next();		
			//First meet
			if (fast==slow) {					
				break;
			}
		}
		//Put slow at head ,they meet after k-m steps
		slow=head;
		while(slow!=fast) {
			fast=fast.next();
			slow=slow.next();
		}
		return slow;
	}
	
	/***************EXAMPLE 3: Find the middle point of non-ring*******************/
	public ListNode findMiddle(ListNode head) {
		ListNode fast,slow;
		fast=slow=head;
		while(fast!=null & fast.next()!=null) {
			fast=fast.next().next();
			slow=slow.next();		
		}
		return slow;
	}
	
	/***************EXAMPLE 4: Find the kth point from the bottom*******************/
	public ListNode findK(ListNode head,int k) {
		ListNode fast,slow;
		fast=slow=head;
		//Move Kth first
		while (k-->0) {
			fast=fast.next();
		}
		while(fast!=null & fast.next()!=null) {
			fast=fast.next();
			slow=slow.next();		
		}
		return slow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList linkedList = new MyLinkedList();

	}

}
