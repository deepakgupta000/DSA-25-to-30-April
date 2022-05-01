package com.DSA_25_30_April;



import java.util.Stack;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Apr26 {
	static ListNode head;

	public static void main(String[] args) {
		ListNode listA = new ListNode(4);
		listA.next = new ListNode(1);
		listA.next.next = new ListNode(8);
		listA.next.next.next = new ListNode(4);
		listA.next.next.next.next = new ListNode(5);

		display(listA);

		ListNode listB = new ListNode(5);
		listB.next = new ListNode(6);
		listB.next.next = new ListNode(1);
		listB.next.next.next = new ListNode(8);
		listB.next.next.next.next = new ListNode(4);
		listB.next.next.next.next.next = new ListNode(5);

		display(listB);

		System.out.println(getIntersectionNode(listA, listB));
		
		Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);
		System.out.println(isPalindrome(head1));

	}

	public static void display(ListNode head) {
		if (head == null) {
			System.out.println("List is empty! ");
		} else {
			ListNode currNode = head;
			while (currNode != null) {
				System.out.print(currNode.val + " -> ");
				currNode = currNode.next;
			}
			System.out.println("Null");
		}
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode temp = headA;
		ListNode temp1 = headB;
		while (temp != temp1) {
			if (temp1 == null)
				temp1 = headA;
			else
				temp1 = temp1.next;
			if (temp == null)
				temp = headB;
			else
				temp = temp.next;

		}
		return temp;
	}

	static boolean isPalindrome(Node head) {

		Node slow = head;
		boolean ispalin = true;
		Stack<Integer> stack = new Stack<Integer>();

		while (slow != null) {
			stack.push(slow.data);
			slow = slow.next;
		}

		while (head != null) {

			int i = stack.pop();
			if (head.data == i) {
				ispalin = true;
			} else {
				ispalin = false;
				break;      
			}
			head = head.next;
		}
		return ispalin;
	}
}