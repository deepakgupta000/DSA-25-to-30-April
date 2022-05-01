package com.DSA_25_30_April;

package LinkedList;
import java.util.LinkedList;

public class Apr27 {
	static DNode head;
	public static void main(String[] args) {
		Node head=new Node(10);
		head.next=new Node(20);
		head.next.next=new Node(30);
		
		Node last=head.next.next;
		last.next=head;
		
		addFirst(10);
		addFirst(20);
		addFirst(30);

		addLast(50);
		addLast(55);

        display();
        getSize();
        greaterThan25();

	}
	
	    public static void addFirst(int data){
	        DNode newNode = new DNode(data);
	        if (head==null){
	            head = newNode;
	        }
	        else {
	            head.prev = newNode;
	            newNode.next = head;
	            head = newNode;
	        }
	    }
	    public static void display(){
	        if (head==null){
	            System.out.println("List is empty! ");
	        }
	        else{
	            DNode curr = head;
	            while (curr!=null){
	                System.out.print(curr.data+" ");
	                curr = curr.next;
	            }
	            System.out.println("Null");
	        }
	    }
	    public static void getSize(){
	        int size = 0;
	        if (head==null){
	            System.out.println("List is empty! ");
	        }
	        else {
	            DNode curr = head;
	            while (curr!=null){
	                size++;
	                curr = curr.next;
	            }
	        }
	        System.out.println("The size of the list is: "+size);
	    }
	    public static void greaterThan25(){
	        if (head==null){
	            System.out.println("List is empty! ");
	        }
	        else{
	            DNode curr = head;
	            while (curr!=null ){
	                if (curr.data<25) {
	                    System.out.print(curr.data + " ");
	                }
	                curr = curr.next;
	            }
	        }
	    }
	private static void addFirst1(int data) {
		DNode new_Node=new DNode(data); 
        if (head == null) {
            head = new_Node; 
        }else {
    		new_Node.next = head;
    		new_Node.prev = new_Node;    		
            head = new_Node; 
        }
	}
	
	private static void addLast(int data) {
		DNode new_Node=new DNode(data); 
        if (head == null) {
        	return;
        }else {
        	DNode cur=head;
        	while(cur.next!=null) {
        		cur=cur.next;
        	}
        	cur.next=new_Node;
        	new_Node.prev=cur;
        }
	}
	
	private static boolean isCyclic(Node head) {
		Node slow = head, fast = head;
		while( fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
			if( slow == fast ) {
				return true;
			}
		}
		return false;
	}
	
	
}