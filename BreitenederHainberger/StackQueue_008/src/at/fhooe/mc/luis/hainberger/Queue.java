package at.fhooe.mc.luis.hainberger;

public class Queue {
	int[] queue;
	int head, top, size;

	int counter;

	String new;
public int howOld(){
int i;
int k;
}

	int newvar;

	/** Initializes the queue instance */
	// public void initQueue(int size) {
	// queue = new int[size];
	// this.size = size;
	// top = 0;
	// counter = 0;
	// }
	/** Clears all elements from the queue */
	public void clear() {
		queue = new int[size];
		top = 0;
		counter = 0;
		head = 0;
		newvar = 99;
	}

	/** Enqueues an element at the back of the queue */
	public void enqueue(int val) {

		if (counter != size) {

			counter += 1;
			queue[top] = val;
			if (top + 1 >= size) {
				top = 0;
			} else {
				top = top + 1;
			}
		} else {

		}
	}

	/** Dequeues the element at the front of the queue */
	public int dequeue() {
		int val = 0;
		if (top == 0) {
			return Integer.MIN_VALUE;
		} else {
			counter -= 1;
			val = queue[head];
			head += 1;
			if (head >= size - 1) {
				head = 0;
			}
			return val;
		}
	}

	/** Returns the front element of the queue without removing it */
	public int peek() {
		if (top == 0) {
			return Integer.MIN_VALUE;
		} else {
			int val = queue[head];
			return val;
		}
	}

	/** Returns the number of elements in the queue */
	public int elements() {
		return counter;

	}

	/** Returns the maximum size of the queue */
	public int size() {
		return size;
	}

	/** Prints all elements in the queue */
//	 public void print(){
//		 int n = 0;
//		 System.out.print("Stack " + size + ": [");
//		 for (int i = 0; i <= counter; i++) {
//				if (n == size) {
//					n = 0;
//					if (n == top - 1) {
//						System.out.print(queue[n] + "].");
//						break;
//
//					} else {
//						System.out.print(queue[n] + ", ");
//					}
//					n++;
//				}
//				if (n == top - 1) {
//					System.out.print(queue[n] + "].");
//					break;
//					
//
//				} else {
//					System.out.print(queue[n] + ", ");
//					n++;
//				}
//			}
//	 }

	/** Constructor initializes queue with a standard size. */
	public Queue() {
		size = 10;
		queue = new int[size];
		top = 0;
		counter = 0;
	}

	/** Constructor initializes queue with the given size. */
	public Queue(int size) {
		queue = new int[size];
		this.size = size;
		top = 0;
		counter = 0;
	}

	/**
	 * Copy constructor initializes queue with another queue. * This constructor
	 * must COPY all elements of the other queue. * The elements of the other
	 * queue must NOT be changed!
	 */
	public Queue(Queue other) {
		this.size = other.size;
		queue = new int[size];
		for (int i = 0; i < size; i++) {
			queue[i] = other.queue[i];
		}
	}

	/**
	 * the method deinitializes the object the method sets all variables zero,
	 * the array to null and the garbage collector does the rest.
	 */
	public void finalize() {
		this.queue = null;
		counter = 0;
		top = 0;
		head = 0;
		size = 0;
	}

	/**
	 * Enqueues all elements from another queue onto this one. If another queue
	 * * [4,5] is enqueued into this queue [1,2,3], the result is [1,2,3,4,5]
	 * and * not [1,2,3,5,4]. The elements of the other queue must NOT be
	 * changed!
	 */
	public void enqueue(Queue other) {
		int[] a = new int[other.counter + this.counter];
		int k = 0;
		int n = head;
		for (int i = 0; i < this.counter; i++) {
			if (n == size) {
				n = 0;
				a[k] = this.queue[n];
				k++;
				n++;
			} else {
				a[k] = this.queue[n];
				n++;
				k++;
			}
		}
		n = other.head;
		for (int i = 0; i < other.counter; i++) {
			if (n == other.size) {
				n = 0;
				a[k] = other.queue[n];
				k++;
				n++;
			} else {
				a[k] = other.queue[i];
				k++;
				n++;
			}

		}
		counter = a.length;
		head = 0;
		queue = a;
		a = null;
	}

	/** Clones this Queue instance and returns an exact COPY. */
	public Queue clone() {
		Queue clone = new Queue();
		clone.size = this.size;
		clone.top = this.top;
		clone.counter = this.counter;
		for (int i = 0; i < size; i++) {
			clone.queue[i] = queue[i];
		}
		return clone;
	}

	/**
	 * Returns true if the other queue is equal to this one, false otherwise.
	 * The contents of the two queues must not be changed!
	 */
	public boolean equals(Queue other) {
		if (this.size == other.size) {
			for (int i = 0; i < size; i++) {
				if (queue[i] == other.queue[i]) {
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * Returns a string representation of the queue. See the exercise *
	 * specification below for the exact string format!
	 */
	public String toString() {
		
		int n = head;
		StringBuffer string = new StringBuffer();
		string.append("Queue " + size + ": [");
		for (int i = 0; i <= counter; i++) {
			if (n == size) {
				n = 0;
				if (n == top - 1) {
					string.append(queue[n] + "].");
					return string.toString();

				} else {
					string.append(queue[n] + ", ");
				}
				n++;
			}
			if (n == top - 1) {
				string.append(queue[n] + "].");
				return string.toString();

			} else {
				string.append(queue[n] + ", ");
				n++;
			}
		}
		return string.toString();

	}
	/**  Returns true if the element val exists in the stack, false otherwise. */
	public boolean search(int val) {
		for (int i = 0; i < top; i++) {
			if (val == queue[i]) {
				return true;
			}
		}
		return false;
	}
}
