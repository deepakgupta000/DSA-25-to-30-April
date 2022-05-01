package com.DSA_25_30_April;

//"""Implement a queue data structure using the following data structure:  
//1. Arrays
//2. LinkedList """
class Queue {
	private static int front, rear, capacity;
	private static int queue[];

	Queue(int c) {
		front = rear = 0;
		capacity = c;
		queue = new int[capacity];
	}

	static void queueEnqueue(int data) {
		if (capacity == rear) {
			System.out.printf("\nQueue is full\n");
			return;
		}

		else {
			queue[rear] = data;
			rear++;
		}
		return;
	}

	static void queueDequeue() {
		if (front == rear) {
			System.out.printf("\nQueue is empty\n");
			return;
		}

		else {
			for (int i = 0; i < rear - 1; i++) {
				queue[i] = queue[i + 1];
			}

			if (rear < capacity)
				queue[rear] = 0;

			rear--;
		}
		return;
	}

	static void queueDisplay() {
		int i;
		if (front == rear) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}

		for (i = front; i < rear; i++) {
			System.out.printf(" %d <-- ", queue[i]);
		}
		return;
	}

	static void queueFront() {
		if (front == rear) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}
		System.out.printf("\nFront Element is: %d", queue[front]);
		return;
	}
}
class QNode {
  int key;
  QNode next;

  public QNode(int key)
  {
      this.key = key;
      this.next = null;
  }
}
class Queue1 {
  QNode front, rear;

  public Queue1()
  {
      this.front = this.rear = null;
  }

  void enqueue(int key)
  {

      QNode temp = new QNode(key);

      if (this.rear == null) {
          this.front = this.rear = temp;
          return;
      }

      this.rear.next = temp;
      this.rear = temp;
  }

  void dequeue()
  {
      if (this.front == null)
          return;

      QNode temp = this.front;
      this.front = this.front.next;

      if (this.front == null)
          this.rear = null;
  }
}
public class Apr30 {
	public static void main(String[] args) {
		//Arrays
		Queue q = new Queue(4);

		q.queueDisplay();

		q.queueEnqueue(20);
		q.queueEnqueue(30);
		q.queueEnqueue(40);
		q.queueEnqueue(50);
		q.queueDisplay();

		q.queueEnqueue(60);

		q.queueDisplay();

		q.queueDequeue();
		q.queueDequeue();
		System.out.printf("\nAfter two node deletion\n");
		q.queueDisplay();

		q.queueFront();
		
		//LinkedList
		Queue1 q1 = new Queue1();
      q1.enqueue(10);
      q1.enqueue(20);
      q1.dequeue();
      q1.dequeue();
      q1.enqueue(30);
      q1.enqueue(40);
      q1.enqueue(50);
      q1.dequeue();
      System.out.println("\nQueue Front : " + q1.front.key);
      System.out.println("Queue Rear : " + q1.rear.key);
	}
}