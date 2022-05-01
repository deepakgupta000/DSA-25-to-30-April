package com.DSA_25_30_April;


import java.util.Arrays;

class Stack
{
    private int arr[];
    private int top;
    private int capacity;
 
    Stack(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
 
    public void push(int x)
    {
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }
 
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }
 
    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
 
        System.out.println("Removing " + peek());
 
        return arr[top--];
    }
 
    public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }
 
        return -1;
    }
 
    public int size() {
        return top + 1;
    }
 
    public boolean isEmpty() {
        return top == -1;          
    }
 
    public boolean isFull() {
        return top == capacity - 1;   
    }
    public String toString() {
    	return Arrays.toString(arr);   
    }
}
public class Apr28 {
	static Stack s=new Stack(6);
	public static void main(String[] args) {
        
        int a[] = {0,0,1,1,2,2,3,4,5,5};


        System.out.println("After Removing Duplicates:"+removeDuplicates(a));
    }

	private static String removeDuplicates(int[] a) {
        for(int i =0;i<a.length;i++)
        {
            if(s.isEmpty())
            {
                s.push(a[i]);
            }

            else {
                int val = s.peek();
                if(val != a[i])
                {
                    s.push(a[i]);
                }
            }
        }
		return s.toString();
	}
}